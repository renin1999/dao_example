package com.proyecto.clogn.entities;

import java.time.LocalDate;

public class Ventas {
	private int idventas;
	private String codventas;
	private int idarticulo;
	private int idgerente;
	private int cantidad;
	private double valor;
	private double total_ventas;
	private LocalDate fecha_venta;
	private LocalDate fecha_carga;
	

	public Ventas() {
		// TODO Auto-generated constructor stub
	}





    @Override
	public String toString() {
		return "Ventas [idventas=" + idventas + ", codventas=" + codventas + ", idarticulo=" + idarticulo
				+ ", idgerente=" + idgerente + ", cantidad=" + cantidad + ", valor=" + valor + ", total_ventas="
				+ total_ventas + ", fecha_venta=" + fecha_venta + ", fecha_carga=" + fecha_carga + "]";
	}





	/**
	 * @param idventas
	 * @param codventas
	 * @param idarticulo
	 * @param idgerente
	 * @param cantidad
	 * @param valor
	 * @param total_ventas
	 * @param fecha_venta
	 * @param fecha_carga
	 */
	public Ventas(int idventas, String codventas, int idarticulo, int idgerente, int cantidad, double valor,
			double total_ventas, LocalDate fecha_venta, LocalDate fecha_carga) {
		super();
		this.idventas = idventas;
		this.codventas = codventas;
		this.idarticulo = idarticulo;
		this.idgerente = idgerente;
		this.cantidad = cantidad;
		this.valor = valor;
		this.total_ventas = total_ventas;
		this.fecha_venta = fecha_venta;
		this.fecha_carga = fecha_carga;
	}





	/**
	 * @return the fecha_venta
	 */
	public LocalDate getFecha_venta() {
		return fecha_venta;
	}





	/**
	 * @param fecha_venta the fecha_venta to set
	 */
	public void setFecha_venta(LocalDate fecha_venta) {
		this.fecha_venta = fecha_venta;
	}





	/**
	 * @return the idventas
	 */
	public int getIdventas() {
		return idventas;
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





	/**
	 * @param idventas the idventas to set
	 */
	public void setIdventas(int idventas) {
		this.idventas = idventas;
	}





	/**
	 * @return the codventas
	 */
	public String getCodventas() {
		return codventas;
	}


	/**
	 * @param codventas the codventas to set
	 */
	public void setCodventas(String codventas) {
		this.codventas = codventas;
	}



    public int getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(int idarticulo) {
        this.idarticulo = idarticulo;
    }

    public int getIdgerente() {
        return idgerente;
    }

    public void setIdgerente(int idgerente) {
        this.idgerente = idgerente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTotal_ventas() {
        return total_ventas;
    }

    public void setTotal_ventas(double total_ventas) {
        this.total_ventas = total_ventas;
    }






}
