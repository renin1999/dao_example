package com.proyecto.clogn.interfaces;

import java.time.LocalDate;

import com.proyecto.clogn.entities.ComprasArticulo;

public interface IComprasArticulo {
	public abstract void list();
	public abstract void find_edit(String cod);
	public abstract void save_edit (int idarticulo, int idproveedor,String codcompra, int cantidad, Double valor, Double totalcompra, LocalDate fechacompra, ComprasArticulo compra);    //prototipo metodo editar desde pgsql
    public abstract void create (int idarticulo, int idproveedor,String codcompra, int cantidad, Double valor, Double totalcompra, LocalDate fechacompra);   //prototipo metodo guardar en pgsql
    public abstract void delete(String cod); 

}
