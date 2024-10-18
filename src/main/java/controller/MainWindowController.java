package controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Product;
import repository.ProductRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private TableView<Product> productsTable;
    @FXML
    private TableColumn<Product,Integer>idOrCol;
    @FXML
    private TableColumn<Product, String> nameOrCol;
    @FXML
    private TableColumn<Product, String> descriptionOrCol;
    @FXML
    private TableColumn<Product, Double> priceOrCol;
    @FXML
    private TableColumn<Product, Integer> stockOrCol;

    @FXML
    private TextField itemSelectedField;


    @FXML
    private Tab orderProductsbtn;
    @FXML
    private Button addItembtn;
    @FXML
    private Tab checkoutBtn;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField searchByIDField;
    @FXML
    private TextField searchByNameField;
    @FXML
    private Button searchItemBtn;
    @FXML
    private Tab settingsBtn;
    @FXML
    private Tab viewCartBtn;

    @FXML
    private Tab viewOrdersBtn;
    private ObservableList<Product> loadProducts(){
        ProductRepository productRepository=new ProductRepository();
        Product p1=new Product(2,"pepe","pipo",9.50,4);
        Product p2=new Product(3,"pepe","pipo",9.50,5);

        return FXCollections.observableArrayList(p1,p2);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        idOrCol.setCellValueFactory(new PropertyValueFactory<Product,Integer>("idOrCol"));
        productsTable.setItems(loadProducts());
    }
}
