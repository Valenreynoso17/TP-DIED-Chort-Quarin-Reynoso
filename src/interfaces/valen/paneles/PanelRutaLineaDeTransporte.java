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

public class PanelRutaLineaDeTransporte extends JPanel{

	JLabel labelSeleccione;
	JComboBox<String> estacionOrigen;
	JComboBox<String> estacionDestino;
	JLabel labelDistancia;
	JTextField distancia;
	JLabel labelDuracion;
	JTextField duracion;
	JLabel labelCantMaxPasajeros;
	JTextField cantMaxPasajeros;
	JLabel labelEstadoRuta;
	JComboBox<String> estadoRuta;
	JLabel labelCosto;
	JTextField costo;
	JButton botonAgregar;
	GridBagConstraints gbc;
	String[] opcionesEstaciones = {"A", "B", "C"};
	String[] opcionesEstado = {"Activa", "No activa"};
	
	public PanelRutaLineaDeTransporte() {
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		this.setBorder(BorderFactory.createTitledBorder("Ruta"));
		
		// Componentes
		labelSeleccione = new JLabel("Seleccione una ruta");
		estacionOrigen = new JComboBox<String>(opcionesEstaciones);
		estacionDestino = new JComboBox<String>(opcionesEstaciones);
		labelDistancia = new JLabel("Distancia:");
		distancia = new JTextField("Kilómetros");
		labelDuracion = new JLabel("Duración del viaje:");
		duracion = new JTextField("Minutos");
		labelCantMaxPasajeros = new JLabel("Cantidad máxima de pasajeros a transportar:");
		cantMaxPasajeros = new JTextField("Unidades");
		labelEstadoRuta = new JLabel("Estado ruta:");
		estadoRuta = new JComboBox<String>(opcionesEstado);
		labelCosto = new JLabel("Costo:");
		costo = new JTextField("Pesos");
		botonAgregar = new JButton("Agregar nueva ruta");
		botonAgregar.setFocusable(false);
		
		// Agregando padding
		gbc.insets = new Insets(5,5,5,5);
		
//		gbc.anchor = GridBagConstraints.WEST;
		
		// Agregando componentes
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		this.add(labelSeleccione, gbc);
		gbc.gridwidth = 1;
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(estacionOrigen, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.add(estacionDestino, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(labelDistancia, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(distancia, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		this.add(labelDuracion, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(duracion, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		this.add(labelCantMaxPasajeros, gbc);
		gbc.gridwidth = 1;
		
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(cantMaxPasajeros, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(labelEstadoRuta, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(estadoRuta, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		this.add(labelCosto, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(costo, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		this.add(botonAgregar, gbc);
		gbc.gridwidth = 1;
		
		
	}
}
