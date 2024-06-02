package clases;

public class Cliente {
	private static int correlativo = 1001;
	int codigoCliente;
	String nombres,apellidos,direccion,telefono,dni;
	
	public Cliente( String nombres, String apellidos, String direccion, String telefono, String dni) {
		super();
		this.codigoCliente = correlativo++;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

}
