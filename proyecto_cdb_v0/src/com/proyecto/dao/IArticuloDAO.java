package com.proyecto.dao;

import java.util.List;

import com.proyecto.clogn.entities.Articulo;
import com.proyecto.clogn.entities.MarcaArticulo;

public interface IArticuloDAO {

    
    public abstract List<Articulo> list();    //prototipo metodo listar desde pgsql
    public abstract Articulo edit(String cod);    //prototipo metodo editar desde pgsql
    public abstract boolean save (Articulo arti,int ope);   //prototipo metodo guardar en pgsql
    public abstract boolean delete(String cod); 
}
