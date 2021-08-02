package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interfaces.valen.paneles.PanelGridListaGestionLineas;

public class PanelEstacionBusqueda extends JPanel{
	
	private JLabel label;
	private JButton button;
	private JTextField field;
	
	public PanelEstacionBusqueda() {
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 1), "Búsqueda de Estaciones"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		label = new JLabel("Id: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 0;
		c.weighty = 0.1;
		c.gridheight = 1; c.gridwidth = 1;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1; c.gridy = 0;
		c.gridwidth = 3;
		//c.weightx = 0.1;
		this.add(field, c);
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = 1;
		//c.weightx = 0.0;
		
		label = new JLabel("Nombre: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 5; c.gridy = 0;
		c.weightx = 0.1;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6; c.gridy = 0;
		c.gridwidth = 3;
		//c.weightx = 0.1;
		this.add(field, c);
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = 1;
		//c.weightx = 0.0;
		
		label = new JLabel("Horario de apertura: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0; c.gridy = 1;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1; c.gridy = 1;
		c.weightx = 0.1;
		this.add(field, c);
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2; c.gridy = 1;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3; c.gridy = 1;
		this.add(field, c);
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("Horario de cierre: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 5; c.gridy = 1;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 6; c.gridy = 1;
		c.weightx = 0.1;
		this.add(field, c);
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 7; c.gridy = 1;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 8; c.gridy = 1;
		this.add(field, c);
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		button = new JButton("Buscar estación");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4; c.gridy = 2;
		this.add(button, c);
	}

}
