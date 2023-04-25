package com.example.javabankingapplication.Models;

import com.example.javabankingapplication.Views.AccountType;
import com.example.javabankingapplication.Views.ViewFactory;
import javafx.scene.chart.PieChart;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;


public class Model {

    //client data section
    private final Client client;

    //has the client successfully logged in
    private boolean clientLoginSuccessFlag;




    //admin data section

    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private boolean adminLoginSuccessFlag;


    private Model() {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        //client seciton
        this.clientLoginSuccessFlag = false;
        this.client = new Client("", "", "", null, null, null);


        //admin section
        this.adminLoginSuccessFlag = false;
    }





    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }

        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public DatabaseDriver getDatabaseDriver() {
        return databaseDriver;
    }




    /**
     * Client method section
     */

    public boolean getClientLoginSuccessFlag () {
        return this.clientLoginSuccessFlag;
    }


    public void setClientLoginSuccessFlag(boolean flag) {
        this.clientLoginSuccessFlag = flag;
    }





    public Client getClient () {
        return client;
    }







    public void evaluateClientCred (String pAddress, String password) {
        ChequingAccount chequingAccount;
        SavingsAccount savingsAccount;
        ResultSet resultSet = databaseDriver.getClientData(pAddress, password);

        try {
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                    this.client.lastNameProperty().set(resultSet.getString("LastName"));
                    this.client.pAddress().set(resultSet.getString("PayeeAddress"));
                    String[] dateParts = resultSet.getString("Date").split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                    this.client.dateProperty().set(date);
                    this.clientLoginSuccessFlag = true;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //admin section
    public boolean getAdminLoginSuccessFlag () {
        return this.adminLoginSuccessFlag;
    }




    public void setAdminLoginSuccessFlag(boolean adminLoginSuccessFlag) {
        this.adminLoginSuccessFlag = adminLoginSuccessFlag;
    }





    public void evaluateAdminCred(String username, String password) {
        ResultSet resultSet = databaseDriver.getAdminData(username, password);
            try {
                if (resultSet.isBeforeFirst()) {
                    this.adminLoginSuccessFlag = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }









}
