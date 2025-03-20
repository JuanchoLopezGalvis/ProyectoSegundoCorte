package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * El {@link PanelLogIn} se encargara de mostrar el apartado del
 * proceso de inicio  de sesión y registro de nuevos usuarios. 
 */
public class PanelLogIn extends JPanel{

	private JCheckBox checkEspañol;
	private JCheckBox checkIngles;
	/**
	 * Este label sera el encargado de indicarle al usuario que seleccione el idioma
	 */
	private JLabel seleccioneIdioma;
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
		setSize(1250, 650);
		setBorder(new EmptyBorder(10, 30, 30, 80));
		setLayout(null); 
		checkEspañol = new JCheckBox("Spanish");
		checkIngles = new JCheckBox("English");
		seleccioneIdioma = new JLabel("Select your language");
		btnIngresar = new BotonRedondeado("Sign in", 20, Color.white, Color.decode("#f67704"), Color.black);
		btnRegistrarse = new BotonRedondeado("Sign up", 20, Color.white, Color.decode("#f67704"), Color.black);
		saludo = new JLabel("<html>&nbsp;&nbsp;Welcome!<html>");
		etiqueta0 = new JLabel("<html>&nbsp;Enter your user and password. If you<br>don´t have an account, please sign up</html>");
		etiqueta1 = new JLabel("User:");
		etiqueta2 = new JLabel("Password:");
		datoUsuario = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoUsuario.setBackground(Color.DARK_GRAY);
		datoUsuario.setForeground(Color.white);
		datoContraseña = new JPasswordField();
		datoContraseña.setBackground(Color.DARK_GRAY);
		datoContraseña.setForeground(Color.white);
		imagenFondo = new ImageIcon(getClass().getResource("/Recursos/TEMU.png")).getImage();
		saludo.setBounds(870, 120, 300, 25);
		etiqueta0.setBounds(755, 140, 380, 100);
		etiqueta1.setBounds(740, 240, 300, 25);
		etiqueta2.setBounds(740, 280, 300, 25);
		datoUsuario.setBounds(935, 240, 200, 25);
		datoContraseña.setBounds(935, 280, 200, 25);
		btnIngresar.setBounds(945, 360, 200, 40);
		btnRegistrarse.setBounds(725, 360, 200, 40);
		seleccioneIdioma.setBounds(20, 20, 200, 25);
		checkEspañol.setBounds(250, 20, 80, 25);
		checkIngles.setBounds(350, 20, 80, 25);
		//leerNombre.setBounds(760, 350, 300, 25);
		etiqueta0.setFont(new Font("Arial", Font.BOLD, 20));
		seleccioneIdioma.setFont(new Font("Arial", Font.BOLD, 18));
		saludo.setFont(new Font("Arial", Font.BOLD, 20));
		etiqueta1.setFont(new Font("Arial", Font.BOLD, 20));
		etiqueta2.setFont(new Font("Arial", Font.BOLD, 20));
		saludo.setForeground(Color.white);
		seleccioneIdioma.setForeground(Color.white);
		etiqueta0.setForeground(Color.white);
		etiqueta1.setForeground(Color.white);
		etiqueta2.setForeground(Color.white);
		checkEspañol.setForeground(Color.white);
		checkIngles.setForeground(Color.white);
		checkEspañol.setBackground(Color.DARK_GRAY);
		checkIngles.setBackground(Color.DARK_GRAY);
		datoContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		add(checkEspañol);
		add(checkIngles);
		add(seleccioneIdioma);
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

	public JCheckBox getCheckEspañol() {
		return checkEspañol;
	}

	public void setCheckEspañol(JCheckBox checkEspañol) {
		this.checkEspañol = checkEspañol;
	}

	public JCheckBox getCheckIngles() {
		return checkIngles;
	}

	public void setCheckIngles(JCheckBox checkIngles) {
		this.checkIngles = checkIngles;
	}

	public JLabel getSeleccioneIdioma() {
		return seleccioneIdioma;
	}

	public void setSeleccioneIdioma(JLabel seleccioneIdioma) {
		this.seleccioneIdioma = seleccioneIdioma;
	}

	public JLabel getSaludo() {
		return saludo;
	}

	public void setSaludo(JLabel saludo) {
		this.saludo = saludo;
	}

	public JLabel getEtiqueta0() {
		return etiqueta0;
	}

	public void setEtiqueta0(JLabel etiqueta0) {
		this.etiqueta0 = etiqueta0;
	}

	public JLabel getEtiqueta1() {
		return etiqueta1;
	}

	public void setEtiqueta1(JLabel etiqueta1) {
		this.etiqueta1 = etiqueta1;
	}

	public JLabel getEtiqueta2() {
		return etiqueta2;
	}

	public void setEtiqueta2(JLabel etiqueta2) {
		this.etiqueta2 = etiqueta2;
	}


}
