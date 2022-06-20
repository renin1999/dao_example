package com.proyecto.dao;

import com.proyecto.caccdb.ConnectionDb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.proyecto.caccdb.Connector;
import com.proyecto.clogn.entities.TipoArticulo;

public class TipoDAOImpl implements ITipoDAO{
	 ConnectionDb conex;
	@Override
	public List<TipoArticulo> list() {
		 StringBuilder sql = new StringBuilder();
	        sql.append("SELECT * FROM \"tipo\"");  //construye la cadena de consulta

	        List<TipoArticulo> list = new ArrayList<>(); //list es la lista de cuentas bancarias
	        
	        try{
	        this.conex = Connector.open(Connector.SQLSERVER);
            ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
	            while (rs.next()){  //mientras haya registros en la tabla
	            	TipoArticulo tipo = new TipoArticulo();  
	            	tipo.setTipo(rs.getInt("idtipo"));//mientras haya registros cargados en el reseltset
	            	tipo.setCodtipo(rs.getString("codtipo"));
	            	tipo.setDetalles(rs.getString("detalles"));
	            	tipo.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	                list.add(tipo);  
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return list;
	}

	@Override
	public TipoArticulo edit(String cod) {
		TipoArticulo tipo = new TipoArticulo(); 
		try {
			this.conex = Connector.open(Connector.SQLSERVER);
			 StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
		     sql.append("SELECT * FROM \"marca\" WHERE \"codmarca\" = ").append(cod);
	    ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
	            while (rs.next()){
	            	tipo.setTipo(rs.getInt("idtipo"));//mientras haya registros cargados en el reseltset
	            	tipo.setCodtipo(rs.getString("codtipo"));
	            	tipo.setDetalles(rs.getString("detalles"));
	            	tipo.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	            }
	            
			conex.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tipo;
		
	}

	@Override
	public boolean save(TipoArticulo tipo,int ope) {
		try {
			
			this.conex = Connector.open(Connector.SQLSERVER);
           
                        StringBuilder sql = new StringBuilder();
			if(ope==1) {
				sql.append("INSERT INTO tipo (codtipo, detalles, fecha_carga) VALUES ('").append(tipo.getCodtipo());
	            sql.append("', '").append(tipo.getDetalles());
	            sql.append("', '").append(tipo.getFecha_carga()).append("')");      //crear la cadena de conexion
	            conex.execute(sql.toString());
				System.out.println("guardao");
				conex.close();
			}else {
				StringBuilder sql2 = new StringBuilder();   //para crear la sentencia sql

                sql2.append("UPDATE tipo SET codtipo = '").append(tipo.getCodtipo());
                sql2.append("', detalles = '").append(tipo.getDetalles());      //crear la cadena de conexion    //crear la cadena de conexion
                sql2.append("', fecha_carga = '").append(tipo.getFecha_carga()).append("' WHERE idtipo = ").append(tipo.getTipo());      //crear la cadena de conexion
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
	          sql.append("DELETE FROM \"tipo\" WHERE \"codtipo\" = ").append(cod);    //crea la sentencia de borrado
	          conex.execute(sql.toString());              //ejecuta sentencia sql
	          delete = true;
	          conex.close(); 
	      } catch (Exception e) {
	      	e.printStackTrace();
	      } 
	      return delete; 
	}

}
