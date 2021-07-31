package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Estacion;
import gestores.GestorEstacion;
import interfaces.valen.otros.TextPrompt;

public class PanelRutaLineaDeTransporte extends JPanel{

	GestorEstacion gestorEstacion;
	
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
		
		gestorEstacion = GestorEstacion.getInstance();
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		this.setBorder(BorderFactory.createTitledBorder("Ruta"));
		
		// Componentes
		labelSeleccione = new JLabel("Seleccione una ruta");
		
		this.obtenerEstaciones();
		
		estacionOrigen = new JComboBox<String>(opcionesEstaciones);
		estacionDestino = new JComboBox<String>(opcionesEstaciones);
		
		labelDistancia = new JLabel("Distancia:");
		distancia = new JTextField();
		TextPrompt tpDistancia = new TextPrompt("Kilómetros", distancia);
		labelDuracion = new JLabel("Duración del viaje:");
		duracion = new JTextField();
		TextPrompt tpDuracion = new TextPrompt("Minutos", duracion);
		labelCantMaxPasajeros = new JLabel("Cantidad máxima pasajeros:");
		cantMaxPasajeros = new JTextField();
		TextPrompt tpCantMaxPasajeros = new TextPrompt("Pasajeros", cantMaxPasajeros);
		labelEstadoRuta = new JLabel("Estado ruta:");
		estadoRuta = new JComboBox<String>(opcionesEstado);
		labelCosto = new JLabel("Costo:");
		costo = new JTextField();
		TextPrompt tpCosto = new TextPrompt("Pesos", costo);
		botonAgregar = new JButton("Agregar nueva ruta");
		
		// Agregando padding
//		gbc.insets = new Insets(5,5,5,5);
		
		gbc.weighty = 1.0;	
		gbc.weightx = 1.0;
		
		// Agregando componentes
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(labelSeleccione, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(estacionOrigen, gbc);
		
		gbc.gridx = 1;
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
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(labelDuracion, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(duracion, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(labelCantMaxPasajeros, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(cantMaxPasajeros, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(labelEstadoRuta, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(estadoRuta, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 6;;
		this.add(labelCosto, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(costo, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(botonAgregar, gbc);
		gbc.gridwidth = 1;
		
	}
	
	private void obtenerEstaciones() {
		List<String> listaEstaciones = gestorEstacion.getStringEstaciones();
		String[] arrayEstaciones = new String[listaEstaciones.size()];
		listaEstaciones.toArray(arrayEstaciones);
//		opcionesEstaciones = new String[listaEstaciones.size()];
//		listaEstaciones.toArray(opcionesEstaciones);
		System.out.println(arrayEstaciones);
		
//		Foo[] array = new Foo[list.size()];
//		list.toArray(array); // fill the array
	}
}
