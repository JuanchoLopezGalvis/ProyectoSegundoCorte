package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class PanelSignUp extends JPanel{

	private BotonRedondeado seleccionImagen;
	private JLabel imagenUser;
	private JLabel imagenContraseña;
	private JLabel imagenContraseñaConfirmacion;
	private Image tamañoOriginal;
	private Image tamañoEscalado;
	private ImageIcon iconoEscalado;
	private TextFieldRedondeado datoUsuario;
	private JPasswordField datoContraseña;
	private JPasswordField datoContraseñaConfirmacion;
	private ImageIcon icon;
	private BotonRedondeado botonAgregarTrabajador;
	public PanelSignUp() {
		setSize(500,500);
		setLayout(null);
		setBackground(Color.BLACK);
		imagenUser = EscalarImagen(30, 30, "src/Recursos/imagenUser.png");
		imagenContraseña = EscalarImagen(30, 30, "src/Recursos/contraseñaa.png");
		imagenContraseñaConfirmacion = EscalarImagen(40, 40, "src/Recursos/contrseñaDeNuevo.png");
		seleccionImagen = new BotonRedondeado("Seleccionar mi foto", 20, Color.DARK_GRAY, Color.decode("#f67704"), Color.white);
		datoUsuario = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		botonAgregarTrabajador = new BotonRedondeado("Agregar Trabajador", 20, Color.DARK_GRAY, Color.decode("#f67704"), Color.white);
		datoContraseña = new JPasswordField();
		datoContraseñaConfirmacion = new JPasswordField();
		imagenUser.setBounds(100, 95, 30, 30);
		imagenContraseña.setBounds(100, 150, 30, 30);
		imagenContraseñaConfirmacion.setBounds(95, 200, 40, 40);
		seleccionImagen.setBounds(150, 250, 200, 30);
		datoUsuario.setBounds(150, 95, 200, 30);
		datoContraseña.setBounds(150, 150, 200, 30);
		datoContraseñaConfirmacion.setBounds(150, 200, 200, 30);
		botonAgregarTrabajador.setBounds(150, 300, 200, 30);
		datoContraseña.setBackground(Color.DARK_GRAY);
		datoContraseñaConfirmacion.setBackground(Color.DARK_GRAY);
		datoContraseña.setForeground(Color.white);
		datoContraseñaConfirmacion.setForeground(Color.white);
		datoContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		datoContraseñaConfirmacion.setHorizontalAlignment(SwingConstants.RIGHT);
		add(imagenContraseñaConfirmacion);
		add(botonAgregarTrabajador);
		add(imagenUser);
		add(imagenContraseña);
		add(datoUsuario);
		add(datoContraseña);
		add(datoContraseñaConfirmacion);
		seleccionImagen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(PanelSignUp.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				} else {
					System.out.println("File selection cancelled.");
				}
			}
		});
		add(seleccionImagen);
	}
	public JLabel EscalarImagen(int ancho, int alto, String ruta) {
		icon = new ImageIcon(ruta);
		tamañoOriginal = icon.getImage();
		tamañoEscalado = tamañoOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		iconoEscalado = new ImageIcon(tamañoEscalado);
		return new JLabel(iconoEscalado);
	}	

}
