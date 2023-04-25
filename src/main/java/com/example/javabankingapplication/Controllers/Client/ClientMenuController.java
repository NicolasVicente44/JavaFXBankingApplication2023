package com.example.javabankingapplication.Controllers.Client;

import com.example.javabankingapplication.Models.Model;
import com.example.javabankingapplication.Views.ClientMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public Button dashboard_btn;
    public Button transaction_btn;
    public Button accounts_btn;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        addListeners();
    }




    private void addListeners () {
        dashboard_btn.setOnAction(event -> onDashboard());
        transaction_btn.setOnAction(event -> onTransactions());
        accounts_btn.setOnAction(event -> onAccounts());
        logout_btn.setOnAction(event -> onLogout());
    }







    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.DASHBOARD);
    }

    private void onTransactions() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.TRANSACTIONS);
    }


    private void onAccounts () {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ACCOUNTS);
    }


    private void onLogout () {
        //get stage
        Stage stage = (Stage) dashboard_btn.getScene().getWindow();
        //close the client window
        Model.getInstance().getViewFactory().closeStage(stage);
        //show login window
        Model.getInstance().getViewFactory().showLoginWindow();
        //set client login successflag/bool to false on logout
        Model.getInstance().setClientLoginSuccessFlag(false);

    }




}








