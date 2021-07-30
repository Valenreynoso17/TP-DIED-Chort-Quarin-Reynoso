package clases;
import java.util.ArrayList;
import java.util.List;

public class Trayecto {
	
	private LineaDeTransporte linea;
	private List<Ruta> rutas;
	private List<Estacion> estaciones;
	
	public Trayecto(LineaDeTransporte linea) {
		this.linea = linea;
		this.rutas = new ArrayList<Ruta>();
		this.estaciones = new ArrayList<Estacion>();
	}
	
	public void aniadirRuta(Ruta ruta) {
		this.rutas.add(ruta);
	}
	
	public void aniadirEstacion(Estacion estacion) {
		this.estaciones.add(estacion);
	}

}
