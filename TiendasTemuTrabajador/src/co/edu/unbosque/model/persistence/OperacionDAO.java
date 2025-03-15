package co.edu.unbosque.model.persistence;

public interface OperacionDAO <C> {
	
	public void guardar(C c);
	public C buscar();
	public void eliminar();
	public void actualizar(C c);
	public void listar();

}
