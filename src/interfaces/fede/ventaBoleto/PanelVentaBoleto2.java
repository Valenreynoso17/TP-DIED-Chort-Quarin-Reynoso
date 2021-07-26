package interfaces.fede.ventaBoleto;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clases.Estacion;
import interfaces.fede.frames.FrameVentaBoleto2;

public class PanelVentaBoleto2 extends JPanel {
	private Estacion origen, destino;
	
	public PanelVentaBoleto2(Estacion origen, Estacion destino) {
		this.origen = origen;
		this.destino = destino;
		
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addActionListener(e -> volverAtras());
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.gridx = 0;
		gbc_botonAtras.gridy = 1;
		this.add(botonAtras, gbc_botonAtras);
		
		JLabel lbl1 = new JLabel(origen.toString());
		GridBagConstraints gbc_lbl1 = new GridBagConstraints();
		gbc_lbl1.gridx = 0;
		gbc_lbl1.gridy = 2;
		this.add(lbl1, gbc_lbl1);
	}
	
	public JFrame getPadre() {
		return (JFrame) this.getTopLevelAncestor();
	}
	
	public void volverAtras() {
		getPadre().dispose();
		((FrameVentaBoleto2) getPadre()).abriVentanaAnterior();
	}
}
