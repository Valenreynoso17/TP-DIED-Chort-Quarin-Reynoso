package interfaces.valen.frames;

import javax.swing.JFrame;

import interfaces.valen.paneles.PanelPrincipalAltaLineaDeTransporte;

public class VentanaAltaLineaDeTransporte extends JFrame{

	PanelPrincipalAltaLineaDeTransporte panelPrincipal;
	
	public VentanaAltaLineaDeTransporte() {
		super("Sistema de Gestión de Transporte Multimodal");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		
		panelPrincipal = new PanelPrincipalAltaLineaDeTransporte(this);
		this.setContentPane(panelPrincipal);
		
		this.setVisible(true);
	}
}
