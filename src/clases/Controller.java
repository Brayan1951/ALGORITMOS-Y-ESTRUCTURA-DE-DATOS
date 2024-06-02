package clases;

import java.util.ArrayList;

import interfaces.Identificable;

public class Controller {
	public ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	public ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
	public ArrayList<Venta> listaVentass = new ArrayList<Venta>();

	public Controller() {
		seedProductos();
		// TODO Auto-generated constructor stub
	}

	private void seedProductos() {
		listaProductos.add(new Producto("Gaseosa Inka Cola", 2.5, 5, 0, 10));
		listaProductos.add(new Producto("Gaseosa Coca Cola", 2.5, 5, 0, 10));
		listaProductos.add(new Producto("Gaseosa Fanta", 2.5, 5, 0, 10));
		listaProductos.add(new Producto("Gaseosa Pepsi", 2.5, 5, 0, 10));
	}

	// Funciones productos
	public ArrayList<Producto> AllProducts() {
		return listaProductos;
	}

	public Producto FindProducto(int id) {

		for (Producto cliente : listaProductos) {
			if (cliente.getCodigoProducto() == id)
				return cliente;
		}
		return null;

	}

	public void DeleteProducto(int id) {
		for (int i = 0; i < listaProductos.size(); i++) {
			if (listaProductos.get(i).getCodigoProducto() == id) {
				listaProductos.remove(i);
			}
		}

	}

	// funcion para todo
	
	public <T extends Identificable> void AddArray(ArrayList<T> lista, T item) {
		lista.add(item);
		
	}
	public <T extends Identificable> T FinbyIdArray(ArrayList<T> lista, int id) {
		for (T item : lista) {
			if (item.getCodigo() == id)
				return item;
		}
		return null;
	}

	public <T extends Identificable> void DeleteyIdArray(ArrayList<T> lista, int id) {

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCodigo() == id) {
				lista.remove(i);
			}
		}
	}
	
	//update
	public <T extends Identificable> void UpdateIdArray(ArrayList<T> lista, int id) {
		
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getCodigo() == id) {
				lista.remove(i);
			}
		}
	}
	
	
	
	
	

}
