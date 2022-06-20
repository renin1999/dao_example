package com.proyecto.clogn.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.proyecto.clogn.entities.Administrador;
import com.proyecto.clogn.entities.Gerente;
import com.proyecto.dao.AdministradorDAOImpl;
import com.proyecto.dao.GerenteDAOImpl;
import com.proyecto.dao.IAdministradorDAO;
import com.proyecto.dao.IGerenteDAO;

public class GerenteImpl implements IGerente {

	@Override
	public void list() {
		IGerenteDAO DAO = new GerenteDAOImpl(); 
		List<Gerente> list = new ArrayList<>();
		
		list=DAO.list();
		
		Iterator<Gerente> it = list.iterator();
		
		while(it.hasNext()) {
			
			Gerente gerente = it.next();
			
			System.out.println("Estado del Objeto: "+gerente.toString());
			
		}
		
	}

	@Override
	public void find_edit(int idusuario) {
		IGerenteDAO DAO = new GerenteDAOImpl(); 
		Gerente gerente = new Gerente();
		Scanner sc = new Scanner(System.in);
		gerente=DAO.edit(idusuario);
		if(gerente.getIdusuario()!=0) {
			System.out.println("INGRESA Idusuario");
			int codi=Integer.parseInt(sc.nextLine());
			save_edit(codi,gerente);
		}
		else
		{
			System.out.println("no existe");
		}
		
	}

	@Override
	public void save_edit(int idusuario, Gerente gerente) {
		IGerenteDAO DAO = new GerenteDAOImpl(); 
		LocalDate fecha = LocalDate.now();
		
		gerente.setIdusuario(idusuario);
		gerente.setFecha_carga(fecha);
		
		DAO.save(gerente, 2);
		
	}

	@Override
	public void create(int idusuario) {
		IGerenteDAO DAO = new GerenteDAOImpl(); 
		Gerente gerente= new Gerente();
		LocalDate fecha = LocalDate.now();
		
		gerente.setIdusuario(idusuario);
		gerente.setFecha_carga(fecha);
		
		DAO.save(gerente, 1);
		
	}

	@Override
	public void delete(int idusuario) {
		IGerenteDAO DAO = new GerenteDAOImpl();
		// TODO Auto-generated method stub
		DAO.delete(idusuario);
		
	}

}
