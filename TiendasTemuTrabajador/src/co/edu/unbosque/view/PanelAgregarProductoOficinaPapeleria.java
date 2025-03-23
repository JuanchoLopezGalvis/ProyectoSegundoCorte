package co.edu.unbosque.view;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.NumberFormatter;
/**
 * Esta clase se encargara de crear el panel que permitira agregar un producto de oficina de papeleria.
 * Esta clase extiende de {@link JPanel} y ademas implementa la interfaz {@link ActionListener}.
 */
public class PanelAgregarProductoOficinaPapeleria extends JPanel{
	
	/**
	 * Este atributo es el encargado de guardar la imagen del producto.
	 */
	private Image imagenProducto;
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
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara el nivel de ruido del producto.
	 */
	private JComboBox<String> datoNivelRuido;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara la funcionalidad del producto.
	 */
	private TextFieldRedondeado datoFuncion;
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
	 * Este atributo es el encargado de guardar la etiqueta que indica el nivel de ruido del producto.
	 */
	private JLabel etiquetaNivelRuido;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica la funcionalidad del producto.
	 */
	private JLabel etiquetaFuncion;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica la imagen del producto.
	 */
	private JLabel etiquetaImagen;
	//private Image imagenProducto;

	/**
	 * Este metodo se encargara de inicializar los componentes de la clase
	 * {@link PanelAgregarProductoOficinaPapeleria}.
	 */
	public PanelAgregarProductoOficinaPapeleria() {
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
		String[] niveles = {"", "Bajo", "Medio", "Alto"};
		datoNivelRuido = new JComboBox<String>(niveles);
		datoFuncion = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		etiquetaNombre = new JLabel("Nombre:");
		etiquetaPrecio = new JLabel("Precio:");
		etiquetaCantidad = new JLabel("Cantidad:");
		etiquetaMarca = new JLabel("Marca:");
		etiquetaNivelRuido = new JLabel("Nivel de ruido:");
		etiquetaFuncion = new JLabel("Función:");
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
		etiquetaFuncion.setBounds(750, 330, 150, 30);
		datoFuncion.setBounds(950, 330, 200, 30);
		etiquetaImagen.setBounds(750, 430, 100, 30);
		seleccionImagen.setBounds(950, 430, 200, 30);
		botonAgregar.setBounds(840, 500, 200, 30);
		etiquetaNombre.setForeground(Color.white);
		etiquetaPrecio.setForeground(Color.white);
		etiquetaCantidad.setForeground(Color.white);
		etiquetaMarca.setForeground(Color.white);
		etiquetaNivelRuido.setForeground(Color.white);
		etiquetaFuncion.setForeground(Color.white);
		etiquetaImagen.setForeground(Color.white);
		datoNivelRuido.setBackground(Color.DARK_GRAY);
		datoNivelRuido.setForeground(Color.white);
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
		add(etiquetaNivelRuido);
		add(datoNivelRuido);
		add(etiquetaFuncion);
		add(datoFuncion);
		seleccionImagen.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png");
		        fileChooser.setFileFilter(filter);
		        fileChooser.setAcceptAllFileFilterUsed(false);
		        int result = fileChooser.showOpenDialog(PanelAgregarProductoOficinaPapeleria.this);
		        if (result == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            try {
		                imagenProducto = ImageIO.read(selectedFile);
		                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
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
	/**
	 * Este metodo se encargara de retornar la imagen de fondo.
	 * @return imagenFondo
	 */
	public BotonRedondeado getSeleccionImagen() {
		return seleccionImagen;
	}
	/**
	 * Este metodo se encargara de modificar la imagen de fondo.
	 * @param seleccionImagen
	 */
	public void setSeleccionImagen(BotonRedondeado seleccionImagen) {
		this.seleccionImagen = seleccionImagen;
	}
	/**
	 * Este metodo se encargara de retornar el boton de agregar.
	 * @return botonAgregar
	 */
	public BotonRedondeado getBotonAgregar() {
		return botonAgregar;
	}
	/**
	 * Este metodo se encargara de modificar el boton de agregar.
	 * @param botonAgregar
	 */
	public void setBotonAgregar(BotonRedondeado botonAgregar) {
		this.botonAgregar = botonAgregar;
	}
	/**
	 * Este metodo se encargara de retornar el campo de texto del nombre.
	 * @return datoNombre
	 */
	public TextFieldRedondeado getDatoNombre() {
		return datoNombre;
	}
	/**
	 * Este metodo se encargara de modificar el campo de texto del nombre.
	 * @param datoNombre
	 */
	public void setDatoNombre(TextFieldRedondeado datoNombre) {
		this.datoNombre = datoNombre;
	}
	/**
	 * Este metodo se encargara de retornar el campo numerico del precio.
	 * @return datoPrecio
	 */
	public JSpinner getDatoPrecio() {
		return datoPrecio;
	}
	/**
	 * Este metodo se encargara de modificar el campo numerica del precio.
	 * @param datoPrecio
	 */
	public void setDatoPrecio(JSpinner datoPrecio) {
		this.datoPrecio = datoPrecio;
	}

	/**
	 * Este metodo se encargara de retornar el campo numerico de la cantidad.
	 * @return datoCantidad
	 */
	public JSpinner getDatoCantidad() {
		return datoCantidad;
	}
	/**
	 * Este metodo se encargara de modificar el campo numerico de la cantidad.
	 * @param datoCantidad
	 */
	public void setDatoCantidad(JSpinner datoCantidad) {
		this.datoCantidad = datoCantidad;
	}
	/**
	 * Este metodo se encargara de retornar el campo de texto de la marca.
	 * @return datoMarca
	 */
	public TextFieldRedondeado getDatoMarca() {
		return datoMarca;
	}
	/**
	 * Este metodo se encargara de modificar el campo de texto de la marca.
	 * @param datoMarca
	 */
	public void setDatoMarca(TextFieldRedondeado datoMarca) {
		this.datoMarca = datoMarca;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta del material.
	 * @return etiquetaMaterial
	 */
	public JLabel getEtiquetaNombre() {
		return etiquetaNombre;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta del material.
	 * @param etiquetaMaterial
	 */
	public void setEtiquetaNombre(JLabel etiquetaNombre) {
		this.etiquetaNombre = etiquetaNombre;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta del color.
	 * @return etiquetaColor
	 */
	public JLabel getEtiquetaPrecio() {
		return etiquetaPrecio;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta del color.
	 * @param etiquetaColor
	 */
	public void setEtiquetaPrecio(JLabel etiquetaPrecio) {
		this.etiquetaPrecio = etiquetaPrecio;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta de la funcionalidad.
	 * @return etiquetaFuncionalidad
	 */
	public JLabel getEtiquetaCantidad() {
		return etiquetaCantidad;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta de la funcionalidad.
	 * @param etiquetaFuncionalidad
	 */
	public void setEtiquetaCantidad(JLabel etiquetaCantidad) {
		this.etiquetaCantidad = etiquetaCantidad;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta de la imagen.
	 * @return etiquetaImagen
	 */
	public JLabel getEtiquetaMarca() {
		return etiquetaMarca;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta de la imagen.
	 * @param etiquetaImagen
	 */
	public void setEtiquetaMarca(JLabel etiquetaMarca) {
		this.etiquetaMarca = etiquetaMarca;
	}
	/**
	 * Este metodo se encargara de retornar la comboBox del nivel de ruido.
	 * @return datoNivelRuido
	 */
	public JComboBox<String> getDatoNivelRuido() {
		return datoNivelRuido;
	}
	/**
	 * Este metodo se encargara de modificar la comboBox del nivel de ruido.
	 * @param datoNivelRuido
	 */
	public void setDatoNivelRuido(JComboBox<String> datoNivelRuido) {
		this.datoNivelRuido = datoNivelRuido;
	}
	/**
	 * Este metodo se encargara de retornar el campo de texto de la funcion.
	 * @return datoFuncion
	 */
	public TextFieldRedondeado getDatoFuncion() {
		return datoFuncion;
	}
	/**
	 * Este metodo se encargara de modificar el campo de texto de la funcion.
	 * @param datoFuncion
	 */
	public void setDatoFuncion(TextFieldRedondeado datoFuncion) {
		this.datoFuncion = datoFuncion;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta del nivel de ruido.
	 * @return etiquetaNivelRuido
	 */
	public JLabel getEtiquetaNivelRuido() {
		return etiquetaNivelRuido;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta del nivel de ruido.
	 * @param etiquetaNivelRuido
	 */
	public void setEtiquetaNivelRuido(JLabel etiquetaNivelRuido) {
		this.etiquetaNivelRuido = etiquetaNivelRuido;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta de la funcionalidad.
	 * @return etiquetaFuncion
	 */
	public JLabel getEtiquetaFuncion() {
		return etiquetaFuncion;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta de la funcionalidad.
	 * @param etiquetaFuncion
	 */
	public void setEtiquetaFuncion(JLabel etiquetaFuncion) {
		this.etiquetaFuncion = etiquetaFuncion;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta de la imagen.
	 * @return etiquetaImagen
	 */
	public JLabel getEtiquetaImagen() {
		return etiquetaImagen;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta de la imagen.
	 * @param etiquetaImagen
	 */
	public void setEtiquetaImagen(JLabel etiquetaImagen) {
		this.etiquetaImagen = etiquetaImagen;
	}
	/**
	 * Este metodo se encargara de retornar la imagen del producto.
	 * @return imagenProducto
	 */
	public Image getImagenProducto() {
		return imagenProducto;
	}
	/**
	 * Este metodo se encargara de modificar la imagen del producto.
	 * @param imagenProducto
	 */
	public void setImagenProducto(Image imagenProducto) {
		this.imagenProducto = imagenProducto;
	}
	
}
