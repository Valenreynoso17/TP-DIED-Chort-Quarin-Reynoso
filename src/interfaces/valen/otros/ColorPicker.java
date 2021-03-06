package interfaces.valen.otros;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.CustomColor;
import interfaces.valen.paneles.PanelListadoGestionLineas;

public class ColorPicker extends JPanel implements ActionListener{

	JPanel panelColor;
	JButton botonElegir;
	JFrame framePadre;
	JPanel panelPadre;
	CustomColor colorActual;
	GridBagConstraints gbc;
	
	public ColorPicker(JFrame frame, JPanel panel, CustomColor color) {
		
		framePadre = frame;
		panelPadre = panel;
		colorActual = color;
		
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridy = 0;
		
		gbc.gridx = 0;
		panelColor = new JPanel();
		panelColor.setBackground(colorActual);
		panelColor.setPreferredSize(new Dimension(15,15));
		
		this.add(panelColor);
		
		gbc.gridx = 1;
		botonElegir = new JButton("Elegir");
		botonElegir.setPreferredSize(new Dimension(70, 15));
		botonElegir.setMargin(new Insets(1,1,1,1));
		botonElegir.addActionListener(this);
		this.add(botonElegir);
	}

	public CustomColor getColor() {
		return colorActual;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonElegir) {
			DialogoColorPicker prueba = new DialogoColorPicker(framePadre, panelPadre, true);
		}
		
	}
}
