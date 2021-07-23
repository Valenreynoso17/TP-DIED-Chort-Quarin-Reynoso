package clases;
import java.util.ArrayList;
import java.util.List;

public class Trayecto {
	
	private LineaDeTransporte linea;
	private List<Ruta> rutas;
	private List<Estacion> estaciones;
	
	public Trayecto(LineaDeTransporte l) {
		this.linea = l;
		this.rutas = new ArrayList<Ruta>();
		this.estaciones = new ArrayList<Estacion>();
	}
	
	public void aniadirRuta(Ruta r) {
		this.rutas.add(r);
	}
	
	public void aniadirEstacion(Estacion e) {
		this.estaciones.add(e);
	}

}
