package com.proyecto.test;

import java.time.LocalDate;
import java.util.Scanner;

import com.proyecto.clogn.entities.Articulo;
import com.proyecto.clogn.entities.MarcaArticulo;
import com.proyecto.clogn.entities.ProveedorCompras;
import com.proyecto.clogn.entities.TipoArticulo;
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
import com.proyecto.dao.ArticuloDAOImpl;
import com.proyecto.dao.IArticuloDAO;
import com.proyecto.dao.IMarcaDAO;
import com.proyecto.dao.IProveedorDao;
import com.proyecto.dao.ITipoDAO;
import com.proyecto.dao.MarcaDAOImpl;
import com.proyecto.dao.ProveedorDAOImpl;
import com.proyecto.dao.TipoDAOImpl;

public class TestSave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//saveProveedor(1);
		//saveMarca(1);
		//saveTipo(1);
		//saveArticulo(1);
		//savePersona(1);
		//saveUsuario(1);
		//saveAdministrador(1);
		//saveGerente(1);
		//saveCompras(1);
		saveVentas(1);
		
	}
	public static void saveProveedor(int ope){            //metodo para probar el grabar
		IProveedor prov = new ProveedorImpl();
		System.out.println("INGRESA CODIGO");
		Scanner sc = new Scanner(System.in);
		String codi=sc.next();
		System.out.println("INGRESA CORREO");
		String corr = sc.next();
		System.out.println("INGRESA DIRECCION");
		String dir=sc.next();
		System.out.println("INGRESA NOMBRE_APELLIDO");
		String nape = sc.next();
		System.out.println("INGRESA TELEFONO");
		String tel=sc.next();
		prov.create(codi,corr,dir,nape,tel);
    }
	
	public static void saveTipo(int ope){            //metodo para probar el grabar
		ITipo tipo = new TipoImpl();
		System.out.println("CREANDO Tipo");
		Scanner sc = new Scanner(System.in);
		System.out.println("INGRESA CODIGO");
		String cod=sc.next();
		System.out.println("INGRESA DETALLEs");
		String detalle = sc.next();
		tipo.create(cod, detalle);//metodo para probar el grabar
    }
	
	public static void saveMarca(int ope){ 
		IMarca marca = new MarcaImpl();
		System.out.println("CREANDO MARCA");
		Scanner sc = new Scanner(System.in);
		System.out.println("INGRESA CODIGO");
		String cod=sc.next();
		System.out.println("INGRESA DETALLE");
		String detalle = sc.next();
		marca.create(cod, detalle);//metodo para probar el grabar
             
    }
	public static void saveArticulo(int ope){  
		IArticulo arti = new ArticuloImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("creando articulo");
		System.out.println("INGRESA CODIGO");
		String codi=sc.nextLine();
		System.out.println("INGRESA detalle");
		String deta = sc.nextLine();
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
		sc.nextLine();
		arti.create(codi, deta, marc, tipo, st, compr, vent);//metodo para probar el grabar	
    }
	public static void savePersona(int ope){  
		IPersona persona = new PersonaImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("INGRESA cedula");
		String ci=sc.nextLine();
		System.out.println("INGRESA nombre");
		String name = sc.nextLine();
		System.out.println("INGRESA edad");
		int edad=Integer.parseInt(sc.nextLine());
		System.out.println("INGRESA sexo");
		String sex = sc.nextLine();
		System.out.println("INGRESA telefono");
		String tel=sc.nextLine();
		System.out.println("INGRESA correo");
		String corr=sc.nextLine();
		persona.create(ci, name, edad, sex, tel, corr);//metodo para probar el grabar	
    }
	public static void saveUsuario(int ope){  
		IUsuario persona = new UsuariosImpl();
		Scanner sc = new Scanner(System.in);
		int id=0;
		System.out.println("INGRESA idpersona");
		id=Integer.parseInt(sc.nextLine());
		System.out.println("INGRESA user");
		String user_ = sc.nextLine();
		System.out.println("INGRESA password");
		String pass = sc.nextLine();
		persona.create(id, user_, pass);//metodo para probar el grabar	
    }
	public static void saveAdministrador(int ope){  
		IAdministrador persona = new AdministradorImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("INGRESA Idusuario");
		int codi=Integer.parseInt(sc.nextLine());
		persona.create(codi);//metodo para probar el grabar	
    }
	public static void saveGerente(int ope){  
		IGerente persona = new GerenteImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("INGRESA idusuario");
		int codi=Integer.parseInt(sc.nextLine());
		persona.create(codi);//metodo para probar el grabar	
    }
	public static void saveCompras(int ope){  
		IComprasArticulo persona = new ComprasArticuloImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("INGRESA idarticulo");
		int arti=Integer.parseInt(sc.nextLine());
		System.out.println("INGRESA idproveedor");
		int prov=Integer.parseInt(sc.nextLine());
		System.out.println("INGRESA codcompra");
		String cod = sc.nextLine();
		System.out.println("INGRESA cantidad");
		int cantidad=Integer.parseInt(sc.nextLine());
		System.out.println("INGRESA valor");
		Double valor = sc.nextDouble();
		sc.nextLine();
		Double total = valor*cantidad;
		System.out.println("INGRESA anio");
		int anio=Integer.parseInt(sc.nextLine());
		System.out.println("INGRESA mes");
		int mes=Integer.parseInt(sc.nextLine());
		System.out.println("INGRESA dia");
		int dia=Integer.parseInt(sc.nextLine());
		LocalDate fecha = LocalDate.of(anio,mes,dia);	
		persona.create(arti,prov,cod,cantidad,valor,total,fecha);//metodo para probar el grabar	
    }
	public static void saveVentas(int ope){  
		IVentas venta = new VentasImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("INGRESA idarticulo");
		int arti=Integer.parseInt(sc.nextLine());;
		System.out.println("INGRESA idgerente	");
		int gere=Integer.parseInt(sc.nextLine());
		System.out.println("INGRESA cod_ventas	");
		String codve = sc.nextLine();
		System.out.println("INGRESA cantidad");
		int cantidad=Integer.parseInt(sc.nextLine());
		System.out.println("INGRESA valor");
		Double valor = sc.nextDouble();
		sc.nextLine();
		System.out.println("INGRESO de fechacompra");
		System.out.println("INGRESA anio");
		int anio=Integer.parseInt(sc.nextLine());
		System.out.println("INGRESA mes");
		int mes=Integer.parseInt(sc.nextLine());
		System.out.println("INGRESA dia");
		int dia=Integer.parseInt(sc.nextLine());
		LocalDate fecha = LocalDate.of(anio,mes,dia);
		venta.create(codve, arti, gere, cantidad, valor, fecha);
		
	}
}
