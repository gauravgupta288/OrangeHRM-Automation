package com.orangehrm.framework.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnections {

    private static ThreadLocal<Connection> dbConnection = null;
    private DBConnections(){

    }

    public Connection getDbConnection() throws SQLException {

            Connection connection = dbConnection.get();
            if(connection == null || connection.isClosed()){
                String url = "jdbc:mysql://localhost:3306/testdb";
                String user = "root";
                String password = "password";

                dbConnection.set(DriverManager.getConnection(url, user, password));
            }

            return connection;
        }


    public void closeConnection() throws SQLException {

        Connection connection = dbConnection.get();
        if(connection != null || !connection.isClosed()){
            dbConnection.remove();
            connection.close();
        }
    }

}
