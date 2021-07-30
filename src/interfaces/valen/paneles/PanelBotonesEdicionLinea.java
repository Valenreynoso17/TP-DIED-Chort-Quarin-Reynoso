package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import interfaces.valen.frames.VentanaEdicionLineaDeTransporte;
import interfaces.valen.frames.VentanaGestionLineasDeTransporte;

public class PanelBotonesEdicionLinea extends JPanel{

	JButton botonCancelar;
	JButton botonTerminado;
	GridBagConstraints gbc;
	
	public PanelBotonesEdicionLinea(VentanaEdicionLineaDeTransporte frame) {
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		gbc.gridx = 0;
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(e -> {frame.dispose();
											  new VentanaGestionLineasDeTransporte();});
		this.add(botonCancelar, gbc);
		
		gbc.gridx = 1;
		botonTerminado = new JButton("Terminado");
		this.add(botonTerminado, gbc);
		
	}
}
