package interfaces.valen.frames;

import java.awt.GridBagLayout;

import javax.swing.JFrame;

import interfaces.valen.paneles.PanelResumenAltaLinea;

public class VentanaSiguienteAltaLineaDeTransporte extends JFrame{

	PanelResumenAltaLinea panelResumen;
	
	public VentanaSiguienteAltaLineaDeTransporte() {
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Resumen del alta de una nueva línea");
		
		panelResumen = new PanelResumenAltaLinea();
		
		this.add(panelResumen);
		
		this.setVisible(true);
	}
}
