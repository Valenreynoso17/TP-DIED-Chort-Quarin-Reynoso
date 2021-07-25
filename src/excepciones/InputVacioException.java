package excepciones;

public class InputVacioException extends Exception {
	
	public InputVacioException() {
		super("Algunos datos no han sido ingresados.");
	}

}
