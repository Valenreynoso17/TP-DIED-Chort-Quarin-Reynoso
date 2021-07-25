package interfaces.julio.otros;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import interfaces.julio.frames.EstacionAlta;
import interfaces.julio.frames.EstacionGestionar;
import interfaces.julio.paneles.PanelEstacionAlta;

public class PopUpMantenimiento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private JLabel label;
	private JButton button;
	private JTextField field;

	/**
	 * Create the frame.
	 */
	public PopUpMantenimiento() {
		super("Registrar tarea de mantenimiento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		contentPane.setBorder(new TitledBorder (new LineBorder (Color.black, 5), "Dar de alta Estación"));
		
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		label = new JLabel("Fecha de inicio: ");
		c.weighty = 0.1;
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 0;
		contentPane.add(label, c);
		
		//c.anchor = GridBagConstraints.NONE;
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		contentPane.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("/");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 0;
		contentPane.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 0;
		contentPane.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("/");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 0;
		contentPane.add(label, c);
		
		field = new JTextField();
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 0;
		contentPane.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("Fecha de fin: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 1;
		contentPane.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		contentPane.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.1;
		
		label = new JLabel("/");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 0.1;
		contentPane.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 1;
		c.weightx = 0.3;
		contentPane.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.1;
		
		label = new JLabel("/");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 1;
		contentPane.add(label, c);
		
		field = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 5;
		c.gridy = 1;
		contentPane.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("Observaciones: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 2;
		contentPane.add(label, c);
		
		//c.anchor = GridBagConstraints.NONE;
		
		field = new JTextField();
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = 2;
		c.gridwidth = 6;
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 0.5;
		contentPane.add(field, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		c.gridheight = 1;
		c.gridwidth = 1;
		
		button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.gridx = 0;
		c.gridy = 4;
		contentPane.add(button, c);
		
		button = new JButton("Registrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.gridx = 6;
		c.gridy = 4;
		contentPane.add(button, c);
		
		
	}

}