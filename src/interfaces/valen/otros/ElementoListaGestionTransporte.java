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
import gestores.GestorLineaDeTransporte;
import interfaces.valen.frames.VentanaEdicionLineaDeTransporte;
import interfaces.valen.frames.VentanaGestionLineasDeTransporte;
import interfaces.valen.paneles.PanelListadoGestionLineas;

public class ElementoListaGestionTransporte extends JPanel{
	
	VentanaGestionLineasDeTransporte frameContenedor;
	LineaDeTransporte lineaDeTransporte;
	JLabel nombreLinea;
	JLabel estadoLinea;
	JButton botonEditar;
	JButton botonBorrar;
	GridBagConstraints gbc;
	GestorLineaDeTransporte gestorLineas;
	
	public ElementoListaGestionTransporte(VentanaGestionLineasDeTransporte frame,PanelListadoGestionLineas panel, LineaDeTransporte linea) {
		
		this.frameContenedor = frame;
		this.lineaDeTransporte = linea;
		gestorLineas = GestorLineaDeTransporte.getInstance();
		
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
		botonBorrar.addActionListener(e -> {
			//Custom JOptionPane
			Object[] options = {"Cancelar",
			                    "Confirmar"};
			int n = JOptionPane.showOptionDialog(frame,
			    "Está seguro que desea eliminar esta línea de transporte del sistema?",
			    "Confirmar eliminación",
			    JOptionPane.YES_NO_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options,
			    options[0]);
			
			if(n == JOptionPane.NO_OPTION) {
				gestorLineas.borrarLineaDeTransporte(linea);
				panel.actualizarPanelGridLista();
			} 
		});
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 3;
		gbc.fill = GridBagConstraints.VERTICAL;
		JPanel panelColor = new JPanel();
		panelColor.setBackground(lineaDeTransporte.getColor());
		this.add(panelColor, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridheight = 1;
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		this.add(nombreLinea, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		this.add(estadoLinea, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		this.add(botonEditar, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		this.add(botonBorrar, gbc);	
		
	}
}
