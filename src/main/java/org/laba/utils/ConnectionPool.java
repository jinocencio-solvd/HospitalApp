package org.laba.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static ConnectionPool instance;
    private final String url = DBConfig.URL;
    private final String username = DBConfig.USER;
    private final String password = DBConfig.PASSWORD;

    private final int maxPoolSize = 5;
    private final List<Connection> connectionPool = new ArrayList<>(maxPoolSize);;
    private final List<Connection> usedConnections = new ArrayList<>();


//    private ConnectionPool(String url, String username, String password, int initialPoolSize,
//        int maxPoolSize) {
//        this.url = url;
//        this.username = username;
//        this.password = password;
//        this.maxPoolSize = maxPoolSize;
//
//        connectionPool = new ArrayList<>(maxPoolSize);
//        for (int i = 0; i < initialPoolSize; i++) {
//            connectionPool.add(createConnection());
//        }
//    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private Connection createConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Error creating connection: " + e.getMessage());
            throw new RuntimeException("Error creating connection.", e);
        }
    }

    public synchronized Connection getConnection() {
        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < maxPoolSize) {
                connectionPool.add(createConnection());
            } else {
                throw new RuntimeException("Maximum pool size reached, no available connections.");
            }
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        usedConnections.remove(connection);
        connectionPool.add(connection);
    }

    public synchronized void closeAllConnections() throws SQLException {
        for (Connection connection : connectionPool) {
            connection.close();
        }
        connectionPool.clear();
        usedConnections.clear();
    }
}
