package clases;

public class Producto {
	private static int correlativo = 2001;
	int codigoProducto;
	String nombre;
	double precio;
	int stockActual,stockMinimo,stockMaximo;

	public Producto( String nombre, double precio, int stockActual, int stockMinimo,
			int stockMaximo) {
		super();
		this.codigoProducto = correlativo++;
		this.nombre = nombre;
		this.precio = precio;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}



	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}

	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setProducto( Producto updateProducto) {
		this.nombre = updateProducto.nombre;
		this.precio = updateProducto.precio;
		this.stockActual = updateProducto.stockActual;
		this.stockMinimo = updateProducto.stockMinimo;
		this.stockMaximo = updateProducto.stockMaximo;
	}
	
	

}
