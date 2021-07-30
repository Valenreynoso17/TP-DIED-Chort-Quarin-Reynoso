package clases;
import java.awt.Color;
import java.util.Random;

import enums.EstadoRuta;

public class Ruta {

	private Estacion origen;
	private Estacion destino;
	private Integer distancia;
	private Integer duracion;
	private Integer cantMaxPasajeros;
	private EstadoRuta estado;
	private double costo;	
	
	public Ruta(Estacion estacionOrigen, Estacion estacionDestino,Integer distancia, Integer duracion, Integer cantMaxPasajeros, EstadoRuta estado, double costo) {
		this.origen = estacionOrigen;
		this.destino = estacionDestino;
		this.distancia = distancia;
		this.duracion = duracion;
		this.cantMaxPasajeros = cantMaxPasajeros;
		this.estado = estado;
		this.costo = costo;
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
	
	//No entiendo para que es esto, la ruta no tiene nombre ni color, ni esta asociado a una linea
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
