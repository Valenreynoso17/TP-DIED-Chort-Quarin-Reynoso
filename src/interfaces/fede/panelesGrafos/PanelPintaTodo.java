package interfaces.fede.panelesGrafos;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

import clases.Dibujable;
import clases.Estacion;
import clases.Flecha;
import interfaces.fede.dialogs.DialogInfoFlechaInactivosVisibles;

public class PanelPintaTodo extends PanelGrafico {
	protected DialogInfoFlechaInactivosVisibles ventanaInfoFlecha;
	public PanelPintaTodo() {
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Flecha> flechas = gestorFlechas.getFlechas();
				if (ventanaInfoFlecha == null || !ventanaInfoFlecha.isVisible()) {
					for (Flecha f : flechas) {
						if (f.getHitbox().contains(e.getPoint())) {
							ventanaInfoFlecha = new DialogInfoFlechaInactivosVisibles(f);
							ventanaInfoFlecha.setVisible(true);
						}
					}
				}
			}
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				List<Flecha> flechas = gestorFlechas.getFlechas();
				Boolean existeAlguna = false;
				for (Flecha f : flechas) {
					if (f.getHitbox().contains(e.getPoint())) {
						existeAlguna = true;
						break;
					}
				}
				if (existeAlguna) setCursor(new Cursor(Cursor.HAND_CURSOR)); 
				else setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	
			}
		});
		
	}
	
	
	@Override
	protected void dibujarGrafo(Graphics2D g2d) {
		for (Dibujable d : dibujables) {
			d.dibujarse(g2d);
			if (d instanceof Estacion) chequearPreferredSize((Estacion) d);
		}
		
	}
}
