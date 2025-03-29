package co.edu.unbosque.model.persistence;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 * La interfaz {@link OperacionDAO} es la encargada de manejar las operaciones de la base de datos.
 * 
 * @param <C> es el tipo de dato que se va a manejar.
 */
public interface OperacionDAO <C> {
	
	public void guardar(C c);
	public C buscar();
	public void eliminar(JComboBox<String> comboBox);
	public void actualizar(C c);
	public void listar(JTable tabla, JComboBox<String> comboBox, JComboBox<String> comboBox2);

}
