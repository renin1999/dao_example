package com.proyecto.dao;

import java.util.List;

import com.proyecto.clogn.entities.ProveedorCompras;

public interface IProveedorDao {
	
    public abstract List<ProveedorCompras> list();    //prototipo metodo listar desde pgsql
    public abstract ProveedorCompras edit(String cod);    //prototipo metodo editar desde pgsql
    public abstract boolean save (ProveedorCompras proveedor,int ope);   //prototipo metodo guardar en pgsql
    public abstract boolean delete(String cod);  

}
