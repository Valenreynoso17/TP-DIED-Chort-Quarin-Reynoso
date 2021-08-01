package interfaces.valen.frames;

import javax.swing.JFrame;

import clases.LineaDeTransporte;
import interfaces.valen.paneles.PanelPrincipalEdicionLineaDeTransporte;

public class VentanaEdicionLineaDeTransporte extends JFrame{
	
	PanelPrincipalEdicionLineaDeTransporte panelPrincipal;
	LineaDeTransporte lineaDeTransporte;

	public VentanaEdicionLineaDeTransporte(LineaDeTransporte lineaDeTransporte) {
		
		this.lineaDeTransporte = lineaDeTransporte;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Edicion de una línea de transporte"); //super("Sistema de Gestión de Transporte Multimodal");
		
		panelPrincipal = new PanelPrincipalEdicionLineaDeTransporte(this, lineaDeTransporte);
		this.setContentPane(panelPrincipal);
		
		this.setVisible(true);
	}
}
