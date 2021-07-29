package excepciones;

public class SinEstacionesAccesiblesException extends Exception {
	public SinEstacionesAccesiblesException() {
		super("No puede alcanzar ninguna otra estacion desde la estacion elegida.\n"
				+ "Por favor, elija otra.");
	}
}
