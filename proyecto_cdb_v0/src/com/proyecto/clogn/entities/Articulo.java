package com.proyecto.clogn.entities;

import java.time.LocalDate;
import java.util.Date;

public class Articulo {
	private int idarticulo;
	private int idtipo;
	private int idmarca;
	private String cod_articulo;
	private String detalle;
	private double valor_compra;
	private double valor_venta;
	private int stock_final;
	private LocalDate fecha_carga;
	
	public Articulo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idtipo
	 * @param idmarca
	 * @param cod_articulo
	 * @param detalle
	 * @param valor_compra
	 * @param valor_venta
	 * @param stock_anterior
	 * @param stock_final
	 * @param fecha_carga
	 */
	public Articulo(int idtipo, int idmarca, String cod_articulo, String detalle,
			double valor_compra, double valor_venta, int stock_final, LocalDate fecha_carga) {
		super();
		this.idtipo = idtipo;
		this.idmarca = idmarca;
		this.cod_articulo = cod_articulo;
		this.detalle = detalle;
		this.valor_compra = valor_compra;
		this.valor_venta = valor_venta;
		this.stock_final = stock_final;
		this.fecha_carga = fecha_carga;
	}



	@Override
	public String toString() {
		return "Articulo [idarticulo=" + idarticulo + ", idtipo=" + idtipo + ", idmarca=" + idmarca + ", cod_articulo="
				+ cod_articulo + ", detalle=" + detalle + ", valor_compra=" + valor_compra + ", valor_venta="
				+ valor_venta + ", stock_final=" + stock_final + ", fecha_carga=" + fecha_carga + "]";
	}

	/**
	 * @return the idtipo
	 */
	public int getIdtipo() {
		return idtipo;
	}

	/**
	 * @param idtipo the idtipo to set
	 */
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}

	/**
	 * @return the idmarca
	 */
	public int getIdmarca() {
		return idmarca;
	}

	/**
	 * @param idmarca the idmarca to set
	 */
	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}

	/**
	 * @return the cod_articulo
	 */
	public String getCod_articulo() {
		return cod_articulo;
	}

	/**
	 * @param cod_articulo the cod_articulo to set
	 */
	public void setCod_articulo(String cod_articulo) {
		this.cod_articulo = cod_articulo;
	}

	/**
	 * @return the detalle
	 */
	public String getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the valor_compra
	 */
	public double getValor_compra() {
		return valor_compra;
	}

	/**
	 * @param valor_compra the valor_compra to set
	 */
	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}

	/**
	 * @return the valor_venta
	 */
	public double getValor_venta() {
		return valor_venta;
	}

	/**
	 * @param valor_venta the valor_venta to set
	 */
	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

	/**
	 * @return the stock_anterior
	 */


	/**
	 * @return the stock_final
	 */
	public int getStock_final() {
		return stock_final;
	}

	/**
	 * @param stock_final the stock_final to set
	 */
	public void setStock_final(int stock_final) {
		this.stock_final = stock_final;
	}

	/**
	 * @return the fecha_carga
	 */
	public LocalDate getFecha_carga() {
		return fecha_carga;
	}

	/**
	 * @param fecha_carga the fecha_carga to set
	 */
	public void setFecha_carga(LocalDate fecha_carga) {
		this.fecha_carga = fecha_carga;
	}

	public int getIdarticulo() {
		return idarticulo;
	}

	public void setIdarticulo(int idarticulo) {
		this.idarticulo = idarticulo;
	}
	
	

}
