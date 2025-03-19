<<<<<<< HEAD
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * La clase {@link FileManager} es la encargada de manejar los archivos de texto y los archivos serializados.
 * 
 */

public class FileManager {


	/**
	 * El atributo archivo es el archivo que se va a manipular.
	 */	
	private static File archivo;
	/**
	 * El atributo lectorArchivoTexto es el lector de archivos de texto.
	 */
	private static Scanner lectorArchivoTexto;
	/**
	 * El atributo escritorArchivoTexto es el escritor de archivos de texto.
	 */
	private static PrintWriter escritorArchivoTexto;
	/**
	 * El atributo RUTA_CARPETA es la ruta de la carpeta donde se guardan los archivos.
	 */
	private static final String RUTA_CARPETA = "src/archivos";
	/**
	 * El atributo fos es el archivo de salida.
	 */
	private static FileOutputStream fos;
	/**
	 * El atributo oos es el objeto de salida.
	 */
	private static ObjectOutputStream oos;
	/**
	 * El atributo fis es el archivo de entrada.
	 */
	private static FileInputStream fis;
	/**
	 * El atributo ois es el objeto de entrada.
	 */
	private static ObjectInputStream ois;


	/**
	 * El metodo crearCarpeta crea la carpeta donde se guardan los archivos.
	 */
	public static void crearCarpeta() {
		// la tarea del objeto file es apuntar a
		// una direccion
		archivo = new File(RUTA_CARPETA);
		if (!archivo.exists() || !archivo.isDirectory()) {
			archivo.mkdir();
		} else {
			System.out.println("La carpeta ya existe");
		}

	}

	/**
	 * El metodo escribirEnArchivoDeTexto escribe en un archivo de texto.
	 * @param nombreArchivo es el nombre del archivo.
	 * @param contenido es el contenido del archivo.
	 */
	public static void escribirEnArchivoDeTexto(String nombreArchivo, String contenido) {

		try {

			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			escritorArchivoTexto = new PrintWriter(archivo);
			escritorArchivoTexto.println(contenido);
			// una vez se hallan echo las operaciones en un archivo hay que cerrarlo
			escritorArchivoTexto.close();

		} catch (IOException e) {
			System.out.println("Error al crear el archivo (escritura)");
			e.printStackTrace();

		}

	}
	
	/**
	 * El metodo leerArchivoDeTexto lee un archivo de texto.
	 * @param nombreArchivo es el nombre del archivo.
	 * @return contenido es el contenido del archivo.
	 */

	public static String leerArchivoDeTexto(String nombreArchivo) {

		try {

			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			lectorArchivoTexto = new Scanner(archivo);

			String contenido = "";
			while (lectorArchivoTexto.hasNext()) {
				contenido += lectorArchivoTexto.nextLine() + "\n";
			}
			lectorArchivoTexto.close();
			return contenido;
		} catch (IOException e) {
			System.out.println("Error al crear el archivo (lectura)");
			e.printStackTrace();

		}
		return null;


	}
	/**
	 * El metodo escribirArchivoSerializado escribe un archivo serializado.
	 * @param nombreArchivo es el nombre del archivo.
	 * @param contenido es el contenido del archivo.
	 */
	//los seializados no escriben String escriben objetos completos
	public static void escribirArchivoSerializado(String nombreArchivo, Object contenido ){
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			oos.close();
			fos.close();
		}catch (IOException e) {
			System.out.println("Error en la escritura del archivo serializado");
			e.printStackTrace();
		}
	}
	

	/**
	 * El metodo leerArchivoSerializado lee un archivo serializado.
	 * @param nombreArchivo es el nombre del archivo.
	 * @return contenido es el contenido del archivo.
	 */
	public static Object leerArchivoSerializado(String nombreArchivo) {
		Object contenido = null;
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			contenido = ois.readObject();
			fis.close();
			ois.close();
		}catch (IOException e) {
			System.out.println("Error al leer el archivo serializado");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error al obtener el contenido del archivo");
			e.printStackTrace();
		}
		return contenido;

	}



}
=======
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * La clase {@link FileManager} es la encargada de manejar los archivos de texto y los archivos serializados.
 * 
 */

public class FileManager {


	/**
	 * El atributo archivo es el archivo que se va a manipular.
	 */	
	private static File archivo;
	/**
	 * El atributo lectorArchivoTexto es el lector de archivos de texto.
	 */
	private static Scanner lectorArchivoTexto;
	/**
	 * El atributo escritorArchivoTexto es el escritor de archivos de texto.
	 */
	private static PrintWriter escritorArchivoTexto;
	/**
	 * El atributo RUTA_CARPETA es la ruta de la carpeta donde se guardan los archivos.
	 */
	private static final String RUTA_CARPETA = "src/archivos";
	/**
	 * El atributo fos es el archivo de salida.
	 */
	private static FileOutputStream fos;
	/**
	 * El atributo oos es el objeto de salida.
	 */
	private static ObjectOutputStream oos;
	/**
	 * El atributo fis es el archivo de entrada.
	 */
	private static FileInputStream fis;
	/**
	 * El atributo ois es el objeto de entrada.
	 */
	private static ObjectInputStream ois;


	/**
	 * El metodo crearCarpeta crea la carpeta donde se guardan los archivos.
	 */
	public static void crearCarpeta() {
		// la tarea del objeto file es apuntar a
		// una direccion
		archivo = new File(RUTA_CARPETA);
		if (!archivo.exists() || !archivo.isDirectory()) {
			archivo.mkdir();
		} else {
			System.out.println("La carpeta ya existe");
		}

	}

	/**
	 * El metodo escribirEnArchivoDeTexto escribe en un archivo de texto.
	 * @param nombreArchivo es el nombre del archivo.
	 * @param contenido es el contenido del archivo.
	 */
	public static void escribirEnArchivoDeTexto(String nombreArchivo, String contenido) {

		try {

			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			escritorArchivoTexto = new PrintWriter(archivo);
			escritorArchivoTexto.println(contenido);
			// una vez se hallan echo las operaciones en un archivo hay que cerrarlo
			escritorArchivoTexto.close();

		} catch (IOException e) {
			System.out.println("Error al crear el archivo (escritura)");
			e.printStackTrace();

		}

	}
	
	/**
	 * El metodo leerArchivoDeTexto lee un archivo de texto.
	 * @param nombreArchivo es el nombre del archivo.
	 * @return contenido es el contenido del archivo.
	 */

	public static String leerArchivoDeTexto(String nombreArchivo) {

		try {

			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			lectorArchivoTexto = new Scanner(archivo);

			String contenido = "";
			while (lectorArchivoTexto.hasNext()) {
				contenido += lectorArchivoTexto.nextLine() + "\n";
			}
			lectorArchivoTexto.close();
			return contenido;
		} catch (IOException e) {
			System.out.println("Error al crear el archivo (lectura)");
			e.printStackTrace();

		}
		return null;


	}
	/**
	 * El metodo escribirArchivoSerializado escribe un archivo serializado.
	 * @param nombreArchivo es el nombre del archivo.
	 * @param contenido es el contenido del archivo.
	 */
	//los seializados no escriben String escriben objetos completos
	public static void escribirArchivoSerializado(String nombreArchivo, Object contenido ){
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			oos.close();
			fos.close();
		}catch (IOException e) {
			System.out.println("Error en la escritura del archivo serializado");
			e.printStackTrace();
		}
	}
	

	/**
	 * El metodo leerArchivoSerializado lee un archivo serializado.
	 * @param nombreArchivo es el nombre del archivo.
	 * @return contenido es el contenido del archivo.
	 */
	public static Object leerArchivoSerializado(String nombreArchivo) {
		Object contenido = null;
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			contenido = ois.readObject();
			fis.close();
			ois.close();
		}catch (IOException e) {
			System.out.println("Error al leer el archivo serializado");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Error al obtener el contenido del archivo");
			e.printStackTrace();
		}
		return contenido;

	}



}
>>>>>>> branch 'master' of git@github.com:JuanchoLopezGalvis/ProyectoSegundoCorte.git
