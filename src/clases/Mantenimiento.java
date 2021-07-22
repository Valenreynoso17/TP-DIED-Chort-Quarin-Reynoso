package clases;

<<<<<<< HEAD
public class Mantenimiento {
=======
import java.time.LocalDate;

public class Mantenimiento {
	
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String observaciones;
	
	public Mantenimiento(LocalDate fI, LocalDate fF, String o) {
		this.fechaInicio = fI;
		this.fechaFin = fF;
		this.observaciones = o;
	}
>>>>>>> 4676fe1 (Atributos y generadores)

}
