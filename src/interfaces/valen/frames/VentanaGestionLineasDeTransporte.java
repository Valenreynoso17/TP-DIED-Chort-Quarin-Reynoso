package interfaces.valen.frames;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import interfaces.valen.paneles.PanelListadoGestionLineas;
import interfaces.fede.ventaBoleto.PanelGrafico;

public class VentanaGestionLineasDeTransporte extends JFrame{

	GridBagLayout gbLayout;
	GridBagConstraints gbc;
	
	public VentanaGestionLineasDeTransporte() {
		
		gbLayout = new GridBagLayout();
		gbc = new GridBagConstraints();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Gestión de líneas de transporte");
		//this.add(new PanelListadoGestionLineas());
		this.setLayout(gbLayout);		
		
		gbc.fill = GridBagConstraints.BOTH;
		
		// PanelListado
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		PanelListadoGestionLineas panelListado = new PanelListadoGestionLineas();
		this.add(panelListado, gbc);
		
		// PanelGrafo
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		PanelGrafico panelGrafo = new PanelGrafico();
		JScrollPane panelScrollGrafo = new JScrollPane(panelGrafo);
		panelScrollGrafo.setBorder(BorderFactory.createTitledBorder("Líneas de transporte"));
		this.add(panelScrollGrafo, gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		
		// Boton Cancelar
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.05;
		gbc.weighty = 0.05;
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setFocusable(false);
		this.add(botonCancelar, gbc);

		
		// Boton Siguiente
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		JButton botonSiguiente = new JButton("Dar de alta una nueva línea");
		botonSiguiente.setFocusable(false);
		botonSiguiente.addActionListener(e -> {this.dispose();
											   new VentanaAltaLineaDeTransporte();});
		this.add(botonSiguiente, gbc);
		
		this.setVisible(true);
	}
}
