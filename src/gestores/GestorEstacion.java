package gestores;

import java.awt.Point;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import clases.Estacion;
import clases.Ruta;
import excepciones.SinEstacionesAccesiblesException;

public class GestorEstacion {
	private List<Estacion> estaciones;
	private static GestorEstacion gestor;
	private GestorRuta gestorRutas;
	
	private GestorEstacion() {
		estaciones = new ArrayList<>();
		gestorRutas = GestorRuta.getInstance();
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
	
	public List<Estacion> getEstacionesOperativas() {
		return this.estaciones.stream().filter(e -> e.operativa()).collect(Collectors.toList());
	}
	
	public void agregarEstacion(String i, String n, LocalTime hA, LocalTime hC, Point pos) {
		estaciones.add(new Estacion(i, n, hA, hC, pos));
	}
	
	public List<Estacion> getEstacionesAccesibles(Estacion estacion) {
		List<Estacion> resultado = new ArrayList<>();
		HashSet<Estacion> marcados = new HashSet<>();
		List<Estacion> adyacentes = this.getAdyacentes(estacion);
		
		marcados.add(estacion);
		
		for (Estacion e : adyacentes) {
			if (!marcados.contains(e)) {
				resultado.addAll(getEstacionesAccesiblesAux(e, marcados));
			}
		}
		
		return resultado;
	}
	
	public List<Estacion> getEstacionesOperativasAccesibles(Estacion estacion) throws SinEstacionesAccesiblesException {
		List<Estacion> accesibles =	this.getEstacionesAccesibles(estacion)
										.stream()
										.filter(e -> e.operativa())
										.collect(Collectors.toList());
		if (accesibles.isEmpty()) throw new SinEstacionesAccesiblesException();
		return accesibles;
	}
	
	private List<Estacion> getEstacionesAccesiblesAux(Estacion estacion, HashSet<Estacion> marcados) {
		Stack<Estacion> pendientes = new Stack<>();
		List<Estacion> resultado = new ArrayList<>();
		
		marcados.add(estacion);
		pendientes.push(estacion);
		
		while (!pendientes.isEmpty()) {
			Estacion e = pendientes.pop();
			resultado.add(e);
			List<Estacion> adyacentes = this.getAdyacentes(e);
			for (Estacion e2 : adyacentes) {
				if (!marcados.contains(e2)) {
					marcados.add(e2);
					pendientes.push(e2);
				}
			}
		}
		
		
		return resultado;
		
	}
	
	public List<Estacion> getAdyacentes(Estacion estacion) {
		List<Ruta> rutas = gestorRutas.getRutas();
		List<Estacion> resultado = new ArrayList<>();
		
		for (Ruta r : rutas) {
			if (r.getOrigen().equals(estacion) && !resultado.contains(r.getOrigen())) resultado.add(r.getDestino());
			
		}
		return resultado;
	}
	
	public List<String> getStringEstaciones(){
		return this.getEstaciones().stream().map(e -> e.getNombre()).collect(Collectors.toList());
	}

}
