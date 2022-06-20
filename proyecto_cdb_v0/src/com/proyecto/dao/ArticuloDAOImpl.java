/**
 * 
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
import com.proyecto.clogn.entities.Articulo;


/**
 * @author lenfa
 *
 */
public class ArticuloDAOImpl implements IArticuloDAO {

	 ConnectionDb conex;
    
    
	@Override
	public List<Articulo> list() {
		StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM \"articulo\"");  //construye la cadena de consulta

        List<Articulo> list = new ArrayList<>(); //list es la lista de cuentas bancarias
        
        try{
        	  this.conex = Connector.open(Connector.SQLSERVER);
            ResultSet rs = this.conex.query(sql.toString()); //ejecuta la consulta
            while (rs.next()){  //mientras haya registros en la tabla
            	Articulo articulo = new Articulo();  
            	articulo.setIdarticulo(rs.getInt("idarticulo"));//mientras haya registros cargados en el reseltset
            	articulo.setIdtipo(rs.getInt("idtipo"));
            	articulo.setIdmarca(rs.getInt("idmarca"));
            	articulo.setCod_articulo(rs.getString("cod_articulo"));
            	articulo.setDetalle(rs.getString("detalle"));
            	articulo.setValor_compra(rs.getDouble("valor_compra"));
            	articulo.setValor_venta(rs.getDouble("valor_venta"));
            	articulo.setStock_final(rs.getInt("stock_final"));
            	articulo.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
                list.add(articulo);  
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return list;
	}

	@Override
	public Articulo edit(String cod) {
		Articulo articulo = new Articulo(); 
		try {
			this.conex = Connector.open(Connector.SQLSERVER);
			
			 StringBuilder sql = new StringBuilder();    //para almacenar la consulta e efectuar en la bd
		     sql.append("SELECT * FROM \"articulo\" WHERE \"cod_articulo\" = ").append(cod);
		        ResultSet rs = this.conex.query(sql.toString());  //ejecuta la consulta
        
	            while (rs.next()){
	            	articulo.setIdarticulo(rs.getInt("idarticulo"));//mientras haya registros cargados en el reseltset
	            	articulo.setIdtipo(rs.getInt("idtipo"));
	            	articulo.setIdmarca(rs.getInt("idmarca"));
	            	articulo.setCod_articulo(rs.getString("cod_articulo"));
	            	articulo.setDetalle(rs.getString("detalle"));
	            	articulo.setValor_compra(rs.getDouble("valor_compra"));
	            	articulo.setValor_venta(rs.getDouble("valor_venta"));
	            	articulo.setStock_final(rs.getInt("stock_final"));
	            	articulo.setFecha_carga(rs.getObject("fecha_carga", LocalDate.class));
	            }
	            
			conex.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articulo;
	}

	@Override
	public boolean save(Articulo arti,int ope) {
		boolean save=false;
		try {
			
				this.conex = Connector.open(Connector.SQLSERVER);
			
			StringBuilder sql = new StringBuilder();
			if(ope==1) {
				sql.append("INSERT INTO articulo (idtipo, idmarca, cod_articulo, detalle, valor_compra, valor_venta, stock_final, fecha_carga) VALUES ('").append(arti.getIdtipo());
	            sql.append("', '").append(arti.getIdmarca());
	            sql.append("', '").append(arti.getCod_articulo());
	            sql.append("', '").append(arti.getDetalle());
	            sql.append("', '").append(arti.getValor_compra());
	            sql.append("', '").append(arti.getValor_venta());
	            sql.append("', '").append(arti.getStock_final());
	            sql.append("', '").append(arti.getFecha_carga()).append("')");      //crear la cadena de conexion
	            conex.execute(sql.toString());
				System.out.println("guardao");
				conex.close();
				save=true;
			}
			else {
				StringBuilder sql2 = new StringBuilder();   //para crear la sentencia sql

                sql2.append("UPDATE articulo SET cod_articulo = '").append(arti.getCod_articulo());
                sql2.append("', idtipo = '").append(arti.getIdtipo());      //crear la cadena de conexion
                sql2.append("', idmarca = '").append(arti.getIdmarca());      //crear la cadena de conexion
                sql2.append("', detalle = '").append(arti.getDetalle());      //crear la cadena de conexion
                sql2.append("', valor_compra = '").append(arti.getValor_compra()); 
                sql2.append("', valor_venta = '").append(arti.getValor_venta());
                sql2.append("', stock_final = '").append(arti.getStock_final());//crear la cadena de conexion
                sql2.append("', fecha_carga = '").append(arti.getFecha_carga()).append("' WHERE idarticulo = ").append(arti.getIdarticulo());      //crear la cadena de conexion
                conex.execute(sql2.toString());
				System.out.println("editao");
				conex.close();
				save=true;
			}
			
		 } catch(Exception e){
             
        } finally {
            this.conex.close();      //cerrar la conexion
        }
		return save;
	}

	@Override
	public boolean delete(String cod) {
		boolean delete = false;                     //bandera que indica resultado de operacion
		  //abrir la conexion con bd mysql
      try{
      this.conex = Connector.open(Connector.SQLSERVER);
      StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
          sql.append("DELETE FROM \"articulo\" WHERE \"cod_articulo\" = ").append(cod);    //crea la sentencia de borrado
          conex.execute(sql.toString());              //ejecuta sentencia sql
          delete = true;
          conex.close(); 
      } catch (Exception e) {
      	e.printStackTrace();
      } 
      return delete;  
	}

}
