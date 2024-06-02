package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clases.Cliente;
import clases.Controller;
import clases.Producto;

public class MantenimientoCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtFind;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Controller controllerCliente) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoCliente frame = new MantenimientoCliente(controllerCliente);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	//Funciones repetitivas
	public void LimpiarCampos(JTextField txtId,JTextField txtFind,JTextField txtNombre,JTextField	txtApellido,JTextField	txtDireccion,JTextField	txtTelefono,JTextField	txtDni,JButton btnEliminar,JButton btnUpdate) {
		txtFind.setText("");
		txtId.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
		btnEliminar.setEnabled(false);
		btnUpdate.setEnabled(false);
		
	}
	public void RellenarCampos(Cliente client,JTextField	txtNombre,JTextField	txtApellido,JTextField	txtDireccion,JTextField	txtTelefono,JTextField	txtDni,JButton btnEliminar,JButton btnUpdate) {
		txtFind.setText("");
		txtId.setText(""+client.getCodigo());
		txtNombre.setText(""+client.getNombres());
		txtApellido.setText(""+client.getApellidos());
		txtDireccion.setText(""+client.getDireccion());
		txtTelefono.setText(""+client.getTelefono());
		txtDni.setText(""+client.getDni());
		btnEliminar.setEnabled(true);
		btnUpdate.setEnabled(true);
		
	}
	public Cliente ReturnCliente(JTextField	txtNombre,JTextField	txtApellido,JTextField	txtDireccion,JTextField	txtTelefono,JTextField	txtDni) {

		String nombre=txtNombre.getText();
		String apellido=txtApellido.getText();
		String direccion=txtDireccion.getText();
		String telefono=txtTelefono.getText();
		String dni=txtDni.getText();
		return new Cliente(nombre,apellido,direccion,telefono,dni);
		
	}

	/**
	 * Create the frame.
	 */
	public MantenimientoCliente(Controller controllerCliente) {

		ArrayList<Cliente> listaClientes= controllerCliente.listaClientes;
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Mantinimiento Clientes");
		setBounds(100, 100, 710, 450);
		getContentPane().setLayout(null);

		txtFind = new JTextField();
		txtFind.setBounds(138, 10, 424, 21);
		getContentPane().add(txtFind);
		txtFind.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombres");
		lblNewLabel.setBounds(10, 110, 101, 21);
		getContentPane().add(lblNewLabel);

		JLabel lblPrecio = new JLabel("Apellidos");
		lblPrecio.setBounds(10, 160, 101, 21);
		getContentPane().add(lblPrecio);

		JLabel lblStockActual = new JLabel("Direccion");
		lblStockActual.setBounds(10, 210, 101, 21);
		getContentPane().add(lblStockActual);

		JLabel lblStockMinimo = new JLabel("Telefono");
		lblStockMinimo.setBounds(10, 260, 101, 21);
		getContentPane().add(lblStockMinimo);

		JLabel lblStockMaximo = new JLabel("Dni");
		lblStockMaximo.setBounds(10, 310, 101, 21);
		getContentPane().add(lblStockMaximo);

		txtNombre = new JTextField();
		txtNombre.setBounds(142, 110, 255, 21);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(142, 160, 255, 21);
		getContentPane().add(txtApellido);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(142, 210, 255, 21);
		getContentPane().add(txtDireccion);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(142, 260, 255, 21);
		getContentPane().add(txtTelefono);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(142, 310, 255, 21);
		getContentPane().add(txtDni);

		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 60, 101, 21);
		getContentPane().add(lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(142, 60, 255, 21);
		getContentPane().add(txtId);

		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 10, 101, 21);
		getContentPane().add(lblBuscar);

		JButton btnBuscar = new JButton("Buscar");
	
		JButton btnUpdate = new JButton("Actualizar");
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(421, 370, 101, 21);
		getContentPane().add(btnUpdate);

		JButton btnEliminar = new JButton("Eliminar");
		
		btnEliminar.setEnabled(false);

		btnEliminar.setBounds(10, 370, 101, 21);
		getContentPane().add(btnEliminar);
		btnBuscar.setBounds(577, 10, 85, 21);
		getContentPane().add(btnBuscar);
		JButton btnAdd = new JButton("Agregar");

		btnAdd.setBounds(561, 370, 101, 21);
		getContentPane().add(btnAdd);
		
		//funciones
		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente=controllerCliente.FinbyIdArray(listaClientes,Integer.parseInt(txtFind.getText()));
				
				if (cliente==null)  {
					LimpiarCampos(txtFind,txtId,txtNombre,txtApellido,txtDireccion,txtTelefono,txtDni, btnEliminar, btnUpdate);
				return ;	       
				}
				RellenarCampos(cliente, txtNombre, txtApellido, txtDireccion, txtTelefono, txtDni, btnEliminar, btnUpdate);
				
				
			}
		});
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente updateCliente=ReturnCliente(txtNombre, txtApellido, txtDireccion, txtTelefono, txtDni);
					
				controllerCliente.FinbyIdArray(listaClientes,Integer.parseInt(txtId.getText())).setCliente(updateCliente);;
				
			}
		});
	
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controllerCliente.DeleteyIdArray(listaClientes,Integer.parseInt(txtId.getText()));
				LimpiarCampos(txtFind,txtId,txtNombre,txtApellido,txtDireccion,txtTelefono,txtDni, btnEliminar, btnUpdate);
					
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente newCliente=controllerCliente.FinbyIdArray(listaClientes,Integer.parseInt(txtFind.getText()));
				
				//listaProductos.add(newProduct);
				controllerCliente.AddArray(listaClientes, newCliente);
				LimpiarCampos(txtFind,txtId,txtNombre,txtApellido,txtDireccion,txtTelefono,txtDni, btnEliminar, btnUpdate);
				
			}
		});
		

	}

}
