/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.caccdb.ConnectionDb;
import com.proyecto.caccdb.Connector;
import com.proyecto.clogn.entities.Articulo;
import com.proyecto.clogn.entities.ComprasArticulo;
import com.proyecto.clogn.entities.TipoArticulo;
import java.util.List;

/**
 *
 * @author Josue Tello
 */
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ComprasDAOImpl  implements IComprasDAO {

     ConnectionDb conn;
     ConnectionDb conex;

	//Statement conn = Connector.getConnector().createStatement();
    @Override
    public List<ComprasArticulo> list() {      // listado desde la bd mysql
    	StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM \"compras\"");  //construye la cadena de consulta

        List<ComprasArticulo> list = new ArrayList<>(); //list es la lista de cuentas bancarias
        
        try{
        	  this.conex = Connector.open(Connector.SQLSERVER);
            ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
            	ComprasArticulo compras = new ComprasArticulo();  
            	compras.setIdarticulo(rs.getInt("idarticulo"));//mientras haya registros cargados en el reseltset
            	compras.setCantidad(rs.getInt("cantidad"));
            	compras.setCodcompra(rs.getString("codcompra"));
            	compras.setFecha_compra(rs.getObject("fecha_compra", LocalDate.class));
            	compras.setIdcompra(rs.getInt("idcompra"));
            	compras.setIdproveedor(rs.getInt("idproveedor"));
            	compras.setTotal_compra(rs.getDouble("total_compra"));
            	compras.setValor(rs.getDouble("valor"));
            	compras.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
                list.add(compras);  
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
    }
    
    
     @Override
    public boolean delete(String cod) {

        boolean delete = false;                     //bandera que indica resultado de operacion

        this.conn = Connector.open(Connector.SQLSERVER); //abrir la conexion con bd mysql
        try{
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM [dbo].[compras] WHERE idcompras = ").append(cod);    //crea la sentencia de borrado
            this.conn.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
        } catch (Exception e) {
            
        } finally {
            this.conn.close();                  //cierra la conexion
        }
        return delete;                              //devuelve el valor de la bandera
    }
    

    @Override
    public boolean save(ComprasArticulo compra, int ope) {
   try {
			
			this.conn = Connector.open(Connector.SQLSERVER);
        		StringBuilder sql = new StringBuilder();
			if(ope==1) {
				sql.append("INSERT INTO compras (idarticulo, idproveedor, codcompra , cantidad, valor, total_compra, fecha_compra, fecha_carga) VALUES (").append(compra.getIdarticulo());
	            sql.append(", ").append(compra.getIdproveedor());
                    sql.append(", '").append(compra.getCodcompra());
                    sql.append("', ").append(compra.getCantidad());
                    sql.append(", ").append(compra.getValor());
                    sql.append(", ").append(compra.getTotal_compra());
                    sql.append(", '").append(compra.getFecha_compra());
	            sql.append("', '").append(compra.getFecha_carga()).append("')");      //crear la cadena de conexion
	            conn.execute(sql.toString());
				System.out.println("guardao");
				conn.close();
			}
			else {
				StringBuilder sql2 = new StringBuilder();   //para crear la sentencia sql

                sql2.append("UPDATE compras SET idarticulo = ").append(compra.getIdarticulo());
                            sql2.append(", idproveedor = ").append(compra.getIdproveedor());
                            sql2.append(", codcompra = '").append(compra.getCodcompra());
                            sql2.append("', cantidad = ").append(compra.getCantidad());
                            sql2.append(", valor = ").append(compra.getValor());
                            sql2.append(", total_compra = ").append(compra.getTotal_compra());
                            sql2.append(", fecha_compra = '").append(compra.getFecha_compra());    //crear la cadena de conexion
                            sql2.append("', fecha_carga = '").append(compra.getFecha_carga()).append("' WHERE idcompra = ").append(compra.getIdcompra());      //crear la cadena de conexion
                conn.execute(sql2.toString());
				System.out.println("editao");
				conn.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

     

    @Override
    public ComprasArticulo edit(String cod) {
    ComprasArticulo compra = new ComprasArticulo(); 
		try {
			this.conn = Connector.open(Connector.SQLSERVER);
			
			 StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
		     sql.append("SELECT * FROM \"compras\" WHERE \"idcompra\" = ").append(cod);
		
            ResultSet rs = this.conn.query(sql.toString()); //ejecuta la consulta
	            while (rs.next()){
	            	compra.setIdcompra(rs.getInt("idcompra"));
	            	compra.setIdarticulo(rs.getInt("idarticulo"));
                        compra.setIdproveedor(rs.getInt("idproveedor"));
                        compra.setCodcompra(rs.getString("codcompra"));
                        compra.setCantidad(rs.getInt("cantidad"));
	            	compra.setValor(rs.getDouble("valor"));
                       compra.setTotal_compra(rs.getDouble("total_compra"));
                         compra.setFecha_compra(rs.getObject("fecha_compra", LocalDate.class));
	            	compra.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	            }
	            
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compra;
    }

    
}
