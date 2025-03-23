package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PanelListarProductoHogarBanio extends JPanel {
    
    private JTable tablaDeProductos;
    private JScrollPane deslizador;
    private Image imagenFondo;
    
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
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Class<?> getColumnClass(int column) {
                return column == 7 ? ImageIcon.class : String.class;
            }
            
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
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            g.drawImage(imagenFondo, 90, 70, 300, 300, this);
        } else {
            System.out.println("Imagen no cargada correctamente.");
        }
    }
    
    public JTable getTabla() {
        return tablaDeProductos;
    }
}
