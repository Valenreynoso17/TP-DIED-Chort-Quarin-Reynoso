package interfaces.valen.frames;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import interfaces.valen.paneles.PanelListadoGestionLineas;
import interfaces.ventaBoleto.PanelGrafico;

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
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		PanelListadoGestionLineas panelListado = new PanelListadoGestionLineas();
		this.add(panelListado, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		//PanelGrafico panelGrafo = new PanelGrafico();
		//JScrollPane panelScrollGrafo = new JScrollPane(panelGrafo);
		JScrollPane panelScrollGrafo = new JScrollPane();
		panelScrollGrafo.setBorder(BorderFactory.createTitledBorder("Líneas de transporte"));
		this.add(panelScrollGrafo, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		JButton botonCancelar = new JButton("Cancelar");
		this.add(botonCancelar, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		JButton botonSiguiente = new JButton("Dar de alta una nueva línea");
		this.add(botonSiguiente, gbc);
		
		this.setVisible(true);
	}
}
