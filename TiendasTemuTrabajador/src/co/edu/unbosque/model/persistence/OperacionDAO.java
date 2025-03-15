package co.edu.unbosque.model.persistence;

/**
 * La interfaz {@link OperacionDAO} es la encargada de manejar las operaciones de la base de datos.
 * 
 * @param <C> es el tipo de dato que se va a manejar.
 */
public interface OperacionDAO <C> {
	
	public void guardar(C c);
	public C buscar();
	public void eliminar();
	public void actualizar(C c);
	public void listar();

}
