package gestores;

import java.awt.Point;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import clases.Estacion;
import clases.Mantenimiento;
import clases.Ruta;
import dao.EstacionDAO;
import dao.EstacionPostgreSQLImpl;
import enums.EstadoEstacion;
import excepciones.SinEstacionesAccesiblesException;

public class GestorEstacion {
	private List<Estacion> estaciones;
	private static GestorEstacion gestor;
	private GestorRuta gestorRutas;
	private static Integer siguienteIdEstacion;
	private EstacionDAO dao;
	
	private GestorEstacion() {
		dao = new EstacionPostgreSQLImpl();
		estaciones = new ArrayList<>(dao.buscar());
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

	
	public void agregarEstacion(Estacion e) {
		estaciones.add(e);
		dao.insertar(e);
		GestorMantenimiento gestorMantenimiento = GestorMantenimiento.getInstance();
	}
	
	public Estacion crearEstacion(String n, LocalTime hA, LocalTime hC, EstadoEstacion ee) {
		siguienteIdEstacion = dao.getUltimoIdEstacion() + 1;
		System.out.println("SIGUIENTE ESTACION " +siguienteIdEstacion);
		return new Estacion(siguienteIdEstacion, n, hA, hC, ee);
	}
	
	public void eliminarEstacion(Integer id) {
		Estacion e = this.getEstacionPorId(id);
		dao.eliminar(e);
		estaciones.remove(e);
	}
	
	public List<Estacion> getEstacionesOperativasAccesibles(Estacion estacion) throws SinEstacionesAccesiblesException {
		List<Estacion> resultado = new ArrayList<>();
		HashSet<Estacion> marcados = new HashSet<>();
		List<Estacion> adyacentes = this.getAdyacentesRutasActivas(estacion);
		
		marcados.add(estacion);
		
		for (Estacion e : adyacentes) {
			if (!marcados.contains(e) && e.operativa()) {
				resultado.addAll(getEstacionesOperativasAccesiblesAux(e, marcados));
			}
		}
		
		if (resultado.isEmpty()) throw new SinEstacionesAccesiblesException();
		
		
		return resultado;
	}
	
	private List<Estacion> getEstacionesOperativasAccesiblesAux(Estacion estacion, HashSet<Estacion> marcados) {
		Stack<Estacion> pendientes = new Stack<>();
		List<Estacion> resultado = new ArrayList<>();
		
		marcados.add(estacion);
		pendientes.push(estacion);
		
		while (!pendientes.isEmpty()) {
			Estacion e = pendientes.pop();
			resultado.add(e);
			List<Estacion> adyacentes = this.getAdyacentesRutasActivas(e);
			for (Estacion e2 : adyacentes) {
				if (!marcados.contains(e2) && e2.operativa()) {
					marcados.add(e2);
					pendientes.push(e2);
				}
			}
		}
		
		
		return resultado;
		
	}
	
	public List<Estacion> getAdyacentesRutasActivas(Estacion estacion) {
		gestorRutas = GestorRuta.getInstance();
		List<Ruta> rutas = gestorRutas.getRutas();
		List<Estacion> resultado = new ArrayList<>();
		
		for (Ruta r : rutas) {
			if (r.activa() && r.getOrigen().equals(estacion) && !resultado.contains(r.getOrigen())) resultado.add(r.getDestino());
			
		}

		return resultado;
	}
	
	public List<Estacion> getAdyacentes(Estacion estacion) {
		gestorRutas = GestorRuta.getInstance();
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
	
	public Estacion getEstacionPorId(Integer idEstacion) {
		return (estaciones.stream().filter(e -> e.getId() == idEstacion).findFirst()).get();
	}
	
	public Estacion getEstacionPorNombre(String nombreEstacion) {
		return (estaciones.stream().filter(e -> e.getNombre() == nombreEstacion).findFirst()).get();
	}

	public void cancelarCambios(Map<Integer, Point> anterioresPosiciones) {
		Set<Integer> ids = anterioresPosiciones.keySet();
		for (Integer id : ids) {
			Estacion est = getEstacionPorId(id);
			est.setPosicion(anterioresPosiciones.get(id));
		}
	}
	
	public void guardarCambios(Set<Integer> modificadas) {
		List<Estacion> estacionesModificadas = modificadas.stream().map(id -> getEstacionPorId(id)).collect(Collectors.toList());
		dao.actualizarPosicion(estacionesModificadas);
	}
	
	public Estacion clonarEstacion(Estacion e) {
		Estacion nueva = new Estacion(e.getId(), e.getNombre(), e.getHorarioApertura(), e.getHorarioCierre(), (Point) e.getPosicion().clone(), e.getEstado(), e.getMantenimientos());
		return nueva;
	}
		
	public void editarEstacion(String id, String nombre, LocalTime horarioApertura, LocalTime horarioCierre, EstadoEstacion estado) {
		
		Estacion e = this.getEstacionPorId(Integer.parseInt(id));
		
		e.editarse(nombre, horarioApertura, horarioCierre, estado);
		
		dao.modificar(e);
	}

	public void cambiarEstadoAgregarMantenimientoPorId(Integer id, EstadoEstacion estadoActual, Mantenimiento mant) {
		
		Estacion e = this.getEstacionPorId(id);
		
		e.setEstado(estadoActual);
		e.aniadirMantenimiento(mant);
		dao.modificar(e);
	}

}
