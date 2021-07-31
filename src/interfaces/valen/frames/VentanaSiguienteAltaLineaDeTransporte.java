package interfaces.valen.frames;

import java.awt.Color;

import javax.swing.JFrame;

import interfaces.valen.paneles.PanelPrincipalSiguienteAltaLineaDeTransporte;

public class VentanaSiguienteAltaLineaDeTransporte extends JFrame{

	PanelPrincipalSiguienteAltaLineaDeTransporte panelPrincipal;
	
	public VentanaSiguienteAltaLineaDeTransporte(String nombreLinea, Integer estadoLinea, Color colorLinea) {
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Resumen del alta de una nueva línea");
		
		panelPrincipal = new PanelPrincipalSiguienteAltaLineaDeTransporte(this, nombreLinea, estadoLinea, colorLinea);
		this.setContentPane(panelPrincipal);
		
		this.setVisible(true);
	}
}
