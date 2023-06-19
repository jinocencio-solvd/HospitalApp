package com.laba.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SQLScriptExecutor {

    private static final Logger LOG = LogManager.getLogger(SQLScriptExecutor.class);
    private static final String sqliteUrl = "jdbc:sqlite:./db/hospital.db";
    private static final String mySqlUrl = "jdbc:mysql://localhost:3306/hospital?user=root&password=password";

    public static void main(String[] args){
        SQLScriptExecutor.processMySqlScript("create");
    }

    public static void processSQLiteScript(String action) {
        String script = "";
        switch (action) {
            case "create":
                script = "./SQL/SQLite/hospital-create-sqlite.sql";
                break;
            case "insert":
                script = "./SQL/SQLite/hospital-insert-sqlite.sql";
                break;
        }
        runSQLScript(script, sqliteUrl);
    }

    public static void processMySqlScript(String action) {
        String script = "";
        switch (action) {
            case "create":
                script = "./SQL/MySQL/hospital-create.sql";
                break;
            case "insert":
                script = "./SQL/MySQL/hospital-inserts.sql";
                break;
        }
        runSQLScript(script, mySqlUrl);
    }

    private static void runSQLScript(String filepath, String dbUrl) {
        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(dbUrl);

            // Create a statement
            Statement statement = connection.createStatement();

            // Read the SQL file
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            StringBuilder sqlScript = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                // Append each line to the SQL script
                sqlScript.append(line);

                // Execute the SQL statement if it ends with a semicolon
                if (line.trim().endsWith(";")) {
                    statement.execute(sqlScript.toString());
                    sqlScript.setLength(0);  // Clear the script
                }
            }
            // Close resources
            reader.close();
            statement.close();
            connection.close();
            LOG.info("Script: " + filepath + " created successfully");
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("Script Failed: " + filepath);
        }
    }
}