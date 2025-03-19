package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelActualizarProductoOficinaElectrodomestico extends JPanel{
	
	private BotonRedondeado bton1;
	
	public PanelActualizarProductoOficinaElectrodomestico() {
		setSize(1250,650);
		setBorder(new EmptyBorder(10, 30, 30, 80));
		bton1 = new BotonRedondeado("Registrarse", 20, Color.white, Color.decode("#f67704"), Color.black);
		setLayout(new GridLayout(1,1,1,1));
		add(bton1);
		
	}

}
