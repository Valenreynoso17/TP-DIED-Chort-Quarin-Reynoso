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
