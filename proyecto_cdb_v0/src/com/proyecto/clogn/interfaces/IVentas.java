package com.proyecto.clogn.interfaces;

import java.time.LocalDate;

import com.proyecto.clogn.entities.Ventas;

public interface IVentas {
	public abstract void list();
	public abstract void find_edit(String cod);
	public abstract void save_edit (String cod, int idarticulo, int gerente, int cantidad, Double valor, LocalDate fechav,Ventas venta);    //prototipo metodo editar desde pgsql
    public abstract void create (String cod, int idarticulo, int gerente, int cantidad, Double valor, LocalDate fechav);   //prototipo metodo guardar en pgsql
    public abstract void delete(String cod); 
}
