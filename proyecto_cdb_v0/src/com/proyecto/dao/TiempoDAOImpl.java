/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.caccdb.ConnectionDb;
import com.proyecto.caccdb.Connector;
import com.proyecto.clogn.entities.MarcaArticulo;
import com.proyecto.clogn.entities.Tiempo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue Tello
 */
public class TiempoDAOImpl implements ITiempoDAO {
 ConnectionDb conex;
 
    @Override
    public List<Tiempo> list() {
     StringBuilder sql = new StringBuilder();
	        sql.append("SELECT * FROM \"tiempo\"");  //construye la cadena de consulta

	         List<Tiempo> list = new ArrayList<>(); //list es la lista de cuentas bancarias
	      
	        try{
	        	this.conex = Connector.open(Connector.SQLSERVER);
            ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
	            while (rs.next()){  //mientras haya registros en la tabla
	            	Tiempo tiempo = new Tiempo();  
	            	tiempo.setIdtiempo(rs.getInt("idtiempo"));//mientras haya registros cargados en el reseltset
	            	tiempo.setTiempo(rs.getDate("tiempo"));
	            	tiempo.setAnio(rs.getInt("anio"));
                        tiempo.setMes(rs.getInt("mes"));
                        tiempo.setMes_str(rs.getString("mes_str"));
                        tiempo.setDia(rs.getInt("dia"));
                        tiempo.setDia_str(rs.getString("dia_str"));
	            	tiempo.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	                list.add(tiempo);  
	                conex.close(); //añade el objeto temporal en la lista
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return list;
    }

    @Override
    
    public Tiempo edit(int id) {
   Tiempo tiempo = new Tiempo(); 
		try {
			this.conex = Connector.open(Connector.SQLSERVER);
			
			 StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
		     sql.append("SELECT * FROM \"tiempo\" WHERE \"idtiempo\" = ").append(id);
		
            ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
	            while (rs.next()){
	            	tiempo.setTiempo(rs.getDate("tiempo"));
	            	tiempo.setAnio(rs.getInt("anio"));
                        tiempo.setMes(rs.getInt("mes"));
                        tiempo.setMes_str(rs.getString("mes_str"));
                        tiempo.setDia(rs.getInt("dia"));
                        tiempo.setDia_str(rs.getString("dia_str"));
	            	tiempo.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	            }
	            
			conex.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tiempo; 
    }


    @Override
    public boolean delete(int id) {
   boolean delete = false;                     //bandera que indica resultado de operacion
      try{
   this.conex = Connector.open(Connector.SQLSERVER);
          StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
          sql.append("DELETE FROM \"tiempo\" WHERE \"idtiempo\" = ").append(id);    //crea la sentencia de borrado
          conex.execute(sql.toString());              //ejecuta sentencia sql
          delete = true;
          conex.close(); 
      } catch (Exception e) {
      	e.printStackTrace();
      } 
      return delete;   
	}


    @Override
    public boolean save(Tiempo tiempo, int ope) {
    
    try {
			
			this.conex = Connector.open(Connector.SQLSERVER);
        		StringBuilder sql = new StringBuilder();
			if(ope==1) {
				sql.append("INSERT INTO tiempo (tiempo, anio, mes, mes_str, dia, dia_str, fecha_carga) VALUES ('").append(tiempo.getTiempo());
	            sql.append("', ").append(tiempo.getAnio());
                    sql.append(", ").append(tiempo.getMes());
                     sql.append(", '").append(tiempo.getMes_str());
                      sql.append("', ").append(tiempo.getDia());
                       sql.append(", '").append(tiempo.getDia_str());                     
	            sql.append("', '").append(tiempo.getFecha_carga()).append("')");      //crear la cadena de conexion
	            conex.execute(sql.toString());
				System.out.println("guardao");
				conex.close();
			}
			else {
				StringBuilder sql2 = new StringBuilder();   //para crear la sentencia sql

                sql2.append("UPDATE tiempo SET tiempo = '").append(tiempo.getTiempo());
                sql2.append("', anio = '").append(tiempo.getAnio());      //crear la cadena de conexion    //crear la cadena de conexion
                sql2.append("', mes = '").append(tiempo.getMes());  
                sql2.append("', mes_str = '").append(tiempo.getMes_str());  
                sql2.append("', dia = '").append(tiempo.getDia());  
                sql2.append("', dia_str = '").append(tiempo.getDia_str());  
                sql2.append("', fecha_carga = '").append(tiempo.getFecha_carga()).append("' WHERE idtiempo = ").append(tiempo.getTiempo());      //crear la cadena de conexion
                conex.execute(sql2.toString());
				System.out.println("editao");
				conex.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
    
    }
    
    
}
