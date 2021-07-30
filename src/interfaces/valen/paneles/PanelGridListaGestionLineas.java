package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Optional;

import javax.swing.JPanel;

import clases.LineaDeTransporte;
import enums.EstadoLineaDeTransporte;
import gestores.GestorLineaDeTransporte;
import interfaces.valen.frames.VentanaGestionLineasDeTransporte;
import interfaces.valen.otros.ElementoListaGestionTransporte;

public class PanelGridListaGestionLineas extends JPanel{
	
	GridBagConstraints gbc;
	GestorLineaDeTransporte gestorLinea;

	public PanelGridListaGestionLineas(VentanaGestionLineasDeTransporte frame) {
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(2,2,2,2);
		gbc.gridx = GridBagConstraints.RELATIVE;
		
		gestorLinea = GestorLineaDeTransporte.getInstance();
		
//		Optional<List<LineaDeTransporte>> lista = Optional.ofNullable(gestorLinea.getLineasDeTransporte());
		List<LineaDeTransporte> lista = gestorLinea.getLineasDeTransporte();
		
		if(lista != null) {
			Integer valorGridy = 0;
			for(int i = 0; i < lista.size(); i++) {
				
				ElementoListaGestionTransporte auxElemento = new ElementoListaGestionTransporte(frame, lista.get(i));
				
				gbc.gridy = valorGridy;
				this.add(auxElemento, gbc);
				
				if (i % 2 == 0) valorGridy++;
			}
		}
		
//		gbc.gridy = 0;
//		this.add(e1, gbc);
//		this.add(e2, gbc);
//		
//		gbc.gridy = 1;
//		this.add(e3, gbc);
//		this.add(e4, gbc);
//		
//		gbc.gridy = 2;
//		this.add(e5, gbc);
//		this.add(e6, gbc);
//		
//		gbc.gridy = 3;
//		this.add(e7, gbc);
//		this.add(e8, gbc);
//		
//		gbc.gridy = 4;
//		this.add(e9, gbc);
//		this.add(e10, gbc);
//		
//		gbc.gridy = 5;
//		this.add(e11, gbc);
//		this.add(e12, gbc);
//		
//		gbc.gridy = 6;
//		this.add(e13, gbc);
//		this.add(e14, gbc);
//		
//		gbc.gridy = 7;
//		this.add(e15, gbc);
//		this.add(e16, gbc);
//		
//		gbc.gridy = 8;
//		this.add(e17, gbc);
		
	}
}
