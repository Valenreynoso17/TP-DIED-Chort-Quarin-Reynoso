package interfaces.ventaBoleto;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.List;

import javax.swing.JPanel;

import clases.Estacion;
import clases.Ruta;
import gestores.GestorEstacion;
import gestores.GestorRuta;

public class PanelGrafico extends JPanel {
	private Integer anchoVentana, altoVentana;
	private GestorEstacion gestorEstaciones;
	private GestorRuta gestorRutas;
	private Integer radioEstaciones, largoFlecha;
	private Double anchoFlecha;
	
	
	
	public PanelGrafico() {
		setBackground(Color.WHITE);
		anchoVentana = 800;
		altoVentana = 600;
		setPreferredSize(new Dimension(anchoVentana, altoVentana));
		
		gestorEstaciones = GestorEstacion.getInstance();
		gestorRutas = GestorRuta.getInstance();
		radioEstaciones = 20;
		anchoFlecha = 4.0;
		largoFlecha = 10;
	}
	
	
	
	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent (g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		dibujarGrafo(g2d);

	}
	
	private void dibujarGrafo(Graphics2D g2d) {
		List<Estacion> estaciones = gestorEstaciones.getEstaciones();
		List<Ruta> rutas = gestorRutas.getRutas();

		for (Estacion e : estaciones) {
			if (e.disponible()) {
				boolean cambios = false;
				
				if (e.getPosicion().x + radioEstaciones >= anchoVentana) {
					anchoVentana = e.getPosicion().x + radioEstaciones;
					cambios = true;
				}
				
				if (e.getPosicion().y + radioEstaciones >= altoVentana) {
					altoVentana = e.getPosicion().y + radioEstaciones;
					cambios = true;
				}
				
				if (cambios) {
					this.setPreferredSize(new Dimension(anchoVentana, altoVentana));
					this.revalidate();
				}
				
				dibujarEstacion(g2d, e);
			}
		}
		
		for (Ruta r : rutas) {
			if (r.disponible()) {
				dibujarRuta(g2d, r);
			}
		}		
	}
	
	private void dibujarEstacion(Graphics2D g2d, Estacion e) {
		Point posicion = e.getPosicion();
		
		
		g2d.setColor(Color.BLUE);
		g2d.fillOval(posicion.x-radioEstaciones, posicion.y-radioEstaciones, 2*radioEstaciones, 2*radioEstaciones);	
		
	}
	
	//Dibuja la flecha que simboliza una ruta entre dos estaciones, con su respectivo color
	private void dibujarRuta(Graphics2D g2d, Ruta e) {
		Point posEstOrigen, posEstDestino, origenFlecha, destinoFlecha;
		Double anguloFlecha;
		Integer descX, descY;
		
		// Se obtiene la posicion de las estaciones origen y destino
		posEstOrigen = e.getOrigen().getPosicion();
		posEstDestino = e.getDestino().getPosicion();
		
		// Se obtiene la direccion de la flecha
		anguloFlecha = Math.atan((posEstDestino.getY()-posEstOrigen.getY())/(posEstDestino.getX()-posEstOrigen.getX()));
		
		// Se corrige la direccion en los casos donde la estacion de origen esta mas a la derecha que la estacion destino
		if ((posEstDestino.getX()-posEstOrigen.getX()) < 0) {
			if (anguloFlecha > 0) anguloFlecha += Math.PI;
			else anguloFlecha -= Math.PI;
		}
		
		// Como la flecha no empieza ni termina en el centro exacto de las estaciones se calcula estos valores
		// que al operarlos con los centro de las estaciones permiten obtener los puntos de origen y destino de la flecha
		descX = (int) Math.round(Math.cos(anguloFlecha) * radioEstaciones);
		descY = (int) Math.round(Math.sin(anguloFlecha) * radioEstaciones);
		
		origenFlecha = new Point(posEstOrigen.x + descX, posEstOrigen.y + descY);
		destinoFlecha = new Point(posEstDestino.x - descX, posEstDestino.y - descY);
		
		dibujarFlecha(g2d, origenFlecha, destinoFlecha, e.getColorLinea(), anguloFlecha);
	}
	
	private void dibujarFlecha(Graphics2D g2d, Point inicio, Point fin, Color color, Double angulo) {
		Point aux1, aux2;
		Double apertura = Math.atan(anchoFlecha/largoFlecha);
		Double hipotenusa = Math.sqrt(largoFlecha*largoFlecha + anchoFlecha*anchoFlecha);
		aux1 = new Point((int)Math.round(fin.x - Math.cos(angulo+apertura)*hipotenusa), (int)Math.round(fin.y - Math.sin(angulo+apertura)*hipotenusa));
		aux2 = new Point((int)Math.round(fin.x - Math.cos(angulo-apertura)*hipotenusa), (int)Math.round(fin.y - Math.sin(angulo-apertura)*hipotenusa));
		int[] x = {fin.x, aux1.x, aux2.x};
		int[] y = {fin.y, aux1.y, aux2.y};
		
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(1));
		g2d.drawLine(inicio.x, inicio.y, fin.x, fin.y);
		
		g2d.fillPolygon(x, y, 3);
		
		
	}
	
	
}
