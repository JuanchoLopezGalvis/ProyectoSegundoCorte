package co.edu.unbosque.controller;

import java.awt.Image;
import java.util.regex.Pattern;

import co.edu.unbosque.util.exception.EmptyImageFieldException;
import co.edu.unbosque.util.exception.EmptyNumberFieldException;
import co.edu.unbosque.util.exception.EmptyStringFieldException;
import co.edu.unbosque.util.exception.InvalidPasswordException;
import co.edu.unbosque.util.exception.NegativeNumberException;
import co.edu.unbosque.util.exception.NumberInStringException;
import co.edu.unbosque.util.exception.WhitespaceFieldException;

public class ExceptionChecker {

    // Verificar si un número es negativo
    public static void checkNegativeNumber(int number, String errorMesage) throws NegativeNumberException {
        if (number <= 0 ) {
            throw new NegativeNumberException(errorMesage);
        }
    }

    // Verificar si un String contiene números
    public static void checkNumberInString(String text, String errorMessage) throws NumberInStringException {
        if (text.matches(".*\\d.*")) {
            throw new NumberInStringException(errorMessage);
        }
    }

    // Verificar si un campo numérico está vacío
    public static void checkNumberField(Number... values) throws EmptyNumberFieldException {
        for (Number value : values) {
            if (value == null) {
                throw new EmptyNumberFieldException("Error.");
            }
        }
        
    }


    // Verificar si un campo de texto está vacío
    public static void checkStringField(String word, String errorMessage) throws EmptyStringFieldException {
        if (word == null || word.trim().isEmpty()) { 
            throw new EmptyStringFieldException(errorMessage);
        }
    }

    // Verificar si la imagen está vacía
    public static void checkImageField(Image image, String mensaje) throws EmptyImageFieldException {
        if (image == null) {
            throw new EmptyImageFieldException(mensaje);
        }
    }

    // Verificar si la contraseña cumple con los requisitos
    public static void checkPasswordField(String password, String errorMessage) throws InvalidPasswordException {
        String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);

        if (!pattern.matcher(password).matches()) {
            throw new InvalidPasswordException(errorMessage);
        }
    }
 
        public static void checkWhitespace(String value, String errorMessage) throws WhitespaceFieldException {
            if (value.contains(" ")) {
                throw new WhitespaceFieldException(errorMessage);
            }
        }


}
