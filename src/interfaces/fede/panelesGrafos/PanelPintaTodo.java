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
import interfaces.fede.dialogs.DialogLeyenda;

public class PanelPintaTodo extends PanelGrafico {
	public PanelPintaTodo() {
		this.descripcionPantalla = 		"- En esta pantalla se muestran todas las estaciones y rutas cargadas en el sistema.\n"
									+ 	"- Presione una flecha para ver las líneas que tienen ruta entre las estaciones y en la direccion de la flecha.\n"
									+ 	"- Colores de flechas:\n"
									+ 	"		Negra: varias lineas\n"
									+ 	"		Gris: la/as ruta/as se encuentra/an inactiva/as\n"
									+ 	"		Otro color: unica linea. Se muestra su color\n";
		
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
				if (!existeAlguna && botonInfo.getHitbox().contains(e.getPoint())) existeAlguna = true;
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
