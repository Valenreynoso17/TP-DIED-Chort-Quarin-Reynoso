package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ElementoListaEdicionLineaDeTransporte extends JPanel{

	JLabel 	labelEstacionOrigen, labelEstacionDestino, labelDistancia, labelDuracion,
			labelEstadoRuta, labelCantMaxPasajeros, labelCosto;
	JComboBox<String> estacionOrigen, estacionDestino, estado;
	JTextField distancia, duracion, cantMaxPasajeros, costo;
	GridBagConstraints gbc;
	
	String[] opcionesEstaciones = {"A", "B", "C"};
	String[] opcionesEstado = {"Activa", "No activa"};
	
	public ElementoListaEdicionLineaDeTransporte() {
		
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
		
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		estacionOrigen = new JComboBox<String>(opcionesEstaciones);
		this.add(estacionOrigen, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 2;
		labelDistancia = new JLabel("Distancia [km]:");
		this.add(labelDistancia, gbc);
		
		gbc.gridx = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		distancia = new JTextField("<<km>>");
		this.add(distancia, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 4;
		labelDuracion = new JLabel("Duracion [min]:");
		this.add(labelDuracion, gbc);
		
		gbc.gridx = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		duracion = new JTextField("<<min>>");
		this.add(duracion, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 6;
		labelEstadoRuta = new JLabel("Estado ruta:");
		this.add(labelEstadoRuta, gbc);
		
		gbc.gridx = 7;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		estado = new JComboBox<String>(opcionesEstado);
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
		this.add(estacionDestino, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 2;
		gbc.gridwidth = 2;
		labelCantMaxPasajeros = new JLabel("Cantidad máxima de pasajeros:");
		this.add(labelCantMaxPasajeros,gbc);
		gbc.gridwidth = 1;
		
		gbc.gridx = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		cantMaxPasajeros = new JTextField("<<cant>>");
		this.add(cantMaxPasajeros, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		gbc.gridx = 6;
		labelCosto = new JLabel("Costo:");
		this.add(labelCosto, gbc);
		
		gbc.gridx = 7;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		costo = new JTextField("<<$>>");
		this.add(costo, gbc);
		gbc.fill = GridBagConstraints.NONE;
		
		
		}
}
