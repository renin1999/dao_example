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



public class MarcaDAOImpl implements IMarcaDAO{

    
     ConnectionDb conex;
	@Override
	public List<MarcaArticulo> list() {
		 StringBuilder sql = new StringBuilder();
	        sql.append("SELECT * FROM \"marca\"");  //construye la cadena de consulta

	        List<MarcaArticulo> list = new ArrayList<>(); //list es la lista de cuentas bancarias
	        
	        try{
	        	this.conex = Connector.open(Connector.SQLSERVER);
            ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
	            while (rs.next()){  //mientras haya registros en la tabla
	            	MarcaArticulo marca = new MarcaArticulo();  
	            	marca.setIdmarca(rs.getInt("idmarca"));//mientras haya registros cargados en el reseltset
	            	marca.setCodmarca(rs.getString("codmarca"));
	            	marca.setDetalle(rs.getString("detalle"));
	            	marca.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	                list.add(marca);  
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return list;
	}

	@Override
	public MarcaArticulo edit(String cod) {
		MarcaArticulo marca = new MarcaArticulo(); 
		try {
			this.conex = Connector.open(Connector.SQLSERVER);
			
			 StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
		     sql.append("SELECT * FROM \"marca\" WHERE \"codmarca\" = ").append(cod);
		
            ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
	            while (rs.next()){
	            	marca.setIdmarca(rs.getInt("direccion"));//mientras haya registros cargados en el reseltset
	            	marca.setCodmarca(rs.getString("direccion"));
	            	marca.setDetalle(rs.getString("direccion"));
	            	marca.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	            }
	            
			conex.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marca;
	}

	@Override
	public boolean save(MarcaArticulo marca, int ope) {
		try {
			
			this.conex = Connector.open(Connector.SQLSERVER);
        		StringBuilder sql = new StringBuilder();
			if(ope==1) {
				sql.append("INSERT INTO marca (codmarca, detalle, fecha_carga) VALUES ('").append(marca.getCodmarca());
	            sql.append("', '").append(marca.getDetalle());
	            sql.append("', '").append(marca.getFecha_carga()).append("')");      //crear la cadena de conexion
	            conex.execute(sql.toString());
				System.out.println("guardao");
				conex.close();
			}
			else {
				StringBuilder sql2 = new StringBuilder();   //para crear la sentencia sql

                sql2.append("UPDATE marca SET codmarca = '").append(marca.getCodmarca());
                sql2.append("', detalle = '").append(marca.getDetalle());      //crear la cadena de conexion    //crear la cadena de conexion
                sql2.append("', fecha_carga = '").append(marca.getFecha_carga()).append("' WHERE idmarca = ").append(marca.getIdmarca());      //crear la cadena de conexion
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
	public boolean delete(String cod) {
		boolean delete = false;                     //bandera que indica resultado de operacion
      try{
   this.conex = Connector.open(Connector.SQLSERVER);
          StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
          sql.append("DELETE FROM \"marca\" WHERE \"codmarca\" = ").append(cod);    //crea la sentencia de borrado
          conex.execute(sql.toString());              //ejecuta sentencia sql
          delete = true;
          conex.close(); 
      } catch (Exception e) {
      	e.printStackTrace();
      } 
      return delete;   
	}

}
