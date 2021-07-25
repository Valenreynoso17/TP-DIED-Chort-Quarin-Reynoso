package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelEstacionBusqueda extends JPanel {
	
	private JLabel label;
	private JButton button;
	private JTextField field;
	
	public PanelEstacionBusqueda() {
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 2), "Búsqueda de Estaciones"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		label = new JLabel("Id:? ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.1;
		c.weighty = 0.1;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		this.add(field, c);
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Nombre: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 3;
		c.gridy = 0;
		c.weightx = 0.2;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		c.weightx = 0.1;
		this.add(field, c);
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Horario de apertura: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 0.1;
		c.weighty = 0.1;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 1;
		this.add(field, c);
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Horario de cierre: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 3;
		c.gridy = 1;
		c.weightx = 0.2;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 1;
		c.weightx = 0.1;
		this.add(field, c);
		c.fill = GridBagConstraints.NONE;
		
		button = new JButton("Buscar estación");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 3;
		c.gridy = 2;
		this.add(button, c);
	}

}
