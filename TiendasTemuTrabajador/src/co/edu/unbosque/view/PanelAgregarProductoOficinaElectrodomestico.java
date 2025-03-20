package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Esta clase se encargara de crear el panel que permitira agregar un producto de oficina o electrodomestico.
 * Esta clase extiende de {@link JPanel} y ademas implementa la interfaz {@link ActionListener}.
 */
public class PanelAgregarProductoOficinaElectrodomestico extends JPanel{

	/**
	 * Este atributo es el encargado de guardar la imagen de fondo del panel.
	 */
	private Image imagenFondo;
	/**
	 * Este atributo es el encargado de guardar el boton que permitira seleccionar la imagen.
	 */
	private BotonRedondeado seleccionImagen;
	/**
	 * Este atributo es el encargado de guardar el boton que permitira agregar el producto.
	 */
	private BotonRedondeado botonAgregar;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara el nombre del producto.
	 */
	private TextFieldRedondeado datoNombre;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara el precio del producto.
	 */
	private TextFieldRedondeado datoPrecio;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara la cantidad del producto.
	 */
	private TextFieldRedondeado datoCantidad;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara la marca del producto.
	 */
	private TextFieldRedondeado datoMarca;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara el material del producto.
	 */
	private JComboBox<String> datoNivelRuido;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara la funcionalidad del producto.
	 */
	private TextFieldRedondeado datoConsumoEnergetico;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica el nombre del producto.
	 */
	private JLabel etiquetaNombre;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica el precio del producto.
	 */
	private JLabel etiquetaPrecio;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica la cantidad del producto.
	 */
	private JLabel etiquetaCantidad;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica la marca del producto.
	 */
	private JLabel etiquetaMarca;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica el material del producto.
	 */
	private JLabel etiquetaNivelRuido;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica la funcionalidad del producto.
	 */
	private JLabel etiquetaConsumoEnergetico;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica la imagen del producto.
	 */
	private JLabel etiquetaImagen;
	//private Image imagenProducto;

	/**
	 * Este metodo se encargara de inicializar los componentes de la clase
	 * {@link PanelAgregarProductoHogarCocina}
	 */
	public PanelAgregarProductoOficinaElectrodomestico() {
		setSize(1250, 650);
		setLayout(null);
		setBackground(Color.black);
		imagenFondo = new ImageIcon(getClass().getResource("/Recursos/agregar.png")).getImage();
		seleccionImagen = new BotonRedondeado("Seleccionar", 20, Color.DARK_GRAY, Color.decode("#f67704"), Color.white);
		botonAgregar = new BotonRedondeado("Agregar", 20, Color.DARK_GRAY, Color.decode("#f67704"), Color.white);
		datoNombre = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoPrecio = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);	
		datoCantidad = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoMarca = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		String[] niveles = {"Bajo", "Medio", "Alto"};
		datoNivelRuido = new JComboBox<String>(niveles);
		datoConsumoEnergetico = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		etiquetaNombre = new JLabel("Nombre:");
		etiquetaPrecio = new JLabel("Precio:");
		etiquetaCantidad = new JLabel("Cantidad:");
		etiquetaMarca = new JLabel("Marca:");
		etiquetaNivelRuido = new JLabel("Nivel de ruido:");
		etiquetaConsumoEnergetico = new JLabel("Consumo energetico:");
		etiquetaImagen = new JLabel("Imagen:");
		etiquetaNombre.setBounds(750, 80, 100, 30);
		datoNombre.setBounds(950, 80, 200, 30);
		etiquetaPrecio.setBounds(750, 130, 100, 30);
		datoPrecio.setBounds(950, 130, 200, 30);
		etiquetaCantidad.setBounds(750, 180, 100, 30);
		datoCantidad.setBounds(950, 180, 200, 30);
		etiquetaMarca.setBounds(750, 230, 100, 30);
		datoMarca.setBounds(950, 230, 200, 30);
		etiquetaNivelRuido.setBounds(750, 280, 100, 30);
		datoNivelRuido.setBounds(950, 280, 200, 30);
		etiquetaConsumoEnergetico.setBounds(750, 330, 150, 30);
		datoConsumoEnergetico.setBounds(950, 330, 200, 30);
		etiquetaImagen.setBounds(750, 430, 100, 30);
		seleccionImagen.setBounds(950, 430, 200, 30);
		botonAgregar.setBounds(840, 500, 200, 30);
		etiquetaNombre.setForeground(Color.white);
		etiquetaPrecio.setForeground(Color.white);
		etiquetaCantidad.setForeground(Color.white);
		etiquetaMarca.setForeground(Color.white);
		etiquetaNivelRuido.setForeground(Color.white);
		etiquetaConsumoEnergetico.setForeground(Color.white);
		etiquetaImagen.setForeground(Color.white);
		datoNivelRuido.setBackground(Color.DARK_GRAY);
		datoNivelRuido.setForeground(Color.white);
		
		add(etiquetaImagen);
		add(botonAgregar);
		add(etiquetaNombre);
		add(datoNombre);
		add(etiquetaPrecio);
		add(datoPrecio);
		add(etiquetaCantidad);
		add(datoCantidad);
		add(etiquetaMarca);
		add(datoMarca);
		add(etiquetaNivelRuido);
		add(datoNivelRuido);
		add(etiquetaConsumoEnergetico);
		add(datoConsumoEnergetico);
		seleccionImagen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(PanelAgregarProductoOficinaElectrodomestico.this);
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
	/**
	 * Este metodo se encargara de pintar la imagen de fondo
	 * en el panel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);  

		if (imagenFondo != null) {
			g.drawImage(imagenFondo, 80, 80, 400, 400, this);  
		} else {
			System.out.println("Imagen no cargada correctamente.");
		}
	}
}
