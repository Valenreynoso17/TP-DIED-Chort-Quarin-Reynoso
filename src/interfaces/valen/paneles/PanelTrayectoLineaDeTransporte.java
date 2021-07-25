package interfaces.valen.paneles;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelTrayectoLineaDeTransporte extends JPanel{

	public PanelTrayectoLineaDeTransporte() {
		
		this.setBorder(BorderFactory.createTitledBorder("Trayecto"));
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
		
//		JButton botonEstacion = new JButton("A");
//		botonEstacion.setFocusable(false);
		
		this.add(new JButton("A"));
		this.add(new JButton("C"));
		this.add(new JButton("F"));
		this.add(new JButton("G"));
		this.add(new JButton("D"));
		this.add(new JButton("E"));
		
	}
}
