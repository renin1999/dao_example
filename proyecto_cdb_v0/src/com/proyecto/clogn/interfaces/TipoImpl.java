package com.proyecto.clogn.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.proyecto.clogn.entities.MarcaArticulo;
import com.proyecto.clogn.entities.TipoArticulo;
import com.proyecto.dao.IMarcaDAO;
import com.proyecto.dao.ITipoDAO;
import com.proyecto.dao.MarcaDAOImpl;
import com.proyecto.dao.TipoDAOImpl;


public class TipoImpl implements ITipo {

	@Override
	public void list() {
		ITipoDAO DAO = new TipoDAOImpl(); 
		List<TipoArticulo> list = new ArrayList<>();
		
		list=DAO.list();
		
		Iterator<TipoArticulo> it = list.iterator();
		
		while(it.hasNext()) {
			
			TipoArticulo tipo = it.next();
			
			System.out.println("Estado del Objeto: "+tipo.toString());
			
		}
		
	}

	@Override
	public void find_edit(String cod) {
		ITipoDAO DAO = new TipoDAOImpl();
		TipoArticulo tipo = new TipoArticulo();
		Scanner sc = new Scanner(System.in);
		tipo=DAO.edit(cod);
		if(tipo.getCodtipo()!=null) {
			System.out.println("INGRESA CODIGO");
			String codi=sc.next();
			System.out.println("INGRESA DETALLES");
			String detalles = sc.next();
			save_edit(codi,detalles,tipo);
		}
		else
		{
			System.out.println("No existe");
		}
		
		
	}

	@Override
	public void save_edit(String cod, String detalle, TipoArticulo tipo) {
		ITipoDAO DAO = new TipoDAOImpl();
		LocalDate fecha = LocalDate.now();
		
		tipo.setCodtipo(cod);
		tipo.setDetalles(detalle);
		tipo.setFecha_carga(fecha);
		
		DAO.save(tipo, 2);
		
	}

	@Override
	public void create(String cod, String detalle) {
		ITipoDAO DAO = new TipoDAOImpl();
		TipoArticulo marca= new TipoArticulo();
		LocalDate fecha = LocalDate.now();
		
		marca.setCodtipo(cod);
		marca.setDetalles(detalle);
		marca.setFecha_carga(fecha);
		
		DAO.save(marca, 1);
		
	}

	@Override
	public void delete(String cod) {
		ITipoDAO DAO = new TipoDAOImpl();
		DAO.delete(cod);
		
	}


}
