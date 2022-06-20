package com.proyecto.clogn.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.proyecto.clogn.entities.Persona;
import com.proyecto.clogn.entities.Usuario;
import com.proyecto.dao.IPersonaDAO;
import com.proyecto.dao.IUsuarioDAO;
import com.proyecto.dao.PersonaDAOImpl;
import com.proyecto.dao.UsuarioDAOImpl;

public class UsuariosImpl implements IUsuario {

	@Override
	public void list() {
		IUsuarioDAO DAO = new UsuarioDAOImpl(); 
		List<Usuario> list = new ArrayList<>();
		
		list=DAO.list();
		
		Iterator<Usuario> it = list.iterator();
		
		while(it.hasNext()) {
			
			Usuario user_ = it.next();
			
			System.out.println("Estado del Objeto: "+user_.toString());
			
		}
		
	}

	@Override
	public void find_edit(String user) {
		
		IUsuarioDAO DAO = new UsuarioDAOImpl();
		Usuario persona = new Usuario();
		Scanner sc = new Scanner(System.in);
		
		persona=DAO.edit(user);
		
		if(persona.getUser()!=null) {
			System.out.println("INGRESA idpersona");
			int id=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA user");
			String user_ = sc.next();
			System.out.println("INGRESA password");
			String pass = sc.next();

			save_edit(id,user_,pass,persona);
		}
		else
		{
			System.out.println("no existe");
		}
		
	}

	@Override
	public void save_edit(int idpersona, String user, String pass, Usuario usuario) {
		IUsuarioDAO DAO = new UsuarioDAOImpl(); 
		LocalDate fecha = LocalDate.now();
		
		usuario.setFecha_carga(fecha);
		usuario.setIdpersona(idpersona);
		usuario.setPassword(pass);
		usuario.setUser(user);
        
        DAO.save(usuario, 2);
		
	}

	@Override
	public void create(int idpersona, String user, String pass) {
		IUsuarioDAO DAO = new UsuarioDAOImpl(); 
		Usuario usuario = new Usuario();
		LocalDate fecha = LocalDate.now();
		
		usuario.setFecha_carga(fecha);
		usuario.setIdpersona(idpersona);
		usuario.setPassword(pass);
		usuario.setUser(user);
        
        DAO.save(usuario, 1);
		
	}

	@Override
	public void delete(String user) {
		// TODO Auto-generated method stub
		IUsuarioDAO DAO = new UsuarioDAOImpl(); 
		DAO.delete(user);
		
	}

}
