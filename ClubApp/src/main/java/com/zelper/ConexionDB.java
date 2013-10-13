/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Administrador
 */
public class ConexionDB {
    public static Connection obtenerConexion() throws SQLException  {
        	Connection con = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/club",
					"root", "mysql");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;

    }
    
    
    
    
}
