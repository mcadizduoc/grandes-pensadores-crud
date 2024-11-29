/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pruebas
 */
public class ConexionBD {
    private static final String DATABASE_HOST = "jdbc:mysql://localhost:3306/grandes_pensadores";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";
    
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection(DATABASE_HOST, DATABASE_USER, DATABASE_PASSWORD);
            
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return connection;
    }
}
