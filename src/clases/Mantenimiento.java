package clases;
import java.time.LocalDate;

public class Mantenimiento {
	
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String observaciones;
	private Integer id;
	
	public Integer getIdEstacion() {
		return idEstacion;
	}

	public void setIdEstacion(Integer idEstacion) {
		this.idEstacion = idEstacion;
	}

	private Integer idEstacion;
	
	public Mantenimiento(Integer i, LocalDate fI, String o, Integer iE) {
		this.id = i;
		this.fechaInicio = fI;
		this.observaciones = o;
		this.idEstacion = iE;
	}
	
	public Mantenimiento(Integer i, LocalDate fI, LocalDate fF, String o, Integer iE) {
		this.id = i;
		this.fechaInicio = fI;
		this.observaciones = o;
		this.fechaFin = fF;
		this.idEstacion = iE;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void finalizarMantenimiento(LocalDate fF) {
		this.fechaFin = fF;
	}

}
