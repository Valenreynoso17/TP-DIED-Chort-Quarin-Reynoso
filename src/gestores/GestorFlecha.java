package gestores;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import clases.Ruta;
import interfaces.fede.panelesGrafos.PanelGrafico;
import clases.Flecha;


public class GestorFlecha {
	private List<Flecha> flechas;
	private Color color = Color.RED;
	

	
	
	public GestorFlecha() {
		flechas = new ArrayList<>();
	}
	
	public List<Flecha> getFlechas() {
		return flechas;
	}
	
	public void asignarAFlecha(Ruta r) {
		Boolean asignadaAFlecha = false;
		for (Flecha f : flechas) {
			if (f.correspondeAEstaFlecha(r)) {
				f.agregarRuta(r);
				asignadaAFlecha = true;
				break;
			}
		}
		if (!asignadaAFlecha) {
			this.agregarFlecha(r);
		}
	}
	
	public void agregarFlecha(Ruta r) {
		Flecha flecha;
		Point posEstOrigen, posEstDestino, origenFlecha, destinoFlecha;
		Double anguloFlecha;
		Integer descX, descY;
		
		// Se obtiene la posicion de las estaciones origen y destino
		posEstOrigen = r.getOrigen().getPosicion();
		posEstDestino = r.getDestino().getPosicion();
		
		// Se obtiene la direccion de la flecha
		anguloFlecha = Math.atan((posEstDestino.getY()-posEstOrigen.getY())/(posEstDestino.getX()-posEstOrigen.getX()));
		
		// Se corrige la direccion en los casos donde la estacion de origen esta mas a la derecha que la estacion destino
		if ((posEstDestino.getX()-posEstOrigen.getX()) < 0) {
			if (anguloFlecha > 0) anguloFlecha += Math.PI;
			else anguloFlecha -= Math.PI;
		}
		
		// Como la flecha no empieza ni termina en el centro exacto de las estaciones se calcula estos valores
		// que al operarlos con los centro de las estaciones permiten obtener los puntos de origen y destino de la flecha
		descX = (int) Math.round(Math.cos(anguloFlecha) * PanelGrafico.getRadioEstaciones());
		descY = (int) Math.round(Math.sin(anguloFlecha) * PanelGrafico.getRadioEstaciones());
		
		origenFlecha = new Point(posEstOrigen.x + descX, posEstOrigen.y + descY);
		destinoFlecha = new Point(posEstDestino.x - descX, posEstDestino.y - descY);
		
		flecha = new Flecha(origenFlecha, destinoFlecha, anguloFlecha, color);
		flecha.agregarRuta(r);
		flechas.add(flecha);
	}
	
	public void borrarFlechas() {
		flechas = new ArrayList<>();
	}
}

