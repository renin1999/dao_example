package com.proyecto.dao;

import java.util.List;

import com.proyecto.clogn.entities.MarcaArticulo;
import com.proyecto.clogn.entities.ProveedorCompras;

public interface IMarcaDAO {
	
    public abstract List<MarcaArticulo> list();    //prototipo metodo listar desde pgsql
    public abstract MarcaArticulo edit(String cod);    //prototipo metodo editar desde pgsql
    public abstract boolean save (MarcaArticulo marca,int ope);   //prototipo metodo guardar en pgsql
    public abstract boolean delete(String cod); 
    
}
