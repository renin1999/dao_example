package com.proyecto.clogn.entities;

import java.time.LocalDate;

public class Administrador {
private int idadministrador;
	private int idusuario;
        private LocalDate  fecha_carga;

	public Administrador() {
		// TODO Auto-generated constructor stub
	}

    public int getIdadministrador() {
        return idadministrador;
    }

    @Override
    public String toString() {
        return "Administrador{" + "idadministrador=" + idadministrador + ", idusuario=" + idusuario + ", fecha_carga=" + fecha_carga + '}';
    }

    public Administrador(int idadministrador, int idusuario, LocalDate fecha_carga) {
        this.idadministrador = idadministrador;
        this.idusuario = idusuario;
        this.fecha_carga = fecha_carga;
    }

    public void setIdadministrador(int idadministrador) {
        this.idadministrador = idadministrador;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public LocalDate getFecha_carga() {
        return fecha_carga;
    }

    public void setFecha_carga(LocalDate fecha_carga) {
        this.fecha_carga = fecha_carga;
    }

}
