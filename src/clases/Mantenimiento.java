package clases;
import java.time.LocalDate;

public class Mantenimiento {
	
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String observaciones;
	
	private Integer id;
	
	public Mantenimiento(Integer i, LocalDate fI, String o) {
		this.id = i;
		this.fechaInicio = fI;
		this.observaciones = o;
	}
	
	public void finalizarMantenimiento(LocalDate fF) {
		this.fechaFin = fF;
	}

}
