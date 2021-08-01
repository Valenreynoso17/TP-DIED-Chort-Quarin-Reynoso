package interfaces.valen.frames;

import javax.swing.JFrame;

import interfaces.valen.paneles.PanelPrincipalAltaLineaDeTransporte;

public class VentanaAltaLineaDeTransporte extends JFrame{

	PanelPrincipalAltaLineaDeTransporte panelPrincipal;
	
	public VentanaAltaLineaDeTransporte() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Alta de una nueva línea"); //super("Sistema de Gestión de Transporte Multimodal");
		
		panelPrincipal = new PanelPrincipalAltaLineaDeTransporte(this);
		this.setContentPane(panelPrincipal);
		
		this.setVisible(true);
	}
}
