package gestores;

import java.util.ArrayList;
import java.util.List;
import clases.Estacion;

public class GestorEstacion {
	private List<Estacion> estaciones;
	private static GestorEstacion gestor;
	
	private GestorEstacion() {
		estaciones = new ArrayList<>();
	}
	
	public static GestorEstacion getInstance() {
		if (gestor == null) {
			gestor = new GestorEstacion();
		}
		
		return gestor;
	}
	
	public List<Estacion> getEstaciones() {
		return estaciones;
	}
}
