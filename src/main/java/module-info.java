module com.example.javabankingapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.javabankingapplication to javafx.fxml;
    exports com.example.javabankingapplication;
    exports com.example.javabankingapplication.Controllers;
    exports com.example.javabankingapplication.Controllers.Admin;
    exports com.example.javabankingapplication.Controllers.Client;
    exports com.example.javabankingapplication.Models;
    exports com.example.javabankingapplication.Views;
}