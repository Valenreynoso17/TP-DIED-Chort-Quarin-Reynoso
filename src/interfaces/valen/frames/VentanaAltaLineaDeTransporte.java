package interfaces.valen.frames;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

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
		
		// PanelAltaLinea
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelAlta = new PanelAltaLineaDeTransporte();
		this.add(panelAlta, gbc);
		
		//PanelGrafo
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		//PanelGrafico panelGrafo = new PanelGrafico();
		//JScrollPane panelScrollGrafo = new JScrollPane(panelGrafo);
		JScrollPane panelScrollGrafo = new JScrollPane();
		panelScrollGrafo.setBorder(BorderFactory.createTitledBorder("Líneas de transporte"));
		this.add(panelScrollGrafo, gbc);
		gbc.gridheight = 1;
		
		// PanelRuta
		gbc.gridx = 0;
		gbc.gridy = 1;
		panelRuta = new PanelRutaLineaDeTransporte();
		this.add(panelRuta, gbc);
		
		// PanelTrayecto
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panelTrayecto = new PanelTrayectoLineaDeTransporte();
		this.add(panelTrayecto, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = GridBagConstraints.NONE;
		
		// Boton Cancelar
		gbc.gridx = 0;
		gbc.gridy = 3;
		botonCancelar = new JButton("Cancelar");
		this.add(botonCancelar, gbc);
		
		// Boton Siguiente
		gbc.gridx = 1;
		gbc.gridy = 3;
		botonSiguiente = new JButton("Siguiente");
		this.add(botonSiguiente, gbc);
		
		this.setVisible(true);
	}
}
