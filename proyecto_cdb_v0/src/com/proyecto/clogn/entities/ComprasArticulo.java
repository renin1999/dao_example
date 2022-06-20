package com.proyecto.clogn.entities;

import java.time.LocalDate;
import java.util.Date;

public class ComprasArticulo {
	
        private int idcompra;
	private String codcompra;
	private int idarticulo; 
	private int idproveedor;
	private int cantidad;
	private double valor;
	private double total_compra;
	private LocalDate fecha_compra;
	private LocalDate fecha_carga;
	

	/**
	 * @return the codcompra
	 */
	public String getCodcompra() {
		return codcompra;
	}


	/**
	 * @param codcompra the codcompra to set
	 */
	public void setCodcompra(String codcompra) {
		this.codcompra = codcompra;
	}




	

	@Override
	public String toString() {
		return "ComprasArticulo [idcompra=" + idcompra + ", codcompra=" + codcompra + ", idarticulo=" + idarticulo
				+ ", idproveedor=" + idproveedor + ", cantidad=" + cantidad + ", valor=" + valor + ", total_compra="
				+ total_compra + ", fecha_compra=" + fecha_compra + ", fecha_carga=" + fecha_carga + "]";
	}


	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}


	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}


	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}


	/**
	 * @return the total_compra
	 */
	public double getTotal_compra() {
		return total_compra;
	}


	/**
	 * @param total_compra the total_compra to set
	 */
	public void setTotal_compra(double total_compra) {
		this.total_compra = total_compra;
	}


	/**
	 * @return the fecha_compra
	 */
	public LocalDate getFecha_compra() {
		return fecha_compra;
	}


	/**
	 * @param fecha_compra the fecha_compra to set
	 */
	public void setFecha_compra(LocalDate fecha_compra) {
		this.fecha_compra = fecha_compra;
	}


	public ComprasArticulo() {
		// TODO Auto-generated constructor stub
	}

    public ComprasArticulo(int idcompra, String codcompra, int idarticulo, int idproveedor, int cantidad, double valor, double total_compra, LocalDate fecha_compra, LocalDate fecha_carga) {
        this.idcompra = idcompra;
        this.codcompra = codcompra;
        this.idarticulo = idarticulo;
        this.idproveedor = idproveedor;
        this.cantidad = cantidad;
        this.valor = valor;
        this.total_compra = total_compra;
        this.fecha_compra = fecha_compra;
        this.fecha_carga = fecha_carga;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(int idarticulo) {
        this.idarticulo = idarticulo;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public LocalDate getFecha_carga() {
        return fecha_carga;
    }

    public void setFecha_carga(LocalDate fecha_carga) {
        this.fecha_carga = fecha_carga;
    }


}
