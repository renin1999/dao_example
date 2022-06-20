package com.proyecto.clogn.interfaces;

import com.proyecto.clogn.entities.Administrador;

public interface IAdministrador {
	public abstract void list();
	public abstract void find_edit(int idusuario);
	public abstract void save_edit (int idusuario, Administrador admin);    //prototipo metodo editar desde pgsql
    public abstract void create (int idusuario);   //prototipo metodo guardar en pgsql
    public abstract void delete(int idusuario); 
}
