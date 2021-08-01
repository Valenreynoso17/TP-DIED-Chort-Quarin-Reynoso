package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import interfaces.julio.frames.EstacionAlta;
import interfaces.julio.frames.EstacionGestionar;
import interfaces.julio.frames.PageRank;

public class PanelPageRank extends JPanel{

	private JComboBox<String> comboBox;
	private JButton button;
	private JLabel label;
	
	private JTextField nombre;
	private JTextField horaApertura;
	private JTextField minutoApertura;
	private JTextField horaCierre;
	private JTextField minutoCierre;
	private JTextField estado;
	
	private EstacionGestionar frameAnterior;
	
	public PanelPageRank(PageRank frame) {
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 3), "Dar de alta Estación"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		label = new JLabel("Nombre: ");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1; c.gridy = 0;
		c.weighty = 0.1; c.weightx = 0.1;
		this.add(label, c);
		c.weightx = 0.0;
		
	}
	
}
