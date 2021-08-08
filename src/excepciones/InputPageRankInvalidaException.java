package excepciones;

public class InputPageRankInvalidaException extends Exception {
	
	public InputPageRankInvalidaException() {
		super("El dato ingresado no es un número o es un valor que no se encuentra en\n el rango [0.00, 1.00]. Por favor, ingrese una entrada válida.");
	}
}
