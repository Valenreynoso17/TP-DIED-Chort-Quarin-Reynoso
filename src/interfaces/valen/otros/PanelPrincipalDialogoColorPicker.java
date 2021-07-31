package interfaces.valen.otros;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import clases.CustomColor;
import gestores.GestorColor;

public class PanelPrincipalDialogoColorPicker extends JPanel{

	JPanel panelColores;
	JPanel panelBotones;
	JButton botonCancelar;
	JButton botonAgregarColor;
	GridBagConstraints gbc;
	GestorColor gestorColor;
	
	public PanelPrincipalDialogoColorPicker(DialogoColorPicker dialogoPadre, JPanel panel) {

		gestorColor = GestorColor.getInstance();
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		panelColores = new JPanel();
		panelColores.setBorder(BorderFactory.createTitledBorder("Elige un color:"));
		
		for(CustomColor color : gestorColor.getColores()) {
			ElementoDialogoColorPicker elemAux = new ElementoDialogoColorPicker(color, dialogoPadre, panel);
			panelColores.add(elemAux);
		}
		
		this.add(panelColores, gbc);
		
		gbc.weighty = 0.0;
		panelBotones = new JPanel();
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(e -> dialogoPadre.dispose());
		panelBotones.add(botonCancelar);
		
		botonAgregarColor = new JButton("Agregar un nuevo color");
		panelBotones.add(botonAgregarColor);
		
		this.add(panelBotones, gbc);
		

	}
}
