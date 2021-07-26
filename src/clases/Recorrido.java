package clases;
import java.util.ArrayList;
import java.util.List;

public class Recorrido {
	
	private Estacion origen;
	private Estacion destino;
	private List<Ruta> rutas;
	private Integer distancia, duracion;
	private Double costo;
	
	public Recorrido(Estacion origen, Estacion destino, Integer distancia, Integer duracion, Double costo) {
		this.origen = origen;
		this.destino = destino;
		this.rutas = new ArrayList<Ruta>();
		this.distancia = distancia;
		this.duracion = duracion;
		this.costo = costo;
	}
	
	public void aniadirRuta(Ruta r) {
		this.rutas.add(r);
	}

}
