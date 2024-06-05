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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ventas extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtSubtotal;
	private JTextField txtIGV;
	private JTextField txtTotal;
	private JTextField txtNombreCliente;
	private JTextField txtApellidoCliente;
	private JTextField txtNombreProducto;
	private JTextField txtCantidad;
	private JTextField txtPrecioUnitario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Controller controllerVenta) {
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

	public Venta returnVenta(Controller controllerVenta, JComboBox cliente, JComboBox producto) {

		int idCliente = Integer.parseInt(cliente.getSelectedItem().toString());
		int idProducto = Integer.parseInt(producto.getSelectedItem().toString());
		int cantidad = Integer.parseInt(txtCantidad.getText());

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");

		// System.out.print(sdf.format(new Date()));
		double total = 0;

		return new Venta(idCliente, idProducto, cantidad, 1, sdf.format(new Date()));

	}

	public void changeVenta(Producto product) {
		int cantidad = Integer.parseInt(txtCantidad.getText());
		double total = cantidad * product.getPrecio();

		txtPrecioUnitario.setText("" + product.getPrecio());
		txtSubtotal.setText("" + (total - (total * 0.18)));
		txtIGV.setText("" + total * 0.18);
		txtTotal.setText("" + total);

	}
	public void cleanVenta(JComboBox cmbProducto,JComboBox cmbCliente) {
		
		cmbProducto.setModel(new DefaultComboBoxModel(new String[] { "PRODUCTO" }));
		cmbCliente.setModel(new DefaultComboBoxModel(new String[] {"CLIENTE"}));
		  txtSubtotal.setText("" );
		  txtIGV.setText("" );
		  txtTotal.setText("" );
		  txtNombreCliente.setText("" );
		  txtApellidoCliente.setText("" );
		  txtNombreProducto.setText("" );
		  txtCantidad.setText("" );
		  txtPrecioUnitario.setText("" );
		
	}
	
	
	

	public Ventas(Controller controllerVenta) {

		ArrayList<Cliente> listaClientes = controllerVenta.listaClientes;
		ArrayList<Producto> listaProductos = controllerVenta.listaProductos;
		ArrayList<Venta> listaVentas = controllerVenta.listaVentass;

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
	
		cmbCliente.setModel(new DefaultComboBoxModel(new String[] {"CLIENTE"}));
		cmbCliente.setToolTipText("");

		cmbCliente.setBounds(101, 39, 90, 21);
		getContentPane().add(cmbCliente);

		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setBounds(10, 90, 81, 13);
		getContentPane().add(lblProducto);

		JComboBox cmbProducto = new JComboBox();
		cmbProducto.setModel(new DefaultComboBoxModel(new String[] { "PRODUCTO" }));

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

		txtSubtotal = new JTextField();
		txtSubtotal.setBounds(153, 235, 186, 21);
		getContentPane().add(txtSubtotal);
		txtSubtotal.setColumns(10);

		txtIGV = new JTextField();
		txtIGV.setColumns(10);
		txtIGV.setBounds(153, 274, 186, 21);
		getContentPane().add(txtIGV);

		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		txtTotal.setBounds(153, 309, 186, 21);
		getContentPane().add(txtTotal);

		txtNombreCliente = new JTextField();
		txtNombreCliente.setEditable(false);
		txtNombreCliente.setColumns(10);
		txtNombreCliente.setBounds(217, 40, 186, 21);
		getContentPane().add(txtNombreCliente);

		txtApellidoCliente = new JTextField();
		txtApellidoCliente.setEditable(false);

		txtApellidoCliente.setColumns(10);
		txtApellidoCliente.setBounds(445, 40, 186, 21);
		getContentPane().add(txtApellidoCliente);

		txtNombreProducto = new JTextField();
		txtNombreProducto.setEditable(false);
		txtNombreProducto.setColumns(10);
		txtNombreProducto.setBounds(217, 86, 186, 21);
		getContentPane().add(txtNombreProducto);

		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);

		txtCantidad.setColumns(10);
		txtCantidad.setBounds(445, 86, 186, 21);
		getContentPane().add(txtCantidad);

		JButton btnNewButton = new JButton("Agregar");

		btnNewButton.setBounds(558, 186, 85, 21);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_2_2 = new JLabel("Precio Unitario");
		lblNewLabel_2_2.setBounds(10, 200, 118, 13);
		getContentPane().add(lblNewLabel_2_2);

		txtPrecioUnitario = new JTextField();
		txtPrecioUnitario.setColumns(10);
		txtPrecioUnitario.setBounds(153, 196, 186, 21);
		getContentPane().add(txtPrecioUnitario);

		/*
		 * for (Cliente cliente: listaClientes) {
		 * 
		 * cmbCliente.addItem(cliente.getCodigo()); } for (Producto producto:
		 * listaProductos) {
		 * 
		 * cmbProducto.addItem(producto.getCodigo()); }
		 */
		// cambios en los combo box

		cmbCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idCliente = Integer.parseInt(cmbCliente.getSelectedItem().toString());

					Cliente client = controllerVenta.FinbyIdArray(listaClientes, idCliente);

					txtNombreCliente.setText(client.getNombres());
					txtApellidoCliente.setText(client.getApellidos());

				} catch (Exception e2) {
				
				}
				// System.out.print(cmbCliente.getSelectedItem());

			}
		});
		cmbProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int idProducto = Integer.parseInt(cmbProducto.getSelectedItem().toString());
					Producto product = controllerVenta.FinbyIdArray(listaProductos, idProducto);

					txtNombreProducto.setText(product.getNombre());
					changeVenta(product);
				} catch (Exception e2) {
					// TODO: handle exception
					/*
					 * cmbProducto.removeAllItems();
					 * 
					 * for (Producto producto: listaProductos) {
					 * 
					 * cmbProducto.addItem(producto.getCodigo()); }
					 */
				}

			}
		});

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Date Factual=new Date();

				Venta newVenta = returnVenta(controllerVenta, cmbCliente, cmbProducto);
				controllerVenta.vender(newVenta);
				cleanVenta(cmbProducto, cmbCliente);

			}
		});

		// metodos de valiudacion

		txtCantidad.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				Producto productoValidate = controllerVenta.FinbyIdArray(listaProductos,
						Integer.parseInt(cmbProducto.getSelectedItem().toString()));
				try {
					int cantidadTemp = Integer.parseInt(txtCantidad.getText());

					if (cantidadTemp < 1) {
						cantidadTemp = 0;
					}

					if (( productoValidate.getStockActual()-cantidadTemp)<productoValidate.getStockMinimo()) {
						
						cantidadTemp = productoValidate.getStockActual()-productoValidate.getStockMinimo();
					}
					if (cantidadTemp > productoValidate.getStockActual() ) {

						cantidadTemp = productoValidate.getStockActual();
					}
					txtCantidad.setText("" + cantidadTemp);

					changeVenta(productoValidate);

				} catch (Exception e2) {
					txtCantidad.setText("0");
					changeVenta(productoValidate);
				}

			}
		});

		// eventos de inicio

		cmbProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtCantidad.setEditable(true);
				cmbProducto.removeAllItems();

				for (Producto producto : listaProductos) {

					cmbProducto.addItem(producto.getCodigo());
				}
			}
		});

		
		cmbCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				cmbCliente.removeAllItems();
				// TODO: handle exception
				for (Cliente cliente : listaClientes) {

					cmbCliente.addItem(cliente.getCodigo());
				}
			}
		});

	}
}
