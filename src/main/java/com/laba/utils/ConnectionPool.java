package com.laba.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {

    private static final Logger LOG = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance;
    private final String url = DBConfig.URL;
    private final String username = DBConfig.USER;
    private final String password = DBConfig.PASSWORD;

    private final int maxPoolSize = 5;
    private final Queue<Connection> connectionPool = new ArrayDeque<>(maxPoolSize);
    private final List<Connection> usedConnections = new ArrayList<>();
    private final Object lock = new Object();

    public ConnectionPool() {
        for (int i = 0; i < maxPoolSize; i++) {
            connectionPool.offer(createConnection());
        }
    }

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

    public Connection getConnection() {
        synchronized (lock) {
            if (connectionPool.isEmpty()) {
                if (usedConnections.size() < maxPoolSize) {
                    connectionPool.offer(createConnection());
                } else {
                    throw new RuntimeException(
                        "Maximum pool size reached, no available connections.");
                }
            }
            Connection connection = connectionPool.poll();
            usedConnections.add(connection);
            LOG.debug("Connection called: " + connection);
            return connection;
        }
    }

    public void releaseConnection(Connection connection) {
        synchronized (lock) {
            LOG.debug("Connection to release: " + connection);
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            usedConnections.remove(connection);
        }
    }

    public void closeAllConnections() throws SQLException {
        synchronized (lock) {
            for (Connection connection : connectionPool) {
                connection.close();
            }
            connectionPool.clear();
            usedConnections.clear();
        }
    }

}
