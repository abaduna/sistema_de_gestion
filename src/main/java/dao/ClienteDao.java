/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mycompany.sistemadegestion.models.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artub
 */
public class ClienteDao {
    public void agregar(Cliente cliente){
    
    
    
        try {
            Connection conexion = conectar();
            String sql = "INSERT INTO `clientes` (`id`, `Nombre`, `Apellido`, `Email`, `Telefono`) VALUES (NULL, '" + cliente.getNombre()  +"', '" + cliente.getApelido() + "', '" + cliente.getEmail()  + "', '" + cliente.getTelefono()  +"')";
            Statement statement  = conexion.createStatement();
            statement.execute(sql); 
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }
    public List<Cliente> listar( ){
    
    String baseDeDatos = "java01" ;
    String usuarios = "root";
    String password = "";
    String hosting = "localhost";
    String puerto = "3306";
    String driver = "com.mysql.jdbc.Driver";
    String conexionUrl = "jdbc:mysql://" + hosting + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";
    
    Connection conexions = null; 
    List<Cliente> listado = new ArrayList<>();
    
        try {
            Class.forName(driver);
            conexions = DriverManager.getConnection(conexionUrl, usuarios, password);
            String sql =  "SELECT * FROM `clientes` ";
            Statement statement  = conexions.createStatement();
           ResultSet resultado = statement.executeQuery(sql); 
           while (resultado.next()){
               Cliente cliente = new Cliente();
               cliente.setNombre(resultado.getString("Nombre"));               
               cliente.setApelido(resultado.getString("Apellido"));               
               cliente.setEmail(resultado.getString("Email"));               
               cliente.setTelefono(resultado.getString("Telefono"));               
               cliente.setId(resultado.getString("id"));
               listado.add(cliente);
           } 
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
return listado ; 
    
    }
    public Connection conectar(){    
    
    String baseDeDatos = "java01" ;
    String usuarios = "root";
    String password = "";
    String hosting = "localhost";
    String puerto = "3306";
    String driver = "com.mysql.jdbc.Driver";
    String conexionUrl = "jdbc:mysql://" + hosting + ":" + puerto + "/" + baseDeDatos + "?useSSL=false";
    
    Connection conexions = null; 
    
        try {
            Class.forName(driver);
            conexions = DriverManager.getConnection(conexionUrl, usuarios, password);

        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return conexions;
    
    
    }
    public void eliminar (String  id ){
    
   
        try {
            Connection conexion = conectar();
            String sql = "DELETE FROM `clientes` WHERE `clientes`.`id` = " + id ;
            Statement statement  = conexion.createStatement();
            statement.execute(sql); 
        } catch (Exception ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }

}
