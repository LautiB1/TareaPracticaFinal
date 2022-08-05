
package Clases;

import DAO.Conexion;
import Interfaces.DAOUsuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAOImp extends Conexion implements DAOUsuarios {

    //los signos de pregunta hacen referencia a los valores que toma
    private final String REGISTRO = "INSERT INTO usuarios(nombre,apellido,email,telefono) VALUES(?,?,?,?)";
    private final String MODIFICAR = "UPDATE usuarios SET telefono=? WHERE nombre=?";
    private final String ELIMINAR = "DELETE FROM usuarios WHERE nombre=?";
    private final String RECUPERAR = "SELECT * FROM usuarios ORDER BY nombre,apellido";

    //this.iniciar va al principio de cada metodo
    //this.conexion.close();
    @Override
    public void registrar(List<Usuarios> usuarios) throws ClassNotFoundException, SQLException {

        this.iniciar();
        PreparedStatement accion = this.conexion.prepareStatement(REGISTRO);

        //fore porque recibe una lista de usuarios
        for (Usuarios usuario : usuarios) {

            
            accion.setString(1, usuario.getNombre());
            accion.setString(2, usuario.getApellido());
            accion.setString(3, usuario.getEmail());
            accion.setString(4, usuario.getTelefono());

            accion.executeUpdate(); //Hace un cambio en la tabla de alguna forma

        }

        System.out.println("Se realizo la actualizacion de la tabla");
        accion.close();
        this.conexion.close();

    }

    @Override
    public List<Usuarios> recuperar() throws ClassNotFoundException, SQLException {

        List<Usuarios> usuarios = new ArrayList<>(); //Lista que retorna 

        this.iniciar();
        Statement accion = this.conexion.createStatement();
        ResultSet resultado = accion.executeQuery(RECUPERAR);

        
        
        while (resultado.next()) {

            
            usuarios.add(new Usuarios(
                    resultado.getInt(1),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4),
                    resultado.getString(5) 
            ));

        }
        resultado.close();
        accion.close();
        this.conexion.close();

        usuarios.forEach(System.out::println);

        return usuarios;

    }

    public List<Usuarios> recuperarID() throws ClassNotFoundException, SQLException {

        List<Usuarios> usuarios = new ArrayList<>(); //Lista que retorna 

        this.iniciar();
        Statement accion = this.conexion.createStatement();
        ResultSet resultado = accion.executeQuery(RECUPERAR);

        
        
        while (resultado.next()) {

            
            usuarios.add(new Usuarios(
                    resultado.getInt(1),
                    resultado.getString(2),
                    resultado.getString(3),
                    resultado.getString(4),
                    resultado.getString(5) 
            ));

        }
        resultado.close();
        accion.close();
        this.conexion.close();

        

        return usuarios;

    }
    
    
    @Override
    public void modificar(Usuarios user) throws ClassNotFoundException, SQLException {

        this.iniciar();
        PreparedStatement accion = this.conexion.prepareStatement(MODIFICAR);
        accion.setString(1, user.getTelefono());
        accion.setString(2, user.getNombre());

        accion.close();
        this.conexion.close();

        System.out.println("Se realizo la actualizacion");

    }

    @Override
    public void eliminar(Usuarios user) throws ClassNotFoundException, SQLException {

        this.iniciar();

        PreparedStatement accion = this.conexion.prepareStatement(ELIMINAR);
        accion.setString(1, user.getNombre());

        accion.close();
        this.conexion.close();

        System.out.println("Se realizo el borrado");

    }

}
    
    


    
    
    
  
    
    

