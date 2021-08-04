package excepciones;

public class DatosRutaInvalidosException extends Exception{
	
	public DatosRutaInvalidosException(String detalles) {
		super("Se han ingresado uno o más datos inválidos. \n"
			+ "Por favor, revise y vuelva a intentarlo. \n\n" + detalles);
	}
}
