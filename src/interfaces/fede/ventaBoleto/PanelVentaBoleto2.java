package interfaces.fede.ventaBoleto;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import clases.Estacion;
import clases.Recorrido;
import clases.Ruta;
import gestores.GestorRecorrido;
import gestores.GestorRuta;
import interfaces.fede.frames.FrameVentaBoleto2;

public class PanelVentaBoleto2 extends JPanel {
	private Estacion origen, destino;
	private GestorRecorrido gestorRecorridos;
	
	public PanelVentaBoleto2(Estacion origen, Estacion destino) {
		this.origen = origen;
		this.destino = destino;
		this.gestorRecorridos = GestorRecorrido.getInstance();
		
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addActionListener(e -> volverAtras());
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.gridx = 0;
		gbc_botonAtras.gridy = 1;
		this.add(botonAtras, gbc_botonAtras);
		
		
		List<Recorrido> recorridos = gestorRecorridos.getRecorridos(origen, destino);
		
		JTable tablaRecorridos = new JTable(new ModeloTablaRecorridos(recorridos));
		JScrollPane spTablaRecorridos = new JScrollPane(tablaRecorridos);
		spTablaRecorridos.setPreferredSize(new Dimension(500, 100));
		GridBagConstraints gbc_spTablaRecorridos = new GridBagConstraints();
		gbc_spTablaRecorridos.gridx = 1;
		gbc_spTablaRecorridos.gridy = 2;
		this.add(spTablaRecorridos, gbc_spTablaRecorridos);
		
		
		
	}
	
	public JFrame getPadre() {
		return (JFrame) this.getTopLevelAncestor();
	}
	
	public void volverAtras() {
		getPadre().dispose();
		((FrameVentaBoleto2) getPadre()).abriVentanaAnterior();
	}
}
