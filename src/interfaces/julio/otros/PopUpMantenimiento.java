package interfaces.julio.otros;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import excepciones.InputInvalidaException;
import excepciones.InputVacioException;
import interfaces.julio.frames.EstacionAlta;
import interfaces.julio.frames.EstacionGestionar;
import interfaces.julio.paneles.PanelEstacionAlta;

public class PopUpMantenimiento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private JLabel label;
	private JButton button;
	
	private JTextField diaFechaInicio;
	private JTextField mesFechaInicio;
	private JTextField anioFechaInicio;
	private JTextField diaFechaFin;
	private JTextField mesFechaFin;
	private JTextField anioFechaFin;
	private JTextArea texto;

	/**
	 * Create the frame.
	 */
	public PopUpMantenimiento() {
		super("Registrar tarea de mantenimiento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 420);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		contentPane.setBorder(new TitledBorder (new LineBorder (Color.black, 1), "Dar de alta Estación"));
		
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		label = new JLabel("Fecha de inicio: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 0;
		contentPane.add(label, c);
		
		//c.anchor = GridBagConstraints.NONE;
		
		diaFechaInicio = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		contentPane.add(diaFechaInicio, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("/");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 0;
		contentPane.add(label, c);
		
		mesFechaInicio = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 0;
		contentPane.add(mesFechaInicio, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("/");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4;
		c.gridy = 0;
		contentPane.add(label, c);
		
		anioFechaInicio = new JTextField();
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 0;
		contentPane.add(anioFechaInicio, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("Fecha de fin: ");
		c.weighty = 0.1;
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0;
		c.gridy = 1;
		contentPane.add(label, c);
		
		diaFechaFin = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		contentPane.add(diaFechaFin, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.1;
		
		label = new JLabel("/");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 0.1;
		contentPane.add(label, c);
		
		mesFechaFin = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 1;
		c.weightx = 0.3;
		contentPane.add(mesFechaFin, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.1;
		
		label = new JLabel("/");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 4; c.gridy = 1;
		contentPane.add(label, c);
		
		anioFechaFin = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 5; c.gridy = 1;
		contentPane.add(anioFechaFin, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("Observaciones: ");
		c.anchor = GridBagConstraints.NORTH;
		c.gridx = 0; c.gridy = 2;

		contentPane.add(label, c);
		
		//c.anchor = GridBagConstraints.NONE;
		
		texto = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(texto);
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; c.gridy = 2;
		c.gridheight = 2; c.gridwidth = 6;
		c.weightx = 0.5;
		contentPane.add(scrollPane, c);
		
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
		c.weighty = 0.05;
		contentPane.add(button, c);
		
		button = new JButton("Registrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					inputEstaVacia();
					inputEsValida();
					
					dispose();
				
				}catch (InputVacioException IVE) {
					
					JOptionPane.showMessageDialog(getFrame(),
							IVE.getMessage(),
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}catch (InputInvalidaException IIE) {
					
					JOptionPane.showMessageDialog(getFrame(),
							IIE.getMessage(),	//VER
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.0;
		c.gridx = 6;
		c.gridy = 4;
		contentPane.add(button, c);
		
		
	}
	
	public void inputEstaVacia() throws InputVacioException{
		
		if(diaFechaInicio.getText().isEmpty() || mesFechaInicio.getText().isEmpty() || anioFechaInicio.getText().isEmpty() ||
				diaFechaFin.getText().isEmpty() || mesFechaFin.getText().isEmpty() || anioFechaFin.getText().isEmpty()) 
				throw new InputVacioException();
	}
	
	public void inputEsValida() throws InputInvalidaException{
		//TODO
		if(diaFechaInicio.getText().isEmpty() || mesFechaInicio.getText().isEmpty() || anioFechaInicio.getText().isEmpty() ||
				diaFechaFin.getText().isEmpty() || mesFechaFin.getText().isEmpty() || anioFechaFin.getText().isEmpty())
				throw new InputInvalidaException();
	}
	
	public JFrame getFrame() {
		return this;
	}

}