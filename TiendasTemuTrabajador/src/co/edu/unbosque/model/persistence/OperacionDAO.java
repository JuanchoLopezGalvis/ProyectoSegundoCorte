
package co.edu.unbosque.model.persistence;

/**
 * La interfaz {@link OperacionDAO} es la encargada de manejar las operaciones de la base de datos.
 * 
 * @param <C> es el tipo de dato que se va a manejar.
 */
public interface OperacionDAO <C> {
	
	public void guardar(C newData);
	
	public int eliminar(int index);
	public int actualizar(int index, C newData);
	public String mostrarTodo ();
	public int contarCantidad();

	public C buscar();
}
