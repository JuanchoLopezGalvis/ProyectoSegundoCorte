package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * El {@link PanelLogIn} se encargara de mostrar el apartado del
 * proceso de inicio  de sesión y registro de nuevos usuarios. 
 */
public class PanelLogIn extends JPanel{
	
	/**
	 * El btnIngresar permitira dos cosas:
	 * 1. Que el usuario "trabajador" ingrese al aplicativo y disponga de
	 * sus funcionalidades.
	 * 2. Cerrar la {@link VentanaLogIn}.
	 */
	private JButton btnIngresar;
	
	/**
	 * El btnRegistrarse permitira dos cosas:
	 * 1. Que el usuario sea registrado y almacenado en la persistencia.
	 * 2. Cerrar la {@link VentanaLogIn}.
	 */
	private JButton btnRegistrarse;
	
	/**
	 * Esta etiqueta sera un saludo de bienvenida
	 */
	private JLabel saludo;
	
	/**
	 * Esta etiqueta le indicara al usuario que dabera hacer en la ventana.
	 */
	
	private JLabel etiqueta0;
	
	/**
	 * Esta etiqueta indicara cual es el campo del usuario.
	 */
	
	private JLabel etiqueta1;
	
	/**
	 * Esta etiqueta indicara cual es el campo de la contraseña.
	 */
	
	private JLabel etiqueta2;
	
	/**
	 * Este sera el campo donde el trabajador pondra su usuario
	 */
	private JTextField datoUsuario;
	
	/**
	 * Este sera el campo donde el trabajador pondra su contraseña
	 */
	private JPasswordField datoContraseña;
	
	/**
	 * Esta es la imagen del logo de TEMU
	 */
	private Image imagenFondo;
	
	/**
	 * Constructor vacio del {@link PanelLogIn} donde le damos todas 
	 * las caracteristicas.
	 */
	public PanelLogIn() {
		
		setBackground(Color.decode("#f67704"));
		setSize(1250, 650);
		setBorder(new EmptyBorder(10, 30, 30, 80));
		setLayout(null); 
		btnIngresar = new JButton("Ingresar");
		btnRegistrarse = new JButton("Registrarse");
		saludo = new JLabel("¡Bienvenid@!");
		etiqueta0 = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ingrese su usuario y contaseña<br>Si no tiene cuenta registrese por favor</html>");
		etiqueta1 = new JLabel("Usuario:");
		etiqueta2 = new JLabel("Contraseña:");
		datoUsuario = new JTextField();
		datoContraseña = new JPasswordField();
		imagenFondo = new ImageIcon(getClass().getResource("/Recursos/TEMU.png")).getImage();
		saludo.setBounds(870, 120, 300, 25);
		etiqueta0.setBounds(765, 140, 380, 100);
		etiqueta1.setBounds(740, 240, 300, 25);
		etiqueta2.setBounds(740, 280, 300, 25);
		datoUsuario.setBounds(935, 240, 200, 25);
		datoContraseña.setBounds(935, 280, 200, 25);
		btnIngresar.setBounds(945, 360, 200, 40);
		btnRegistrarse.setBounds(725, 360, 200, 40);
		//leerNombre.setBounds(760, 350, 300, 25);
		etiqueta0.setFont(new Font("Arial", Font.BOLD, 20));
		saludo.setFont(new Font("Arial", Font.BOLD, 20));
		etiqueta1.setFont(new Font("Arial", Font.BOLD, 20));
		etiqueta2.setFont(new Font("Arial", Font.BOLD, 20));
		saludo.setForeground(Color.white);
		etiqueta0.setForeground(Color.white);
		etiqueta1.setForeground(Color.white);
		etiqueta2.setForeground(Color.white);
		
		
		add(btnIngresar);
		add(btnRegistrarse);
		add(etiqueta0);
		add(etiqueta1);
		add(etiqueta2);
		add(saludo);
		add(datoContraseña);
		add(datoUsuario);
		
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);  

		if (imagenFondo != null) {
			g.drawImage(imagenFondo, 20, 40, 650, 500, this);  
		} else {
			System.out.println("Imagen no cargada correctamente.");
		}
	}


}
