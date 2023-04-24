package com.example.javabankingapplication.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ChequingAccount extends Account {
    //number of transactions a client is allowed per day
    private final IntegerProperty transactionLimit;


    public ChequingAccount (String owner, String accountNumber, double balance, int tLimit) {
        super(owner, accountNumber, balance);
        this.transactionLimit = new SimpleIntegerProperty(this, "Transaction Limit", tLimit);
    }



    public IntegerProperty transactionLimitProp() {
        return transactionLimit;
    }

}
