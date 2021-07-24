package interfaces.valen.paneles;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelTrayectoLineaDeTransporte extends JPanel{

	public PanelTrayectoLineaDeTransporte() {
		
		this.setBorder(BorderFactory.createTitledBorder("Trayecto"));
		
		JButton botonEstacion = new JButton("A");
		botonEstacion.setFocusable(false);
		
		this.add(botonEstacion);
	}
}
