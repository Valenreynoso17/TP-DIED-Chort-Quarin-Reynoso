package clases;
import java.awt.Color;

import enums.EstadoRuta;

public class Ruta {

	private Integer distancia;
	private Integer duracion;
	private Integer maxPasajeros;
	private EstadoRuta estado;
	private double costo;
	
	private Estacion origen;
	private Estacion destino;
	
	public Ruta(Estacion o, Estacion des,Integer d, Integer du, Integer mP, EstadoRuta e, double c) {
		this.origen = o;
		this.destino = des;
		this.distancia = d;
		this.duracion = du;
		this.maxPasajeros = mP;
		this.estado = e;
		this.costo = c;
	}
	
	public Boolean activa() {
		return estado == EstadoRuta.ACTIVA;
	}
	
	public Estacion getOrigen() {
		return origen;
	}
	
	public Estacion getDestino() {
		return destino;
	}
	
	// Capaz lo termine sacando - FEDE
	public Color getColorLinea() {
		return Color.RED;
	}
	
}
