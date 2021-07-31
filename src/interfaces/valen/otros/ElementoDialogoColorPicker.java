package interfaces.valen.otros;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import clases.CustomColor;
import gestores.GestorColor;

public class ElementoDialogoColorPicker extends JPanel{

	JPanel panelColor;
	JButton boton;
	GridBagConstraints gbc;
	
	public ElementoDialogoColorPicker(CustomColor color) {
		
		this.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		boton = new JButton(color.getNombre());
		this.add(boton, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		panelColor = new JPanel();
		panelColor.setBackground(color);
		this.add(panelColor, gbc);
		
	}
}
