package excepciones;

public class InputInvalidaException extends Exception {
	
	public InputInvalidaException() {
		super("Se han ingresado uno o más datos inválidos. Por favor,\n"+
			  "revise y vuelva a intentarlo. \nRecuerde que: \n\n");
	}

}
