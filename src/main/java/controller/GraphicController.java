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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.Objects;

public class GraphicController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private URL url;
    Connection connection;
    @FXML
    public void switchToRegisterWindow(ActionEvent event){
        try {
            url = new File("src/main/resources/com/shop/leinadprojects/shop_java_sql/registerScene.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
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
            url = new File("src/main/resources/com/shop/leinadprojects/shop_java_sql/logInScene.fxml").toURI().toURL();
            root=FXMLLoader.load(url);
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al ejecutar comando: " + e.getMessage());
        }
    }
    @FXML
    private Label loginErrorLabel,nameError,surnameError,emailError,ageError,passwordError,confPassError,resultRegistration;
    @FXML
    private TextField logEmail,logPassword;
    @FXML
    private TextField regNameField,regSurnameField,regEmailField,regAgeField,regPassField,regConfField;
    @FXML
    private TextField logText;


    @FXML
    protected void registerAction(){
        String ageClient=regAgeField.getText();
        if(regNameField.getText()==null){
            resultRegistration.setText("Please fill all the fields marked with a *");
        }else{
            connection=DbConnection.getConnection();
            ClientRepository clientRepository=new ClientRepository();
            if(regPassField.equals(regConfField)){
                confPassError.setText("The password doesn't match");
            }else{
                if(clientRepository.searchClient(regEmailField.getText())){
                    emailError.setText("This email already has an account");
                }else{
                    Client client=new Client(regNameField.getText(),regSurnameField.getText(),regEmailField.getText(),Integer.valueOf(ageClient),regPassField.getText());
                    if(clientRepository.register(client)){

                    }
                }
        }
        }

    }
    @FXML
    protected void loginAction(){
        connection=DbConnection.getConnection();
        ClientRepository clientRepository=new ClientRepository();
         if(!clientRepository.logIn(logEmail.getText(),logPassword.getText())){
             loginErrorLabel.setText("The email or password are incorrect");
         }else{
             loginErrorLabel.setText("You logged successfully");
         }
    }
}