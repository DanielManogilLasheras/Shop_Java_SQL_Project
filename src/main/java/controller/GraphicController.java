package controller;

import dataBase.DbConnection;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.Client;
import repository.ClientRepository;

import java.sql.Connection;

public class GraphicController {
    Connection connection;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField name,surname,email,age,password;
    @FXML
    private TextField logText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Bienvenido a la tienda online JAVA_SQL! Por favor, registre un nuevo usuario, " +
                "o inicie sesión si ya tiene una cuenta en nuestra base de datos.");
    }
    @FXML
    protected void signUpAction(){
        connection=DbConnection.getConnection();
        String ageClient=age.getText();
        Client client=new Client(name.getText(),surname.getText(),email.getText(),Integer.valueOf(ageClient),password.getText());
        ClientRepository clientRepository=new ClientRepository();
        clientRepository.signUp(client);
    }
}