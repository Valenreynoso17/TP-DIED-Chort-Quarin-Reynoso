package interfaces.fede.panelesGrafos;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import clases.Estacion;
import clases.Flecha;
import interfaces.fede.dialogs.DialogInfoFlechaInactivosVisibles;



public class PanelPermiteCambiarPosicion extends PanelPintaTodo {
	protected Estacion seleccionada;
	protected Point puntoRelativoAgarre;
	protected Map<Integer, Point> anterioresPosiciones;
	
	public PanelPermiteCambiarPosicion(Estacion nuevaEstacion) {
		super();
		if (nuevaEstacion != null) {
			estaciones.add(nuevaEstacion);
			dibujables.add(nuevaEstacion);
		}
		
		anterioresPosiciones = new LinkedHashMap<>();
		
		MouseListener[] listeners = this.getMouseListeners();
		for (int i=0; i<listeners.length; i++) {
			this.removeMouseListener(listeners[i]);
		}
		
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
						
						
						anterioresPosiciones.putIfAbsent(est.getId(), (Point) est.getPosicion().clone());
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
		
		
		MouseMotionListener[] listeners2 = this.getMouseMotionListeners();
		for (int i = 0; i<listeners2.length; i++) {
			this.removeMouseMotionListener(listeners2[i]);
		}
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
	
	public void cancelarCambios() {
		gestorEstaciones.cancelarCambios(anterioresPosiciones);
	}
	
	public void guardarCambios() {
		gestorEstaciones.guardarCambios(anterioresPosiciones.keySet());
	}
}
