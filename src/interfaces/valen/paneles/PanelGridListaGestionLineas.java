package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import interfaces.valen.otros.ElementoListaGestionTransporte;

public class PanelGridListaGestionLineas extends JPanel{
	
	GridBagConstraints gbc;

	public PanelGridListaGestionLineas() {
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(2,2,2,2);
		gbc.gridx = GridBagConstraints.RELATIVE;
		
		ElementoListaGestionTransporte e1 = new ElementoListaGestionTransporte("Linea Verde", "Activa");
		ElementoListaGestionTransporte e2 = new ElementoListaGestionTransporte("Linea Amarilla", "No activa");
		ElementoListaGestionTransporte e3 = new ElementoListaGestionTransporte("Linea Roja", "No activa");
		ElementoListaGestionTransporte e4 = new ElementoListaGestionTransporte("Linea Azul", "No activa");
		ElementoListaGestionTransporte e5 = new ElementoListaGestionTransporte("Linea Juancho", "No activa");
		ElementoListaGestionTransporte e6 = new ElementoListaGestionTransporte("Linea Naranja", "Activa");
		ElementoListaGestionTransporte e7 = new ElementoListaGestionTransporte("Linea Mariano", "No activa");
		ElementoListaGestionTransporte e8 = new ElementoListaGestionTransporte("Linea Pepe", "No activa");
		ElementoListaGestionTransporte e9 = new ElementoListaGestionTransporte("Linea El domingo", "No activa");
		ElementoListaGestionTransporte e10 = new ElementoListaGestionTransporte("Linea Agus", "No activa");
		ElementoListaGestionTransporte e11 = new ElementoListaGestionTransporte("Linea Azul", "No activa");
		ElementoListaGestionTransporte e12 = new ElementoListaGestionTransporte("Linea Juancho", "No activa");
		ElementoListaGestionTransporte e13 = new ElementoListaGestionTransporte("Linea Naranja", "Activa");
		ElementoListaGestionTransporte e14 = new ElementoListaGestionTransporte("Linea Mariano", "No activa");
		ElementoListaGestionTransporte e15 = new ElementoListaGestionTransporte("Linea Pepe", "No activa");
		ElementoListaGestionTransporte e16 = new ElementoListaGestionTransporte("Linea El domingo", "No activa");
		ElementoListaGestionTransporte e17 = new ElementoListaGestionTransporte("Linea Agus", "No activa");
		
		gbc.gridy = 0;
		this.add(e1, gbc);
		this.add(e2, gbc);
		
		gbc.gridy = 1;
		this.add(e3, gbc);
		this.add(e4, gbc);
		
		gbc.gridy = 2;
		this.add(e5, gbc);
		this.add(e6, gbc);
		
		gbc.gridy = 3;
		this.add(e7, gbc);
		this.add(e8, gbc);
		
		gbc.gridy = 4;
		this.add(e9, gbc);
		this.add(e10, gbc);
		
		gbc.gridy = 5;
		this.add(e11, gbc);
		this.add(e12, gbc);
		
		gbc.gridy = 6;
		this.add(e13, gbc);
		this.add(e14, gbc);
		
		gbc.gridy = 7;
		this.add(e15, gbc);
		this.add(e16, gbc);
		
		gbc.gridy = 8;
		this.add(e17, gbc);
		
	}
}
