/**
 * 
 */
package com.proyecto.clogn.interfaces;

import java.util.List;

import com.proyecto.clogn.entities.Articulo;
import com.proyecto.clogn.entities.TipoArticulo;

/**
 * @author lenfa
 *
 */
public interface IArticulo {
	   
	public abstract void list();
	public abstract void find_edit(String cod);
	public abstract void save_edit (String cod, String detalle, int idmarca, int idtipo, int stock, double valorc, double valorv, Articulo Arti);    //prototipo metodo editar desde pgsql
    public abstract void create (String cod, String detalle, int idmarca, int idtipo, int stock, double valorc, double valorv);   //prototipo metodo guardar en pgsql
    public abstract void delete(String cod); 
}
