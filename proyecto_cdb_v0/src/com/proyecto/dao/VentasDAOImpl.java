/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.caccdb.ConnectionDb;
import com.proyecto.caccdb.Connector;
import com.proyecto.clogn.entities.MarcaArticulo;
import com.proyecto.clogn.entities.Ventas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josue Tello
 */
public class VentasDAOImpl implements IVentasDAO {

     ConnectionDb conex;
     
    @Override
    public List<Ventas> list() {
         StringBuilder sql = new StringBuilder();
	        sql.append("SELECT * FROM \"ventas\"");  //construye la cadena de consulta

	        List<Ventas> list = new ArrayList<>(); //list es la lista de cuentas bancarias
	        
	        try{
	        	this.conex = Connector.open(Connector.SQLSERVER);
            ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
	            while (rs.next()){  //mientras haya registros en la tabla
	            	Ventas ventas = new Ventas();  
	            	ventas.setIdventas(rs.getInt("idventas"));
	            	ventas.setCodventas(rs.getString("codventas"));
	            	ventas.setFecha_venta(rs.getObject("fecha_venta", LocalDate.class));
	            	ventas.setIdarticulo(rs.getInt("idarticulo"));
                        ventas.setIdgerente(rs.getInt("idgerente"));
                        ventas.setCantidad(rs.getInt("cantidad"));
                         ventas.setValor(rs.getDouble("valor"));
                         ventas.setTotal_ventas(rs.getDouble("total_venta"));
                         ventas.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	                list.add(ventas);  
 //añade el objeto temporal en la lista
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return list;
    }

    @Override
    public Ventas edit(String id) {
  Ventas ventas = new Ventas(); 
		try {
			this.conex = Connector.open(Connector.SQLSERVER);
			
			 StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
		     sql.append("SELECT * FROM \"ventas\" WHERE \"codventas\" = ").append(id);
		
            ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
	            while (rs.next()){
	            		ventas.setIdventas(rs.getInt("idventas"));
	            		ventas.setFecha_venta(rs.getObject("fecha_venta", LocalDate.class));
	            	    ventas.setIdarticulo(rs.getInt("idarticulo"));
                        ventas.setIdgerente(rs.getInt("idgerente"));
                        ventas.setCodventas(rs.getString("codventas"));
                        ventas.setCantidad(rs.getInt("cantidad"));
                         ventas.setValor(rs.getDouble("valor"));
                         ventas.setTotal_ventas(rs.getDouble("total_venta"));
                         ventas.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	            }
	            
			conex.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ventas;
    }

    @Override
    public boolean save(Ventas ventas, int ope) {
    
        try {
			
			this.conex = Connector.open(Connector.SQLSERVER);
        		StringBuilder sql = new StringBuilder();
			if(ope==1) {
				sql.append("INSERT INTO ventas (idarticulo, idgerente ,codventas, cantidad, valor, total_venta,fecha_venta, fecha_carga) VALUES (").append(ventas.getIdarticulo());                
                    sql.append(" , ").append(ventas.getIdgerente());
                    sql.append(" , '").append(ventas.getCodventas());
                    sql.append("', ").append(ventas.getCantidad());
                    sql.append(" , ").append(ventas.getValor());
                    sql.append(" , ").append(ventas.getTotal_ventas());
                    sql.append(" , '").append(ventas.getFecha_venta());
	            sql.append("' , '").append(ventas.getFecha_carga()).append("' )");      //crear la cadena de conexion
	            conex.execute(sql.toString());
				System.out.println("guardao");
				conex.close();
			}
			else {
				StringBuilder sql2 = new StringBuilder();   //para crear la sentencia sql

                sql2.append("UPDATE ventas SET idarticulo = ").append(ventas.getIdarticulo());
                sql2.append(", codventas = '").append(ventas.getCodventas());
                sql2.append("', fecha_venta = '").append(ventas.getFecha_venta());
                sql2.append("', idgerente = ").append(ventas.getIdgerente());
                sql2.append(", cantidad = ").append(ventas.getCantidad());
                sql2.append(", total_venta = ").append(ventas.getTotal_ventas());
                sql2.append(", fecha_carga = '").append(ventas.getFecha_carga());//crear la cadena de conexion    //crear la cadena de conexion
                sql2.append("', valor = '").append(ventas.getValor()).append("' WHERE idventas = ").append(ventas.getIdventas());      //crear la cadena de conexion
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

    @Override
    public boolean delete(String id) {
   boolean delete = false;                     //bandera que indica resultado de operacion
      try{
   this.conex = Connector.open(Connector.SQLSERVER);
          StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
          sql.append("DELETE FROM \"ventas\" WHERE \"codventas\" = ").append(id);    //crea la sentencia de borrado
          conex.execute(sql.toString());              //ejecuta sentencia sql
          delete = true;
          conex.close(); 
      } catch (Exception e) {
      	e.printStackTrace();
      } 
      return delete;   
    }
    
}
