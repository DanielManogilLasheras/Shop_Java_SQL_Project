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
import javafx.stage.Window;
import model.Client;
import repository.ClientRepository;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;


public class GraphicController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Window window;
    private URL url;
    private Client client;
    private ClientRepository clientRepository;
    Connection connection;
    @FXML
    private Label loginErrorLabel,nameError,surnameError,emailError,ageError,passwordError,confPassError,resultRegistration;
    @FXML
    private TextField logEmail,logPassword;
    @FXML
    private TextField regNameField,regSurnameField,regEmailField,regAgeField,regPassField,regConfField;
    @FXML
    Button button;
    @FXML
    public void switchToRegisterWindow(ActionEvent event){
        try {

            url = new File("src/main/resources/com/shop/leinadprojects/shop_java_sql/registerScene.fxml").toURI().toURL();
            root = FXMLLoader.load(url);
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Daniel Manogil Shop Java-SQL");
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
            stage.setResizable(false);
            stage.setTitle("Daniel Manogil Shop Java-SQL");
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al ejecutar comando: " + e.getMessage());
        }
    }

    @FXML
    protected void registerAction(){
        resultRegistration.setText("");
        confPassError.setText("");
        emailError.setText("");
        int ageClient=Integer.valueOf(regAgeField.getText());
        String confPassword=regConfField.getText();
        client=new Client(regNameField.getText(),regSurnameField.getText(),regEmailField.getText(),ageClient,regPassField.getText());
        if(client.getName().isBlank()||client.getSurname().isBlank()||client.getEmail().isBlank()||client.getAge()==0||client.getPassword().isBlank()||confPassword.isBlank()){
            resultRegistration.setText("Please fill all the fields marked with a *");
        }else{
            connection=DbConnection.getConnection();
            clientRepository=new ClientRepository();
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
    protected boolean loginAction(){
        String loginActionEmail=logEmail.getText();
        String loginActionPassword=logPassword.getText();
        clientRepository=new ClientRepository();
        if(loginActionEmail.isBlank()||loginActionPassword.isBlank()){
            loginErrorLabel.setText("Please fill the fields of email and password to log in");
        }else{
            if(clientRepository.searchClient(loginActionEmail)){
                connection=DbConnection.getConnection();
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
            client=new Client();
            client=clientRepository.retrieveClientInfo(logEmail.getText());
            try {
                url=new File("src/main/resources/com/shop/leinadprojects/shop_java_sql/shopMainWindow.fxml").toURI().toURL();
            } catch (MalformedURLException e) {
                System.out.println("Error al formar la url de carga " + e.getMessage());
            }
            try {
                root=FXMLLoader.load(url);
            } catch (IOException e) {
                System.out.println("Error en la carga del recurso: " + e.getMessage());
            }
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.setResizable(false);
            stage.setTitle("Daniel Manogil Shop Java-SQL");
            stage.show();
        }
    }
}