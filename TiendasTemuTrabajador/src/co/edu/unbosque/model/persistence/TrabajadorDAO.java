package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;

import co.edu.unbosque.model.Trabajador;

public class TrabajadorDAO implements OperacionDAO<Trabajador> {

	private ArrayList<Trabajador> listaDeTrabajadores;
	private final String TEXT_FILE_NAME = "tabajador.csv";
	private final String SERIAL_FILE_NAME = "tabajador.dat";
	
	public TrabajadorDAO() {
		listaDeTrabajadores = new ArrayList<Trabajador>();
	}
	@Override
	public void guardar(Trabajador nuevoTrabajador) {
		listaDeTrabajadores.add(nuevoTrabajador);
	}
	
	public boolean verificarExistencia(String usuario, String contraseña){
		boolean existe = false;
		for (Trabajador trabajador : listaDeTrabajadores) {
			if(trabajador.getUsuario().equals(usuario) && trabajador.getContraseña().equals(contraseña)) {
				existe = true;
			}
		}
		return existe;
	}

	@Override
	public Trabajador buscar() {
		return null;
	}

	@Override
	public void eliminar(JComboBox<String> comboBox) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Trabajador c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listar(JTable tabla, JComboBox<String> comboBox) {
		// TODO Auto-generated method stub
		
	}
	
	public void escribirArchivo() {
	    StringBuilder contenido = new StringBuilder();
	    for (Trabajador trabajador : listaDeTrabajadores) {

	    }
	    FileManager.escribirEnArchivoDeTexto(TEXT_FILE_NAME, contenido.toString());
	}

	public void escribirArchivoSerializado() {

		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaDeTrabajadores);

	}
	
	public void leerArchivoSerializado() {
		
		listaDeTrabajadores = (ArrayList<Trabajador>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		
		if (listaDeTrabajadores == null ) {
			listaDeTrabajadores = new ArrayList<>();			
		}
		
		
	}
	public ArrayList<Trabajador> getListaDeTrabajadores() {
		return listaDeTrabajadores;
	}
	public void setListaDeTrabajadores(ArrayList<Trabajador> listaDeTrabajadores) {
		this.listaDeTrabajadores = listaDeTrabajadores;
	}

}
