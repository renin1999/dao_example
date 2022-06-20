package com.proyecto.clogn.entities;

import java.time.LocalDate;
import java.util.Date;

public class TipoArticulo {
	private int tipo;
	private String codtipo;
	private String detalles;
	private LocalDate fecha_carga;

	public TipoArticulo() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param codtipo
	 * @param detalles
	 * @param fecha_carga
	 */
	public TipoArticulo(String codtipo, String detalles, LocalDate fecha_carga) {
		super();
		this.codtipo = codtipo;
		this.detalles = detalles;
		this.fecha_carga = fecha_carga;
	}


	/**
	 * @return the codtipo
	 */
	public String getCodtipo() {
		return codtipo;
	}

	/**
	 * @param codtipo the codtipo to set
	 */
	public void setCodtipo(String codtipo) {
		this.codtipo = codtipo;
	}

	/**
	 * @return the detalles
	 */
	public String getDetalles() {
		return detalles;
	}

	/**
	 * @param detalles the detalles to set
	 */
	public void setDetalles(String detalles) {
		this.detalles = detalles;
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





	@Override
	public String toString() {
		return "TipoArticulo [tipo=" + tipo + ", codtipo=" + codtipo + ", detalles=" + detalles + ", fecha_carga="
				+ fecha_carga + "]";
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	

	
}
