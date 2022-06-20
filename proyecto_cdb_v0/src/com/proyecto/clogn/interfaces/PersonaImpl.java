package com.proyecto.clogn.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.proyecto.clogn.entities.MarcaArticulo;
import com.proyecto.clogn.entities.Persona;
import com.proyecto.dao.IMarcaDAO;
import com.proyecto.dao.IPersonaDAO;
import com.proyecto.dao.MarcaDAOImpl;
import com.proyecto.dao.PersonaDAOImpl;

public class PersonaImpl implements IPersona {

	@Override
	public void list() {
		IPersonaDAO DAO = new PersonaDAOImpl(); 
		List<Persona> list = new ArrayList<>();
		
		list=DAO.list();
		
		Iterator<Persona> it = list.iterator();
		
		while(it.hasNext()) {
			
			Persona persona = it.next();
			
			System.out.println("Estado del Objeto: "+persona.toString());
			
		}
		
	}

	@Override
	public void find_edit(String cod) {
		IPersonaDAO DAO = new PersonaDAOImpl();
		Persona persona = new Persona();
		Scanner sc = new Scanner(System.in);
		persona=DAO.edit(cod);
		if(persona.getCedula()!=null) {
			System.out.println("INGRESA CEDULA");
			String ci=sc.next();
			System.out.println("INGRESA CORREO");
			String correo = sc.next();
			System.out.println("INGRESA EDAD");
			int edad=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA NOMBRWE");
			String nombre = sc.next();
			System.out.println("INGRESA SEXO");
			String sex = sc.next();
			System.out.println("INGRESA TELEFONO");
			String tel = sc.next();
			
			
			save_edit(ci,nombre,edad,sex,tel,correo,persona);
		}
		else
		{
			System.out.println("no existe");
		}
		
	}

	@Override
	public void save_edit(String ced, String nombre_ape, int edad, String sexo, String telefono, String correo,
			Persona persona) {
		IPersonaDAO DAO = new PersonaDAOImpl(); 
		LocalDate fecha = LocalDate.now();
		persona.setCedula(ced);
		persona.setCorreo(correo);
		persona.setEdad(edad);
		persona.setFecha_carga(fecha);
		persona.setNombre_ape(nombre_ape);
		persona.setSexo(sexo);
		persona.setTelefono(telefono);
        
        DAO.save(persona, 2);
		
	}

	@Override
	public void create(String ced, String nombre_ape, int edad, String sexo, String telefono, String correo) {
		 IPersonaDAO DAO = new PersonaDAOImpl(); 
         
         Persona per = new Persona();
         LocalDate fecha = LocalDate.now();
         per.setCedula(ced);
         per.setCorreo(correo);
         per.setEdad(edad);
         per.setFecha_carga(fecha);
         per.setNombre_ape(nombre_ape);
         per.setSexo(sexo);
         per.setTelefono(telefono);
         
         DAO.save(per, 1);
		
	}

	@Override
	public void delete(String cod) {
		IPersonaDAO DAO = new PersonaDAOImpl();
		DAO.delete(cod);
		
	}

}
