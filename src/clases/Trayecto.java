package clases;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import excepciones.LineaNoAsociadaException;

public class Trayecto {
	
	private Integer id;
	private Integer idLineaAsociada;
	private LineaDeTransporte linea;
	private List<Ruta> rutas;
	private List<Estacion> estaciones;
	
	public Trayecto(Integer id, Integer lineaAsociada, List<Ruta> rutas) {
		this.id = id;
		this.idLineaAsociada = lineaAsociada;
		this.linea = null;
		this.rutas = rutas;
		this.estaciones = new ArrayList<Estacion>();
	}
	
	public void aniadirRuta(Ruta ruta) {
		this.rutas.add(ruta);
	}
	
	public void aniadirEstacion(Estacion estacion) {
		this.estaciones.add(estacion);
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getIdLineaAsociada() {
		return idLineaAsociada;
	}
	
	public void asociarLinea(LineaDeTransporte unaLinea) {
		this.linea = unaLinea;
	}
	
	public void asociarRutas(List<Ruta> unaListaRutas) {
		this.rutas = unaListaRutas;
	}
	
	public Color getColorLinea() throws LineaNoAsociadaException {
		if (linea == null) throw new LineaNoAsociadaException("El trayecto no tiene su entidad linea asociada");
		return linea.getColor();
	}
	
	public String getNombreLinea() throws LineaNoAsociadaException {
		if (linea == null) throw new LineaNoAsociadaException("El trayecto no tiene su entidad linea asociada");
		return linea.getNombre();
	}
}
