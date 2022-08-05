
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    //Campos
    private final String URL="jdbc:mysql://localhost:3306/basetareafinalsql";
    private final String USER="root";
    private final String PASSWORD="job8541ax";
    protected Connection conexion; //Protected porque despues la vamos a heredar
    
    
    //Conexion Sql inicializacion
    public void iniciar() throws ClassNotFoundException, SQLException{
        
        Class.forName("com.mysql.jdbc.Driver"); //Sirve para ver si tenemos algun error con el jdbc
        this.conexion=DriverManager.getConnection(URL, USER, PASSWORD);
        
    }
    
   
          
    
}
