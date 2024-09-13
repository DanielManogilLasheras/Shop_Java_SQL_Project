package com.shop.leinadprojects.shop_java_sql;
import dataBase.DbConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Client;
import repository.ClientRepository;

import java.io.IOException;
import java.sql.Connection;

public class Insertion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Insertion.class.getResource("graphicsView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("LEINAD SL BASIC JAVA-SQL SHOP");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}