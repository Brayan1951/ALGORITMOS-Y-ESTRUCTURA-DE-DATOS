package clases;

import java.util.ArrayList;

public class Controller {
	public ArrayList<Producto> listaProductos=new ArrayList<Producto>();
	public ArrayList<Cliente> listaClientes=new ArrayList<Cliente>();
	public ArrayList<Venta> listaVentass=new ArrayList<Venta>();
	public Controller() {
		seedProductos();
		// TODO Auto-generated constructor stub
	}

	private void seedProductos() {
		listaProductos.add(new Producto("Gaseosa Inka Cola",2.5,5,0,10));
		listaProductos.add(new Producto("Gaseosa Coca Cola",2.5,5,0,10));
		listaProductos.add(new Producto("Gaseosa Fanta",2.5,5,0,10));
		listaProductos.add(new Producto("Gaseosa Pepsi",2.5,5,0,10));
	}
	
	
	
	
	
	//Funciones productos
	public ArrayList<Producto> AllProducts(){
		return listaProductos;
	}
	
	public Producto FindProducto(int id ) {
		
		for (Producto cliente : listaProductos) {
			if (cliente.getCodigoProducto()==id) return cliente; 
		}
		return null;
		
	}
	
	
	
}
