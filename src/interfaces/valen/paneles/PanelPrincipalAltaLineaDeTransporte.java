package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import clases.CustomColor;
import interfaces.fede.panelesGrafos.PanelGrafico;
import interfaces.valen.frames.VentanaAltaLineaDeTransporte;
import interfaces.valen.frames.VentanaGestionLineasDeTransporte;
import interfaces.valen.frames.VentanaSiguienteAltaLineaDeTransporte;
import interfaces.valen.otros.ElementoListaTrayecto;

public class PanelPrincipalAltaLineaDeTransporte extends JPanel{
	
	PanelAltaLineaDeTransporte panelAlta;
	PanelRutaLineaDeTransporte panelRuta;
	PanelTrayectoLineaDeTransporte panelTrayecto;
	GridBagConstraints gbc;
	JButton botonCancelar;
	JButton botonSiguiente;
	VentanaAltaLineaDeTransporte frame;
	
	List<ElementoListaTrayecto> listaTrayecto;
	
	public PanelPrincipalAltaLineaDeTransporte(VentanaAltaLineaDeTransporte frame) {
		
		this.frame = frame;
		listaTrayecto = new ArrayList<ElementoListaTrayecto>();
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		
		// PanelAltaLinea
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		panelAlta = new PanelAltaLineaDeTransporte(frame);
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
		panelRuta = new PanelRutaLineaDeTransporte(frame, this, listaTrayecto);
		this.add(panelRuta, gbc);
		gbc.gridheight = 1;
		
		// PanelTrayecto
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panelTrayecto = new PanelTrayectoLineaDeTransporte(listaTrayecto);
		this.add(panelTrayecto, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		
		// Boton Cancelar
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(e -> {frame.dispose();
											  new VentanaGestionLineasDeTransporte();});
		this.add(botonCancelar, gbc);
		
		// Boton Siguiente
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		botonSiguiente = new JButton("Siguiente");
		botonSiguiente.addActionListener(e -> this.checkearAntesDeSiguiente());
		this.add(botonSiguiente, gbc);
	}
	
	public void actualizar() {

		this.remove(panelRuta);
    	this.remove(panelTrayecto);
    	
    	this.revalidate();
    	this.repaint();
    	
    	gbc.fill = GridBagConstraints.BOTH;
    	gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridheight = 2;
		panelRuta = new PanelRutaLineaDeTransporte(frame, this, listaTrayecto);
		this.add(panelRuta, gbc);
		gbc.gridheight = 1;
    	
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panelTrayecto = new PanelTrayectoLineaDeTransporte(listaTrayecto);
		this.add(panelTrayecto, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
	}
	
	public void checkearAntesDeSiguiente() {
		frame.setVisible(false);
		this.checkearDatosDeLineaValidos(panelAlta.getNombreLinea(), panelAlta.getColorLinea());
		new VentanaSiguienteAltaLineaDeTransporte(frame, panelAlta.getNombreLinea(), panelAlta.getEstadoLinea(), panelAlta.getColorLinea());
	}
	
	public void checkearDatosDeLineaValidos(String nombre, CustomColor color) {
		
	}
}
