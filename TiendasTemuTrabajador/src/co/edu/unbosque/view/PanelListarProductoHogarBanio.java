package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * La clase PanelListarProductoHogarBanio es una clase que extiende de JPanel
 * y se encarga de mostrar la lista de productos de hogar que se utilizan en el baño.
 */
public class PanelListarProductoHogarBanio extends JPanel {
    
	/**
	 * atributo de la clase encargado de almacenar la tabla de productos.
	 */
    private JTable tablaDeProductos;
    /**
	 * atributo de la clase encargado de almacenar el deslizador de la tabla.
	 */
    private JScrollPane deslizador;
    /**
     * atributo de la clase encargado de almacenar la imagen de fondo del panel.
     */
    private Image imagenFondo;
    
    /**
	 * Constructor de la clase {@link PanelListarProductoHogarBanio}
	 * donde se inicializan los atributos de la clase.
	 */
    public PanelListarProductoHogarBanio() {
        setBackground(Color.BLACK);
        setSize(1250, 600);
        setLayout(null);
        imagenFondo = new ImageIcon(getClass().getResource("/Recursos/ojos.png")).getImage();
        
        
        tablaDeProductos = new JTable();
        tablaDeProductos.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"Nombre", "Precio", "Cantidad", "Marca", "Material", "Color", "Zona", "Imagen"}
        ) {
            /**
			 * este atributo es un serial que se genera automaticamente.
			 * con el fin de guardar la version de la clase.
			 */
			private static final long serialVersionUID = 1L;

			/**
			 * Metodo que retorna el tipo de dato de la columna.
			 * @param column es la columna de la tabla.
			 * @return retorna el tipo de dato de la columna.
			 */
			@Override
            public Class<?> getColumnClass(int column) {
                return column == 7 ? ImageIcon.class : String.class;
            }
            /**
             * Metodo que retorna si la celda es editable o no.
             * @param row es la fila de la tabla.
             * @param column es la columna de la tabla.
             */
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        
        tablaDeProductos.setPreferredScrollableViewportSize(new Dimension(800, 400));
        tablaDeProductos.setFillsViewportHeight(true);
        tablaDeProductos.setRowHeight(80);
        tablaDeProductos.setBackground(Color.DARK_GRAY);
        tablaDeProductos.setForeground(Color.white);
        
        deslizador = new JScrollPane(tablaDeProductos);
        deslizador.setBounds(550, 30, 650, 420);
        deslizador.setBackground(Color.DARK_GRAY);
        deslizador.setForeground(Color.DARK_GRAY);
        
        add(deslizador);
    }
    
    /**
	 * Metodo que se encarga de pintar la imagen de fondo del panel.
	 * @param g es el objeto de la clase Graphics.
	 */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 90, 70, 300, 300, this);
        } else {
            System.out.println("Imagen no cargada correctamente.");
        }
    }
    
    /**
     * Metodo que retorna la tabla de productos.
     * @return tablaDeProductos es la tabla de productos.
     */
    public JTable getTabla() {
        return tablaDeProductos;
    }
}
