package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Controller;
import clases.Producto;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	Controller mainController=new Controller(); 

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 629);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("MANTENIMIENTO");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuClientes = new JMenuItem("CLIENTES");

		mnNewMenu.add(menuClientes);
		
		JMenuItem menuProductos = new JMenuItem("PRODUCTOS");
	
		mnNewMenu.add(menuProductos);
		
		JMenuItem menuVentas = new JMenuItem("VENTAS");
		menuVentas.setHorizontalAlignment(SwingConstants.CENTER);
	
		menuBar.add(menuVentas);
		
		JMenuItem menuAlmacen = new JMenuItem("ALMACEN");
		menuAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(menuAlmacen);
		
		JMenuItem menuReportes = new JMenuItem("REPORTES");
		menuReportes.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(menuReportes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane escritorio = new JDesktopPane();
		escritorio.setBounds(0, 0, 867, 564);
		contentPane.add(escritorio);
		
		;
//		Producto produ=new Producto("Gaseosa Inka Cola",2.5,5,0,10);
		

		
		//Funciones / eventos
		//botones - 
		menuProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MantenimientoProductos mantenimientoProductos=new MantenimientoProductos(mainController);
				escritorio.add(mantenimientoProductos);
				mantenimientoProductos.show();
				
			}
		});
		
		
		menuClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MantenimientoCliente mantenimientoCliente=new MantenimientoCliente(mainController);
				escritorio.add(mantenimientoCliente);
				mantenimientoCliente.show();
				
			}
		});
		
		menuVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventas ventas=new Ventas(mainController);
				escritorio.add(ventas);
				ventas.show();
			
			}
		});
		
		
	}
}
