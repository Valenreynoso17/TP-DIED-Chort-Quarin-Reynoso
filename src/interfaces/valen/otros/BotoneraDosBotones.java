package interfaces.valen.otros;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Por lo pronto no anda

public class BotoneraDosBotones extends JPanel{

	JButton boton1;
	JButton boton2;
	
	public BotoneraDosBotones(String labelBoton1, String labelBoton2, JFrame frame, JFrame frameSiguiente, JFrame frameAnterior) {
		
		boton1 = new JButton(labelBoton1);
		boton1.addActionListener(e -> 	{frame.dispose(); 
										 frameAnterior.setVisible(true);});
		this.add(boton1);
		
		boton2 = new JButton(labelBoton2);
		boton2.addActionListener(e -> 	{frame.dispose(); 
		 								 frameSiguiente.setVisible(true);});
		this.add(boton2);
	}
}
