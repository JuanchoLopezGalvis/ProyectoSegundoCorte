package co.edu.unbosque.controller;

import java.awt.Image;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import co.edu.unbosque.util.exception.EmptyImageFieldException;
import co.edu.unbosque.util.exception.EmptyNumberFieldException;
import co.edu.unbosque.util.exception.EmptyStringFieldException;
import co.edu.unbosque.util.exception.InvalidPasswordException;
import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.util.exception.NumberInStringException;
//+import co.edu.unbosque.util.exception.NumberOutOfBoundException;

public class ExceptionChecker {

	public static void checkNegativeNumber(int number) throws NegativeNumberException {
		if (number < 0) {
			throw new NegativeNumberException();
		}

	}

	public static void checkNumberInString(String text) throws NumberInStringException {
		if (text.matches(".*\\d.*")) {
			throw new NumberInStringException();
		}
	}
	public static void checkNumberField(Number numero1, Number numero2) throws EmptyNumberFieldException{
		if (numero1 == null || numero2 == null) {
			JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad válida");
			return;
		}
		}
		
	public static void checkStringField(String word, String errorMessage) throws EmptyStringFieldException {
	    if (word == null || word.trim().isEmpty()) { // Trim para evitar espacios vacíos
	        throw new EmptyStringFieldException(errorMessage);
	    }
	}
	
	public static void checkImageField(Image image, String mensaje) throws EmptyImageFieldException {
	    if (image == null) {
	        throw new EmptyImageFieldException(mensaje);
	    }
	
				}
			public static void checkPasswordField(String password, String errorMessage) throws InvalidPasswordException {
			    String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
			    Pattern pattern = Pattern.compile(PASSWORD_REGEX);
			    
			    if (!pattern.matcher(password).matches()) {
			        throw new InvalidPasswordException(errorMessage);
			    }
			
				    
	}
