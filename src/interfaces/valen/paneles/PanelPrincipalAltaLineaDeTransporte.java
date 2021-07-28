package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import interfaces.fede.panelesGrafos.PanelGrafico;
import interfaces.valen.frames.VentanaAltaLineaDeTransporte;
import interfaces.valen.frames.VentanaSiguienteAltaLineaDeTransporte;

public class PanelPrincipalAltaLineaDeTransporte extends JPanel{
	
	PanelAltaLineaDeTransporte panelAlta;
	PanelRutaLineaDeTransporte panelRuta;
	PanelTrayectoLineaDeTransporte panelTrayecto;
	GridBagConstraints gbc;
	JButton botonCancelar;
	JButton botonSiguiente;
	
	public PanelPrincipalAltaLineaDeTransporte(VentanaAltaLineaDeTransporte frame) {
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		
		// PanelAltaLinea
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		panelAlta = new PanelAltaLineaDeTransporte();
		this.add(panelAlta, gbc);
		
		//PanelGrafo
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.gridheight = 3;
		PanelGrafico panelGrafo = new PanelGrafico();
		JScrollPane panelScrollGrafo = new JScrollPane(panelGrafo);
		panelScrollGrafo.setBorder(BorderFactory.createTitledBorder("Líneas de transporte"));
		this.add(panelScrollGrafo, gbc);
		gbc.gridheight = 1;
		gbc.weightx = 0.0;
		
		// PanelRuta
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
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
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		botonCancelar = new JButton("Cancelar");
		this.add(botonCancelar, gbc);
		
		// Boton Siguiente
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		botonSiguiente = new JButton("Siguiente");
		botonSiguiente.addActionListener(e -> {frame.dispose();
											   new VentanaSiguienteAltaLineaDeTransporte();});
		this.add(botonSiguiente, gbc);
	}
}
