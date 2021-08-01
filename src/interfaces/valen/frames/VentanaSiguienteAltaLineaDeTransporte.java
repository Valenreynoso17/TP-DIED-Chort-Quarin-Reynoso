package interfaces.valen.frames;

import java.awt.Color;

import javax.swing.JFrame;

import clases.CustomColor;
import interfaces.valen.paneles.PanelPrincipalSiguienteAltaLineaDeTransporte;

public class VentanaSiguienteAltaLineaDeTransporte extends JFrame{

	PanelPrincipalSiguienteAltaLineaDeTransporte panelPrincipal;
	
	public VentanaSiguienteAltaLineaDeTransporte(VentanaAltaLineaDeTransporte frame, String nombreLinea, Integer estadoLinea, CustomColor colorLinea) {
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Resumen del alta de una nueva línea");  //super("Sistema de Gestión de Transporte Multimodal");
		
		panelPrincipal = new PanelPrincipalSiguienteAltaLineaDeTransporte(frame, this, nombreLinea, estadoLinea, colorLinea);
		this.setContentPane(panelPrincipal);
		
		this.setVisible(true);
	}
}
