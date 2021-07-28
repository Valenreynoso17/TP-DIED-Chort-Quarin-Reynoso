package interfaces.valen.frames;

import javax.swing.JFrame;

import interfaces.valen.paneles.PanelPrincipalEdicionLineaDeTransporte;

public class VentanaEdicionLineaDeTransporte extends JFrame{
	
	PanelPrincipalEdicionLineaDeTransporte panelPrincipal;

	public VentanaEdicionLineaDeTransporte() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Edicion de una línea de transporte");
		
		panelPrincipal = new PanelPrincipalEdicionLineaDeTransporte(this);
		this.setContentPane(panelPrincipal);
		
		this.setVisible(true);
	}
}
