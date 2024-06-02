package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;

import clases.Controller;
import clases.Producto;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MantenimientoProductos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtFind;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStockActual;
	private JTextField txtStockMinimo;
	private JTextField txtStockMaximo;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,Controller controllerProductos) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoProductos frame = new MantenimientoProductos( controllerProductos);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void LimpiarCampos(JTextField txtId,JTextField	txtNombre,JTextField	txtPrecio,JTextField	txtStockActual,JTextField	txtStockMaximo,JTextField	txtStockMinimo) {
		txtId.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtStockActual.setText("");
		txtStockMaximo.setText("");
		txtStockMinimo.setText("");
		
	}
	public Producto ReturnProducto(JTextField	txtNombre,JTextField	txtPrecio,JTextField	txtStockActual,JTextField	txtStockMaximo,JTextField	txtStockMinimo) {

		String nombre=txtNombre.getText();
		double precio=Double.parseDouble(txtPrecio.getText());
		int stockActual=Integer.parseInt( txtStockActual.getText());
		int stockMaximo=Integer.parseInt( txtStockMaximo.getText());
		int stockMinimo=Integer.parseInt( txtStockMinimo.getText());
		return new Producto(nombre,precio,stockActual,stockMaximo,stockMinimo);
		
	}
	/**
	 * Create the frame.
	 */
	
	public MantenimientoProductos(Controller controllerProductos) {
		ArrayList<Producto> listaProductos=controllerProductos.listaProductos;
		setTitle("Mantinimiento Productos");
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 710, 443);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (Producto producto : listaProductos) {
					System.out.print("\n"+producto.getCodigoProducto()+""+producto.getNombre());
				}
				
			}
		});
		btnNewButton.setBounds(599, 370, 85, 21);
		getContentPane().add(btnNewButton);
		
		txtFind = new JTextField();
		txtFind.setBounds(138, 10, 424, 21);
		getContentPane().add(txtFind);
		txtFind.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 110, 101, 21);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 160, 101, 21);
		getContentPane().add(lblPrecio);
		
		JLabel lblStockActual = new JLabel("Stock Actual");
		lblStockActual.setBounds(10, 210, 101, 21);
		getContentPane().add(lblStockActual);
		
		JLabel lblStockMinimo = new JLabel("Stock Minimo");
		lblStockMinimo.setBounds(10, 260, 101, 21);
		getContentPane().add(lblStockMinimo);
		
		JLabel lblStockMaximo = new JLabel("Stock Maximo");
		lblStockMaximo.setBounds(10, 310, 101, 21);
		getContentPane().add(lblStockMaximo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(142, 110, 255, 21);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(142, 160, 255, 21);
		getContentPane().add(txtPrecio);
		
		txtStockActual = new JTextField();
		txtStockActual.setColumns(10);
		txtStockActual.setBounds(142, 210, 255, 21);
		getContentPane().add(txtStockActual);
		
		txtStockMinimo = new JTextField();
		txtStockMinimo.setColumns(10);
		txtStockMinimo.setBounds(142, 260, 255, 21);
		getContentPane().add(txtStockMinimo);
		
		txtStockMaximo = new JTextField();
		txtStockMaximo.setColumns(10);
		txtStockMaximo.setBounds(142, 310, 255, 21);
		getContentPane().add(txtStockMaximo);
		
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
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.print(cliente);
				Producto product=controllerProductos.FindProducto(Integer.parseInt(txtFind.getText()));
				if (product==null)  {
					LimpiarCampos(txtId,txtNombre,txtPrecio,txtStockActual,txtStockMaximo,txtStockMinimo);
				return ;	
				}
				System.out.print("camnbio de filds");
				txtId.setText(""+product.getCodigoProducto());
				txtNombre.setText(""+product.getNombre());
				txtPrecio.setText(""+product.getPrecio());
				txtStockActual.setText(""+product.getStockActual());
				txtStockMaximo.setText(""+product.getStockMaximo());
				txtStockMinimo.setText(""+product.getStockMinimo());
				
				//System.out.print(controllerProductos.FindProducto(Integer.parseInt(txtFind.getText())));
				
				
			}
		});
		btnBuscar.setBounds(577, 10, 85, 21);
		getContentPane().add(btnBuscar);
		
		JButton btnUpdate = new JButton("Actualizar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto updateProduct=ReturnProducto(txtNombre,txtPrecio,txtStockActual,txtStockMaximo,txtStockMinimo);
				
				controllerProductos.FindProducto(Integer.parseInt(txtFind.getText())).setProducto(updateProduct);;
				
			}
		});
		btnUpdate.setBounds(10, 370, 101, 21);
		getContentPane().add(btnUpdate);
		
		
	

	}
}