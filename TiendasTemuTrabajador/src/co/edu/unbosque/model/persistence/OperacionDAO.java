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
	
	/**
	 * Guarda un objeto en el archivo txt y serializado y en la lista.
	 * 
	 * @param c es el objeto que se va a guardar.
	 */
	public void guardar(C c);
	public C buscar();
	/**
	 * Elimina un objeto de la lista y del archivo txt y serializado.
	 * 
	 * @param comboBox es el comboBox que contiene los objetos.
	 */
	public void eliminar(JComboBox<String> comboBox);
	/**
	 * Actualiza un objeto en la lista y en el archivo txt y serializado.
	 * 
	 * @param c es el objeto que se va a actualizar.
	 */
	public void actualizar(C c);
	/**
	 * Lista los objetos.
	 * 
	 * @param tabla es la tabla donde se van a listar los objetos.
	 * @param comboBox es el comboBox que contiene los objetos.
	 * @param comboBox2 es el comboBox que contiene los objetos.
	 */
	public void listar(JTable tabla, JComboBox<String> comboBox, JComboBox<String> comboBox2);

}
