package com.proyecto.clogn.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.proyecto.clogn.entities.Articulo;
import com.proyecto.clogn.entities.TipoArticulo;
import com.proyecto.dao.ArticuloDAOImpl;
import com.proyecto.dao.IArticuloDAO;


public class ArticuloImpl implements IArticulo {

	@Override
	public void list() {
		IArticuloDAO artiDAO = new ArticuloDAOImpl(); 
		List<Articulo> list = new ArrayList<>();
		
		list=artiDAO.list();
		
		Iterator<Articulo> it = list.iterator();
		
		while(it.hasNext()) {
			
			Articulo arti = it.next();
			
			System.out.println("Estado del Objeto: "+arti.toString());
			
		}

	}


	@Override
	public void create(String cod, String detalle, int idmarca, int idtipo, int stock, double valorc, double valorv ) {
		IArticuloDAO artiDAO = new ArticuloDAOImpl(); 
        Articulo arti = new Articulo();
        LocalDate fecha = LocalDate.now();
        
            arti.setCod_articulo(cod);
            arti.setDetalle(detalle);
            arti.setFecha_carga(fecha);
            arti.setIdmarca(idmarca);
            arti.setIdtipo(idtipo);
            arti.setStock_final(stock);
            arti.setValor_compra(valorc);
            arti.setValor_venta(valorv);      
            artiDAO.save(arti,1);  
	}

	@Override
	public void delete(String cod) {
		IArticuloDAO artiDAO = new ArticuloDAOImpl(); 
		artiDAO.delete(cod);
	
	}

	@Override
	public void find_edit(String cod) {
		IArticuloDAO artiDAO = new ArticuloDAOImpl(); 
        Articulo arti = new Articulo();
        Scanner sc = new Scanner(System.in);
		arti=artiDAO.edit(cod);
		
		if(arti.getClass()!=null) {
			System.out.println("INGRESA CODIGO");
			String codi=sc.next();
			System.out.println("INGRESA detalle");
			String deta = sc.next();
			System.out.println("INGRESA MARCA");
			int marc=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA TIPO");
			int tipo=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA STOCK");
			int st=Integer.parseInt(sc.nextLine());
			System.out.println("INGRESA VALOR COMPRA");
			Double compr=sc.nextDouble();
			System.out.println("INGRESA VALOR VENTA");
			Double vent=sc.nextDouble();
			save_edit(codi,deta,marc,tipo,st,compr,vent,arti);
			
		}
		else {
			System.out.println("no existe");
		}
			
		
	}
	@Override
	public void save_edit(String cod, String detalle, int idmarca, int idtipo, int stock, double valorc, double valorv, Articulo arti ) {
		IArticuloDAO artiDAO = new ArticuloDAOImpl(); 
        LocalDate fecha = LocalDate.now();
        
            arti.setCod_articulo(cod);
            arti.setDetalle(detalle);
            arti.setFecha_carga(fecha);
            arti.setIdmarca(idmarca);
            arti.setIdtipo(idtipo);
            arti.setStock_final(stock);
            arti.setValor_compra(valorc);
            arti.setValor_venta(valorv);      
            artiDAO.save(arti,2); 
	}


}
