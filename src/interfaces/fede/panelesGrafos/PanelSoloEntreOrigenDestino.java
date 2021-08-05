package interfaces.fede.panelesGrafos;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Set;

import clases.Dibujable;
import clases.Estacion;
import clases.Flecha;
import clases.Recorrido;
import gestores.GestorRecorrido;
import interfaces.fede.dialogs.DialogInfoFlechaInactivosVisibles;
import interfaces.fede.dialogs.DialogLeyenda;
import interfaces.fede.otros.GamaColor;

public class PanelSoloEntreOrigenDestino extends PanelPintaSoloVisibles {
	protected Set<Estacion> estRecorridas;
	protected GestorRecorrido gestorRecorridos;
	
	public PanelSoloEntreOrigenDestino(List<Recorrido> recorridos) {
		super(recorridos.get(0).getOrigen(), recorridos.get(0).getDestino());
		
		this.descripcionPantalla = 		"- En esta pantalla se muestran todas las estaciones por las que se puede pasar para ir desde la estacion origen a la estacion destino. Estas dos ultimas se resaltan en otro color.\n"
									+ 	"- Presione una flecha para ver las líneas que tienen ruta entre las estaciones y en la direccion de la flecha.\n"
									+ 	"- Colores de flechas:\n"
									+ 	"		Negra: varias lineas\n"
									+ 	"		Otro color: unica linea. Se muestra su color\n";
		
		gestorRecorridos = GestorRecorrido.getInstance();
		estRecorridas = gestorRecorridos.getEstacionesRecorridas(recorridos);
	
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
						if (estRecorridas.contains(f.getEstacionOrigen()) && estRecorridas.contains(f.getEstacionDestino()) && f.getHitbox().contains(e.getPoint())) {
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
					if (estRecorridas.contains(f.getEstacionOrigen()) && estRecorridas.contains(f.getEstacionDestino()) && f.getHitbox().contains(e.getPoint())) {
						existeAlguna = true;
						break;
					}
				}
				if (!existeAlguna && (botonInfo.getHitbox().contains(e.getPoint()))) existeAlguna = true;
				if (existeAlguna) setCursor(new Cursor(Cursor.HAND_CURSOR)); 
				else setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	
			}
		});
	}
	
	@Override
	protected void dibujarGrafo(Graphics2D g2d){
		for (Dibujable d : dibujables) {
			if (estRecorridas.contains(d) 
					|| (d instanceof Flecha && estRecorridas.contains(((Flecha) d).getEstacionOrigen()) 
							&& estRecorridas.contains(((Flecha) d).getEstacionDestino()))) {
				if (d.equals(origen) || d.equals(destino)) ((Estacion) d).dibujarse(g2d, GamaColor.VERDE);
				else d.dibujarse(g2d);
				if (d instanceof Estacion) chequearPreferredSize((Estacion) d);
			}
		}
	}
}
