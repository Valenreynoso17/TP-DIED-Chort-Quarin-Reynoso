package interfaces.valen.otros;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import clases.LineaDeTransporte;
import enums.EstadoLineaDeTransporte;
import interfaces.valen.frames.VentanaEdicionLineaDeTransporte;
import interfaces.valen.frames.VentanaGestionLineasDeTransporte;

public class ElementoListaGestionTransporte extends JPanel{
	
	VentanaGestionLineasDeTransporte frameContenedor;
	LineaDeTransporte lineaDeTransporte;
	JLabel nombreLinea;
	JLabel estadoLinea;
	JButton botonEditar;
	JButton botonBorrar;
	GridBagConstraints gbc;
	
	public ElementoListaGestionTransporte(VentanaGestionLineasDeTransporte frame, LineaDeTransporte linea) {
		
		this.frameContenedor = frame;
		this.lineaDeTransporte = linea;
		
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		this.setLayout(new GridBagLayout());
		
		gbc = new GridBagConstraints();
		gbc.insets = new Insets(2,2,2,2);
		
		gbc.anchor = GridBagConstraints.WEST;
		
		nombreLinea = new JLabel(lineaDeTransporte.getNombre());
		nombreLinea.setFont(new Font(null, Font.BOLD, 16));
		
		if(lineaDeTransporte.getEstado() == EstadoLineaDeTransporte.ACTIVA)	estadoLinea = new JLabel("Activa");
		else estadoLinea = new JLabel("No activa");
		
		botonEditar = new JButton("Editar");
		botonEditar.setPreferredSize(new Dimension(50, 20));
		botonEditar.setMargin(new Insets(0,0,0,0));
		botonEditar.addActionListener(e -> {frameContenedor.dispose();
											new VentanaEdicionLineaDeTransporte(lineaDeTransporte);});
		
		botonBorrar = new JButton("Borrar");
		botonBorrar.setPreferredSize(new Dimension(50, 20));
		botonBorrar.setMargin(new Insets(0,0,0,0));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		this.add(nombreLinea, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		this.add(estadoLinea, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		this.add(botonEditar, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		this.add(botonBorrar, gbc);	
		
	}
}
