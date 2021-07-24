package gestores;

import java.util.ArrayList;
import java.util.List;
import clases.Estacion;
import clases.Ruta;
import enums.EstadoRuta;

public class GestorRuta {
	private List<Ruta> rutas;
	private static GestorRuta gestor;
	
	private GestorRuta() {
		rutas = new ArrayList<>();
	}
	
	public static GestorRuta getInstance() {
		if (gestor == null) {
			gestor = new GestorRuta();
		}
		
		return gestor;
	}
	
	public List<Ruta> getRutas() {
		return rutas;
	}
	
	public void agregarRuta(Estacion o, Estacion des,Integer d, Integer du, Integer mP, EstadoRuta e, double c) {
		rutas.add(new Ruta(o, des, d, du, mP, e, c));
	}
}
