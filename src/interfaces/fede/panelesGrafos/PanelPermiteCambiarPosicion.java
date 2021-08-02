package interfaces.fede.panelesGrafos;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

import clases.Estacion;
import clases.Flecha;
import interfaces.fede.dialogs.DialogInfoFlechaInactivosVisibles;

public class PanelPermiteCambiarPosicion extends PanelPintaTodo {
	protected DialogInfoFlechaInactivosVisibles ventanaInfoFlecha;
	protected Estacion seleccionada;
	protected Point puntoRelativoAgarre;
	
	public PanelPermiteCambiarPosicion() {
		super();
		
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
			
			@Override
			public void mousePressed(MouseEvent e) {
				for (Estacion est : estaciones) {
					if (est.getHitbox().contains(e.getPoint())) {
						seleccionada = est;
						puntoRelativoAgarre = new Point(e.getPoint().x - est.getPosicion().x, e.getPoint().y - est.getPosicion().y);
					}
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (seleccionada != null) {
					seleccionada = null;
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
				if (!existeAlguna) {
					for (Estacion est : estaciones) {
						if (est.getHitbox().contains(e.getPoint())) {
							existeAlguna = true;
							break;
						}
					}
				}
				if (existeAlguna) setCursor(new Cursor(Cursor.HAND_CURSOR)); 
				else setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if (seleccionada != null) {
					seleccionada.mover(puntoRelativoAgarre, e.getPoint());
					gestorFlechas.recalcularFlechas(seleccionada);
					repaint();
					chequearPreferredSize(seleccionada);
				}
			}
		});
	}
	
	
}
