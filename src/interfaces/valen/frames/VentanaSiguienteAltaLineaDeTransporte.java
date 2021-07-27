package interfaces.valen.frames;

import javax.swing.JFrame;

import interfaces.valen.paneles.PanelPrincipalSiguienteAltaLineaDeTransporte;

public class VentanaSiguienteAltaLineaDeTransporte extends JFrame{

	PanelPrincipalSiguienteAltaLineaDeTransporte panelPrincipal;
	
	public VentanaSiguienteAltaLineaDeTransporte() {
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Resumen del alta de una nueva l�nea");
		
		panelPrincipal = new PanelPrincipalSiguienteAltaLineaDeTransporte(this);
		this.setContentPane(panelPrincipal);
		
		this.setVisible(true);
	}
}