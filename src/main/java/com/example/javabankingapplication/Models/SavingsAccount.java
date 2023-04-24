package com.example.javabankingapplication.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingsAccount extends Account{
    //the withdrawal limit of the savings account
    private final DoubleProperty withdrawalLimit;


    public SavingsAccount (String owner, String accountNumber,double balance, double withdrawalLimit) {
        super(owner, accountNumber, balance);
        this. withdrawalLimit = new SimpleDoubleProperty(this, "Withdrawal Limit", withdrawalLimit);
    }



    public DoubleProperty withdrawalLimitProp () {
        return withdrawalLimit;
    }
}
