package interfaces.fede.panelesGrafos;

import java.awt.Graphics2D;

import clases.Dibujable;
import clases.Estacion;

public class PanelPintaTodo extends PanelGrafico {
	public PanelPintaTodo() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected void dibujarGrafo(Graphics2D g2d) {
		for (Dibujable d : dibujables) {
			d.dibujarse(g2d);
			if (d instanceof Estacion) chequearPreferredSize((Estacion) d);
		}
		
	}
}
