
package Interfaces;

import Clases.Usuarios;
import java.sql.SQLException;
import java.util.List;


public interface DAOUsuarios {
    
    //CRUD
    //Agrego los throws de iniciar en la clase Conexion
    //CREATE
    public void registrar(List<Usuarios> usuarios)throws ClassNotFoundException, SQLException;
    
    //READ
    public List<Usuarios> recuperar()throws ClassNotFoundException, SQLException;
    
    //UPDATE
    public void modificar(Usuarios user)throws ClassNotFoundException, SQLException;
    
    //DELETE
    public void eliminar(Usuarios user)throws ClassNotFoundException, SQLException;
    
    
}
