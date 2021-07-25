package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.valen.frames.VentanaSiguienteAltaLineaDeTransporte;
import interfaces.valen.otros.ColorPicker;

public class PanelPrincipalSiguienteAltaLineaDeTransporte extends JPanel{

	PanelResumenAltaLinea panelResumen;
	PanelTablaAltaLinea panelTabla;
	GridBagConstraints gbc;
	
	public PanelPrincipalSiguienteAltaLineaDeTransporte(VentanaSiguienteAltaLineaDeTransporte frame) {
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelResumen = new PanelResumenAltaLinea();
		this.add(panelResumen, gbc);
		
//		ColorPicker colorP = new ColorPicker((JFrame) this.getTopLevelAncestor());
//		
//		this.add(colorP);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelTabla = new PanelTablaAltaLinea();
		this.add(panelTabla, gbc);
	}
}
