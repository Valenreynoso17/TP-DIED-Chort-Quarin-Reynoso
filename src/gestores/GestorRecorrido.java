package gestores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	// Este metodo devuelve una lista con todos los recorridos posibles desde origen hasta destino
	public List<Recorrido> getRecorridos(Estacion origen, Estacion destino) {
		List<List<Ruta>> caminos = gestorRutas.buscarCaminos(origen, destino);
		List<Recorrido> recorridos = new ArrayList<>();
		
		for (List<Ruta> camino : caminos) {
			Integer distancia = 0;
			Integer duracion = 0;
			Double costo = 0.0;
			Recorrido recorrido;
			
			for (Ruta r : camino) {
				distancia += r.getDistancia();
				duracion += r.getDuracion();
				costo += r.getCosto();
			}
			
			recorrido = new Recorrido(origen, destino, distancia, duracion, costo);
			recorrido.agregarRutas(camino);
			recorridos.add(recorrido);
		}
		
		return recorridos;
	}
	
	public Recorrido crearRecorrido(Estacion origen, Estacion destino, Integer distancia, Integer duracion, Double costo) {
		return new Recorrido(origen, destino, distancia, duracion, costo);
	}
	
	public Set<Estacion> getEstacionesRecorridas(List<Recorrido> recorridos) {
		Set<Estacion> estaciones = new HashSet<>();
		List<Estacion> estacionesAux = null;
		
		for (Recorrido r : recorridos) {
			estacionesAux = r.getEstacionesRecorridas();
			for (Estacion e : estacionesAux) {
				estaciones.add(e);
			}
		}
		
		return estaciones;
	}
	
	
	public Recorrido recorridoSinRutas() {
		return new Recorrido(null, null, 0, 0, 0.0);
	}
	
	
	public Integer calcularFlujoMaximo(List<Recorrido> recorridos) {
		Map<Ruta, Integer> capacidadRestante = new HashMap<Ruta, Integer>();
		Integer flujoMaximo = 0;
		
		for (Recorrido rec : recorridos) {
			for (Ruta r : rec.getRutas()) {
				if (!capacidadRestante.containsKey(r)) capacidadRestante.put(r, r.getCantMaxPasajeros());
			}
		}
		
		for (Recorrido rec : recorridos) {
			Integer capacidadDeRutaLimitante = Integer.MAX_VALUE;
			
			for (Ruta r : rec.getRutas()) {
				if (capacidadRestante.get(r) < capacidadDeRutaLimitante) capacidadDeRutaLimitante = capacidadRestante.get(r); 
			}
			
			flujoMaximo += capacidadDeRutaLimitante;
			final Integer aux = capacidadDeRutaLimitante;
			
			for (Ruta r : rec.getRutas()) {
				capacidadRestante.compute(r, (k, v) -> v -= aux);
			}
			
		}
		
		return flujoMaximo;
	}

}
