package controller;

import com.shop.leinadprojects.shop_java_sql.Insertion;
import dataBase.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Client;
import repository.ClientRepository;

import java.io.IOException;
import java.sql.Connection;

public class GraphicController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Connection connection;
    @FXML
    public void switchToRegisterWindow(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(GraphicController.class.getResource("hello-view.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al ejecutar comando: " + e.getMessage());
        }
    }
    @FXML
    public void switchToLoginWindow(ActionEvent event){
        try {
            Parent root=FXMLLoader.load(getClass().getResource("logInScene.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al ejecutar comando: " + e.getMessage());
        }
    }
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
    protected void registerAction(){
        connection=DbConnection.getConnection();
        String ageClient=age.getText();
        Client client=new Client(name.getText(),surname.getText(),email.getText(),Integer.valueOf(ageClient),password.getText());
        ClientRepository clientRepository=new ClientRepository();
        clientRepository.register(client);
    }
    @FXML
    protected void loginAction(){
        connection=DbConnection.getConnection();
        ClientRepository clientRepository=new ClientRepository();
         if(clientRepository.logIn(email.getText(),password.getText())){
             welcomeText.setText("Logeado con exito");
         }else{
             welcomeText.setText("No has logeado");
         }
    }
}