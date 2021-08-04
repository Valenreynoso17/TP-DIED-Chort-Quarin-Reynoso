package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import clases.LineaDeTransporte;
import clases.Ruta;
import enums.EstadoRuta;
import gestores.GestorEstacion;

public class ElementoListaEdicionLineaDeTransporte extends JPanel{

	Ruta ruta;
	JLabel 	labelEstacionOrigen, labelEstacionDestino, labelDistancia, labelDuracion,
			labelEstadoRuta, labelCantMaxPasajeros, labelCosto;
	JComboBox<String> estacionOrigen, estacionDestino, estado;
	JTextField distancia, duracion, cantMaxPasajeros, costo;
	GridBagConstraints gbc;
	String[] opcionesEstaciones;
	String[] opcionesEstado = {"Activa", "No activa"};
	
	public ElementoListaEdicionLineaDeTransporte(Ruta ruta) {
		
		this.ruta = ruta;
		
		this.setSize(new Dimension(602,60));
		this.setMaximumSize(new Dimension(602,60));
		this.setMinimumSize(new Dimension(602,60));
		this.setPreferredSize(new Dimension(602,60));
		
		this.setLayout(new GridBagLayout());
		this.setBorder(new LineBorder(Color.GRAY,1));
		gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(2,0,2,0);
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		// Primera fila
		gbc.gridy = 0;
		
		gbc.gridx = 0;
		labelEstacionOrigen = new JLabel("Estación origen:");
		this.add(labelEstacionOrigen, gbc);
		
		this.obtenerEstaciones();
		
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		estacionOrigen = new JComboBox<String>(opcionesEstaciones);
		estacionOrigen.setSelectedItem(ruta.getStringOrigen());
		estacionOrigen.setEnabled(false);
		this.add(estacionOrigen, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 2;
		labelDistancia = new JLabel("Distancia [km]:");
		this.add(labelDistancia, gbc);
		
		gbc.gridx = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		distancia = new JTextField(String.valueOf(ruta.getDistancia()));
		this.add(distancia, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 4;
		labelDuracion = new JLabel("Duracion [min]:");
		this.add(labelDuracion, gbc);
		
		gbc.gridx = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		duracion = new JTextField(String.valueOf(ruta.getDuracion()));
		this.add(duracion, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 6;
		labelEstadoRuta = new JLabel("Estado ruta:");
		this.add(labelEstadoRuta, gbc);
		
		gbc.gridx = 7;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		estado = new JComboBox<String>(opcionesEstado);
		if(ruta.getEstado() == EstadoRuta.ACTIVA) {
			estado.setSelectedItem("Activa");
		}
		else {
			estado.setSelectedItem("No activa");
		}

		this.add(estado, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		// Segunda fila
		gbc.gridy = 1;
		
		gbc.gridx = 0;
		labelEstacionDestino = new JLabel("Estación destino:");
		this.add(labelEstacionDestino, gbc);
		
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		estacionDestino = new JComboBox<String>(opcionesEstaciones);
		estacionDestino.setSelectedItem(ruta.getStringDestino());
		estacionDestino.setEnabled(false);
		this.add(estacionDestino, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		labelCantMaxPasajeros = new JLabel("Cantidad máxima de pasajeros:");
		this.add(labelCantMaxPasajeros,gbc);
		gbc.gridwidth = 1;
		
		gbc.gridx = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		cantMaxPasajeros = new JTextField(String.valueOf(ruta.getCantMaxPasajeros()));
		this.add(cantMaxPasajeros, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 6;
		labelCosto = new JLabel("Costo:");
		this.add(labelCosto, gbc);
		
		gbc.gridx = 7;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		costo = new JTextField(String.valueOf(ruta.getCosto()));
		this.add(costo, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
	}
	
	private void obtenerEstaciones() {
		GestorEstacion gestorEstacion = GestorEstacion.getInstance();
		List<String> listaEstaciones = gestorEstacion.getStringEstaciones();
		String[] arrayEstaciones = new String[listaEstaciones.size()];
		listaEstaciones.toArray(arrayEstaciones);
		opcionesEstaciones = new String[listaEstaciones.size()];
		listaEstaciones.toArray(opcionesEstaciones);
	}
	
	public String getStringOrigen() {
		return (String) estacionOrigen.getSelectedItem();
	}
	
	public String getStringDestino() {
		return (String) estacionDestino.getSelectedItem();
	}
	
	public String getDistancia() {
		return distancia.getText();
	}
	
	public String getDuracion() {
		return duracion.getText();
	}
	
	public String getCantMaxPasajeros() {
		return cantMaxPasajeros.getText();
	}
	
	public String getCosto() {
		return costo.getText();
	}
	
	public Ruta getRuta() {
		return ruta;
	}
	
	public String getEstado() {
		return (String) estado.getSelectedItem();
	}
}
