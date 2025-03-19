<<<<<<< HEAD
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * El {@link PanelLogIn} se encargara de mostrar el apartado del
 * proceso de inicio  de sesión y registro de nuevos usuarios. 
 */
public class PanelLogIn extends JPanel{

	/**
	 * Este boton sera el encargado de enviar los datos del usuario
	 * Y viene de la clase {@link BotonRedondeado}
	 */
	private BotonRedondeado btnIngresar;
	/**
	 * Este boton sera el encargado de enviar los datos del usuario
	 * Y viene de la clase {@link BotonRedondeado}
	 */
	private BotonRedondeado btnRegistrarse;


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
	private TextFieldRedondeado datoUsuario;

	/**
	 * Este sera el campo donde el trabajador pondra su contraseña
	 */
	private JPasswordField datoContraseña;

	/**
	 * Esta es la imagen del logo de TEMU
	 */
	private Image imagenFondo;


	/**
	 * Este metodo se encargara de inicializar los componentes de la clase
	 * {@link PanelLogIn}
	 */
	public PanelLogIn() {

		setBackground(Color.black);
		//		setBackground(Color.decode("#f67704"));
		setSize(1250, 650);
		setBorder(new EmptyBorder(10, 30, 30, 80));
		setLayout(null); 
		btnIngresar = new BotonRedondeado("Ingresar", 20, Color.white, Color.decode("#f67704"), Color.black);
		btnRegistrarse = new BotonRedondeado("Registrarse", 20, Color.white, Color.decode("#f67704"), Color.black);
		saludo = new JLabel("¡Bienvenid@!");
		etiqueta0 = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ingrese su usuario y contaseña<br>Si no tiene cuenta registrese por favor</html>");
		etiqueta1 = new JLabel("Trabajador:");
		etiqueta2 = new JLabel("Contraseña:");
		datoUsuario = new TextFieldRedondeado(20, Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoUsuario.setBackground(Color.DARK_GRAY);
		datoUsuario.setForeground(Color.white);
		datoContraseña = new JPasswordField();
		datoContraseña.setBackground(Color.DARK_GRAY);
		datoContraseña.setForeground(Color.white);
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
		//Clase  completada 
		//Excelente



	}

	/**
	 * Este metodo se encargara de pintar la imagen de fondo
	 * en el panel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);  

		if (imagenFondo != null) {
			g.drawImage(imagenFondo, 20, 40, 650, 500, this);  
		} else {
			System.out.println("Imagen no cargada correctamente.");
		}
	}

	/**
	 * Este metodo se encargara de retornar el boton de ingresar
	 * @return btnIngresar
	 */
	public BotonRedondeado getBtnIngresar() {
		return btnIngresar;
	}

	/**
	 * Este metodo se encargara de modificar el boton de ingresar
	 * @param btnIngresar
	 */
	public void setBtnIngresar(BotonRedondeado btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	/**
	 * Este metodo se encargara de retornar el boton de registrarse
	 * @return btnRegistrarse
	 */
	public BotonRedondeado getBtnRegistrarse() {
		return btnRegistrarse;
	}

	/**
	 * Este metodo se encargara de modificar el boton de registrarse
	 * @param btnRegistrarse
	 */
	public void setBtnRegistrarse(BotonRedondeado btnRegistrarse) {
		this.btnRegistrarse = btnRegistrarse;
	}

	/**
	 * Este metodo se encargara de retornar la etiqueta de saludo
	 * @return saludo
	 */
	public TextFieldRedondeado getDatoUsuario() {
		return datoUsuario;
	}

	/**
	 * Este metodo se encargara de modificar la etiqueta de saludo
	 * @param saludo
	 */
	public void setDatoUsuario(TextFieldRedondeado datoUsuario) {
		this.datoUsuario = datoUsuario;
	}

	/**
	 * Este metodo se encargara de retornar la etiqueta de saludo
	 * @return saludo
	 */
	public JPasswordField getDatoContraseña() {
		return datoContraseña;
	}

	/**
	 * Este metodo se encargara de modificar la etiqueta de saludo
	 * @param saludo
	 */
	public void setDatoContraseña(JPasswordField datoContraseña) {
		this.datoContraseña = datoContraseña;
	}


}
=======
package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * El {@link PanelLogIn} se encargara de mostrar el apartado del
 * proceso de inicio  de sesión y registro de nuevos usuarios. 
 */
public class PanelLogIn extends JPanel{

	/**
	 * Este boton sera el encargado de enviar los datos del usuario
	 * Y viene de la clase {@link BotonRedondeado}
	 */
	private BotonRedondeado btnIngresar;
	/**
	 * Este boton sera el encargado de enviar los datos del usuario
	 * Y viene de la clase {@link BotonRedondeado}
	 */
	private BotonRedondeado btnRegistrarse;


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
	private TextFieldRedondeado datoUsuario;

	/**
	 * Este sera el campo donde el trabajador pondra su contraseña
	 */
	private JPasswordField datoContraseña;

	/**
	 * Esta es la imagen del logo de TEMU
	 */
	private Image imagenFondo;


	/**
	 * Este metodo se encargara de inicializar los componentes de la clase
	 * {@link PanelLogIn}
	 */
	public PanelLogIn() {

		setBackground(Color.black);
		//		setBackground(Color.decode("#f67704"));
		setSize(1250, 650);
		setBorder(new EmptyBorder(10, 30, 30, 80));
		setLayout(null); 
		btnIngresar = new BotonRedondeado("Ingresar", 20, Color.white, Color.decode("#f67704"), Color.black);
		btnRegistrarse = new BotonRedondeado("Registrarse", 20, Color.white, Color.decode("#f67704"), Color.black);
		saludo = new JLabel("¡Bienvenid@!");
		etiqueta0 = new JLabel("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ingrese su usuario y contaseña<br>Si no tiene cuenta registrese por favor</html>");
		etiqueta1 = new JLabel("Trabajador:");
		etiqueta2 = new JLabel("Contraseña:");
		datoUsuario = new TextFieldRedondeado(20, Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoUsuario.setBackground(Color.DARK_GRAY);
		datoUsuario.setForeground(Color.white);
		datoContraseña = new JPasswordField();
		datoContraseña.setBackground(Color.DARK_GRAY);
		datoContraseña.setForeground(Color.white);
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
		//Clase  completada 
		//Excelente



	}

	/**
	 * Este metodo se encargara de pintar la imagen de fondo
	 * en el panel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);  

		if (imagenFondo != null) {
			g.drawImage(imagenFondo, 20, 40, 650, 500, this);  
		} else {
			System.out.println("Imagen no cargada correctamente.");
		}
	}

	/**
	 * Este metodo se encargara de retornar el boton de ingresar
	 * @return btnIngresar
	 */
	public BotonRedondeado getBtnIngresar() {
		return btnIngresar;
	}

	/**
	 * Este metodo se encargara de modificar el boton de ingresar
	 * @param btnIngresar
	 */
	public void setBtnIngresar(BotonRedondeado btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	/**
	 * Este metodo se encargara de retornar el boton de registrarse
	 * @return btnRegistrarse
	 */
	public BotonRedondeado getBtnRegistrarse() {
		return btnRegistrarse;
	}

	/**
	 * Este metodo se encargara de modificar el boton de registrarse
	 * @param btnRegistrarse
	 */
	public void setBtnRegistrarse(BotonRedondeado btnRegistrarse) {
		this.btnRegistrarse = btnRegistrarse;
	}

	/**
	 * Este metodo se encargara de retornar la etiqueta de saludo
	 * @return saludo
	 */
	public TextFieldRedondeado getDatoUsuario() {
		return datoUsuario;
	}

	/**
	 * Este metodo se encargara de modificar la etiqueta de saludo
	 * @param saludo
	 */
	public void setDatoUsuario(TextFieldRedondeado datoUsuario) {
		this.datoUsuario = datoUsuario;
	}

	/**
	 * Este metodo se encargara de retornar la etiqueta de saludo
	 * @return saludo
	 */
	public JPasswordField getDatoContraseña() {
		return datoContraseña;
	}

	/**
	 * Este metodo se encargara de modificar la etiqueta de saludo
	 * @param saludo
	 */
	public void setDatoContraseña(JPasswordField datoContraseña) {
		this.datoContraseña = datoContraseña;
	}


}
>>>>>>> branch 'master' of git@github.com:JuanchoLopezGalvis/ProyectoSegundoCorte.git
