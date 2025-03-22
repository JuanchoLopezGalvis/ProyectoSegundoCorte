package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelEliminarProductoOficinaPapeleria extends JPanel{
	
	private BotonRedondeado botonEliminar;
	private JLabel etiqueta1;	
	private Image imagenFondo;
	private JComboBox<String> productosExistentes; ;

	public PanelEliminarProductoOficinaPapeleria() {
		
		setBackground(Color.black);
		setSize(625, 325);	
		setLayout(null);
		setBorder(new EmptyBorder(100, 325, 100, 300));
		
		botonEliminar = new BotonRedondeado("Eliminar producto", 20, Color.DARK_GRAY, Color.decode("#f67704"), Color.white);		
		imagenFondo = new ImageIcon(getClass().getResource("/Recursos/caneca.png")).getImage();
		etiqueta1 = new JLabel("<html>Seleccione el producto<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a eliminar</html>");
		productosExistentes = new JComboBox<>();
		
		etiqueta1.setForeground(Color.white);
		etiqueta1.setBounds(810, 150, 300, 40);
		etiqueta1.setFont(new Font("Arial", Font.BOLD, 20));
		
		productosExistentes.setBackground(Color.DARK_GRAY);
		productosExistentes.setForeground(Color.white);
		productosExistentes.setBounds(775, 260, 300, 30);
		botonEliminar.setBounds(775, 330, 300, 30);
		
	
		
		add(etiqueta1);
		add(productosExistentes);
		add(botonEliminar);
		
		repaint();

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);  

		if (imagenFondo != null) {
			g.drawImage(imagenFondo, 20, 20, 600, 500, this);  
		} else {
			System.out.println("Imagen no cargada correctamente.");
		}
	}

}
