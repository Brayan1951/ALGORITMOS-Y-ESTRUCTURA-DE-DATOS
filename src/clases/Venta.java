package clases;

public class Venta {
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

}
