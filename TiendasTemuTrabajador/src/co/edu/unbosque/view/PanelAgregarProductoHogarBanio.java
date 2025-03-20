package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.NumberFormatter;

/**
 * Esta clase se encargara de crear el panel que permitira agregar un producto de hogar de baño.
 *
 */
public class PanelAgregarProductoHogarBanio extends JPanel{

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
	private JSpinner datoPrecio;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara la cantidad del producto.
	 */
	private JSpinner datoCantidad;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara la marca del producto.
	 */
	private TextFieldRedondeado datoMarca;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara el material del producto.
	 */
	private TextFieldRedondeado datoMaterial;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara el color del producto.
	 */
	private TextFieldRedondeado datoColor;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara la funcionalidad del producto.
	 */
	private TextFieldRedondeado datoZona;
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
	private JLabel etiquetaMaterial;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica el color del producto.
	 */
	private JLabel etiquetaColor;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica la funcionalidad del producto.
	 */
	private JLabel etiquetaZona;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica la imagen del producto.
	 */
	private JLabel etiquetaImagen;
	//private Image imagenProducto;

	/**
	 * Este metodo se encargara de inicializar los componentes de la clase
	 * {@link PanelAgregarProductoHogarCocina}
	 */
	public PanelAgregarProductoHogarBanio() {
		setSize(1250, 650);
		setLayout(null);
		setBackground(Color.black);
		imagenFondo = new ImageIcon(getClass().getResource("/Recursos/agregar.png")).getImage();
		seleccionImagen = new BotonRedondeado("Seleccionar", 20, Color.DARK_GRAY, Color.decode("#f67704"), Color.white);
		botonAgregar = new BotonRedondeado("Agregar", 20, Color.DARK_GRAY, Color.decode("#f67704"), Color.white);
		datoNombre = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoPrecio = new JSpinner();	
		datoCantidad = new JSpinner();
		datoMarca = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoMaterial = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoColor = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoZona = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		etiquetaNombre = new JLabel("Nombre:");
		etiquetaPrecio = new JLabel("Precio:");
		etiquetaCantidad = new JLabel("Cantidad:");
		etiquetaMarca = new JLabel("Marca:");
		etiquetaMaterial = new JLabel("Material:");
		etiquetaColor = new JLabel("Color:");
		etiquetaZona = new JLabel("Zona de uso:");
		etiquetaImagen = new JLabel("Imagen:");
		etiquetaNombre.setBounds(750, 80, 100, 30);
		datoNombre.setBounds(950, 80, 200, 30);
		etiquetaPrecio.setBounds(750, 130, 100, 30);
		datoPrecio.setBounds(950, 130, 200, 30);
		etiquetaCantidad.setBounds(750, 180, 100, 30);
		datoCantidad.setBounds(950, 180, 200, 30);
		etiquetaMarca.setBounds(750, 230, 100, 30);
		datoMarca.setBounds(950, 230, 200, 30);
		etiquetaMaterial.setBounds(750, 280, 100, 30);
		datoMaterial.setBounds(950, 280, 200, 30);
		etiquetaColor.setBounds(750, 330, 100, 30);
		datoColor.setBounds(950, 330, 200, 30);
		etiquetaZona.setBounds(750, 380, 100, 30);
		datoZona.setBounds(950, 380, 200, 30);
		etiquetaImagen.setBounds(750, 430, 100, 30);
		seleccionImagen.setBounds(950, 430, 200, 30);
		botonAgregar.setBounds(840, 500, 200, 30);
		etiquetaNombre.setForeground(Color.white);
		etiquetaPrecio.setForeground(Color.white);
		etiquetaCantidad.setForeground(Color.white);
		etiquetaMarca.setForeground(Color.white);
		etiquetaMaterial.setForeground(Color.white);
		etiquetaColor.setForeground(Color.white);
		etiquetaZona.setForeground(Color.white);
		etiquetaImagen.setForeground(Color.white);
		datoPrecio.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1000));
		((JSpinner.DefaultEditor) datoPrecio.getEditor()).getTextField().setBackground(Color.DARK_GRAY);
		((JSpinner.DefaultEditor) datoPrecio.getEditor()).getTextField().setForeground(Color.WHITE);
		JFormattedTextField txt = ((JSpinner.DefaultEditor) datoPrecio.getEditor()).getTextField();
		NumberFormatter formatter = (NumberFormatter) txt.getFormatter();
		formatter.setAllowsInvalid(false);  // No permite caracteres no numéricos
		formatter.setMinimum(0); 
		datoCantidad.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		((JSpinner.DefaultEditor) datoCantidad.getEditor()).getTextField().setBackground(Color.DARK_GRAY);
		((JSpinner.DefaultEditor) datoCantidad.getEditor()).getTextField().setForeground(Color.WHITE);
		JFormattedTextField txt2 = ((JSpinner.DefaultEditor) datoCantidad.getEditor()).getTextField();
		NumberFormatter formatter2 = (NumberFormatter) txt2.getFormatter();
		formatter2.setAllowsInvalid(false);  // No permite caracteres no numéricos
		formatter2.setMinimum(0); 

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
		add(etiquetaMaterial);
		add(datoMaterial);
		add(etiquetaColor);
		add(datoColor);
		add(etiquetaZona);
		add(datoZona);
		seleccionImagen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(PanelAgregarProductoHogarBanio.this);
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
	public BotonRedondeado getSeleccionImagen() {
		return seleccionImagen;
	}
	public void setSeleccionImagen(BotonRedondeado seleccionImagen) {
		this.seleccionImagen = seleccionImagen;
	}
	public BotonRedondeado getBotonAgregar() {
		return botonAgregar;
	}
	public void setBotonAgregar(BotonRedondeado botonAgregar) {
		this.botonAgregar = botonAgregar;
	}
	public TextFieldRedondeado getDatoNombre() {
		return datoNombre;
	}
	public void setDatoNombre(TextFieldRedondeado datoNombre) {
		this.datoNombre = datoNombre;
	}
	public JSpinner getDatoPrecio() {
		return datoPrecio;
	}
	public void setDatoPrecio(JSpinner datoPrecio) {
		this.datoPrecio = datoPrecio;
	}

	public JSpinner getDatoCantidad() {
		return datoCantidad;
	}
	public void setDatoCantidad(JSpinner datoCantidad) {
		this.datoCantidad = datoCantidad;
	}
	public TextFieldRedondeado getDatoMarca() {
		return datoMarca;
	}
	public void setDatoMarca(TextFieldRedondeado datoMarca) {
		this.datoMarca = datoMarca;
	}
	public TextFieldRedondeado getDatoMaterial() {
		return datoMaterial;
	}
	public void setDatoMaterial(TextFieldRedondeado datoMaterial) {
		this.datoMaterial = datoMaterial;
	}
	public TextFieldRedondeado getDatoColor() {
		return datoColor;
	}
	public void setDatoColor(TextFieldRedondeado datoColor) {
		this.datoColor = datoColor;
	}
	public TextFieldRedondeado getDatoZona() {
		return datoZona;
	}
	public void setDatoZona(TextFieldRedondeado datoZona) {
		this.datoZona = datoZona;
	}


}
