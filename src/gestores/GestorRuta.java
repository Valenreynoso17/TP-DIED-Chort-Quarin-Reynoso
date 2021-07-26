package gestores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
	
	// Devuelve una lista con todas las lista de rutas que pueden recorrerse para ir desde origen a destino
	public List<List<Ruta>> buscarCaminos(Estacion origen, Estacion destino) {
		List<List<Ruta>> salida = new ArrayList<>();
		List<Estacion> marcados = new ArrayList<>();
		marcados.add(origen);
		buscarCaminosAux(origen, destino, marcados, new ArrayList<>(), salida);
		return salida;
	}
	
	private void buscarCaminosAux(Estacion e1, Estacion e2, List<Estacion> marcados, List<Ruta> camino, List<List<Ruta>> salida) {	
		if (e1.equals(e2)) salida.add(camino);
		else {
			List<Ruta> salientes = this.getRutasSaliente(e1);
			List<Estacion> copiaMarcados = null;
			List<Ruta> copiaCamino = null;
			
			marcados.add(e1);
			for(Ruta r : salientes) {
				if (!marcados.contains(r.getDestino())) {
					copiaMarcados = marcados.stream().collect(Collectors.toList());
					copiaCamino = camino.stream().collect(Collectors.toList());
					copiaCamino.add(r);
					buscarCaminosAux(r.getDestino(), e2, copiaMarcados, copiaCamino, salida);
				}				
			}
		}
	}
	
	public List<Ruta> getRutasSaliente(Estacion e) {
		List<Ruta> retorno = new ArrayList<>();
		
		for (Ruta r : rutas) {
			if (r.activa() && r.getOrigen().equals(e)) retorno.add(r);
		}
		
		return retorno;
	}
	
	

}
