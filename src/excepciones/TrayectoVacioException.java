package excepciones;

public class TrayectoVacioException extends Exception{

	public TrayectoVacioException() {
		super("El trayecto debe contener al menos una ruta.");
	}
}
