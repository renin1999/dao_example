package com.proyecto.clogn.interfaces;

import java.util.List;

import com.proyecto.clogn.entities.TipoArticulo;

public interface ITipo {
	public abstract void list();
	public abstract void find_edit(String cod);
	public abstract void save_edit (String cod, String detalle, TipoArticulo tipo);    //prototipo metodo editar desde pgsql
    public abstract void create (String cod, String detalle);   //prototipo metodo guardar en pgsql
    public abstract void delete(String cod); 

}
