package com.laba.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateSqliteDb {

    public static void main(String[] args) {
        try {
            // Establish a connection to the SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:./db/hospital.db");

            // Create a statement
            Statement statement = connection.createStatement();

            // Read the SQL file
            String filePath = "./SQL/hospital-create-sqlite.sql";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
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