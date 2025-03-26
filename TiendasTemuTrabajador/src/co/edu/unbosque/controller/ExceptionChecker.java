package co.edu.unbosque.controller;

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

//	public static void NumberOutOfBoundsException(int num) throws NumberOutOfBoundException {
//		if (num >= 20 || num == 0) {
//			throw new NumberOutOfBoundException();
//		}
//		}

	
//	public static void InputMismatchException () throws InputMismatchException{
//		throw new InputMismatchException();
//	}

}
