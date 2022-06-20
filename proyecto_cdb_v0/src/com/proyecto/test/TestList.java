package com.proyecto.test;

import java.util.Scanner;

import com.proyecto.clogn.interfaces.AdministradorImpl;
import com.proyecto.clogn.interfaces.ArticuloImpl;
import com.proyecto.clogn.interfaces.ComprasArticuloImpl;
import com.proyecto.clogn.interfaces.GerenteImpl;
import com.proyecto.clogn.interfaces.IAdministrador;
import com.proyecto.clogn.interfaces.IArticulo;
import com.proyecto.clogn.interfaces.IComprasArticulo;
import com.proyecto.clogn.interfaces.IGerente;
import com.proyecto.clogn.interfaces.IMarca;
import com.proyecto.clogn.interfaces.IPersona;
import com.proyecto.clogn.interfaces.IProveedor;
import com.proyecto.clogn.interfaces.ITipo;
import com.proyecto.clogn.interfaces.IUsuario;
import com.proyecto.clogn.interfaces.IVentas;
import com.proyecto.clogn.interfaces.MarcaImpl;
import com.proyecto.clogn.interfaces.PersonaImpl;
import com.proyecto.clogn.interfaces.ProveedorImpl;
import com.proyecto.clogn.interfaces.TipoImpl;
import com.proyecto.clogn.interfaces.UsuariosImpl;
import com.proyecto.clogn.interfaces.VentasImpl;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listProveedor(1);
		listMarca(1);
		listTipo(1);
		listArticulo(1);
		listPersona(1);
		listUsuario(1);
		listAdministrador(1);
		listGerente(1);
		listCompras(1);
		listVentas(1);
		
	}
	
	
	
	public static void listMarca(int ope){ 
		IMarca marca = new MarcaImpl();
		System.out.println("LISTANDO MARCA");
		
		marca.list();//metodo para probar el grabar
             
	}
	public static void listTipo(int ope){ 
		ITipo tipo = new TipoImpl();
		System.out.println("LISTANDO TIPO");
		
		tipo.list();//metodo para probar el grabar
             
	}
	public static void listProveedor(int ope){ 
		IProveedor prov = new ProveedorImpl();
		System.out.println("LISTANDO proveedor");
		
		prov.list();//metodo para probar el grabar
             
	}
	public static void listArticulo(int ope){ 
		IArticulo arti = new ArticuloImpl();
		System.out.println("LISTANDO articulo");		
		arti.list();//metodo para probar el grabar       
	}
	public static void listPersona(int ope){ 
		IPersona persona = new PersonaImpl();
		System.out.println("LISTANDO persona");		
		persona.list();//metodo para probar el grabar       
	}
	public static void listUsuario(int ope){ 
		IUsuario user = new UsuariosImpl();
		System.out.println("LISTANDO persona");		
		user.list();//metodo para probar el grabar       
	}
	public static void listAdministrador(int ope){ 
		IAdministrador user = new AdministradorImpl();
		System.out.println("LISTANDO admins");		
		user.list();//metodo para probar el grabar       
	}
	public static void listGerente(int ope){ 
		IGerente user = new GerenteImpl();
		System.out.println("LISTANDO gerentes");		
		user.list();//metodo para probar el grabar       
	}
	public static void listCompras(int ope){ 
		IComprasArticulo compras = new ComprasArticuloImpl();
		System.out.println("LISTANDO compras");		
		compras.list();//metodo para probar el grabar       
	}
	public static void listVentas(int ope){ 
		IVentas ventas = new VentasImpl();
		System.out.println("LISTANDO ventas");		
		ventas.list();//metodo para probar el grabar       
	}
}
