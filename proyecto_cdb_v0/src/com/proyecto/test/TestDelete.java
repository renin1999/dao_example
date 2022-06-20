package com.proyecto.test;

import java.util.Scanner;

import com.proyecto.clogn.interfaces.AdministradorImpl;
import com.proyecto.clogn.interfaces.ArticuloImpl;
import com.proyecto.clogn.interfaces.ComprasArticuloImpl;
import com.proyecto.clogn.interfaces.IAdministrador;
import com.proyecto.clogn.interfaces.IArticulo;
import com.proyecto.clogn.interfaces.IComprasArticulo;
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

public class TestDelete {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//deleteProveedor(1);
		//deleteMarca(1);
		//deleteTipo(1);
		//deleteArticulo(1);
		//deletePersona(1);
		//deleteUsuario(1);
		//deleteUsuario(1);
		deleteVentas(1);
	}
	
	public static void deleteMarca(int ope){ 
		IMarca tipo = new MarcaImpl();
		System.out.println("BORRANDO MARCA");
		System.out.println("CUÁL borrarás?");
		Scanner sc = new Scanner(System.in);
		String cod = sc.next();
		tipo.delete(cod);//metodo para probar el grabar
             
	}
	public static void deleteTipo(int ope){ 
		ITipo tipo = new TipoImpl();
		System.out.println("BORRANDO tipo");
		System.out.println("CUÁL borrarás?");
		Scanner sc = new Scanner(System.in);
		String cod = sc.next();
		tipo.delete(cod);//metodo para probar el grabar
             
	}
	public static void deleteProveedor(int ope){ 
		IProveedor prov = new ProveedorImpl();
		System.out.println("BORRANDO proveedor");
		System.out.println("CUÁL borrarás?");
		Scanner sc = new Scanner(System.in);
		String cod = sc.next();
		prov.delete(cod);//metodo para probar el grabar
             
	}
	public static void deleteArticulo(int ope){ 
		IArticulo arti = new ArticuloImpl();
		System.out.println("BORRANDO articulo");
		System.out.println("CUÁL borrarás?");
		Scanner sc = new Scanner(System.in);
		String cod = sc.next();
		arti.delete(cod);//metodo para probar el grabar
             
	}
	public static void deletePersona(int ope){ 
		IPersona persona = new PersonaImpl();
		System.out.println("CUÁL persona?");
		Scanner sc = new Scanner(System.in);
		String cod = sc.next();
		persona.delete(cod);//metodo para probar el grabar
             
	}
	public static void deleteUsuario(int ope){ 
		IUsuario usuario = new UsuariosImpl();
		System.out.println("CUÁL persona?");
		Scanner sc = new Scanner(System.in);
		String cod = sc.nextLine();
		usuario.delete(cod);//metodo para probar el grabar      
	}
	public static void deleteAdministrador(int ope){ 
		IAdministrador usuario = new AdministradorImpl();
		System.out.println("CUÁL admin?");
		Scanner sc = new Scanner(System.in);
		int codi=Integer.parseInt(sc.nextLine());
		usuario.delete(codi);//metodo para probar el grabar      
	}
	public static void deleteCompras(int ope){ 
		IComprasArticulo compras = new ComprasArticuloImpl();
		System.out.println("CUÁL compra?");
		Scanner sc = new Scanner(System.in);
		String cod = sc.nextLine();
		compras.delete(cod);//metodo para probar el grabar      
	}
	public static void deleteVentas(int ope){ 
		IVentas ventas = new VentasImpl();
		System.out.println("CUÁL venta?");
		Scanner sc = new Scanner(System.in);
		String cod = sc.nextLine();
		ventas.delete(cod);//metodo para probar el grabar      
	}
}
