package repository;
import dataBase.DbConnection;
import interfaces.DatabaseSchematic;
import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository implements DatabaseSchematic {
    Connection connection;
    public ArrayList<Product> listOfProducts(){
        connection= DbConnection.getConnection();
        Product product;
        ArrayList<Product>listOfProducts=new ArrayList<>();
        String query=String.format("SELECT * FROM %s",
                DatabaseSchematic.PRODUCT_TABLE);
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                product=new Product(
                        resultSet.getInt("id_product"),
                        resultSet.getString(DatabaseSchematic.COL_NAME_PRODUCT),
                        resultSet.getString(DatabaseSchematic.COL_DESCRIPTION_PRODUCT),
                        resultSet.getDouble(DatabaseSchematic.COL_COST_PRODUCT),
                        resultSet.getInt(DatabaseSchematic.COL_STOCK_PRODUCT)
                );
                listOfProducts.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DbConnection.closeConnection();
            connection=null;
        }
        return listOfProducts;
    }
}