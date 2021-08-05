package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import interfaces.valen.otros.ElementoListaTrayecto;

public class PanelTrayectoLineaDeTransporte extends JPanel{

	List<ElementoListaTrayecto> listaTrayecto;
	PanelPrincipalAltaLineaDeTransporte panelPadre;
	
	public PanelTrayectoLineaDeTransporte(PanelPrincipalAltaLineaDeTransporte panelPadre, List<ElementoListaTrayecto> listaTrayecto) {
		
		this.panelPadre = panelPadre;
		this.listaTrayecto = listaTrayecto;
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 1), "Trayecto"));
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
