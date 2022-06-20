package com.proyecto.clogn.entities;

import java.time.LocalDate;
import java.util.Date;

public class Usuario {
        private int idusuario;
	private int idpersona;
	private String user;
	private String password;
	private LocalDate  fecha_carga;

    

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public Usuario(int idusuario, int idpersona, String user, String password, LocalDate fecha_carga) {
        this.idusuario = idusuario;
        this.idpersona = idpersona;
        this.user = user;
        this.password = password;
        this.fecha_carga = fecha_carga;
    }

 
    public LocalDate getFecha_carga() {
        return fecha_carga;
    }

    public void setFecha_carga(LocalDate fecha_carga) {
        this.fecha_carga = fecha_carga;
    }
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idpersona
	 * @param user
	 * @param password
	 * @param fecha_carga
	 */
	

	
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", idpersona=" + idpersona + ", user=" + user + ", password="
				+ password + ", fecha_carga=" + fecha_carga + "]";
	}

	/**
	 * @return the fecha_carga
	 */
	
	

}
