package com.proyecto.clogn.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.proyecto.clogn.entities.Articulo;
import com.proyecto.clogn.entities.ProveedorCompras;
import com.proyecto.clogn.entities.TipoArticulo;
import com.proyecto.dao.IProveedorDao;
import com.proyecto.dao.ITipoDAO;
import com.proyecto.dao.ProveedorDAOImpl;
import com.proyecto.dao.TipoDAOImpl;

public class ProveedorImpl implements IProveedor {

	@Override
	public void list() {
		IProveedorDao DAO = new ProveedorDAOImpl(); 
		List<ProveedorCompras> list = new ArrayList<>();
		
		list=DAO.list();
		
		Iterator<ProveedorCompras> it = list.iterator();
		
		while(it.hasNext()) {
			
			ProveedorCompras tipo = it.next();
			
			System.out.println("Estado del Objeto: "+tipo.toString());
			
		}
		
	}

	@Override
	public void find_edit(String cod) {
		IProveedorDao DAO = new ProveedorDAOImpl();
		ProveedorCompras prov = new ProveedorCompras();
		Scanner sc = new Scanner(System.in);
		prov=DAO.edit(cod);
		if(prov.getCodproveedor()!=null) {
			System.out.println("INGRESA CODIGO");
			String codi=sc.next();
			System.out.println("INGRESA CORREO");
			String corr = sc.next();
			System.out.println("INGRESA DIRECCION");
			String dir=sc.next();
			System.out.println("INGRESA NOMBRE_APELLIDO");
			String nape = sc.next();
			System.out.println("INGRESA TELEFONO");
			String tel=sc.next();
			save_edit(codi,corr,dir,nape,tel,prov);
		}
		else
		{
			System.out.println("no existe");
		}
		
		
	}

	@Override
	public void save_edit(String cod, String correo, String dir, String nombre_ape, String tel, ProveedorCompras prov) {
		IProveedorDao DAO = new ProveedorDAOImpl();
		LocalDate fecha = LocalDate.now();
		
		prov.setCodproveedor(cod);
		prov.setCorreo(correo);
		prov.setDireccion(dir);
		prov.setFecha_carga(fecha);
		prov.setNombre_ape(nombre_ape);
		prov.setTelefono(tel);
		
		
		DAO.save(prov, 2);
		
	}

	@Override
	public void create(String cod, String correo, String dir, String nombre_ape, String tel) {
		IProveedorDao DAO = new ProveedorDAOImpl();
		ProveedorCompras prov= new ProveedorCompras();
		LocalDate fecha = LocalDate.now();
		
		prov.setCodproveedor(cod);
		prov.setCorreo(correo);
		prov.setDireccion(dir);
		prov.setFecha_carga(fecha);
		prov.setNombre_ape(nombre_ape);
		prov.setTelefono(tel);
		
		DAO.save(prov, 1);
		
	}

	@Override
	public void delete(String cod) {
		IProveedorDao DAO = new ProveedorDAOImpl();
		DAO.delete(cod);
		
	}



}
