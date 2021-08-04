package gestores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import clases.Estacion;
import clases.Ruta;
import clases.Trayecto;
import dao.RutaDAO;
import dao.RutaSQLImp;
import enums.EstadoRuta;
import interfaces.valen.otros.ElementoListaTrayecto;
import interfaces.valen.paneles.ElementoListaEdicionLineaDeTransporte;

public class GestorRuta {
	private List<Ruta> rutas;
	private static GestorRuta gestor;
	private RutaDAO rutaDAO;
	private GestorTrayecto gestorTrayecto;
	private static Integer siguienteIdRuta; 
	
	
	private GestorRuta() {
		rutaDAO = new RutaSQLImp();
		rutas = new ArrayList<>(rutaDAO.buscar());
		Thread t1 = new Thread(() -> {
			siguienteIdRuta = rutaDAO.getSiguienteIdRuta() + 1;
		});
		t1.run();
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
	
	public void agregarRuta(Integer id, Integer idTrayecto, Estacion o, Estacion des, Integer d, Integer du, Integer mP, EstadoRuta e, double c) {
		rutas.add(new Ruta(id, idTrayecto, o, des, d, du, mP, e, c));
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
				if (!marcados.contains(r.getDestino()) && r.getDestino().operativa()) {
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
	
	public List<Ruta> buscarRutasAsociadasATrayectoPorID(Integer idTrayecto){
		return rutas.stream().filter(r -> r.getIdTrayecto() == idTrayecto).collect(Collectors.toList());
	}
	
	public void asociarATrayectos() {
		gestorTrayecto = GestorTrayecto.getInstance();
		for(Ruta unaRuta : this.rutas) {
			Trayecto trayectoAux = (gestorTrayecto.getListaTrayectos().stream().filter(t -> t.getId() == unaRuta.getIdTrayecto()).findFirst()).get();
			unaRuta.asociarTrayecto(trayectoAux);
		}
	}
	
	public List<Ruta> agregarRutas(Integer idTrayecto, List<ElementoListaTrayecto> listaTrayecto, Trayecto tray) {
		
		List<Ruta> listaResultado = new ArrayList<Ruta>();
		
		GestorEstacion gestorEstacion = GestorEstacion.getInstance();
		
		for(ElementoListaTrayecto unElemento : listaTrayecto) {
			
			Ruta rutaAux;
			
			if(unElemento.getEstado() == "Activa") {
				rutaAux = new Ruta(siguienteIdRuta, idTrayecto,
									gestorEstacion.getEstacionPorNombre(unElemento.getEstacionOrigen()),
									gestorEstacion.getEstacionPorNombre(unElemento.getEstacionDestino()),
									unElemento.getDistancia(), unElemento.getDuracion(), unElemento.getCantMaxPasajeros(),
									EstadoRuta.ACTIVA, unElemento.getCosto());
			} else {
				rutaAux = new Ruta(siguienteIdRuta, idTrayecto,
									gestorEstacion.getEstacionPorNombre(unElemento.getEstacionOrigen()),
									gestorEstacion.getEstacionPorNombre(unElemento.getEstacionDestino()),
									unElemento.getDistancia(), unElemento.getDuracion(), unElemento.getCantMaxPasajeros(),
									EstadoRuta.NO_ACTIVA, unElemento.getCosto());
			}
			
			this.rutas.add(rutaAux);
			listaResultado.add(rutaAux);
			siguienteIdRuta++;
			
			rutaAux.asociarTrayecto(tray);
		}
		
		rutaDAO.insertar(listaResultado);
		return listaResultado;
	}
	
	public void eliminarRutas(List<Ruta> rutasAEliminar) {
		this.rutas.removeAll(rutasAEliminar);
	}
	
	public void editarRutas(List<ElementoListaEdicionLineaDeTransporte> listaElementos) {
		Ruta rutaAEditar;
		List<Ruta> listaRutasAEditar = new ArrayList<Ruta>();
		
		for(ElementoListaEdicionLineaDeTransporte unElemento : listaElementos) {
			
			rutaAEditar = unElemento.getRuta();
			rutaAEditar.setDistancia(Integer.parseInt(unElemento.getDistancia()));
			rutaAEditar.setDuracion(Integer.parseInt(unElemento.getDuracion()));
			rutaAEditar.setCantMaxPasajeros(Integer.parseInt(unElemento.getCantMaxPasajeros()));
			rutaAEditar.setEstado(unElemento.getEstado());
			listaRutasAEditar.add(rutaAEditar);
			
		}
		
		rutaDAO.modificarRutas(listaRutasAEditar);
		
	}

}
