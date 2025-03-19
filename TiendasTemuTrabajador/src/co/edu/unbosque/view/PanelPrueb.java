package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelPrueb extends JPanel{
	
	private JFileChooser imagen;
	private FileNameExtensionFilter filtro;
	
	public PanelPrueb() {
		setSize(1250, 650);
		setBorder(new EmptyBorder(10, 30, 30, 80));
		setLayout(new GridLayout(1,1,1,1));
		imagen = new JFileChooser();
		filtro = new FileNameExtensionFilter("PNG", "png");
		imagen.setFileFilter(filtro);
		imagen.setAcceptAllFileFilterUsed(false);
		add(imagen);
	}

}
