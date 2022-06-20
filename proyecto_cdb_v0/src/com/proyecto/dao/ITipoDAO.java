/**
 * 
 */
package com.proyecto.dao;

import java.util.List;

import com.proyecto.clogn.entities.TipoArticulo;

/**
 * @author lenfa
 *
 */
public interface ITipoDAO {
    
    public abstract List<TipoArticulo> list();    //prototipo metodo listar desde pgsql
    public abstract TipoArticulo edit(String cod);    //prototipo metodo editar desde pgsql
    public abstract boolean save (TipoArticulo arti,int ope);   //prototipo metodo guardar en pgsql
    public abstract boolean delete(String cod); 
}
