package repository;

import dataBase.DbConnection;
import interfaces.DatabaseSchematic;
import model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRepository implements DatabaseSchematic{
    Connection connection;

    public boolean searchClient(String email){
        connection= DbConnection.getConnection();
        boolean userFound=false;
        String query=String.format("SELECT * FROM %s WHERE %s=?",
                DatabaseSchematic.CLIENT_TABLE,
                DatabaseSchematic.COL_EMAIL);
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            ResultSet resultSet=preparedStatement.executeQuery();
            userFound=resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DbConnection.closeConnection();
            connection=null;
        }
        return userFound;
    }
    public void signUp(Client clientToSign){
        if(!searchClient(clientToSign.getEmail())){
            connection=DbConnection.getConnection();
            PreparedStatement preparedStatement=null;
            String query="INSERT INTO client (name,surname,email,age,password) VALUES (?,?,?,?,?)";
            try {
                preparedStatement= connection.prepareStatement(query);
                preparedStatement.setString(1,clientToSign.getName());
                preparedStatement.setString(2,clientToSign.getSurname());
                preparedStatement.setString(3,clientToSign.getEmail());
                preparedStatement.setInt(4,clientToSign.getAge());
                preparedStatement.setString(5,clientToSign.getPassword());
                preparedStatement.execute();
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Error en la sentencia SQL" + e.getMessage());
            }
            DbConnection.closeConnection();

        }
    }
    public boolean signIn(String email,String password){
        connection=DbConnection.getConnection();
        boolean login=false;
        ResultSet resultSet;
        PreparedStatement preparedStatement=null;
        String query=String.format("SELECT * FROM %s WHERE %s=? AND %s=?",
                DatabaseSchematic.CLIENT_TABLE,
                DatabaseSchematic.COL_NAME,
                DatabaseSchematic.COL_PASSWORD);
        try {
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            login=resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error en la sentencia SQL");
        }
        return false;
    }
}

