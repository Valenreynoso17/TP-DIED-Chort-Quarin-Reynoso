package interfaces.valen.paneles;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import interfaces.valen.otros.ElementoListaTrayecto;

public class PanelTrayectoLineaDeTransporte extends JPanel{

	List<ElementoListaTrayecto> listaTrayecto;
	PanelPrincipalAltaLineaDeTransporte panelPadre;
	
	public PanelTrayectoLineaDeTransporte(PanelPrincipalAltaLineaDeTransporte panelPadre, List<ElementoListaTrayecto> listaTrayecto) {
		
		this.panelPadre = panelPadre;
		this.listaTrayecto = listaTrayecto;
		
		this.setBorder(BorderFactory.createTitledBorder("Trayecto"));
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 15));
		
		for(ElementoListaTrayecto unElemento : listaTrayecto) {
			JButton botonAux = new JButton(unElemento.getEstaciones());
			botonAux.addActionListener(e -> cambiarAModoEdicion(unElemento));
			this.add(botonAux);
		}
		
	}
	
	public void cambiarAModoEdicion(ElementoListaTrayecto unElemento) {
		panelPadre.actualizarAModoEdicion(unElemento);
	}
}
