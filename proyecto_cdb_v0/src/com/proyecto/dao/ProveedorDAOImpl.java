package com.proyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.proyecto.caccdb.*;

import com.proyecto.clogn.entities.ProveedorCompras;

import com.proyecto.caccdb.Connector;


public class ProveedorDAOImpl implements IProveedorDao {
	
	 ConnectionDb conex;
         

	@Override
	public List<ProveedorCompras> list() {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM \"proveedor\"");  //construye la cadena de consulta

        List<ProveedorCompras> list = new ArrayList<>(); //list es la lista de cuentas bancarias
        
        try{
        this.conex = Connector.open(Connector.SQLSERVER);
            ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
            	ProveedorCompras proveedor = new ProveedorCompras();  
            	proveedor.setIdproveedor(rs.getInt("idproveedor"));//mientras haya registros cargados en el reseltset
            	proveedor.setCodproveedor(rs.getString("codproveedor"));
            	proveedor.setCorreo(rs.getString("correo"));
            	proveedor.setDireccion(rs.getString("direccion"));
            	proveedor.setNombre_ape(rs.getString("nombre_ape"));
            	proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
                list.add(proveedor);  
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
		
	}

	@Override
	public ProveedorCompras edit(String codproveedor) {
		ProveedorCompras proveedor = new ProveedorCompras(); 
		try {
			this.conex = Connector.open(Connector.SQLSERVER);
      	 StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
		     sql.append("SELECT * FROM \"proveedor\" WHERE \"codproveedor\" = ").append(codproveedor);
	    ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
	            while (rs.next()){
	            	proveedor.setIdproveedor(rs.getInt("idproveedor"));//mientras haya registros cargados en el reseltset
	            	proveedor.setCodproveedor(rs.getString("codproveedor"));
	            	proveedor.setCorreo(rs.getString("correo"));
	            	proveedor.setDireccion(rs.getString("direccion"));
	            	proveedor.setNombre_ape(rs.getString("nombre_ape"));
	            	proveedor.setTelefono(rs.getString("telefono"));
	                proveedor.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	            }
	            
			conex.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proveedor;
	}

	@Override
	public boolean save(ProveedorCompras proveedor, int ope) {
		try {
			this.conex = Connector.open(Connector.SQLSERVER);
      
                        StringBuilder sql = new StringBuilder();
			if(ope==1) {
				sql.append("INSERT INTO proveedor (codproveedor, nombre_ape, telefono, correo, direccion, fecha_carga) VALUES ('").append(proveedor.getCodproveedor());
				sql.append("', '").append(proveedor.getNombre_ape());      //crear la cadena de conexion
	            sql.append("', '").append(proveedor.getTelefono());      //crear la cadena de conexion
	            sql.append("', '").append(proveedor.getCorreo());
	            sql.append("', '").append(proveedor.getDireccion());
	            sql.append("', '").append(proveedor.getFecha_carga()).append("')");      //crear la cadena de conexion
	            conex.execute(sql.toString());
				System.out.println("guardao");
				conex.close();
			}
			else {
				 StringBuilder sql2 = new StringBuilder();   //para crear la sentencia sql

	                sql2.append("UPDATE proveedor SET codproveedor = '").append(proveedor.getCodproveedor());
	                sql2.append("', nombre_ape = '").append(proveedor.getNombre_ape());      //crear la cadena de conexion
	                sql2.append("', telefono = '").append(proveedor.getTelefono());      //crear la cadena de conexion
	                sql2.append("', correo = '").append(proveedor.getCorreo());      //crear la cadena de conexion
	                sql2.append("', direccion = '").append(proveedor.getDireccion());      //crear la cadena de conexion
	                sql2.append("', fecha_carga = '").append(proveedor.getFecha_carga()).append("' WHERE idproveedor = ").append(proveedor.getIdproveedor());      //crear la cadena de conexion
	                conex.execute(sql2.toString());
					System.out.println("editao");
					conex.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String cod) {
		boolean delete = false;                     //bandera que indica resultado de operacion

		
		  //abrir la conexion con bd mysql
        try{
        this.conex = Connector.open(Connector.SQLSERVER);
            StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
            sql.append("DELETE FROM \"proveedor\" WHERE \"codproveedor\" = ").append(cod);    //crea la sentencia de borrado
            conex.execute(sql.toString());              //ejecuta sentencia sql
            delete = true;
            conex.close(); 
        } catch (Exception e) {
        	e.printStackTrace();
        } 
        return delete;    
	}

}
