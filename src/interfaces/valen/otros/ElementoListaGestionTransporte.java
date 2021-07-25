package interfaces.valen.otros;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class ElementoListaGestionTransporte extends JPanel{
	
	JLabel nombreLinea;
	JLabel estadoLinea;
	JButton botonEditar;
	JButton botonBorrar;
	GridBagConstraints gbc;
	
	public ElementoListaGestionTransporte(String nombre, String estado) {
		
		gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		
		nombreLinea = new JLabel(nombre);
		nombreLinea.setFont(new Font(null, Font.BOLD, 16));
		
		estadoLinea = new JLabel(estado);
		
		botonEditar = new JButton("Editar");
		botonEditar.setFocusable(false);
		botonEditar.setPreferredSize(new Dimension(50, 20));
		botonEditar.setMargin(new Insets(0, 0, 0, 0));
		
		botonBorrar = new JButton("Borrar");
		botonBorrar.setFocusable(false);
		botonBorrar.setPreferredSize(new Dimension(50, 20));
		botonBorrar.setMargin(new Insets(0, 0, 0, 0));
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.setLayout(new GridBagLayout());
		
		gbc.insets = new Insets(0,0,0,0);
		
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
		
//		this.setMaximumSize(new Dimension(115, 60));
		
	}
}
