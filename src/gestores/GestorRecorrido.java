package gestores;

import java.util.ArrayList;
import java.util.List;

import clases.Estacion;
import clases.Recorrido;
import clases.Ruta;

public class GestorRecorrido {
	private static GestorRecorrido gestor;
	private GestorRuta gestorRutas;
	
	private GestorRecorrido() {
		gestorRutas = GestorRuta.getInstance();
	}
	
	public static GestorRecorrido getInstance() {
		if (gestor == null) {
			gestor = new GestorRecorrido();
		}
		
		return gestor;
	}
	
	public List<Recorrido> getRecorridos(Estacion origen, Estacion destino) {
		return new ArrayList<>();
	}
	

}
