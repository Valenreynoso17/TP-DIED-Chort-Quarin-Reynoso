package interfaces.valen.frames;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import interfaces.fede.ventaBoleto.PanelGrafico;
import interfaces.valen.paneles.PanelAltaLineaDeTransporte;
import interfaces.valen.paneles.PanelRutaLineaDeTransporte;
import interfaces.valen.paneles.PanelTrayectoLineaDeTransporte;

public class VentanaAltaLineaDeTransporte extends JFrame{

	PanelAltaLineaDeTransporte panelAlta;
	PanelRutaLineaDeTransporte panelRuta;
	PanelTrayectoLineaDeTransporte panelTrayecto;
	GridBagConstraints gbc;
	JButton botonCancelar;
	JButton botonSiguiente;
	
	public VentanaAltaLineaDeTransporte() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Alta de una nueva línea");
		this.setLayout(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		
		// PanelAltaLinea
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		panelAlta = new PanelAltaLineaDeTransporte();
		this.add(panelAlta, gbc);
		
		//PanelGrafo
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.8;
		gbc.weighty = 0.8;
		gbc.gridheight = 3;
		PanelGrafico panelGrafo = new PanelGrafico();
		JScrollPane panelScrollGrafo = new JScrollPane(panelGrafo);
		panelScrollGrafo.setBorder(BorderFactory.createTitledBorder("Líneas de transporte"));
		this.add(panelScrollGrafo, gbc);
		gbc.gridheight = 1;
		
		// PanelRuta
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		gbc.gridheight = 2;
		panelRuta = new PanelRutaLineaDeTransporte();
		this.add(panelRuta, gbc);
		gbc.gridheight = 1;
		
		// PanelTrayecto
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panelTrayecto = new PanelTrayectoLineaDeTransporte();
		this.add(panelTrayecto, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		
		// Boton Cancelar
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.07;
		gbc.weighty = 0.07;
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFocusable(false);
		this.add(botonCancelar, gbc);
		
		// Boton Siguiente
		gbc.gridx = 1;
		gbc.gridy = 4;
		botonSiguiente = new JButton("Siguiente");
		botonSiguiente.setFocusable(false);
		this.add(botonSiguiente, gbc);
		
		this.setVisible(true);
	}
}
