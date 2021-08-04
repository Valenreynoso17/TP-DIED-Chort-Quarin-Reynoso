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
import interfaces.fede.dialogs.DialogInfoFlechaInactivosNoVisibles;
import interfaces.fede.dialogs.DialogLeyenda;
import interfaces.fede.otros.GamaColor;
import interfaces.fede.otros.RenderInfoFlecha;

public class PanelPintaSoloVisibles extends PanelGrafico {
	protected Estacion origen, destino;
	public PanelPintaSoloVisibles(Estacion origen, Estacion destino) {
		super();
		
		this.origen = origen;
		this.destino = destino;
		
		this.descripcionPantalla = 		"- En esta pantalla se muestran todas las estaciones operativas y las rutas activas.\n"
									+ 	"- Presione una flecha para ver las lineas que tienen ruta entre las estaciones y en la direccion de la flecha.\n"
									+ 	"- Colores de flechas:\n"
									+ 	"    Negra: varias lineas";
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Flecha> flechas = gestorFlechas.getFlechas();
				if (ventanaInfo == null || !ventanaInfo.isVisible()) {
					for (Flecha f : flechas) {
						if (f.getHitbox().contains(e.getPoint())) {
							ventanaInfo = new DialogInfoFlechaInactivosNoVisibles(f, new RenderInfoFlecha<>());
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
			if (d.visible()) {
				if (d.equals(origen)) origen.dibujarse(g2d, GamaColor.VERDE);
				else if (d.equals(destino)) destino.dibujarse(g2d, GamaColor.VERDE);
				else d.dibujarse(g2d);
				if (d instanceof Estacion) chequearPreferredSize((Estacion) d);
			}
		}
	}
}
