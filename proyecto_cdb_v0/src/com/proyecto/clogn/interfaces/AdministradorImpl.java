package com.proyecto.clogn.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.proyecto.clogn.entities.Administrador;
import com.proyecto.clogn.entities.MarcaArticulo;
import com.proyecto.dao.AdministradorDAOImpl;
import com.proyecto.dao.IAdministradorDAO;
import com.proyecto.dao.IMarcaDAO;
import com.proyecto.dao.MarcaDAOImpl;



public class AdministradorImpl implements IAdministrador {

	@Override
	public void list() {
		IAdministradorDAO DAO = new AdministradorDAOImpl(); 
		List<Administrador> list = new ArrayList<>();
		
		list=DAO.list();
		
		Iterator<Administrador> it = list.iterator();
		
		while(it.hasNext()) {
			
			Administrador admin = it.next();
			
			System.out.println("Estado del Objeto: "+admin.toString());
			
		}
		
	}

	@Override
	public void find_edit(int idusuario) {
		IAdministradorDAO DAO = new AdministradorDAOImpl(); 
		Administrador admin = new Administrador();
		Scanner sc = new Scanner(System.in);
		admin=DAO.edit(idusuario);
		
		if( Integer.valueOf(admin.getIdusuario())!=null) {
			System.out.println("INGRESA Idusuario");
			int codi=Integer.parseInt(sc.nextLine());
			save_edit(codi,admin);
		}
		else
		{
			System.out.println("no existe");
		}
		
	}

	@Override
	public void save_edit(int idusuario, Administrador admin) {
		IAdministradorDAO DAO = new AdministradorDAOImpl(); 
		LocalDate fecha = LocalDate.now();
		
		admin.setIdusuario(idusuario);
		admin.setFecha_carga(fecha);
		
		DAO.save(admin, 2);
		
	}

	@Override
	public void create(int idusuario) {
		IAdministradorDAO DAO = new AdministradorDAOImpl(); 
		Administrador admin= new Administrador();
		LocalDate fecha = LocalDate.now();
		
		admin.setIdusuario(idusuario);
		admin.setFecha_carga(fecha);
		
		DAO.save(admin, 1);
		
	}

	@Override
	public void delete(int idusuario) {
		IAdministradorDAO DAO = new AdministradorDAOImpl();
		// TODO Auto-generated method stub
		DAO.delete(idusuario);
		
	}

}
