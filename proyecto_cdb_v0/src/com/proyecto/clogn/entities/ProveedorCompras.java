package com.proyecto.clogn.entities;

import java.time.LocalDate;
import java.util.Date;

public class ProveedorCompras {
	
	private int idproveedor;
	private String codproveedor;
	private String nombre_ape;
	private String telefono;
	private String correo;
	private String direccion;
	private LocalDate fecha_carga;

	/**
	 * @return the codproveedor
	 */
	
	public String getCodproveedor() {
		return codproveedor;
	}

	/**
	 * @return the idproveedor
	 */
	public int getIdproveedor() {
		return idproveedor;
	}

	/**
	 * @param codproveedor the codproveedor to set
	 */
	public void setCodproveedor(String codproveedor) {
		this.codproveedor = codproveedor;
	}

	/**
	 * @return the nombre_ape
	 */
	public String getNombre_ape() {
		return nombre_ape;
	}

	/**
	 * @param nombre_ape the nombre_ape to set
	 */
	public void setNombre_ape(String nombre_ape) {
		this.nombre_ape = nombre_ape;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
		return "ProveedorCompras [idproveedor=" + idproveedor + ", codproveedor=" + codproveedor + ", nombre_ape="
				+ nombre_ape + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion
				+ ", fecha_carga=" + fecha_carga + "]";
	}

	/**
	 * @param idproveedor the idproveedor to set
	 */
	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public ProveedorCompras() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codproveedor
	 * @param nombre_ape
	 * @param telefono
	 * @param correo
	 * @param direccion
	 * @param fecha_carga
	 */
	
	public ProveedorCompras(String codproveedor, String nombre_ape, String telefono, String correo, String direccion,
			LocalDate fecha_carga) {
		super();
		this.codproveedor = codproveedor;
		this.nombre_ape = nombre_ape;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.fecha_carga = fecha_carga;
	}

}
