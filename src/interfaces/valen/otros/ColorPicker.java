package interfaces.valen.otros;

import java.awt.Color;
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
	
	public ColorPicker(JFrame frame) {
		
		framePadre = frame;
		
		panelColor = new JPanel();
		panelColor.setBackground(Color.red);
		this.add(panelColor);
		
		botonElegir = new JButton("Elegir color");
		botonElegir.setFocusable(false);
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
