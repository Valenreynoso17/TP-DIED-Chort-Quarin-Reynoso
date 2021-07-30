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

public class ColorPicker extends JPanel implements ActionListener{

	JPanel panelColor;
	JButton botonElegir;
	JFrame framePadre;
	GridBagConstraints gbc;
	
	public ColorPicker(JFrame frame, Color colorActual) {
		
		framePadre = frame;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonElegir) {
			DialogoColorPicker prueba = new DialogoColorPicker(framePadre, true);
		}
		
	}
}
