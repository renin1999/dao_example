package com.proyecto.clogn.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.proyecto.clogn.entities.ComprasArticulo;
import com.proyecto.dao.ComprasDAOImpl;
import com.proyecto.dao.IComprasDAO;


public class ComprasArticuloImpl implements IComprasArticulo {

	@Override
	public void list() {
		IComprasDAO DAO = new ComprasDAOImpl(); 
		List<ComprasArticulo> list = new ArrayList<>();
		
		list=DAO.list();
		
		Iterator<ComprasArticulo> it = list.iterator();
		
		while(it.hasNext()) {
			
			ComprasArticulo compra = it.next();
			
			System.out.println("Estado del Objeto: "+compra.toString());
			
		}
		
	}

	@Override
	public void find_edit(String cod) {
		IComprasDAO DAO = new ComprasDAOImpl(); 
		ComprasArticulo compra = new ComprasArticulo();
		Scanner sc = new Scanner(System.in);
		compra=DAO.edit(cod);
		if(compra.getCodcompra()!=null) {
			System.out.println("INGRESA idarticulo");
			int idart=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA idproveedor");
			int idprove=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA codcompra");
			String codcompra = sc.nextLine();
			System.out.println("INGRESA cantidad");
			int cantidad=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA valor");
			Double valor = sc.nextDouble();
			sc.nextLine();
			Double totalcompra= cantidad*valor;
			System.out.println("INGRESO de fechacompra");
			System.out.println("INGRESA anio");
			int anio=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA mes");
			int mes=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA dia");
			int dia=Integer.parseInt(sc.nextLine());
			LocalDate fecha = LocalDate.of(anio,mes,dia);
			
			save_edit(idart,idprove,codcompra, cantidad,valor, totalcompra, fecha, compra);
		}
		else
		{
			System.out.println("no existe");
		}
		
	}

	@Override
	public void save_edit(int idarticulo, int idproveedor, String codcompra, int cantidad, Double valor,
			Double totalcompra, LocalDate fechacompra, ComprasArticulo compra) {
		IComprasDAO DAO = new ComprasDAOImpl();
		LocalDate fecha = LocalDate.now();
		
		compra.setCantidad(cantidad);
		compra.setCodcompra(codcompra);
		compra.setFecha_carga(fecha);
		compra.setFecha_compra(fechacompra);
		compra.setIdarticulo(idarticulo);
		compra.setIdproveedor(idproveedor);
		compra.setTotal_compra(totalcompra);
		compra.setValor(valor);
		
		DAO.save(compra, 2);
		
	}

	@Override
	public void create(int idarticulo, int idproveedor, String codcompra, int cantidad, Double valor,
			Double totalcompra, LocalDate fechacompra) {
		IComprasDAO DAO = new ComprasDAOImpl();
		LocalDate fecha = LocalDate.now();
		ComprasArticulo compra = new ComprasArticulo();
		compra.setCantidad(cantidad);
		compra.setCodcompra(codcompra);
		compra.setFecha_carga(fecha);
		compra.setFecha_compra(fechacompra);
		compra.setIdarticulo(idarticulo);
		compra.setIdproveedor(idproveedor);
		compra.setTotal_compra(totalcompra);
		compra.setValor(valor);
		
		DAO.save(compra, 1);
		
		
	}

	@Override
	public void delete(String cod) {
		IComprasDAO DAO = new ComprasDAOImpl();
		DAO.delete(cod);
		
	}

	
}
