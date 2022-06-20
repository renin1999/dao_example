package com.proyecto.clogn.interfaces;

import com.proyecto.clogn.entities.Usuario;

public interface IUsuario {
	public abstract void list();
	public abstract void find_edit(String user);
	public abstract void save_edit (int idpersona, String user, String pass,Usuario usuario);    //prototipo metodo editar desde pgsql
    public abstract void create (int idpersona, String user, String pass);   //prototipo metodo guardar en pgsql
    public abstract void delete(String user); 
}
