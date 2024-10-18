package controller;

import dataBase.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Client;
import repository.ClientRepository;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;

public class RegisterController {

    @FXML
    private Button backLoginButton;

    @FXML
    private Label confPassError;

    @FXML
    private Label emailError;

    @FXML
    private Label passwordError;

    @FXML
    private TextField regAgeField;

    @FXML
    private TextField regConfField;

    @FXML
    private TextField regEmailField;

    @FXML
    private TextField regNameField;

    @FXML
    private TextField regPassField;

    @FXML
    private TextField regSurnameField;

    @FXML
    private Button registerButton;

    @FXML
    private Label resultRegistration;

    @FXML
    protected void registerAction(){
        resultRegistration.setText("");
        confPassError.setText("");
        emailError.setText("");
        int ageClient=Integer.valueOf(regAgeField.getText());
        String confPassword=regConfField.getText();
        Client client=new Client(regNameField.getText(),regSurnameField.getText(),regEmailField.getText(),ageClient,regPassField.getText());
        if(client.getName().isBlank()||client.getSurname().isBlank()||client.getEmail().isBlank()||client.getAge()==0||client.getPassword().isBlank()||confPassword.isBlank()){
            resultRegistration.setText("Please fill all the fields marked with a *");
        }else{
            Connection connection= DbConnection.getConnection();
            ClientRepository clientRepository=new ClientRepository();
            if(!client.getPassword().equals(confPassword)){
                confPassError.setText("The password doesn't match");
            }else{
                if(clientRepository.searchClient(client.getEmail())){
                    emailError.setText("This email already has an account");
                }else{
                    if(clientRepository.register(client)){
                        resultRegistration.setText("Your account has been created succesfully");
                    }else{
                        resultRegistration.setText("Error: The account could not be signed");
                    }
                }
            }
        }
    }

    @FXML
    public void switchToLoginWindow(ActionEvent event){
        try {
            URL url = new File("src/main/resources/com/shop/leinadprojects/shop_java_sql/logInScene.fxml").toURI().toURL();
            Parent root= FXMLLoader.load(url);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Daniel Manogil Shop Java-SQL");
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al ejecutar comando: " + e.getMessage());
        }
    }

}