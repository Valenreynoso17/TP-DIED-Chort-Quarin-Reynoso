package interfaces.valen.otros;

public class ElementoListaTrayecto {
	String estacionOrigen;
	String estacionDestino;
	Integer distancia;
	Integer duracion;
	Integer cantMaxPasajeros;
	Integer costo;
	String estado;
	
	public ElementoListaTrayecto(String estacionOrigen, String estacionDestino, Integer distancia, Integer duracion,
			Integer cantMaxPasajeros, Integer costo, String estado) {
		this.estacionOrigen = estacionOrigen;
		this.estacionDestino = estacionDestino;
		this.distancia = distancia;
		this.duracion = duracion;
		this.cantMaxPasajeros = cantMaxPasajeros;
		this.costo = costo;
		this.estado = estado;
	}
	
	public String getEstaciones() {
		return estacionOrigen + " - " + estacionDestino;
	}
}
