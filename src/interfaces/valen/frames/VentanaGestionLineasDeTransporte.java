package interfaces.valen.frames;

import javax.swing.JFrame;

import interfaces.valen.paneles.PanelPrincipalGestionLineasDeTransporte;

public class VentanaGestionLineasDeTransporte extends JFrame{

	PanelPrincipalGestionLineasDeTransporte panelPrincipal;
	
	public VentanaGestionLineasDeTransporte() {
		super("Sistema de Gestión de Transporte Multimodal");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		
		panelPrincipal = new PanelPrincipalGestionLineasDeTransporte(this);
		this.setContentPane(panelPrincipal);	
		
		this.setVisible(true);
	}
}
