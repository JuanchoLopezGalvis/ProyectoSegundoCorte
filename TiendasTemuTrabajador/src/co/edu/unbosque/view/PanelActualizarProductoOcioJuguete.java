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

public class PanelActualizarProductoOcioJuguete extends JPanel{

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
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara el nivel de calidad del producto.
	 */
	private JComboBox<String> datoNivelCalidad;
	/**
	 * Este atributo es el encargado de guardar el campo de texto donde se ingresara la edad recomendada del producto.
	 */
	private JSpinner datoEdadRecomendada;
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
	 * Este atributo es el encargado de guardar la etiqueta que indica el nivel de calidad del producto.
	 */
	private JLabel etiquetaNivelCalidad;
	/**
	 * Este atributo es el encargado de guardar la etiqueta que indica la edad recomendada del producto.
	 */
	private JLabel etiquetaEdadRecomendada;
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
	public PanelActualizarProductoOcioJuguete() {
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
		String[] niveles = {"Bajo", "Medio", "Alto"};
		datoNivelCalidad = new JComboBox<String>(niveles);
		datoEdadRecomendada = new JSpinner();
		etiquetaProductosExistentes = new JLabel("Seleccione el producto:");
		etiquetaNombre = new JLabel("Nombre:");
		etiquetaPrecio = new JLabel("Precio:");
		etiquetaCantidad = new JLabel("Cantidad:");
		etiquetaMarca = new JLabel("Marca:");
		etiquetaNivelCalidad = new JLabel("Nivel de calidad:");
		etiquetaEdadRecomendada = new JLabel("Edad recomendada:");
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
		etiquetaNivelCalidad.setBounds(750, 280, 100, 30);
		datoNivelCalidad.setBounds(950, 280, 200, 30);
		etiquetaEdadRecomendada.setBounds(750, 330, 115, 30);
		datoEdadRecomendada.setBounds(950, 330, 200, 30);
		etiquetaImagen.setBounds(750, 430, 100, 30);
		seleccionImagen.setBounds(950, 430, 200, 30);
		botonActualizar.setBounds(840, 500, 200, 30);
		etiquetaProductosExistentes.setForeground(Color.white);
		productosExistentes.setBackground(Color.DARK_GRAY);
		productosExistentes.setForeground(Color.white);
		etiquetaNombre.setForeground(Color.white);
		etiquetaPrecio.setForeground(Color.white);
		etiquetaCantidad.setForeground(Color.white);
		etiquetaMarca.setForeground(Color.white);
		etiquetaNivelCalidad.setForeground(Color.white);
		etiquetaEdadRecomendada.setForeground(Color.white);
		etiquetaImagen.setForeground(Color.white);
		datoNivelCalidad.setBackground(Color.DARK_GRAY);
		datoNivelCalidad.setForeground(Color.white);
		datoPrecio.setModel(new SpinnerNumberModel(0, 0,1000000, 1000));
		((JSpinner.DefaultEditor) datoPrecio.getEditor()).getTextField().setBackground(Color.DARK_GRAY);
		((JSpinner.DefaultEditor) datoPrecio.getEditor()).getTextField().setForeground(Color.WHITE);
		JFormattedTextField txt = ((JSpinner.DefaultEditor) datoPrecio.getEditor()).getTextField();
		NumberFormatter formatter = (NumberFormatter) txt.getFormatter();
		formatter.setAllowsInvalid(false);  // No permite caracteres no numéricos
		formatter.setMinimum(0); 
		datoCantidad.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		((JSpinner.DefaultEditor) datoCantidad.getEditor()).getTextField().setBackground(Color.DARK_GRAY);
		((JSpinner.DefaultEditor) datoCantidad.getEditor()).getTextField().setForeground(Color.WHITE);
		JFormattedTextField txt2 = ((JSpinner.DefaultEditor) datoCantidad.getEditor()).getTextField();
		NumberFormatter formatter2 = (NumberFormatter) txt2.getFormatter();
		formatter2.setAllowsInvalid(false);  // No permite caracteres no numéricos
		formatter2.setMinimum(0); 
		datoEdadRecomendada.setModel(new SpinnerNumberModel(0, 0, 150, 1));
		((JSpinner.DefaultEditor) datoEdadRecomendada.getEditor()).getTextField().setBackground(Color.DARK_GRAY);
		((JSpinner.DefaultEditor) datoEdadRecomendada.getEditor()).getTextField().setForeground(Color.WHITE);
		JFormattedTextField txt3 = ((JSpinner.DefaultEditor) datoEdadRecomendada.getEditor()).getTextField();
		NumberFormatter formatter3 = (NumberFormatter) txt3.getFormatter();
		formatter3.setAllowsInvalid(false);  // No permite caracteres no numéricos
		formatter3.setMinimum(0); 
		
		add(productosExistentes);
		add(etiquetaProductosExistentes);
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
		add(etiquetaNivelCalidad);
		add(datoNivelCalidad);
		add(etiquetaEdadRecomendada);
		add(datoEdadRecomendada);
		seleccionImagen.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        JFileChooser fileChooser = new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png");
		        fileChooser.setFileFilter(filter);
		        fileChooser.setAcceptAllFileFilterUsed(false);
		        int result = fileChooser.showOpenDialog(PanelActualizarProductoOcioJuguete.this);
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
	 * Este metodo se encarga de retornar la combo box del nivel de calidad.
	 * @return datoNivelCalidad
	 */
	public JComboBox<String> getDatoNivelCalidad() {
		return datoNivelCalidad;
	}
	/**
	 * Este metodo se encarga de modificar la combo box del nivel de calidad.
	 * @param datoNivelCalidad
	 */
	public void setDatoNivelCalidad(JComboBox<String> datoNivelCalidad) {
		this.datoNivelCalidad = datoNivelCalidad;
	}
	/**
	 * Este metodo se encargarga de retornar el campo numerico de la edad recomendada.
	 * @return datoEdadRecomendada
	 */
	public JSpinner getDatoEdadRecomendada() {
		return datoEdadRecomendada;
	}
	/**
	 * Este metodo se encargara de modificar el campo numerico de la edad recomendada.
	 * @param datoEdadRecomendada
	 */
	public void setDatoEdadRecomendada(JSpinner datoEdadRecomendada) {
		this.datoEdadRecomendada = datoEdadRecomendada;
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
	 * Este metodo se encargara de retornar la etiqueta del nivel de calidad.
	 * @return etiquetaNivelCalidad
	 */
	public JLabel getEtiquetaNivelCalidad() {
		return etiquetaNivelCalidad;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta del nivel de calidad.
	 * @param etiquetaNivelCalidad
	 */
	public void setEtiquetaNivelCalidad(JLabel etiquetaNivelCalidad) {
		this.etiquetaNivelCalidad = etiquetaNivelCalidad;
	}
	/**
	 * Este metodo se encargara de retornar la etiqueta de la edad recomendada.
	 * @return etiquetaEdadRecomendada
	 */
	public JLabel getEtiquetaEdadRecomendada() {
		return etiquetaEdadRecomendada;
	}
	/**
	 * Este metodo se encargara de modificar la etiqueta de la edad recomendada.
	 * @param etiquetaEdadRecomendada
	 */
	public void setEtiquetaEdadRecomendada(JLabel etiquetaEdadRecomendada) {
		this.etiquetaEdadRecomendada = etiquetaEdadRecomendada;
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
	/**
	 * Este metodo se encargara de retornar la imagen del producto.
	 * @return imagenFondo
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
