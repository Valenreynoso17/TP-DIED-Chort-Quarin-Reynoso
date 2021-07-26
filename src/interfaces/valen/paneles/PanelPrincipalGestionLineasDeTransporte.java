package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import interfaces.fede.panelesGrafos.PanelGrafico;
import interfaces.valen.frames.VentanaAltaLineaDeTransporte;
import interfaces.valen.frames.VentanaGestionLineasDeTransporte;

public class PanelPrincipalGestionLineasDeTransporte extends JPanel{
	
	GridBagLayout gbLayout;
	GridBagConstraints gbc;
	PanelListadoGestionLineas panelListado;
	PanelGrafico panelGrafo;
	JButton botonCancelar;
	JButton botonSiguiente;
	
	public PanelPrincipalGestionLineasDeTransporte(VentanaGestionLineasDeTransporte frame) {
		
		this.setLayout(new GridBagLayout());	
		gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		
		// PanelListado
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		panelListado = new PanelListadoGestionLineas();
		this.add(panelListado, gbc);
		
		// PanelGrafo
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		panelGrafo = new PanelGrafico();
		JScrollPane panelScrollGrafo = new JScrollPane(panelGrafo);
		panelScrollGrafo.setBorder(BorderFactory.createTitledBorder("Líneas de transporte"));
		this.add(panelScrollGrafo, gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		
		// Boton Cancelar
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.05;
		gbc.weighty = 0.05;
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFocusable(false);
		this.add(botonCancelar, gbc);

		
		// Boton Siguiente
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		botonSiguiente = new JButton("Dar de alta una nueva línea");
		botonSiguiente.setFocusable(false);
		botonSiguiente.addActionListener(e -> {frame.dispose();
											   new VentanaAltaLineaDeTransporte();});
		this.add(botonSiguiente, gbc);
		
	}
}
