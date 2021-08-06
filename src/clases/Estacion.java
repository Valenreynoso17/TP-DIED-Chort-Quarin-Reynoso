package clases;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import enums.EstadoEstacion;
import interfaces.fede.otros.GamaColor;
import interfaces.fede.panelesGrafos.PanelGrafico;

public class Estacion implements Dibujable, Cloneable, Comparable<Estacion>{
	
	private Integer id;
	private String nombre;
	private EstadoEstacion estado;
	private LocalTime horarioApertura;
	private LocalTime horarioCierre;
	private Float escala;
	
	private List<Mantenimiento> mantenimientos;
	
	private Point posicion;
	
	public Estacion(Integer i, String n, LocalTime hA, LocalTime hC, EstadoEstacion ee) {
		this.id = i;
		this.nombre = n;
		this.horarioApertura = hA;
		this.horarioCierre = hC;
		this.estado = ee;
		this.posicion = new Point();
		this.posicion.x = 100; this.posicion.y = 100;
		this.mantenimientos = new ArrayList<Mantenimiento>();
		this.escala = 1.0f;
	}
	
	public Estacion(String n, LocalTime hA, LocalTime hC, EstadoEstacion ee) {
		this.id = -1;
		this.nombre = n;
		this.horarioApertura = hA;
		this.horarioCierre = hC;
		this.estado = ee;
		this.posicion = new Point();
		this.posicion.x = 100; this.posicion.y = 100;
		this.mantenimientos = new ArrayList<Mantenimiento>();
		this.escala = 1.0f;
	}
	
	// ver si lo dejamos
	public Estacion(Integer id, String nombre, LocalTime horarioApertura, LocalTime horarioCierre, Point pos, EstadoEstacion estado, List<Mantenimiento> mantenimientos) {
		this.id = id;
		this.nombre = nombre;
		this.horarioApertura = horarioApertura;
		this.horarioCierre = horarioCierre;
		this.posicion = pos;
		this.estado = estado;
		this.mantenimientos = mantenimientos;
		this.escala = 1.0f;
	}
	
	public void editarse(String n, LocalTime hA, LocalTime hC, EstadoEstacion e) {
		this.nombre = n;
		this.horarioApertura = hA;
		this.horarioCierre = hC;
		this.estado = e;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstadoEstacion getEstado() {
		return estado;
	}

	public void setEstado(EstadoEstacion estado) {
		this.estado = estado;
	}

	public LocalTime getHorarioApertura() {
		return horarioApertura;
	}

	public void setHorarioApertura(LocalTime horarioApertura) {
		this.horarioApertura = horarioApertura;
	}

	public LocalTime getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioCierre(LocalTime horarioCierre) {
		this.horarioCierre = horarioCierre;
	}
	
	public GamaColor getGamaColor() {
		if (estado == EstadoEstacion.OPERATIVA) return GamaColor.AZUL;
		else return GamaColor.GRIS;
	}

	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}
	
	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}
	
	public Point getPosicion() {
		return posicion;
	}
	
	public Boolean operativa() {
		return estado == EstadoEstacion.OPERATIVA;
	}
	

	public void aniadirMantenimiento(Mantenimiento m) {
		this.mantenimientos.add(m);
	}
	
	public String toString() {
		return "Estacion " + nombre;
	}
	
	public Shape getHitbox() {
		Integer radioEstaciones = PanelGrafico.getRadioEstaciones();
		return new Ellipse2D.Double(posicion.getX()-radioEstaciones, posicion.getY()-radioEstaciones, 2.0*radioEstaciones, 2.0*radioEstaciones);
	}
	
	public void mover(Point puntoRelativoAgarre, Point nuevaPos) {
		if (nuevaPos.x - puntoRelativoAgarre.x - PanelGrafico.getRadioEstaciones() > 1) posicion.x = nuevaPos.x - puntoRelativoAgarre.x;
		if (nuevaPos.y - puntoRelativoAgarre.y - PanelGrafico.getRadioEstaciones() > 1) posicion.y = nuevaPos.y - puntoRelativoAgarre.y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacion other = (Estacion) obj;
		if (estado != other.estado)
			return false;
		if (horarioApertura == null) {
			if (other.horarioApertura != null)
				return false;
		} else if (!horarioApertura.equals(other.horarioApertura))
			return false;
		if (horarioCierre == null) {
			if (other.horarioCierre != null)
				return false;
		} else if (!horarioCierre.equals(other.horarioCierre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mantenimientos == null) {
			if (other.mantenimientos != null)
				return false;
		} else if (!mantenimientos.equals(other.mantenimientos))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}
	
	public Estacion clonar() throws CloneNotSupportedException {
		return new Estacion(Integer.valueOf(id), String.valueOf(nombre), LocalTime.of(horarioApertura.getHour(), horarioApertura.getMinute()), LocalTime.of(horarioCierre.getHour(), horarioCierre.getMinute()), estado);
	}
	

	@Override
	public void dibujarse(Graphics2D g2d) {
		g2d.setColor(this.getGamaColor().getRelleno());
		g2d.fillOval(posicion.x-PanelGrafico.getRadioEstaciones(), posicion.y-PanelGrafico.getRadioEstaciones(), 2*PanelGrafico.getRadioEstaciones(), 2*PanelGrafico.getRadioEstaciones());	
		g2d.setColor(this.getGamaColor().getBorde());
		g2d.setStroke(new BasicStroke(1.0f));
		g2d.drawOval(posicion.x-PanelGrafico.getRadioEstaciones(), posicion.y-PanelGrafico.getRadioEstaciones(), 2*PanelGrafico.getRadioEstaciones(), 2*PanelGrafico.getRadioEstaciones());
		if (this.operativa()) g2d.setColor(Color.BLACK);
		else g2d.setColor(new Color(90, 90, 90));
		g2d.drawString(nombre, posicion.x, posicion.y);
		
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		return super.clone();
	}

	public void dibujarse(Graphics2D g2d, GamaColor gama) {
		g2d.setColor(gama.getRelleno());
		g2d.fillOval(posicion.x-PanelGrafico.getRadioEstaciones(), posicion.y-PanelGrafico.getRadioEstaciones(), 2*PanelGrafico.getRadioEstaciones(), 2*PanelGrafico.getRadioEstaciones());	
		g2d.setColor(gama.getBorde());
		g2d.setStroke(new BasicStroke(1.0f));
		g2d.drawOval(posicion.x-PanelGrafico.getRadioEstaciones(), posicion.y-PanelGrafico.getRadioEstaciones(), 2*PanelGrafico.getRadioEstaciones(), 2*PanelGrafico.getRadioEstaciones());
		g2d.setColor(Color.BLACK);
		g2d.drawString(nombre, posicion.x, posicion.y);
		
	}
	
	@Override
	public void reescalar(Float escala) {
		this.escala = escala;
	}
	
	@Override
	public Boolean visible() {
		return this.operativa();
	}
	
	public Optional<LocalDate> getFechaInicioUltimoMantenimiento(){
		return this.mantenimientos.stream().max(Comparator.comparing(m -> m.getFechaInicio())).map(m -> m.getFechaInicio());
	}
	
	public Optional<LocalDate> getFechaUltimoMantenimientoRealizado() {
		// 1) Si devuelve un valor, significa que el ultimo mantenimiento ya terminó -> Prioridad media
		// Si devuelve null, significa una de dos: 2) Tiene un mantenimiento activo -> Mínima prioridad
		//										   3) Nunca se realizó un mantenimiento en la estación -> Maxima prioridad
		return this.mantenimientos.stream().max(Comparator.comparing(m -> m.getFechaInicio())).map(m -> m.getFechaFin());
	}

	@Override
	public int compareTo(Estacion e) {
		Optional<LocalDate> fechaThis = this.getFechaUltimoMantenimientoRealizado();
		Optional<LocalDate> fechaE = e.getFechaUltimoMantenimientoRealizado();
		
		// Comparando dos estacione cuyos ultimos mantenimientos ya terminaron
		// El orden queda determinado por las fechas (1)
		if (fechaThis.isPresent() && fechaE.isPresent()) return fechaThis.get().compareTo(fechaE.get());
		
		if (fechaThis.isPresent()) {
			// e nunca tuvo mantenimiento
			if(e.mantenimientos.isEmpty()) return 1;
			// tiene un mantenimiento activo
			return -1;
		}
		
		// else - los dos devolvieron null
		if (this.mantenimientos.isEmpty()) {
			if(e.mantenimientos.isEmpty()) return 1; // Los dos tienen la misma prioridad (Con 0 se rompía)
			return -1; // e tiene un mantenimiento activo y this nunca tuvo mantenimiento
		}
		
		if (e.mantenimientos.isEmpty()) {
			// This tiene un mantenimiento activo y e nunca tuvo
			return 1;
		}
		
		// Los dos tienen un mantenimiento activo (Con 0 se rompía)
		return 1;
		
		
	}
}
