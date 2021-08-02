package interfaces.valen.paneles;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import interfaces.valen.otros.ElementoListaTrayecto;

public class PanelTrayectoLineaDeTransporte extends JPanel{

	List<ElementoListaTrayecto> listaTrayecto;
	
	public PanelTrayectoLineaDeTransporte(List<ElementoListaTrayecto> listaTrayecto) {
		
		this.listaTrayecto = listaTrayecto;
		
		this.setBorder(BorderFactory.createTitledBorder("Trayecto"));
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
		
//		JButton botonEstacion = new JButton("A");
//		botonEstacion.setFocusable(false);
		
		for(ElementoListaTrayecto unElemento : listaTrayecto) {
			JButton botonAux = new JButton(unElemento.getEstaciones());
			this.add(botonAux);
		}
		
	}
}
