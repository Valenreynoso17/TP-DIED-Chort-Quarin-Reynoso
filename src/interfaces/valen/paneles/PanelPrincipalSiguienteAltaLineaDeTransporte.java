package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.valen.frames.VentanaSiguienteAltaLineaDeTransporte;
import interfaces.valen.otros.ColorPicker;

public class PanelPrincipalSiguienteAltaLineaDeTransporte extends JPanel{

	PanelResumenAltaLinea panelResumen;
	PanelTablaAltaLinea panelTabla;
	PanelBotonesResumenAltaLinea panelBotones;	
	GridBagConstraints gbc;
	
	public PanelPrincipalSiguienteAltaLineaDeTransporte(VentanaSiguienteAltaLineaDeTransporte frame) {
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		// GridBag de 3x1
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		// Primer componente - Panel resumen
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0.0;
		panelResumen = new PanelResumenAltaLinea(frame);
		this.add(panelResumen, gbc);
		
		// Segundo componente - Panel tabla
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		panelTabla = new PanelTablaAltaLinea();
		this.add(panelTabla, gbc);
		
		// Tercer componente - Panel botones
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 0.0;
		panelBotones = new PanelBotonesResumenAltaLinea();
		this.add(panelBotones, gbc);
		
	}
}
