package com.shop.leinadprojects.shop_java_sql;
import dataBase.DbConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Client;
import repository.ClientRepository;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Insertion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("logInScene.fxml"));
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.setTitle("Daniel Manogil Shop Java-SQL");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}