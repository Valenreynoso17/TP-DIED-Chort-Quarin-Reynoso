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
	
	
	
	public Estacion getOrigen() {
		return this.origen;
	}
	
	public Estacion getDestino() {
		return this.destino;
	}
	
	public void agregarRuta(Ruta r) {
		this.rutas.add(r);
	}
	
	public void agregarRutas(List<Ruta> lista) {
		this.rutas.addAll(lista);
	}
	
	public List<Estacion> getEstacionesRecorridas() {
		List<Estacion> estaciones = new ArrayList<>();
		estaciones.add(origen);
		
		for (Ruta r : rutas) {
			estaciones.add(r.getDestino());
		}
		
		return estaciones;
	}
	
	public List<Ruta> getRutas() {
		return this.rutas;
	}
	
	public Integer getDistancia() {
		return this.distancia;
	}
	
	public Integer getDuracion() {
		return this.duracion;
	}
	
	public Double getCosto() {
		return this.costo;
	}

	@Override
	public String toString() {
		String retorno = origen.getNombre();
		for (Ruta r : rutas) {
			retorno += " - " + r.getDestino().getNombre();
		}
		return retorno;
	}
}
