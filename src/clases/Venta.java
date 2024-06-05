package clases;

import interfaces.Identificable;

public class Venta implements Identificable {
	private static int correlativo = 3001;
	int codigoVenta,codigoCliente,codigoProducto,cantidad;
	double precio;
	String fecha;
	
	
	public Venta( int codigoCliente, int codigoProducto, int cantidad, double precio, String fecha) {
		super();
		this.codigoVenta = correlativo++;
		this.codigoCliente = codigoCliente;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
	}


	public Venta() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public int getCodigo() {
		// TODO Auto-generated method stub
		return this.codigoVenta;
	}

	
	
	
	
	
}
