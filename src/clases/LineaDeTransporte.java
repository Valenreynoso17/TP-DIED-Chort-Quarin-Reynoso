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
	
}
