package com.proyecto.clogn.interfaces;


import com.proyecto.clogn.entities.Persona;

public interface IPersona {
	public abstract void list();
	public abstract void find_edit(String cod);
	public abstract void save_edit (String ced, String nombre_ape, int edad, String sexo, String telefono, String correo,Persona persona);    //prototipo metodo editar desde pgsql
    public abstract void create (String ced, String nombre_ape, int edad, String sexo, String telefono, String correo);   //prototipo metodo guardar en pgsql
    public abstract void delete(String cod); 

}
