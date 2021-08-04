package clases;
import java.awt.Color;

import enums.EstadoLineaDeTransporte;

public class LineaDeTransporte {

	private Integer id;
	private String nombre;
	private CustomColor color;
	private EstadoLineaDeTransporte estado;
	private Trayecto trayecto;
	
	public LineaDeTransporte(Integer id, String nombre, CustomColor color, EstadoLineaDeTransporte estadoRuta, Trayecto trayecto) {
		this.id = id;
		this.nombre = nombre;
		this.color = color;
		this.estado = estadoRuta;
		this.trayecto = trayecto;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Enum<EstadoLineaDeTransporte> getEstado(){
		return estado;
	}
	
	public CustomColor getColor() {
		return color;
	}
	
	public Boolean estaActiva() {
		return estado == EstadoLineaDeTransporte.ACTIVA;
	}
	
	public Integer getIdColor() {
		return this.getColor().getId();
	}
	
	public Trayecto getTrayecto() {
		return trayecto;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setColor(CustomColor color) {
		this.color = color;
	}
	
	public void setEstado(String estado) {
		if (estado == "Activa") this.estado = EstadoLineaDeTransporte.ACTIVA;
		else this.estado = EstadoLineaDeTransporte.NO_ACTIVA;
	}
	
	public void asociarTrayecto(Trayecto unTrayecto) {
		this.trayecto = unTrayecto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof LineaDeTransporte))
			return false;
		LineaDeTransporte other = (LineaDeTransporte) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
