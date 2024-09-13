package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    static Connection connection=null;

    public static void createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        //Abrir la conexion
        //crear URI -> ruta distintiva a un recurso local o de red
        String uri="jdbc:mysql://127.0.0.1:3306/Shop_Java_DB";
        //abrir la conexion desde uri con un usuario que tiene una pass

            connection= DriverManager.getConnection(uri,"root","");
        }catch (ClassNotFoundException e) {
            System.out.println("Error: Could not load the driver.");
        }
        catch (SQLException e) {
            System.out.println("Error: Login failed");
            System.out.println(e.getMessage());
        }
    }
    public static Connection getConnection(){
        if(connection==null){
            createConnection();
        }
        return connection;
    }
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error:Could not terminate connection");
        }
        connection=null;
    }
}
