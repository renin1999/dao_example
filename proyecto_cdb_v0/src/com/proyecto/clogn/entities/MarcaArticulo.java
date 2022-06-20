package com.proyecto.clogn.entities;

import java.time.LocalDate;
import java.util.Date;

public class MarcaArticulo {
	private int idmarca;
	private String codmarca;
	private String detalle;
	private LocalDate fecha_carga;
	

	/**
	 * @return the codmarca
	 */
	public String getCodmarca() {
		return codmarca;
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
	 * @param codmarca the codmarca to set
	 */
	public void setCodmarca(String codmarca) {
		this.codmarca = codmarca;
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


	public MarcaArticulo() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param codmarca
	 * @param detalle
	 * @param fecha_carga
	 */
	public MarcaArticulo(String codmarca, String detalle, LocalDate fecha_carga) {
		super();
		this.codmarca = codmarca;
		this.detalle = detalle;
		this.fecha_carga = fecha_carga;
	}


	@Override
	public String toString() {
		return "MarcaArticulo [idmarca=" + idmarca + ", codmarca=" + codmarca + ", detalle=" + detalle
				+ ", fecha_carga=" + fecha_carga + "]";
	}



	
}
