package interfaces.valen.frames;

import javax.swing.JFrame;

import interfaces.valen.paneles.PanelPrincipalGestionLineasDeTransporte;

public class VentanaGestionLineasDeTransporte extends JFrame{

	PanelPrincipalGestionLineasDeTransporte panelPrincipal;
	
	public VentanaGestionLineasDeTransporte() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Gestión de líneas de transporte");
		
		panelPrincipal = new PanelPrincipalGestionLineasDeTransporte(this);
		this.setContentPane(panelPrincipal);	
		
		this.setVisible(true);
	}
}
