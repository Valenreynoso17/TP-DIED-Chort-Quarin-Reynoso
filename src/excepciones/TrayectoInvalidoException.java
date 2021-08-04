package excepciones;

public class TrayectoInvalidoException extends Exception{
	public TrayectoInvalidoException(String error) {
		super("El trayecto seleccionado es inválido. \n" + 
			  " - " + error);
	}
}
