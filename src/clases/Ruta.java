package clases;
import java.awt.Color;
import java.util.Random;

import enums.EstadoRuta;
import excepciones.LineaNoAsociadaException;
import excepciones.TrayectoNoAsociadoException;
import gestores.GestorTrayecto;

public class Ruta {

	private Integer id;
	private Integer idTrayecto;
	private Trayecto trayecto;
	private Estacion origen;
	private Estacion destino;
	private Integer distancia;
	private Integer duracion;
	private Integer cantMaxPasajeros;
	private EstadoRuta estado;
	private double costo;	
	
	public Ruta(Integer id, Integer idTrayecto, Estacion estacionOrigen, Estacion estacionDestino,Integer distancia, Integer duracion, Integer cantMaxPasajeros, EstadoRuta estado, double costo) {
		this.id = id;
		this.idTrayecto = idTrayecto;
		this.trayecto = null;
		this.origen = estacionOrigen;
		this.destino = estacionDestino;
		this.distancia = distancia;
		this.duracion = duracion;
		this.cantMaxPasajeros = cantMaxPasajeros;
		this.estado = estado;
		this.costo = costo;
	}
	
	public Integer getID() {
		return this.id;
	}
	
	public Boolean activa() {
		return estado == EstadoRuta.ACTIVA;
	}
	
	public Estacion getOrigen() {
		return origen;
	}
	
	public Estacion getDestino() {
		return destino;
	}
	
	public String getStringOrigen() {
		return origen.getNombre();
	}
	
	public String getStringDestino() {
		return destino.getNombre();
	}
	
	public Double getCosto() {
		return this.costo;
	}
	
	public Integer getDistancia() {
		return this.distancia;
	}
	
	public Integer getDuracion() {
		return this.duracion;
	}
	
	public Integer getIdTrayecto() {
		return this.idTrayecto;
	}
	
	public String getStringEstado() {
		return this.estado.toString();
	}
	
	public EstadoRuta getEstado() {
		return this.estado;
	}
	
	public Integer getIdEstacionOrigen() {
		return this.getOrigen().getId();
	}
	
	public Integer getIdEstacionDestino() {
		return this.getDestino().getId();
	}
	
	public void asociarTrayecto(Trayecto unTrayecto) {
		this.trayecto = unTrayecto;
	}

	public Integer getCantMaxPasajeros() {
		return this.cantMaxPasajeros;
	}
	
	public Color getColorLinea() throws TrayectoNoAsociadoException {
		if (trayecto == null) throw new TrayectoNoAsociadoException("Esta ruta no tiene su entidad trayecto asociada");
		
		Color colorLinea;
		try {
			colorLinea = trayecto.getColorLinea();
			return colorLinea;
		}
		catch (LineaNoAsociadaException exc1) {
			GestorTrayecto gestor = GestorTrayecto.getInstance();
			gestor.asociarALineas();
			
			try {
				colorLinea = trayecto.getColorLinea();
				return colorLinea;
			}
			catch (LineaNoAsociadaException exc2) {
				exc2.printStackTrace();
			}
		}
		
		return null;
	}

	// Para probar cositas. Hay que cambiarlo
	public String getNombreLinea() throws TrayectoNoAsociadoException {
		if (trayecto == null) throw new TrayectoNoAsociadoException("Esta ruta no tiene su entidad trayecto asociada");
		
		String nombreLinea;
		try {
			nombreLinea = trayecto.getNombreLinea();
			return nombreLinea;
		}
		catch (LineaNoAsociadaException exc1) {
			GestorTrayecto gestor = GestorTrayecto.getInstance();
			gestor.asociarALineas();
			
			try {
				nombreLinea = trayecto.getNombreLinea();
				return nombreLinea;
			}
			catch (LineaNoAsociadaException exc2) {
				exc2.printStackTrace();
			}
		}
		
		return null;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public void setCantMaxPasajeros(Integer cantMaxPasajeros) {
		this.cantMaxPasajeros = cantMaxPasajeros;
	}

	public void setEstado(String estado) {
		if(estado == "Activa") this.estado = EstadoRuta.ACTIVA;
		else this.estado = EstadoRuta.NO_ACTIVA;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	

	
}
