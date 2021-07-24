package interfaces.otros;

import java.awt.Color;

import javax.swing.*;

public class ElementoListaGestionTransporte extends JPanel{
	
	JLabel nombreLinea;
	JLabel estadoLinea;
	JButton botonEditar;
	JButton botonBorrar;
	
	public ElementoListaGestionTransporte(String nombre, String estado) {
		nombreLinea = new JLabel(nombre);
		estadoLinea = new JLabel(estado);
		botonEditar = new JButton("Editar");
		botonBorrar = new JButton("Borrar");
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(nombreLinea);
		
		JPanel panelBotones = new JPanel();
		panelBotones.add(botonEditar);
		panelBotones.add(botonBorrar);
		this.add(panelBotones);
		
		this.add(estadoLinea);
	}
}
