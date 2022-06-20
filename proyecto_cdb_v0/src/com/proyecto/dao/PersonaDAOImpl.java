/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.caccdb.ConnectionDb;
import com.proyecto.caccdb.Connector;
import com.proyecto.clogn.entities.MarcaArticulo;
import com.proyecto.clogn.entities.Persona;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue Tello
 */

public class PersonaDAOImpl implements IPersonaDAO{

 
	 ConnectionDb conn;

	//Statement conn = Connector.getConnector().createStatement();
    @Override
    public List<Persona> list() {      // listado desde la bd mysql
        this.conn = Connector.open(Connector.SQLSERVER);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM persona"); 
         LocalDate fecha = LocalDate.now();
        List<Persona> list = new ArrayList<>();
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
               Persona persona = new Persona();  
                persona.setIdpersona(rs.getInt("idpersona"));  
                persona.setCedula(rs.getString("cedula"));  
                persona.setNombre_ape(rs.getString("nombre_ape"));
                persona.setEdad(rs.getInt("edad"));
                persona.setSexo(rs.getString("sexo"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setCorreo(rs.getString("correo"));
                persona.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
                list.add(persona);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }
    
     @Override
    public boolean delete(String id) {
        boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = Connector.open(Connector.SQLSERVER); //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM [dbo].[persona] WHERE cedula = ").append(id);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
            System.out.println("borrao");
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
    

        
    @Override
    public boolean save(Persona persona,int ope) {
             this.conn = Connector.open(Connector.SQLSERVER); 
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
             //  Statement conn = Connector.getConnector().createStatement();
               
            if (ope == 1) {  //es cero cuando se esta ingresando un registro nuevo: ver inicializac'on del atributo 
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
               sql.append("INSERT INTO [dbo].[persona] ([cedula] ,[nombre_ape] ,[edad] ,[sexo] ,[telefono] ,[correo],[fecha_carga]) VALUES (");
                sql.append("'").append(persona.getCedula());
                 sql.append("', '").append(persona.getNombre_ape());                  
                 sql.append("',  ").append(persona.getEdad()); 
                 sql.append(" , '").append(persona.getSexo());                  
                 sql.append("', '").append(persona.getTelefono()); 
                 sql.append("', '").append(persona.getCorreo()); 
                 sql.append("', '").append(persona.getFecha_carga()).append("' )");      //crear la cadena de conexion
                 this.conn.execute(sql.toString()); 
                 System.out.println("creao");
            } else {   //es un registro previamente existente: estamos actualizando
                StringBuilder sql2 = new StringBuilder();   //para crear la sentencia sql
                sql2.append("UPDATE [persona] SET [cedula] = '").append(persona.getCedula());
                sql2.append("', [nombre_ape] = '").append(persona.getNombre_ape());
                sql2.append("', [edad] = '").append(persona.getEdad());
                sql2.append("', [sexo] = '").append(persona.getSexo());
                sql2.append("', [telefono] = '").append(persona.getTelefono());
                sql2.append("', [correo] = '").append(persona.getCorreo());
                sql2.append("', [fecha_carga] = '").append(persona.getFecha_carga()).append("' WHERE [idpersona] = ").append(persona.getIdpersona()); 
            this.conn.execute(sql2.toString());
            System.out.println("editao");
            }
            save = true;                                //cambia estado de bandera
        } catch(Exception e){
             
        } finally {
            this.conn.close();      //cerrar la conexion
        }
        
        return save; 
    }
    
        
        
    @Override
    public Persona edit(String id) {
       this.conn = Connector.open(Connector.SQLSERVER); 
    Persona  persona = new Persona ();  
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM \"persona\" WHERE \"cedula\" = ").append(id);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){ 
            	persona.setIdpersona(rs.getInt("idpersona"));//mientras haya registros cargados en el reseltset
                persona.setCedula(rs.getString("cedula"));
                 persona.setNombre_ape(rs.getString("nombre_ape"));
                  persona.setEdad(rs.getInt("edad"));
                   persona.setSexo(rs.getString("sexo"));
                    persona.setTelefono(rs.getString("telefono"));
                     persona.setCorreo(rs.getString("correo"));
                  persona.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
            }
        } catch (Exception e) {
        	e.toString();
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return persona;             //devuelve el objeto creado
    }



    
}
