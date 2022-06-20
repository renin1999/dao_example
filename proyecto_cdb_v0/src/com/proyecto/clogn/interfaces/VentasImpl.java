package com.proyecto.clogn.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.proyecto.clogn.entities.Persona;
import com.proyecto.clogn.entities.Ventas;
import com.proyecto.dao.IPersonaDAO;
import com.proyecto.dao.IVentasDAO;
import com.proyecto.dao.PersonaDAOImpl;
import com.proyecto.dao.VentasDAOImpl;

public class VentasImpl implements IVentas {

	@Override
	public void list() {
		IVentasDAO DAO = new VentasDAOImpl(); 
		List<Ventas> list = new ArrayList<>();
		
		list=DAO.list();
		
		Iterator<Ventas> it = list.iterator();
		
		while(it.hasNext()) {
			
			Ventas ventas = it.next();
			
			System.out.println("Estado del Objeto: "+ventas.toString());
			
		}
		
	}

	@Override
	public void find_edit(String cod) {
		IVentasDAO DAO = new VentasDAOImpl();
		Ventas ventas = new Ventas();
		Scanner sc = new Scanner(System.in);
		ventas=DAO.edit(cod);
		if(ventas.getCodventas()!=null) {

			System.out.println("INGRESA idarticulo");
			int arti=Integer.parseInt(sc.nextLine());;
			System.out.println("INGRESA idgerente	");
			int gere=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA cod_ventas	");
			String codve = sc.nextLine();
			System.out.println("INGRESA cantidad");
			int cantidad=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA valor");
			Double valor = sc.nextDouble();
			sc.nextLine();
			System.out.println("INGRESO de fechacompra");
			System.out.println("INGRESA anio");
			int anio=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA mes");
			int mes=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA dia");
			int dia=Integer.parseInt(sc.nextLine());
			LocalDate fecha = LocalDate.of(anio,mes,dia);
			
			save_edit(codve,arti,gere,cantidad,valor,fecha,ventas);
		}
		else
		{
			System.out.println("no existe");
		}
		
	}

	@Override
	public void save_edit(String cod, int idarticulo, int gerente, int cantidad, Double valor, LocalDate fechav,
			Ventas venta) {
		IVentasDAO DAO = new VentasDAOImpl(); 
		LocalDate fecha = LocalDate.now();
		venta.setCantidad(cantidad);
		venta.setCodventas(cod);
		venta.setIdarticulo(idarticulo);
		venta.setIdgerente(gerente);
		venta.setFecha_venta(fechav);
		venta.setTotal_ventas(valor*cantidad);
		venta.setValor(valor);
        DAO.save(venta, 2);
		
	}

	@Override
	public void create(String cod, int idarticulo, int gerente, int cantidad, Double valor, LocalDate fechav) {
		IVentasDAO DAO = new VentasDAOImpl();
		Ventas venta = new Ventas();
		LocalDate fecha = LocalDate.now();
		venta.setCantidad(cantidad);
		venta.setCodventas(cod);
		venta.setIdarticulo(idarticulo);
		venta.setIdgerente(gerente);
		venta.setFecha_venta(fechav);
		venta.setTotal_ventas(valor*cantidad);
		venta.setValor(valor);
		venta.setFecha_carga(fecha);
        DAO.save(venta, 1);
		
	}

	@Override
	public void delete(String cod) {
		IVentasDAO DAO = new VentasDAOImpl();
		DAO.delete(cod);
		
	}

}
