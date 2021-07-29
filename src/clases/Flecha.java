package clases;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
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
	
	
	public Flecha(Point posOrigen, Point posDestino, Double anguloFlecha, Color color) {
		this.posOrigen = posOrigen;
		this.posDestino = posDestino;
		this.anguloFlecha = anguloFlecha;
		this.color = color;
		this.rutas = new ArrayList<>();
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
		
	}
	
}
