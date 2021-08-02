package excepciones;

public class NombreColorEnUsoException extends Exception{

	public NombreColorEnUsoException() {
		super("El nombre o color ya se encuentran en uso.");
	}
}
