package interfaces.valen.otros;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.*;

public class ElementoListaGestionTransporte extends JPanel{
	
	JLabel nombreLinea;
	JLabel estadoLinea;
	JButton botonEditar;
	JButton botonBorrar;
	
	public ElementoListaGestionTransporte(String nombre, String estado) {
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
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(nombreLinea);
		this.add(estadoLinea);
		JPanel panelBotones = new JPanel();
		panelBotones.add(botonEditar);
		panelBotones.add(botonBorrar);
		this.add(panelBotones);
		
		
	}
}
