/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.caccdb.ConnectionDb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.caccdb.Connector;
import com.proyecto.clogn.entities.MarcaArticulo;
import com.proyecto.clogn.entities.TipoArticulo;
import com.proyecto.clogn.entities.Usuario;
/**
 *
 * @author Josue Tello
 */
public class UsuarioDAOImpl implements IUsuarioDAO{
ConnectionDb conex;
    @Override
    public List<Usuario> list() {
        StringBuilder sql = new StringBuilder();
	        sql.append("SELECT * FROM \"usuario\"");  //construye la cadena de consulta

	        List<Usuario> list = new ArrayList<>(); //list es la lista de cuentas bancarias
	        
	        try{
	        this.conex = Connector.open(Connector.SQLSERVER);
            ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
	            while (rs.next()){  //mientras haya registros en la tabla
	            	Usuario usuario = new Usuario();  
	            	usuario.setIdusuario(rs.getInt("idusuario"));//mientras haya registros cargados en el reseltset
	            	usuario.setIdpersona(rs.getInt("idpersona"));
	            	usuario.setUser(rs.getString("username"));
                    usuario.setPassword(rs.getString("userpassword"));
	            	usuario.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	                list.add(usuario);  
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return list;
    }

    @Override
    public Usuario edit(String cod) {
    	Usuario usuarios = new Usuario(); 
		try {
			this.conex = Connector.open(Connector.SQLSERVER);
			
			 StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
			 sql.append("SELECT * FROM usuario WHERE username = '").append(cod).append("'");
		
            ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
	            while (rs.next()){//mientras haya registros cargados en el reseltset
	            	usuarios.setIdpersona(rs.getInt("idpersona"));
	            	usuarios.setIdusuario(rs.getInt("idusuario"));
	            	usuarios.setPassword(rs.getString("userpassword"));
	            	usuarios.setUser(rs.getString("username"));
	            	usuarios.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	            }
	            
			conex.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuarios;           //devuelve el objeto creado
    }

    @Override
    public boolean save(Usuario usuarios, int ope) {
     this.conex = Connector.open(Connector.SQLSERVER); 
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
             //  Statement conn = Connector.getConnector().createStatement();
               
           if(ope==1) {  //es cero cuando se esta ingresando un registro nuevo: ver inicializac'on del atributo 
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
               sql.append("INSERT INTO [usuario] ([idpersona] ,[username] ,[userpassword] ,[fecha_carga]) VALUES (");
                sql.append("'").append(usuarios.getIdpersona());
                 sql.append("', '").append(usuarios.getUser());                  
                 sql.append("', '").append(usuarios.getPassword()); 
                 sql.append("', '").append(usuarios.getFecha_carga()).append(" ' )");
                 System.out.println("creao");//crear la cadena de conexion
                 this.conex.execute(sql.toString()); 
            } else {   //es un registro previamente existente: estamos actualizando
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE [usuario] SET [idpersona] = '").append(usuarios.getIdpersona());
                sql.append("', [username] = '").append(usuarios.getUser());
                sql.append("', [userpassword] = '").append(usuarios.getPassword());
                sql.append("', [fecha_carga] = '").append(usuarios.getFecha_carga()).append("' WHERE [idusuario] = ").append(usuarios.getIdusuario()); 
            this.conex.execute(sql.toString());
            System.out.println("editao");
            }
            save = true;                                //cambia estado de bandera
        } catch(Exception e){
             
        } finally {
            this.conex.close();      //cerrar la conexion
        }
        
        return save; 
    }

    @Override
    public boolean delete(String id) {
   boolean delete = false;                     //bandera que indica resultado de operacion

        this.conex = Connector.open(Connector.SQLSERVER); //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM [dbo].[usuario] WHERE [username] = ").append(id);    //crea la sentencia de borrado
            this.conex.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conex.close();                  //cierra la conexion
        }
        return delete;  
    }
    
    
}
