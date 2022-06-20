/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.clogn.entities.Gerente;
import java.util.List;

/**
 *
 * @author Josue Tello
 */

import com.proyecto.caccdb.ConnectionDb;
import com.proyecto.caccdb.Connector;
import com.proyecto.clogn.entities.Gerente;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class GerenteDAOImpl implements IGerenteDAO {
ConnectionDb conn;

	//Statement conn = Connector.getConnector().createStatement();
    @Override
    public List<Gerente> list() {      // listado desde la bd mysql
        this.conn = Connector.open(Connector.SQLSERVER);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM gerente"); 
         LocalDate fecha = LocalDate.now();
        List<Gerente> list = new ArrayList<>();
        
        try{
            ResultSet rs = this.conn.query(sql.toString());  //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
               Gerente gerente = new Gerente();  
                gerente.setIdgerente(rs.getInt("idgerente"));  
                gerente.setIdusuario(rs.getInt("idusuario"));  
                gerente.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
                list.add(gerente);  //añade el objeto temporal en la lista
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();      //cierra la conexion
        }
        return list;    //devuelve la lista generada
    }
    

    @Override
    public Gerente edit(int id) {

        this.conn = Connector.open(Connector.SQLSERVER); 
    Gerente  gerente = new Gerente ();  
        
        StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
        sql.append("SELECT * FROM gerente WHERE idgerente = ").append(id);   //cadena de consulta
        
        try {
            ResultSet rs = this.conn.query(sql.toString());  //carga todos los registros que cumplen con la condicion del sql

            while (rs.next()){          //mientras haya registros cargados en el reseltset
                gerente.setIdgerente(rs.getInt("idgerente"));
                 gerente.setIdusuario(rs.getInt("idusuario"));
                  gerente.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
            }
        } catch (Exception e) {
            
        } finally {
            this.conn.close();          //cierra la conexion
        }
        return gerente;     
        
    }

    @Override
    public boolean save(Gerente gerente, int ope) {
        this.conn = Connector.open(Connector.SQLSERVER); 
        boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
             //  Statement conn = Connector.getConnector().createStatement();
               
            if (ope==1) {  //es cero cuando se esta ingresando un registro nuevo: ver inicializac'on del atributo 
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
               sql.append("INSERT INTO [dbo].[gerente] ([idusuario],[fecha_carga]) VALUES (");
                sql.append(" ").append(gerente.getIdusuario());
                 sql.append(" , '").append(gerente.getFecha_carga()).append("' )");      //crear la cadena de conexion
                 this.conn.execute(sql.toString()); 
                 System.out.println("guardao");
            } else {   //es un registro previamente existente: estamos actualizando
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("UPDATE [dbo].[gerente] SET [idusuario] = ").append(gerente.getIdusuario());
                sql.append(", [fecha_carga] = '").append(gerente.getFecha_carga()).append("' WHERE [idgerente] = ").append(gerente.getIdgerente()); 
            this.conn.execute(sql.toString());
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
    public boolean delete(int id) {
     boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = Connector.open(Connector.SQLSERVER); //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM [dbo].[gerente] WHERE idgerente = ").append(id);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;         
    
    }
    
}
