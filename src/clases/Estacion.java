package clases;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import enums.EstadoEstacion;

public class Estacion {
	
	private String id;
	private String nombre;
	private EstadoEstacion estado;
	private LocalTime horarioApertura;
	private LocalTime horarioCierre;
	
	private List<Mantenimiento> mantenimientos;
	
	//private Point posicion; //VER
	
	public Estacion(String i, String n, LocalTime hA, LocalTime hC) {
		this.id = i;
		this.nombre = n;
		this.horarioApertura = hA;
		this.horarioCierre = hC;
		this.estado = EstadoEstacion.OPERATIVA;
		this.mantenimientos = new ArrayList<Mantenimiento>();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstadoEstacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoEstacion estado) {
		this.estado = estado;
	}

	public LocalTime getHorarioApertura() {
		return horarioApertura;
	}

	public void setHorarioApertura(LocalTime horarioApertura) {
		this.horarioApertura = horarioApertura;
	}

	public LocalTime getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioCierre(LocalTime horarioCierre) {
		this.horarioCierre = horarioCierre;
	}

	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public void aniadirMantenimiento(Mantenimiento m) {
		this.mantenimientos.add(m);
	}

}
