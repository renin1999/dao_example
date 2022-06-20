package com.proyecto.clogn.entities;

import java.time.LocalDate;
import java.util.Date;

public class Tiempo {
	
    private int idtiempo;	
    private int anio;
	private int mes;
	private String mes_str;
	private int dia;
	private String dia_str;
        private Date tiempo;
	private LocalDate fecha_carga;

	public Tiempo() {
		// TODO Auto-generated constructor stub
	}

    public int getIdtiempo() {
        return idtiempo;
    }

    public void setIdtiempo(int idtiempo) {
        this.idtiempo = idtiempo;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return "Tiempo{" + "idtiempo=" + idtiempo + ", anio=" + anio + ", mes=" + mes + ", mes_str=" + mes_str + ", dia=" + dia + ", dia_str=" + dia_str + ", tiempo=" + tiempo + ", fecha_carga=" + fecha_carga + '}';
    }

    public Tiempo(int idtiempo, int anio, int mes, String mes_str, int dia, String dia_str, Date tiempo, LocalDate fecha_carga) {
        this.idtiempo = idtiempo;
        this.anio = anio;
        this.mes = mes;
        this.mes_str = mes_str;
        this.dia = dia;
        this.dia_str = dia_str;
        this.tiempo = tiempo;
        this.fecha_carga = fecha_carga;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getMes_str() {
        return mes_str;
    }

    public void setMes_str(String mes_str) {
        this.mes_str = mes_str;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getDia_str() {
        return dia_str;
    }

    public void setDia_str(String dia_str) {
        this.dia_str = dia_str;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public LocalDate getFecha_carga() {
        return fecha_carga;
    }

    public void setFecha_carga(LocalDate fecha_carga) {
        this.fecha_carga = fecha_carga;
    }

	
	/**
	 * @param anio
	 * @param mes
	 * @param mes_str
	 * @param dia
	 * @param dia_str
	 * @param fecha_carga
	 */
        
}
