package Conextion;








import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PARRA
 */
public class Conexiones {

    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10314087" + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static String user = "sql10314087";
    public static String password = "y6ixzbxeqX";

    public static Connection conectar(){
    
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName(driver).newInstance();  //Definicion del driver 

        } catch (Exception ex) {
            // handle the error
        }

        Connection conn = null;
        try {

            conn = DriverManager.getConnection(url, user, password); 

            if (conn != null) {
                System.out.println("Conexion exitosa");
            }
            // Do something with the Connection
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return conn;
    }
    
    public static void desconectar(Connection con) throws SQLException{
        con.close();
    }    
}
