package excepciones;

public class RutaYaAgregadaException extends Exception{

	public RutaYaAgregadaException() {
		super("La ruta que quiere agregar ya se encuentra en el trayecto.");
	}
}
