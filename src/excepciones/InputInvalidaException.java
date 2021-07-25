package excepciones;

public class InputInvalidaException extends Exception {
	
	public InputInvalidaException() {
		super("Se han ingresado uno o más datos inválidos.\n"+
			  "Por favor, revise y vuelva a intentar.");
	}

}
