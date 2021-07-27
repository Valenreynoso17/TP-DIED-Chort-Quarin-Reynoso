package clases;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	
	public Double getCosto() {
		return this.costo;
	}
	
	public Integer getDistancia() {
		return this.distancia;
	}
	
	public Integer getDuracion() {
		return this.duracion;
	}
	
	// Hay que cambiarlo
	public String getNombreLinea() {
		return "Linea Colectivo 16";
	}
	
	// Capaz lo termine sacando - FEDE
	public Color getColorLinea() {
		return Color.RED;
	}
	
	// Para probar cositas. Hay que cambiarlo
	public String linea() {
		return "Linea: " + new Random().nextInt();
	}
	

	
}
