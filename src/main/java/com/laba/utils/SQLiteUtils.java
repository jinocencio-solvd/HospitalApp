package com.laba.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLiteUtils {

    public static void processSQLiteScript(String action) {
        String script = "";
        switch(action){
            case "create":
                script = "./SQL/SQLite/hospital-create-sqlite.sql";
                break;
            case "insert":
                script = "./SQL/SQLite/hospital-insert-sqlite.sql";
                break;
        }
        runSQLiteScript(script);
    }

    private static void runSQLiteScript(String filepath) {
        try {
            // Establish a connection to the SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./db/hospital.db");

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
                    statement.executeUpdate(sqlScript.toString());
                    sqlScript.setLength(0);  // Clear the script
                }
            }

            // Close resources
            reader.close();
            statement.close();
            connection.close();

            System.out.println("SQL file executed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}