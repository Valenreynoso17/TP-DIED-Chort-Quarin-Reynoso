package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import interfaces.julio.frames.MenuPrincipal;
import interfaces.julio.frames.ProximoMantenimiento;

public class PanelProximoMantenimiento extends JPanel{

	private JButton button;
	private JLabel label;
	
	public PanelProximoMantenimiento(ProximoMantenimiento frame) {
		
this.setBorder(new TitledBorder (new LineBorder (Color.black, 3), "Próximo mantenimiento"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		label = new JLabel("Para la próxima versión.");
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		this.add(label, c);
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.1;
		c.weighty = 0.2;
		c.gridwidth = 1;
		
		
		button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new MenuPrincipal();
			}
		});
		c.insets = new Insets(0,100,20,0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		this.add(button, c);
		
	}
	
}
