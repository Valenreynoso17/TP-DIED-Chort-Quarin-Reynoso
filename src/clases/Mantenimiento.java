package clases;
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

}
