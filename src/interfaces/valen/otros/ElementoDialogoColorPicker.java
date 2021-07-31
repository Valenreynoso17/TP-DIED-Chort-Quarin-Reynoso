package interfaces.valen.otros;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import clases.CustomColor;
import gestores.GestorColor;
import interfaces.valen.paneles.PanelAltaLineaDeTransporte;
import interfaces.valen.paneles.PanelListadoGestionLineas;

public class ElementoDialogoColorPicker extends JPanel{

	JPanel panelColor;
	JButton boton;
	CustomColor color;
	GridBagConstraints gbc;
	
	public ElementoDialogoColorPicker(CustomColor color,DialogoColorPicker dialogoPadre, JPanel panel) {
		
		this.color = color;
		
		this.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		boton = new JButton(color.getNombre());
		boton.addActionListener(e -> {
			dialogoPadre.dispose();
			if (panel instanceof PanelListadoGestionLineas) ((PanelListadoGestionLineas) panel).cambiarColorPicker(color);
			else if (panel instanceof PanelAltaLineaDeTransporte) ((PanelAltaLineaDeTransporte) panel).cambiarColorPicker(color);
		});
		boton.setMargin(new Insets(5, 5, 5, 5));
		this.add(boton, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.VERTICAL;
		panelColor = new JPanel();
		panelColor.setBackground(color);
		this.add(panelColor, gbc);		
	}
}
