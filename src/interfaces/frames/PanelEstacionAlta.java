package interfaces.frames;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelEstacionAlta extends JPanel{
	
	private JComboBox<String> comboBox;
	private JButton button;
	private JTextField field;
	private JLabel label;
	
	public PanelEstacionAlta() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		label = new JLabel("Id:? ");
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		this.add(field, c);
		
		label = new JLabel("Nombre: ");
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		this.add(field, c);
		
		label = new JLabel("Horario de apertura: ");
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		this.add(field, c);
		
		label = new JLabel(":");
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		this.add(field, c);
		
		label = new JLabel("Horario de cierre: ");
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		this.add(field, c);
		
		label = new JLabel(":");
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		this.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.2;
		c.weighty = 0.5;
		this.add(field, c);
		
		label = new JLabel("Estado: ");
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		this.add(label, c);
		
		comboBox = new JComboBox<String>();
		comboBox.addItem("OPERATIVA");
		comboBox.addItem("EN MANTENIMIENTO");
		
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		this.add(comboBox, c);
		
		button = new JButton("Salir");
		c.fill = GridBagConstraints.LINE_START;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		this.add(button, c);
		
		button = new JButton("Crear");
		c.fill = GridBagConstraints.LINE_END;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 5;
		this.add(button, c);
		
//		button = new JButton("Button 2");
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.weightx = 0.5;
//		c.gridx = 1;
//		c.gridy = 0;
//		this.add(button, c);
//
//		button = new JButton("Button 3");
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.weightx = 0.5;
//		c.gridx = 2;
//		c.gridy = 0;
//		this.add(button, c);
//
//		button = new JButton("Long-Named Button 4");
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.ipady = 40;      //make this component tall
//		c.weightx = 0.0;
//		c.gridwidth = 3;
//		c.gridx = 0;
//		c.gridy = 1;
//		this.add(button, c);
//
//		button = new JButton("5");
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.ipady = 0;       //reset to default
//		c.weighty = 1.0;   //request any extra vertical space
//		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
//		c.insets = new Insets(10,0,0,0);  //top padding
//		c.gridx = 1;       //aligned with button 2
//		c.gridwidth = 2;   //2 columns wide
//		c.gridy = 2;       //third row
//		this.add(button, c);
	
	
	
	
	}

}
