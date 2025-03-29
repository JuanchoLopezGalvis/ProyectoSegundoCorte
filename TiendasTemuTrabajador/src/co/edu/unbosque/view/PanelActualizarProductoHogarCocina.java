package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.NumberFormatter;

public class PanelActualizarProductoHogarCocina extends JPanel{
	
	/**
	 * Este atributo es el encargado de guardar la imagen de fondo del panel.
	 */
	private Image imagenFondo;
	/**
	 * Este atributo es el encargado de guardar el boton que permitira seleccionar la imagen.
	 */
	private BotonRedondeado seleccionImagen;
	/**
	 * Este atributo es el encargado de guardar el boton que permitira actualizar el producto.
	 */
	private BotonRedondeado botonActualizar;
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
	private TextFieldRedondeado datoFuncionalidad;
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
	private JLabel etiquetaFuncionalidad;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica la imagen del producto.
	 */
	private JLabel etiquetaImagen;
	/**
	 * Este atributo es el encargado de guardar el combo box que permitira seleccionar los productos existentes.
	 */
	private JComboBox<String > productosExistentes;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica los productos existentes.
	 */
	private JLabel etiquetaProductosExistentes;

	/**
	 * Este metodo se encargara de inicializar los componentes de la clase
	 * {@link PanelAgregarProductoHogarCocina}
	 */
	public PanelActualizarProductoHogarCocina() {
		setSize(1250, 650);
		setLayout(null);
		setBackground(Color.black);
		productosExistentes = new JComboBox<String>();
		imagenFondo = new ImageIcon(getClass().getResource("/Recursos/actu.png")).getImage();
		seleccionImagen = new BotonRedondeado("Seleccionar", 20, Color.DARK_GRAY, Color.decode("#f67704"), Color.white);
		botonActualizar = new BotonRedondeado("Actualizar", 20, Color.DARK_GRAY, Color.decode("#f67704"), Color.white);
		datoNombre = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoPrecio = new JSpinner();
		datoCantidad = new JSpinner();	
		datoMarca = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoMaterial = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoColor = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
		datoFuncionalidad = new TextFieldRedondeado(Color.white, Color.DARK_GRAY, 20, Color.decode("#f67704"), 1.5f);
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
		etiquetaProductosExistentes = new JLabel("Seleccione el producto:");
		etiquetaNombre = new JLabel("Nombre:");
		etiquetaPrecio = new JLabel("Precio:");
		etiquetaCantidad = new JLabel("Cantidad:");
		etiquetaMarca = new JLabel("Marca:");
		etiquetaMaterial = new JLabel("Material:");
		etiquetaColor = new JLabel("Color:");
		etiquetaFuncionalidad = new JLabel("Funcionalidad:");
		etiquetaImagen = new JLabel("Imagen:");
		etiquetaProductosExistentes.setBounds(750, 30, 200, 30);
		productosExistentes.setBounds(950, 30, 200, 30);
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
		etiquetaFuncionalidad.setBounds(750, 380, 100, 30);
		datoFuncionalidad.setBounds(950, 380, 200, 30);
		etiquetaImagen.setBounds(750, 430, 100, 30);
		seleccionImagen.setBounds(950, 430, 200, 30);
		botonActualizar.setBounds(840, 500, 200, 30);
		etiquetaProductosExistentes.setForeground(Color.white);
		productosExistentes.setForeground(Color.white);
		productosExistentes.setBackground(Color.DARK_GRAY);
		etiquetaNombre.setForeground(Color.white);
		etiquetaPrecio.setForeground(Color.white);
		etiquetaCantidad.setForeground(Color.white);
		etiquetaMarca.setForeground(Color.white);
		etiquetaMaterial.setForeground(Color.white);
		etiquetaColor.setForeground(Color.white);
		etiquetaFuncionalidad.setForeground(Color.white);
		etiquetaImagen.setForeground(Color.white);
		
		add(etiquetaProductosExistentes);
		add(productosExistentes);
		add(etiquetaImagen);
		add(botonActualizar);
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
		add(etiquetaFuncionalidad);
		add(datoFuncionalidad);
		seleccionImagen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(PanelActualizarProductoHogarCocina.this);
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
	 * Este metodo se encargara de retornar el boton de actualizar.
	 * @return botonActualizar
	 */
	public BotonRedondeado getBotonActualizar() {
		return botonActualizar;
	}
	/**
	 * Este metodo se encargara de modificar el boton de actualizar.
	 * @param botonActualizar
	 */
	public void setBotonActualizar(BotonRedondeado botonActualizar) {
		this.botonActualizar = botonActualizar;
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
	 * Este metodo se encargara de modificar el campo numerico del precio.
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
	 * Este metodo se encargara de retornar la etiqueta del nombre.
	 * @return etiquetaNombre
	 */
	public TextFieldRedondeado getDatoMaterial() {
		return datoMaterial;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta del nombre.
	 * @param etiquetaNombre
	 */
	public void setDatoMaterial(TextFieldRedondeado datoMaterial) {
		this.datoMaterial = datoMaterial;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta del precio.
	 * @return etiquetaPrecio
	 */
	public TextFieldRedondeado getDatoColor() {
		return datoColor;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta del precio.
	 * @param etiquetaPrecio
	 */
	public void setDatoColor(TextFieldRedondeado datoColor) {
		this.datoColor = datoColor;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta de la cantidad.
	 * @return etiquetaCantidad
	 */
	public TextFieldRedondeado getDatoFuncionalidad() {
		return datoFuncionalidad;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta de la cantidad.
	 * @param etiquetaCantidad
	 */
	public void setDatoFuncionalidad(TextFieldRedondeado datoFuncionalidad) {
		this.datoFuncionalidad = datoFuncionalidad;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta de la marca.
	 * @return etiquetaMarca
	 */
	public Image getImagenFondo() {
		return imagenFondo;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta de la marca.
	 * @param etiquetaMarca
	 */
	public void setImagenFondo(Image imagenFondo) {
		this.imagenFondo = imagenFondo;
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
	 * Este metodo se encargara de retornar la etiqueta del material.
	 * @return etiquetaMaterial
	 */
	public JLabel getEtiquetaMaterial() {
		return etiquetaMaterial;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta del material.
	 * @param etiquetaMaterial
	 */
	public void setEtiquetaMaterial(JLabel etiquetaMaterial) {
		this.etiquetaMaterial = etiquetaMaterial;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta del color.
	 * @return etiquetaColor
	 */
	public JLabel getEtiquetaFuncionalidad() {
		return etiquetaFuncionalidad;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta del color.
	 * @param etiquetaColor
	 */
	public void setEtiquetaFuncionalidad(JLabel etiquetaFuncionalidad) {
		this.etiquetaFuncionalidad = etiquetaFuncionalidad;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta del color.
	 * @return etiquetaColor
	 */
	public JLabel getEtiquetaColor() {
		return etiquetaColor;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta del color.
	 * @param etiquetaColor
	 */
	public void setEtiquetaColor(JLabel etiquetaColor) {
		this.etiquetaColor = etiquetaColor;
	}
	/**
	 * Este metodo se encargara de retornar la comboBox de los productos existentes.
	 * @return productosExistentes
	 */
	public JComboBox<String> getProductosExistentes() {
		return productosExistentes;
	}
	/**
	 * Este metodo se encargara de modificar la comboBox de los productos existentes.
	 * @param productosExistentes
	 */
	public void setProductosExistentes(JComboBox<String> productosExistentes) {
		this.productosExistentes = productosExistentes;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta de los productos existentes.
	 * @return etiquetaProductosExistentes
	 */
	public JLabel getEtiquetaProductosExistentes() {
		return etiquetaProductosExistentes;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta de los productos existentes.
	 * @param etiquetaProductosExistentes
	 */
	public void setEtiquetaProductosExistentes(JLabel etiquetaProductosExistentes) {
		this.etiquetaProductosExistentes = etiquetaProductosExistentes;
	}
    
}
