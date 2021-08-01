package clases;
import java.util.ArrayList;
import java.util.List;

public class Trayecto {
	
	private Integer id;
	private LineaDeTransporte linea;
	private List<Ruta> rutas;
	private List<Estacion> estaciones;
	
	public Trayecto(Integer id, LineaDeTransporte linea, List<Ruta> rutas) {
		this.id = id;
		this.linea = linea;
		this.rutas = rutas;
		this.estaciones = new ArrayList<Estacion>();
	}
	
	public void aniadirRuta(Ruta ruta) {
		this.rutas.add(ruta);
	}
	
	public void aniadirEstacion(Estacion estacion) {
		this.estaciones.add(estacion);
	}
	
	public Integer getId() {
		return id;
	}

}
