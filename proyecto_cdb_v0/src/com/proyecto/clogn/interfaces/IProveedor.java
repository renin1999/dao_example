package com.proyecto.clogn.interfaces;

import java.util.List;



import com.proyecto.clogn.entities.ProveedorCompras;
import com.proyecto.clogn.entities.TipoArticulo;

public interface IProveedor {
	public abstract void list();
	public abstract void find_edit(String cod);
	public abstract void save_edit (String cod, String correo, String dir, String nombre_ape, String tel, ProveedorCompras prov);    //prototipo metodo editar desde pgsql
    public abstract void create (String cod, String correo, String dir, String nombre_ape, String tel);   //prototipo metodo guardar en pgsql
    public abstract void delete(String cod); 

}
