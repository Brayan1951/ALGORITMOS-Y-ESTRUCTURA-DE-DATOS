package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import clases.Cliente;
import clases.Controller;
import clases.Producto;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventas extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtNombreCliente;
	private JTextField txtApellidoCliente;
	private JTextField txtNombreProducto;
	private JTextField txtCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,Controller controllerVenta) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas frame = new Ventas(controllerVenta);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventas(Controller controllerVenta) {
		
		ArrayList<Cliente> listaClientes= controllerVenta.listaClientes;
		ArrayList<Producto> listaProductos=controllerVenta.listaProductos;
		
		
		setTitle("Ventas");
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 710, 450);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(10, 43, 81, 13);
		getContentPane().add(lblNewLabel);
		
		JComboBox cmbCliente = new JComboBox();
	
		cmbCliente.setBounds(101, 39, 90, 21);
		getContentPane().add(cmbCliente);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(10, 90, 81, 13);
		getContentPane().add(lblProducto);
		
		JComboBox cmbProducto = new JComboBox();
	
		cmbProducto.setBounds(101, 86, 90, 21);
		getContentPane().add(cmbProducto);
		
		JLabel lblNewLabel_1 = new JLabel("Detalle de Venta");
		lblNewLabel_1.setBounds(10, 148, 205, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Importe subtotal");
		lblNewLabel_2.setBounds(10, 190, 118, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Importe del IGV");
		lblNewLabel_2_1.setBounds(10, 229, 118, 13);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Importe  total a pagar");
		lblNewLabel_2_1_1.setBounds(10, 264, 118, 13);
		getContentPane().add(lblNewLabel_2_1_1);
		
		textField = new JTextField();
		textField.setBounds(153, 186, 186, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(153, 225, 186, 21);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(153, 260, 186, 21);
		getContentPane().add(textField_2);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setColumns(10);
		txtNombreCliente.setBounds(217, 40, 186, 21);
		getContentPane().add(txtNombreCliente);
		
		txtApellidoCliente = new JTextField();
		txtApellidoCliente.setColumns(10);
		txtApellidoCliente.setBounds(445, 40, 186, 21);
		getContentPane().add(txtApellidoCliente);
		
		txtNombreProducto = new JTextField();
		txtNombreProducto.setColumns(10);
		txtNombreProducto.setBounds(217, 86, 186, 21);
		getContentPane().add(txtNombreProducto);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(445, 86, 186, 21);
		getContentPane().add(txtCantidad);
		
		
		for (Cliente cliente: listaClientes) {
			
			cmbCliente.addItem(cliente.getCodigo());
		}
		for (Producto producto: listaProductos) {
			
			cmbProducto.addItem(producto.getCodigo());
		}
		
		//cambios en los combo box
		

		cmbCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idCliente=Integer.parseInt(cmbCliente.getSelectedItem().toString());
					
					Cliente client= controllerVenta.FinbyIdArray(listaClientes, idCliente);
					
					txtNombreCliente.setText(client.getNombres());
					txtApellidoCliente.setText(client.getApellidos());
					
					
				} catch (Exception e2) {
					cmbCliente.removeAllItems();
					// TODO: handle exception
					for (Cliente cliente: listaClientes) {
						
						cmbCliente.addItem(cliente.getCodigo());
					}
				}
				//System.out.print(cmbCliente.getSelectedItem());
			
				
				
				  
			}
		});
		cmbProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int idProducto=Integer.parseInt(cmbProducto.getSelectedItem().toString());
					Producto product= controllerVenta.FinbyIdArray(listaProductos, idProducto);
				
					txtNombreProducto.setText(product.getNombre());
				} catch (Exception e2) {
					// TODO: handle exception
					
					cmbProducto.removeAllItems();
					
					for (Producto producto: listaProductos) {
						
						cmbProducto.addItem(producto.getCodigo());
					}
				}
	
			
			}
		});

	}
}
