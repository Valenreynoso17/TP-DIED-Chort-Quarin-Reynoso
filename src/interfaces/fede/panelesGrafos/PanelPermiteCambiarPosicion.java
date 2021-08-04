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
import java.util.Set;

import clases.Estacion;
import clases.Flecha;
import interfaces.fede.dialogs.DialogInfoFlechaInactivosVisibles;
import interfaces.fede.dialogs.DialogLeyenda;



public class PanelPermiteCambiarPosicion extends PanelPintaTodo {
	protected Estacion seleccionada, nuevaEstacion;
	protected Point puntoRelativoAgarre;
	protected Map<Integer, Point> anterioresPosiciones;
	
	public PanelPermiteCambiarPosicion(Estacion nuevaEstacion) {
		super();
		if (nuevaEstacion != null) {
			this.nuevaEstacion = nuevaEstacion;
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
				if (ventanaInfo == null || !ventanaInfo.isVisible()) {
					for (Flecha f : flechas) {
						if (f.getHitbox().contains(e.getPoint())) {
							ventanaInfo = new DialogInfoFlechaInactivosVisibles(f);
							ventanaInfo.setVisible(true);
						}
					}
					if (botonInfo.getHitbox().contains(e.getPoint())) {
						ventanaInfo = new DialogLeyenda(descripcionPantalla);
						ventanaInfo.setVisible(true);
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
				if (seleccionada == null && nuevaEstacion.getHitbox().contains(e.getPoint())) {
					seleccionada = nuevaEstacion;
					puntoRelativoAgarre = new Point(e.getPoint().x - nuevaEstacion.getPosicion().x, e.getPoint().y - nuevaEstacion.getPosicion().y);
				
					anterioresPosiciones.putIfAbsent(nuevaEstacion.getId(), (Point) nuevaEstacion.getPosicion().clone());
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
				if (!existeAlguna 
						&& (botonInfo.getHitbox().contains(e.getPoint())) 
						|| nuevaEstacion.getHitbox().contains(e.getPoint())) existeAlguna = true;
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
		if (nuevaEstacion != null) anterioresPosiciones.remove(nuevaEstacion.getId());
		gestorEstaciones.cancelarCambios(anterioresPosiciones);
	}
	
	public void guardarCambios() {
		Set<Integer> setEstaciones = anterioresPosiciones.keySet();
		gestorEstaciones.guardarCambios(setEstaciones);
	}
}
