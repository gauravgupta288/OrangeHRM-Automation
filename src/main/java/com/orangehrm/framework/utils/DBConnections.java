package com.orangehrm.framework.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnections {

    private static Connection dbConnection = null;
    private DBConnections(){

    }

    public Connection getDbConnection() throws SQLException {
        if(dbConnection == null){
            String url = "jdbc:mysql://localhost:3306/testdb";
            String user = "root";
            String password = "password";

            dbConnection =DriverManager.getConnection(url, user, password);
        }

        return dbConnection;
    }

    public void closeConnection() throws SQLException {
        if(dbConnection != null){
            dbConnection.close();
            dbConnection = null;
        }
    }

}
