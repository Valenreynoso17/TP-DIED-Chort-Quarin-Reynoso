package clases;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import clases.Ruta;

public class Flecha implements Dibujable{
	private Point posOrigen, posDestino;
	private List<Ruta> rutas;
	private Color color;
	private Double anguloFlecha;
	private static Integer largoFlecha = 10;
	private static Double anchoFlecha = 4.0;
	private static Double anchoHitbox = 10.0;
	//private Polygon hitbox;
	private Float escala;
	
	
	public Flecha(Point posOrigen, Point posDestino, Double anguloFlecha, Color color) {
		this.posOrigen = posOrigen;
		this.posDestino = posDestino;
		this.anguloFlecha = anguloFlecha;
		this.color = color;
		this.rutas = new ArrayList<>();
		//this.hitbox = this.calcularHitbox();
		this.escala = 1.0f;
		
	}
	
	public Polygon getHitbox() {
		Integer despX = (int) Math.round((anchoHitbox/2)*Math.cos(anguloFlecha-(Math.PI/2)));
		Integer despY = (int) Math.round((anchoHitbox/2)*Math.sin(anguloFlecha-(Math.PI/2)));
		
		int[] x = {Math.round(escala*(posOrigen.x - despX)), Math.round(escala*(posOrigen.x + despX)), Math.round(escala*(posDestino.x + despX)), Math.round(escala*(posDestino.x - despX))}; 
		int[] y = {Math.round(escala*(posOrigen.y - despY)), Math.round(escala*(posOrigen.y + despY)), Math.round(escala*(posDestino.y + despY)), Math.round(escala*(posDestino.y - despY))};
		
		return new Polygon(x, y, 4);
	}
	
	public Boolean correspondeAEstaFlecha(Ruta r) {
		return this.getEstacionOrigen().equals(r.getOrigen()) && this.getEstacionDestino().equals(r.getDestino());
	}
	
	public void agregarRuta(Ruta r) {
		rutas.add(r);
	}
	
	public Double getAnguloFlecha() {
		return anguloFlecha;
	}
	
	public Estacion getEstacionOrigen() {
		return rutas.get(0).getOrigen();
	}
	
	public Estacion getEstacionDestino() {
		return rutas.get(0).getDestino();
	}

	public List<Ruta> getRutas() {
		return this.rutas;
	}
	
	@Override
	public void dibujarse(Graphics2D g2d) {
		Point aux1, aux2;
		Double apertura = Math.atan(anchoFlecha/largoFlecha);
		Double hipotenusa = Math.sqrt(largoFlecha*largoFlecha + anchoFlecha*anchoFlecha);
		aux1 = new Point((int)Math.round(posDestino.x - Math.cos(anguloFlecha+apertura)*hipotenusa), (int)Math.round(posDestino.y - Math.sin(anguloFlecha+apertura)*hipotenusa));
		aux2 = new Point((int)Math.round(posDestino.x - Math.cos(anguloFlecha-apertura)*hipotenusa), (int)Math.round(posDestino.y - Math.sin(anguloFlecha-apertura)*hipotenusa));
		int[] x = {posDestino.x, aux1.x, aux2.x};
		int[] y = {posDestino.y, aux1.y, aux2.y};
		
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(1));
		g2d.drawLine(posOrigen.x, posOrigen.y, posDestino.x, posDestino.y);
		
		g2d.fillPolygon(x, y, 3);
		//g2d.drawPolygon(getHitbox());
	}
	
	@Override
	public void reescalar(Float escala) {
		this.escala = escala;
		//hitbox = calcularHitbox();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((posDestino == null) ? 0 : posDestino.hashCode());
		result = prime * result + ((posOrigen == null) ? 0 : posOrigen.hashCode());
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
		Flecha other = (Flecha) obj;
		if (posDestino == null) {
			if (other.posDestino != null)
				return false;
		} else if (!posDestino.equals(other.posDestino))
			return false;
		if (posOrigen == null) {
			if (other.posOrigen != null)
				return false;
		} else if (!posOrigen.equals(other.posOrigen))
			return false;
		return true;
	}
	
}
