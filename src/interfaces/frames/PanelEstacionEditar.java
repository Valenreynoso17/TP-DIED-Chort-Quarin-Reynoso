package interfaces.frames;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanelEstacionEditar extends JPanel{

	
	private JComboBox<String> comboBox;
	private JButton button;
	private JTextField field;
	private JLabel label;
	
	private EstacionGestionar frameAnterior;
	
	public PanelEstacionEditar(EstacionEditar frame) {
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 5), "Editar Estación"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		label = new JLabel("Id:? ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.0;
		c.weighty = 0.1;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Nombre: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 1;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Horario de apertura: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 2;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 2;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 2;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel("Horario de cierre: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 3;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		
		label = new JLabel(":");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 3;
		c.weightx = 0.1;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 3;
		c.weightx = 0.3;
		this.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("Estado: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 4;
		this.add(label, c);
		
		comboBox = new JComboBox<String>();
		comboBox.addItem("OPERATIVA");
		comboBox.addItem("EN MANTENIMIENTO");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 4;
		this.add(comboBox, c);
		
		button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				frameAnterior = new EstacionGestionar();
				frameAnterior.setVisible(true);
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		this.add(button, c);
		
		button = new JButton("Confirmar edición");
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 4;
		c.gridy = 5;
		this.add(button, c);
		
	}

	
}
