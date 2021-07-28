package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interfaces.valen.otros.ColorPicker;

public class PanelDatosLineaDeTransporte extends JPanel{

	JLabel labelNombreLinea;
	JTextField nombreLinea;
	JLabel labelEstado;
	JComboBox<String> estado;
	JLabel labelColor;
	JButton botonColor;
	//ColorPicker colorPicker;
	GridBagConstraints gbc;
	String[] opcionesEstado = {"Activa", "No activa"};
	
	public PanelDatosLineaDeTransporte() {
		
		this.setBorder(BorderFactory.createTitledBorder("Datos de la línea"));
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		// Componentes
		labelNombreLinea = new JLabel("Nombre de la línea:");
		nombreLinea = new JTextField("<<Nombre de la línea>>");
		labelEstado = new JLabel("Estado:");
		estado = new JComboBox<String>(opcionesEstado);
		labelColor = new JLabel("Color:");
		botonColor = new JButton("Color");
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridy = 0;
		
		gbc.gridx = 0;
		this.add(labelNombreLinea, gbc);
		
		gbc.gridx = 1;
		gbc.weightx = 1.0;
		this.add(nombreLinea, gbc);
		gbc.weightx = 0.0;
		
		gbc.gridx = 2;
		this.add(labelEstado, gbc);
		
		gbc.gridx = 3;
		this.add(estado, gbc);
		
		gbc.gridx = 4;
		this.add(labelColor, gbc);
		
		gbc.gridx = 5;
		this.add(botonColor, gbc);
	}
}
