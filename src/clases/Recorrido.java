package clases;
import java.util.ArrayList;
import java.util.List;

public class Recorrido {
	
	private Estacion origen;
	private Estacion destino;
	private List<Ruta> rutas;
	
	public Recorrido(Estacion o, Estacion d) {
		this.origen = o;
		this.destino = d;
		this.rutas = new ArrayList<Ruta>();
	}
	
	public void aniadirRuta(Ruta r) {
		this.rutas.add(r);
	}

}
