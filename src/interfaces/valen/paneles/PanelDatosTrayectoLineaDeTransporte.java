package interfaces.valen.paneles;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelDatosTrayectoLineaDeTransporte extends JPanel{
	
	public PanelDatosTrayectoLineaDeTransporte() {
		
		this.setLayout(new GridLayout(0,1,1,5));
	
		ElementoListaEdicionLineaDeTransporte e1 = new ElementoListaEdicionLineaDeTransporte();
		ElementoListaEdicionLineaDeTransporte e2 = new ElementoListaEdicionLineaDeTransporte();
//		ElementoListaEdicionLineaDeTransporte e3 = new ElementoListaEdicionLineaDeTransporte();
//		ElementoListaEdicionLineaDeTransporte e4 = new ElementoListaEdicionLineaDeTransporte();
//		ElementoListaEdicionLineaDeTransporte e5 = new ElementoListaEdicionLineaDeTransporte();
//		ElementoListaEdicionLineaDeTransporte e6 = new ElementoListaEdicionLineaDeTransporte();
//		ElementoListaEdicionLineaDeTransporte e7 = new ElementoListaEdicionLineaDeTransporte();
//		ElementoListaEdicionLineaDeTransporte e8 = new ElementoListaEdicionLineaDeTransporte();
//		ElementoListaEdicionLineaDeTransporte e9 = new ElementoListaEdicionLineaDeTransporte();
		
		this.add(e1);
		this.add(e2);
//		this.add(e3);
//		this.add(e4);
//		this.add(e5);
//		this.add(e6);
//		this.add(e7);
//		this.add(e8);
//		this.add(e9);
		
	}
}
