package com.proyecto.clogn.entities;

import java.time.LocalDate;
import java.util.Date;

public class Persona {
private int idpersona;
	private String cedula;
	private String nombre_ape;
	private int edad;
	private String sexo;
	private String telefono;
	private String correo;
	private LocalDate fecha_carga;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

    public int getIdpersona() {
        return idpersona;
    }

    public Persona(int idpersona, String cedula, String nombre_ape, int edad, String sexo, String telefono, String correo, LocalDate fecha_carga) {
        this.idpersona = idpersona;
        this.cedula = cedula;
        this.nombre_ape = nombre_ape;
        this.edad = edad;
        this.sexo = sexo;
        this.telefono = telefono;
        this.correo = correo;
        this.fecha_carga = fecha_carga;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public LocalDate getFecha_carga() {
        return fecha_carga;
    }

    public void setFecha_carga(LocalDate fecha_carga) {
        this.fecha_carga = fecha_carga;
    }

	/**
	 * @param cedula
	 * @param nombre_ape
	 * @param edad
	 * @param sexo
	 * @param telefono
	 * @param correo
	 * @param fecha_carga
	 */
	
	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	 * @return the fecha_carga
	 */
	

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre_ape=" + nombre_ape + ", edad=" + edad + ", sexo=" + sexo
				+ ", telefono=" + telefono + ", correo=" + correo + ", fecha_carga=" + fecha_carga + "]";
	}
	
	

}
