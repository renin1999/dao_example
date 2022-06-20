package com.proyecto.clogn.entities;

import java.time.LocalDate;
import java.util.Date;

public class Gerente {
	private int idgerente;
	private int idusuario;
        private LocalDate  fecha_carga;

	public Gerente() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public String toString() {
        return "Gerente{" + "idgerente=" + idgerente + ", idusuario=" + idusuario + ", fecha_carga=" + fecha_carga + '}';
    }

    public Gerente(int idgerente, int idusuario, LocalDate fecha_carga) {
        this.idgerente = idgerente;
        this.idusuario = idusuario;
        this.fecha_carga = fecha_carga;
    }

    public int getIdgerente() {
        return idgerente;
    }

    public void setIdgerente(int idgerente) {
        this.idgerente = idgerente;
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
