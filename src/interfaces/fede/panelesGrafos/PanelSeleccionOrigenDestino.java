package interfaces.fede.panelesGrafos;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

import clases.Dibujable;
import clases.Estacion;
import clases.Flecha;

public class PanelSeleccionOrigenDestino extends PanelPintaSoloVisibles {
	public PanelSeleccionOrigenDestino() {
		super(null, null);
		
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
	
}
