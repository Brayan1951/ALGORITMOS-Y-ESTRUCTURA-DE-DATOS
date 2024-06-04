package clases;

import interfaces.Identificable;

public class Cliente implements Identificable {
	private static int correlativo = 1001;
	int codigoCliente;
	String nombres,apellidos,direccion,telefono,dni;
	
	public Cliente( Cliente newCliente) {
		super();
		this.codigoCliente = correlativo++;
		this.nombres = newCliente.nombres;
		this.apellidos = newCliente.apellidos;
		this.direccion = newCliente.direccion;
		this.telefono = newCliente.telefono;
		this.dni = newCliente.dni;
	}
	public Cliente( String nombres, String apellidos, String direccion, String telefono, String dni) {
		super();
		this.codigoCliente = correlativo++;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
	}

	@Override
	public int getCodigo() {
		// TODO Auto-generated method stub
		return this.codigoCliente;
	}
	
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setCliente( Cliente updateCliente) {
		this.nombres = updateCliente.nombres;
		this.apellidos = updateCliente.apellidos;
		this.direccion = updateCliente.direccion;
		this.telefono = updateCliente.telefono;
		this.dni = updateCliente.dni;
	}

	
	
	

}
