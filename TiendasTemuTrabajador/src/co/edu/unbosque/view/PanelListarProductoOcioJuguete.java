package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelListarProductoOcioJuguete extends JPanel{

	private JTable tablaDeProductos;
	private JScrollPane deslizador;
	private BotonRedondeado botonMostrarTodo;
	private Image imagenFondo;
	
	public PanelListarProductoOcioJuguete() {
		
		setBackground(Color.BLACK);
		setSize(1250, 600);
		setLayout(null);
		imagenFondo = new ImageIcon(getClass().getResource("/Recursos/ojos.png")).getImage();
		botonMostrarTodo = new BotonRedondeado("Mostrar", 35, Color.DARK_GRAY, Color.decode("#f67704"), Color.white);
		tablaDeProductos = new JTable();
		deslizador = new JScrollPane();
		botonMostrarTodo.setBounds(480, 500, 250, 40);
		
		tablaDeProductos.setModel(new DefaultTableModel(
				
				new Object [] [] { 
					

					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					
				},
				
				new String [] {
						"Nombre", "Precio", "Cantidad", "Marca", "Material" ,"Color", "Zona"
				}
				
				));
		
		tablaDeProductos.setPreferredScrollableViewportSize(new Dimension(800, 400));
		tablaDeProductos.setFillsViewportHeight(true);
		
		deslizador.setViewportView(tablaDeProductos);
		deslizador.setBounds(550, 30, 650, 420);
		deslizador.setBackground(Color.DARK_GRAY);
		deslizador.setForeground(Color.DARK_GRAY);
		tablaDeProductos.setBackground(Color.DARK_GRAY);
		tablaDeProductos.setForeground(Color.white);
		add(deslizador);
		add(botonMostrarTodo);
		
		
		
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);  

		if (imagenFondo != null) {
			g.drawImage(imagenFondo, 90, 70, 300, 300, this);  
		} else {
			System.out.println("Imagen no cargada correctamente.");
		}
	}
}
