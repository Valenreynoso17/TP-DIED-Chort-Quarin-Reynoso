package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import interfaces.fede.panelesGrafos.PanelPintaTodo;
import interfaces.julio.frames.MenuPrincipal;
import interfaces.valen.frames.VentanaAltaLineaDeTransporte;
import interfaces.valen.frames.VentanaGestionLineasDeTransporte;

public class PanelPrincipalGestionLineasDeTransporte extends JPanel{
	
	GridBagLayout gbLayout;
	GridBagConstraints gbc;
	PanelListadoGestionLineas panelListado;
	PanelPintaTodo panelGrafo;
	JScrollPane panelScrollGrafo;
	JButton botonCancelar;
	JButton botonSiguiente;
	
	public PanelPrincipalGestionLineasDeTransporte(VentanaGestionLineasDeTransporte frame) {
		
		this.setLayout(new GridBagLayout());	
		gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		
		// PanelListado
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.05;
		gbc.weighty = 0.05;
		panelListado = new PanelListadoGestionLineas(frame, this);
		this.add(panelListado, gbc);
		
		// PanelGrafo
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.95;
		gbc.weighty = 0.95;
		panelGrafo = new PanelPintaTodo();
		panelScrollGrafo = new JScrollPane(panelGrafo);
		panelScrollGrafo.setBorder(new TitledBorder (new LineBorder (Color.black, 1),"L�neas de transporte"));
		this.add(panelScrollGrafo, gbc);
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(5, 5, 5, 5);
		
		// Boton Cancelar
		gbc.gridx = 0;
		gbc.gridy = 1;
		botonCancelar = new JButton("Volver");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new MenuPrincipal();
			}
		});
		botonCancelar.setFocusable(false);
		this.add(botonCancelar, gbc);

		
		// Boton Siguiente
		gbc.gridx = 1;
		gbc.gridy = 1;
		botonSiguiente = new JButton("Dar de alta una nueva l�nea");
		botonSiguiente.setFocusable(false);
		botonSiguiente.addActionListener(e -> {frame.dispose();
											   new VentanaAltaLineaDeTransporte();});
		this.add(botonSiguiente, gbc);
		
		gbc.insets = new Insets(0, 0, 0, 0);
	}
	
	public void actualizarPanelGrafico() {
		this.remove(panelScrollGrafo);
		this.remove(panelGrafo);
    	
    	this.revalidate();
    	this.repaint();
    	
    	gbc.fill = GridBagConstraints.BOTH;
    	gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.95;
		gbc.weighty = 0.95;
		panelGrafo = new PanelPintaTodo();
		panelScrollGrafo = new JScrollPane(panelGrafo);
		panelScrollGrafo.setBorder(new TitledBorder (new LineBorder (Color.black, 1), "L�neas de transporte"));
		this.add(panelScrollGrafo, gbc);
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		
	}
}
