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
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Client;
import repository.ClientRepository;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;


public class LoginController {

    @FXML
    private TextField logEmail;

    @FXML
    private TextField logPassword;

    @FXML
    private Button loginButton;

    @FXML
    private Label loginErrorLabel;

    @FXML
    public void switchToRegisterWindow(ActionEvent event){
        try {
            URL url = new File("src/main/resources/com/shop/leinadprojects/shop_java_sql/registerScene.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
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

    @FXML
    protected boolean loginAction(){
        String loginActionEmail=logEmail.getText();
        String loginActionPassword=logPassword.getText();
        ClientRepository clientRepository=new ClientRepository();
        if(loginActionEmail.isBlank()||loginActionPassword.isBlank()){
            loginErrorLabel.setText("Please fill the fields of email and password to log in");
        }else{
            if(clientRepository.searchClient(loginActionEmail)){
                Connection connection= DbConnection.getConnection();
                if(!clientRepository.logIn(logEmail.getText(),logPassword.getText())){
                    loginErrorLabel.setText("The email or password are incorrect");
                }else{
                    return true;
                }
            }
        }
        return false;
    }
    @FXML
    protected void shopMainWindow(ActionEvent event){
        if (loginAction()){
            Client client=new Client();
            ClientRepository clientRepository=new ClientRepository();
            client=clientRepository.retrieveClientInfo(logEmail.getText());
            try {
               URL url=new File("src/main/resources/com/shop/leinadprojects/shop_java_sql/shopMainWindow.fxml").toURI().toURL();
                Parent root= FXMLLoader.load(url);
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.setMaxHeight(Screen.getPrimary().getBounds().getHeight());
                stage.setMaxWidth(Screen.getPrimary().getBounds().getWidth());
                stage.setFullScreen(true);
                stage.setResizable(true);
                stage.setTitle("Daniel Manogil Shop Java-SQL");
                stage.show();
            } catch (IOException e) {
                System.out.println("Error en la carga del recurso: " + e.getMessage());
            }
        }
    }

}
