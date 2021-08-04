package interfaces.valen.frames;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;

import clases.CustomColor;
import interfaces.valen.otros.ElementoListaTrayecto;
import interfaces.valen.paneles.PanelPrincipalSiguienteAltaLineaDeTransporte;

public class VentanaSiguienteAltaLineaDeTransporte extends JFrame{

	PanelPrincipalSiguienteAltaLineaDeTransporte panelPrincipal;
	
	public VentanaSiguienteAltaLineaDeTransporte(VentanaAltaLineaDeTransporte frame, String nombreLinea, String estadoLinea, CustomColor colorLinea, List<ElementoListaTrayecto> listaTrayecto) {
		super("Sistema de Gestión de Transporte Multimodal");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		
		panelPrincipal = new PanelPrincipalSiguienteAltaLineaDeTransporte(frame, this, nombreLinea, estadoLinea, colorLinea, listaTrayecto);
		this.setContentPane(panelPrincipal);
		
		this.setVisible(true);
	}
}
