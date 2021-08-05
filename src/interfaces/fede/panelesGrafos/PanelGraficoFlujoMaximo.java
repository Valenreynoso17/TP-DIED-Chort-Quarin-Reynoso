package interfaces.fede.panelesGrafos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import clases.Flecha;
import clases.Recorrido;
import interfaces.fede.dialogs.DialogInfoFlechaInactivosNoVisibles;
import interfaces.fede.dialogs.DialogLeyenda;
import interfaces.fede.otros.RenderInfoFlechaFlujoMaximo;

public class PanelGraficoFlujoMaximo extends PanelSoloEntreOrigenDestino {
	public PanelGraficoFlujoMaximo(List<Recorrido> recorridos) {
		super(recorridos);
		
		this.descripcionPantalla = 		"- En esta pantalla se muestran todas las estaciones por las que se puede pasar para ir desde la estacion origen a la estacion destino. Estas dos ultimas se resaltan en otro color.\n"
									+ 	"- Presione una flecha para ver las líneas que tienen ruta entre las estaciones y en la direccion de la flecha.\n"
									+ 	"- Colores de flechas:\n"
									+ 	"		Negra: varias lineas\n"
									+ 	"		Otro color: unica linea. Se muestra su color\n";
		
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
							ventanaInfo = new DialogInfoFlechaInactivosNoVisibles(f, new RenderInfoFlechaFlujoMaximo<>());
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
		

		
	}
}
