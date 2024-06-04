package gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import clases.Cliente;
import clases.Controller;
import clases.Producto;
import clases.Venta;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import org.w3c.dom.Text;

import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventas extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField txtNombreCliente;
	private JTextField txtApellidoCliente;
	private JTextField txtNombreProducto;
	private JTextField txtCantidad;
	private JTextField textField_3;
	

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
	
	public Venta returnVenta(Controller controllerVenta,JComboBox cliente,JComboBox producto) {
		
		int idCliente=Integer.parseInt(cliente.getSelectedItem().toString());
		int idProducto=Integer.parseInt(producto.getSelectedItem().toString());
		int cantidad=Integer.parseInt( txtCantidad.getText());
		
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yy");
				
		
		//System.out.print(sdf.format(new Date()));
		double total=0;
		
		return new Venta(idCliente,idProducto,cantidad,1,sdf.format(new Date()));
		
		
	}
	
	
	public Ventas(Controller controllerVenta) {
		
		ArrayList<Cliente> listaClientes= controllerVenta.listaClientes;
		ArrayList<Producto> listaProductos=controllerVenta.listaProductos;
		ArrayList<Venta> listaVentas=controllerVenta.listaVentass;
		
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
		lblNewLabel_2.setBounds(10, 239, 118, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Importe del IGV");
		lblNewLabel_2_1.setBounds(10, 278, 118, 13);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Importe  total a pagar");
		lblNewLabel_2_1_1.setBounds(10, 313, 118, 13);
		getContentPane().add(lblNewLabel_2_1_1);
		
		textField = new JTextField();
		textField.setBounds(153, 235, 186, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(153, 274, 186, 21);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(153, 309, 186, 21);
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
		
		JButton btnNewButton = new JButton("Agregar");
		
		btnNewButton.setBounds(558, 186, 85, 21);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2_2 = new JLabel("Precio Unitario");
		lblNewLabel_2_2.setBounds(10, 200, 118, 13);
		getContentPane().add(lblNewLabel_2_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(153, 196, 186, 21);
		getContentPane().add(textField_3);
		
		
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
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Date Factual=new Date();
				
				
				Venta newVenta=returnVenta(controllerVenta, cmbCliente, cmbProducto);
				controllerVenta.AddArray(listaVentas, newVenta);
				
				
				for (Venta venta : listaVentas) {
					System.out.print(venta.getCodigo());
				}
				
				
				
				
				
				
			}
		});

		
		
		//metodos de valiudacion
		

		
		txtCantidad.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				
				Producto productoValidate=controllerVenta.FinbyIdArray(listaProductos, Integer.parseInt(cmbProducto.getSelectedItem().toString()));
				try {
					int cantidadTemp= Integer.parseInt( txtCantidad.getText());
					
					if (cantidadTemp<1) {
						cantidadTemp=1;
					}
					
					if (cantidadTemp>productoValidate.getStockActual()) {
						
						cantidadTemp= productoValidate.getStockActual();
					}
					txtCantidad.setText( ""+cantidadTemp);
				} catch (Exception e2) {
					txtCantidad.setText( "1");
					
				}
				
				
				
			}
		});

		
	}
}
