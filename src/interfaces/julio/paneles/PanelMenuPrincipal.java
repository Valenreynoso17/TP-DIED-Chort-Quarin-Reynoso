package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import interfaces.julio.frames.EstacionEditar;
import interfaces.julio.frames.EstacionGestionar;
import interfaces.julio.frames.MenuPrincipal;
import interfaces.julio.otros.PopUpMantenimiento;

public class PanelMenuPrincipal extends JPanel{
	
	private JButton button;
	private JLabel label;
	
	private EstacionGestionar frameEstacionGestionar;
	private PopUpMantenimiento popUpMantenimiento;
	
	
	public PanelMenuPrincipal(MenuPrincipal frame) {
		
	this.setBorder(new TitledBorder (new LineBorder (Color.black, 3), "Menú principal"));
	
	this.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	label = new JLabel("TP DIED 2021");
	c.anchor = GridBagConstraints.CENTER;
	c.gridx = 0; c.gridy = 0;
	c.gridwidth = 2;
	this.add(label, c);
	c.gridwidth = 1;
	
	button = new JButton("Gestionar estaciones");
	c.anchor = GridBagConstraints.CENTER;
	c.gridx = 0; c.gridy = 1;
	c.weighty = 0.1; c.weightx = 0.1;
	this.add(button, c);
	
	button = new JButton("Gestionar trayectos");
	c.gridx = 1; c.gridy = 1;
	this.add(button, c);
	
	button = new JButton("Hacer algo");
	c.gridx = 0; c.gridy = 2;
	this.add(button, c);
	
	button = new JButton("Hacer algo 2");
	c.gridx = 1; c.gridy = 2;
	this.add(button, c);
	
	button = new JButton("Hacer algo 3");
	c.gridx = 0; c.gridy = 3;
	this.add(button, c);
	
	button = new JButton("SALIR");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
		}
	});
	c.gridx = 1; c.gridy = 3;
	this.add(button, c);

	}
	
}
