package interfaces.fede.panelesGrafos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import clases.Flecha;
import clases.Recorrido;
import interfaces.fede.dialogs.DialogInfoFlechaInactivosNoVisibles;
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
				if (ventanaInfoFlecha == null || !ventanaInfoFlecha.isVisible()) {
					for (Flecha f : flechas) {
						if (f.getHitbox().contains(e.getPoint())) {
							ventanaInfoFlecha = new DialogInfoFlechaInactivosNoVisibles(f, new RenderInfoFlechaFlujoMaximo<>());
							ventanaInfoFlecha.setVisible(true);
						}
					}
				}
			}
		});
		
	
		
	}
}
