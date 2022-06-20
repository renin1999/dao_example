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

public class TestUpdate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//updateProveedor(1);
		//updateMarca(1);
		//updateTipo(1);
		//updateArticulo(1);
		//updatePersona(1);
		//updateUsuario(1);
		//updateAdministrador(1);
		//updateCompras(1);
		updateVentas(1);
		
	}
	
	public static void updateMarca(int ope){ 
		IMarca marca = new MarcaImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("ACTUALIZANDO MARCA");
		System.out.println("QUE MARCA VAS A ACTUALIZAR?");
		String cod=sc.next();
		marca.find_edit(cod);
             
	}
	public static void updateTipo(int ope){ 
		ITipo tipo = new TipoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("ACTUALIZANDO TIPO");
		System.out.println("QUE TIPO VAS A ACTUALIZAR?");
		String cod=sc.next();
		tipo.find_edit(cod);
             
	}
	public static void updateProveedor(int ope){ 
		IProveedor prov = new ProveedorImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("ACTUALIZANDO proveedor");
		System.out.println("QUE proveedor VAS A ACTUALIZAR?");
		String cod=sc.next();
		prov.find_edit(cod);
             
	}
	public static void updateArticulo(int ope){ 
		IArticulo arti = new ArticuloImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("ACTUALIZANDO ARTICULO");
		System.out.println("QUE ARTICULO VAS A ACTUALIZAR?");
		String cod=sc.next();
		arti.find_edit(cod);
             
	}
	public static void updatePersona(int ope){ 
		IPersona persona = new PersonaImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("ACTUALIZANDO persona");
		System.out.println("QUE persona VAS A ACTUALIZAR?");
		String cod=sc.next();
		persona.find_edit(cod);
             
	}
	public static void updateUsuario(int ope){ 
		IUsuario user = new UsuariosImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("ACTUALIZANDO usuario");
		System.out.println("QUE usuario VAS A ACTUALIZAR?");
		String cod=sc.next();
		user.find_edit(cod);       
	}
	public static void updateAdministrador(int ope){ 
		IAdministrador user = new AdministradorImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("ACTUALIZANDO admin");
		System.out.println("QUE admin VAS A ACTUALIZAR?");
		int codi=Integer.parseInt(sc.nextLine());
		user.find_edit(codi);       
	}
	public static void updateCompras(int ope){ 
		IComprasArticulo compras = new ComprasArticuloImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("ACTUALIZANDO compras");
		System.out.println("QUE compras VAS A ACTUALIZAR?");
		String codi=sc.nextLine();
		compras.find_edit(codi);       
	}
	public static void updateVentas(int ope){ 
		IVentas venta = new VentasImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("ACTUALIZANDO ventas");
		System.out.println("QUE venta VAS A ACTUALIZAR?");
		String codi=sc.nextLine();
		venta.find_edit(codi);       
	}
}
