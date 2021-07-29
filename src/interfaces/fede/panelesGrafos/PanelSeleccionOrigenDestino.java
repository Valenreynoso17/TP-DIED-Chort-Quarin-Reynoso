package interfaces.fede.panelesGrafos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import clases.Dibujable;
import clases.Estacion;

public class PanelSeleccionOrigenDestino extends PanelGrafico {
	public Estacion origen, destino;
	
	public PanelSeleccionOrigenDestino() {
		super();
		
	}
	
	
	@Override
	protected void paintComponent (Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g.create();
		super.paintComponent(g2d);	
	}
	
	public void pintarOrigen(Estacion e) {
		if (origen != null) repaint(origen.getPosicion().x - radioEstaciones - 5, origen.getPosicion().y - radioEstaciones - 5, (radioEstaciones + 5)*2, (radioEstaciones + 5)*2);
		origen = e;
		if (destino != null) repaint(destino.getPosicion().x - radioEstaciones - 5, destino.getPosicion().y - radioEstaciones - 5, (radioEstaciones + 5)*2, (radioEstaciones + 5)*2);
		destino = null;
		repaint(e.getPosicion().x - radioEstaciones - 5, e.getPosicion().y - radioEstaciones - 5, (radioEstaciones + 5)*2, (radioEstaciones + 5)*2);
	}
	
	public void pintarDestino(Estacion e) {
		if (destino != null) repaint(destino.getPosicion().x - radioEstaciones - 5, destino.getPosicion().y - radioEstaciones - 5, (radioEstaciones + 5)*2, (radioEstaciones + 5)*2);
		destino = e;
		repaint(e.getPosicion().x - radioEstaciones - 5, e.getPosicion().y - radioEstaciones - 5, (radioEstaciones + 5)*2, (radioEstaciones + 5)*2);
	}
	
	protected void dibujarGrafo(Graphics2D g2d) {
		for (Dibujable d : dibujables) {
			if (d.equals(origen)) origen.dibujarse(g2d, GamaColor.VERDE);
			else if (d.equals(destino)) destino.dibujarse(g2d, GamaColor.VERDE);
			else d.dibujarse(g2d);
		}
	}
	
}
