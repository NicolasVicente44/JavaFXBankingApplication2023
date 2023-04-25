package com.example.javabankingapplication.Models;

import java.sql.*;

//this file connects to the databse and defiens the functions wanted for the model
public class DatabaseDriver {
    private Connection conn;


    public DatabaseDriver () {
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:mazebank.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * client section
     */
    public ResultSet getClientData(String pAddress, String password) {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"' AND Password='"+password+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }







    /**
     * admin section
     */


    public ResultSet getAdminData (String username, String password) {
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Admins WHERE Username='"+username+"' AND Password='"+password+"';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  resultSet;
    }




}












