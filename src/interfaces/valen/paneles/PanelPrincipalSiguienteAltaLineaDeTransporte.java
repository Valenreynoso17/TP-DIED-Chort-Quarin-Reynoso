package interfaces.valen.paneles;

import javax.swing.JPanel;

import interfaces.valen.frames.VentanaSiguienteAltaLineaDeTransporte;

public class PanelPrincipalSiguienteAltaLineaDeTransporte extends JPanel{

	PanelResumenAltaLinea panelResumen;
	
	public PanelPrincipalSiguienteAltaLineaDeTransporte(VentanaSiguienteAltaLineaDeTransporte frame) {
		
		panelResumen = new PanelResumenAltaLinea();
		
		this.add(panelResumen);
	}
}
