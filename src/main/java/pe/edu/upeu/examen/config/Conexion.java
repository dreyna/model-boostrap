package pe.edu.upeu.examen.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String USER = "C##userlp1";
    private static final String PASS = "1234567";
    private static Connection cx = null;
    public static Connection getConexion(){
    	    try {
                Class.forName(DRIVER);
                if(cx==null){
                    cx = DriverManager.getConnection(URL, USER, PASS);
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Error Conexion: "+e);
            }
            return cx;        
    }
   public static void cerrar() throws SQLException {
      if (cx != null) {
         cx.close();
         
         
      }
   }
}
