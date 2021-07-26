package clases;
import java.awt.Color;
import java.awt.Point;
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
	
	private Point posicion; //VER 
	
	public Estacion(String i, String n, LocalTime hA, LocalTime hC) {
		this.id = i;
		this.nombre = n;
		this.horarioApertura = hA;
		this.horarioCierre = hC;
		this.estado = EstadoEstacion.OPERATIVA;
		this.mantenimientos = new ArrayList<Mantenimiento>();
	}
	
	// ver si lo dejamos
	public Estacion(String i, String n, LocalTime hA, LocalTime hC, Point pos) {
		this(i, n, hA, hC);
		this.posicion = pos;
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
	
	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}
	
	public Point getPosicion() {
		return posicion;
	}
	
	public Boolean operativa() {
		return estado == EstadoEstacion.OPERATIVA;
	}
	

	public void aniadirMantenimiento(Mantenimiento m) {
		this.mantenimientos.add(m);
	}
	
	public String toString() {
		return "Estacion " + nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((horarioApertura == null) ? 0 : horarioApertura.hashCode());
		result = prime * result + ((horarioCierre == null) ? 0 : horarioCierre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mantenimientos == null) ? 0 : mantenimientos.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacion other = (Estacion) obj;
		if (estado != other.estado)
			return false;
		if (horarioApertura == null) {
			if (other.horarioApertura != null)
				return false;
		} else if (!horarioApertura.equals(other.horarioApertura))
			return false;
		if (horarioCierre == null) {
			if (other.horarioCierre != null)
				return false;
		} else if (!horarioCierre.equals(other.horarioCierre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mantenimientos == null) {
			if (other.mantenimientos != null)
				return false;
		} else if (!mantenimientos.equals(other.mantenimientos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}
	
	

}
