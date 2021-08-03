package excepciones;

public class NombreEstacionRepetidoException extends Exception {
	
	public NombreEstacionRepetidoException() {
		super("El nombre ingresado es igual al de otra estación. Por favor,\n ingrese otro nombre que no esté repetido.");
	}

}
