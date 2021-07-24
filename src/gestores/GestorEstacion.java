package gestores;

import java.awt.Point;
import java.time.LocalTime;
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
	
	public void agregarEstacion(String i, String n, LocalTime hA, LocalTime hC, Point pos) {
		estaciones.add(new Estacion(i, n, hA, hC, pos));
	}
}
