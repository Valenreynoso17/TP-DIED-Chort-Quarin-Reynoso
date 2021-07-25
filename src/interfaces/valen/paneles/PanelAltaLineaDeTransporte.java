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

public class PanelAltaLineaDeTransporte extends JPanel{

	GridBagConstraints gbc;
	JLabel labelNombre;
	JTextField nombreLinea;
	JLabel labelEstado;
	JComboBox<String> estado;
	JLabel labelColor;
	String[] opcionesEstado = {"Activa", "No activa"};
	
	public PanelAltaLineaDeTransporte() {
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		this.setBorder(BorderFactory.createTitledBorder("Alta de una nueva línea"));
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		// Componentes del panel
		labelNombre = new JLabel("Nombre:");
		nombreLinea = new JTextField("Ingrese el nombre de la línea");
		labelEstado = new JLabel("Estado:");
		estado = new JComboBox<String>(opcionesEstado);
		labelColor = new JLabel("Color:");
		//TODO: agregar el color picker
		
		// Agregando padding
		gbc.insets = new Insets(5,5,5,5);
		
		// Agregando los componentes al panel		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(labelNombre, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(nombreLinea, gbc);
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 1;
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(labelEstado, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(estado, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		this.add(labelColor, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 1;
		this.add(new JButton("ColorPicker"), gbc);
	}
}
