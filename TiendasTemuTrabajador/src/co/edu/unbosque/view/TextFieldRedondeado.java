package co.edu.unbosque.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * La clase {@link TextFieldRedondeado} se encarga de crear un campo de texto con los bordes redondeados.
 */

public class TextFieldRedondeado extends JTextField{

	/**
	 * Este atributo es el encargado de guardar el radio de los bordes del boton.
	 */
    private int cornerRadius;
    /**
     * Este atributo es el encargado de guardar el color del borde del boton.
     */
    private Color borderColor;
    /**
	 * Este atributo es el encargado de guardar el color del fondo del boton.
	 */
    private Color background;
    /**
     * Este atributo es el encargado de guardar el color del texto del boton.
     */
    private Color foreground;
    /**
	 * Este atributo es el encargado de guardar el grosor del borde del boton.
	 */
    private float borderWidth;
    
    /**
	 * Este es el constructor de la clase {@link TextFieldRedondeado} que recibe
	 * @param foregraund
	 * @param backgraund
	 * @param cornerRadius
	 * @param borderColor
	 * @param borderWidth
	 */

    public TextFieldRedondeado(Color foregraund, Color backgraund ,int cornerRadius, Color borderColor, float borderWidth) {
        this.cornerRadius = cornerRadius;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        this.background = backgraund;
        this.foreground = foregraund;
        setOpaque(false);
        setForeground(foreground);
        setHorizontalAlignment(SwingConstants.RIGHT);
    }
    /**
	 * Este metodo se encarga de pintar el boton con los bordes redondeados.
	 */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(background);
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));
        
        g2.dispose();
        
        super.paintComponent(g);
    }
    
    /**
     * Este metodo se encarga de pintar el borde del boton con los bordes redondeados.
     */
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderWidth));
        g2.draw(new RoundRectangle2D.Float(borderWidth / 2, borderWidth / 2, 
        	    getWidth() - borderWidth, getHeight() - borderWidth, cornerRadius, cornerRadius));
        g2.dispose();
    }
}
