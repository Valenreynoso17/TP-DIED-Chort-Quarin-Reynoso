package interfaces.valen.otros;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorPicker extends JPanel implements ActionListener{

	JPanel panelColor;
	JButton botonElegir;
	JFrame framePadre;
	GridBagConstraints gbc;
	
	public ColorPicker(JFrame frame) {
		
		framePadre = frame;
		
		this.setLayout(new GridBagLayout());
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridy = 0;
		
		gbc.gridx = 0;
		panelColor = new JPanel();
		panelColor.setBackground(Color.red);
		this.add(panelColor);
		
		gbc.gridx = 1;
		botonElegir = new JButton("Elegir color");

		System.out.println(botonElegir.getSize());
		System.out.println(botonElegir.getMaximumSize());
		System.out.println(botonElegir.getMinimumSize());
		System.out.println(botonElegir.getPreferredSize());
		
//		botonElegir.setSize();
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
