package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.valen.frames.VentanaSiguienteAltaLineaDeTransporte;
import interfaces.valen.otros.ColorPicker;

public class PanelResumenAltaLinea extends JPanel{

	JLabel labelNombre, nombreLinea, labelEstado, estado, labelColor;
	JPanel color;
	GridBagConstraints gbc;
	
	public PanelResumenAltaLinea(VentanaSiguienteAltaLineaDeTransporte frame, String nomLinea, Integer estadoLinea, Color colorLinea) {
		
		this.setBorder(BorderFactory.createTitledBorder("Resumen - Alta de línea"));
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		// Componentes
		labelNombre = new JLabel("Nombre:");
		nombreLinea = new JLabel(nomLinea);
		labelEstado = new JLabel("Estado:");
		
		if(estadoLinea == 0) estado = new JLabel("Activa");
		else estado = new JLabel("No activa");
		
		labelColor = new JLabel("Color:");
		color = new JPanel();
		color.setBackground(colorLinea);
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridy = 0;
		
		gbc.gridx = 0;
		this.add(labelNombre, gbc);
		
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.add(nombreLinea, gbc);
		gbc.weightx = 0.0;
		
		gbc.gridx = 2;
		this.add(labelEstado, gbc);
		
		gbc.gridx = 3;
		this.add(estado, gbc);
		
		gbc.gridx = 4;
		this.add(labelColor, gbc);
		
		gbc.gridx = 5;
		this.add(color, gbc);
				
	}
	
}
