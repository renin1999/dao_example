package com.proyecto.clogn.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.proyecto.clogn.entities.MarcaArticulo;
import com.proyecto.dao.IMarcaDAO;
import com.proyecto.dao.MarcaDAOImpl;

public class MarcaImpl implements IMarca {


	@Override
	public void list() {
		IMarcaDAO artiDAO = new MarcaDAOImpl(); 
		List<MarcaArticulo> list = new ArrayList<>();
		
		list=artiDAO.list();
		
		Iterator<MarcaArticulo> it = list.iterator();
		
		while(it.hasNext()) {
			
			MarcaArticulo marca = it.next();
			
			System.out.println("Estado del Objeto: "+marca.toString());
			
		}
		
	}

	@Override
	public void find_edit(String cod) {
		IMarcaDAO DAO = new MarcaDAOImpl();
		MarcaArticulo marca = new MarcaArticulo();
		Scanner sc = new Scanner(System.in);
		marca=DAO.edit(cod);
		if(marca.getCodmarca()!=null) {
			System.out.println("INGRESA CODIGO");
			String codi=sc.next();
			System.out.println("INGRESA DETALLE");
			String detalles = sc.next();
			save_edit(codi,detalles,marca);
		}
		else
		{
			System.out.println("no existe");
		}
		
	}

	@Override
	public void save_edit(String cod, String detalle, MarcaArticulo marca) {
		IMarcaDAO DAO = new MarcaDAOImpl();
		LocalDate fecha = LocalDate.now();
		
		marca.setCodmarca(cod);
		marca.setDetalle(detalle);
		marca.setFecha_carga(fecha);
		
		DAO.save(marca, 2);
		
	}

	@Override
	public void create(String cod, String detalle) {
		
		IMarcaDAO DAO = new MarcaDAOImpl();
		MarcaArticulo marca= new MarcaArticulo();
		LocalDate fecha = LocalDate.now();
		
		marca.setCodmarca(cod);
		marca.setDetalle(detalle);
		marca.setFecha_carga(fecha);
		
		DAO.save(marca, 1);
		
	}

	@Override
	public void delete(String cod) {
		IMarcaDAO DAO = new MarcaDAOImpl();
		DAO.delete(cod);	
	}

}
