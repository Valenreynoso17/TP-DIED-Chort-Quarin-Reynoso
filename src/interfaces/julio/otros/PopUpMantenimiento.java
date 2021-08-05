package interfaces.julio.otros;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;

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
import interfaces.julio.paneles.PanelEstacionEditar;

public class PopUpMantenimiento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private JLabel label;
	private JButton button;
	
	private JTextField diaFechaInicio;
	private JTextField mesFechaInicio;
	private JTextField anioFechaInicio;
	private JTextArea texto;
	
	private LocalDate fechaHoy = LocalDate.now();

	
	public PopUpMantenimiento(PanelEstacionEditar frame, Vector filaSeleccionada){
		super("Registrar tarea de mantenimiento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 420);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(frame);
		
		this.setVisible(true);
		
		contentPane.setBorder(new TitledBorder (new LineBorder (Color.black, 1), "Dar de alta Estación"));
		
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		label = new JLabel("Fecha de inicio: ");
		c.anchor = GridBagConstraints.EAST;
		c.gridx = 0; c.gridy = 0;
		contentPane.add(label, c);
		
		diaFechaInicio = new JTextField(((Integer) fechaHoy.getDayOfMonth()).toString());
		diaFechaInicio.setEditable(false);
		diaFechaInicio.setHorizontalAlignment(JTextField.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5; c.weighty = 0.1;
		c.gridx = 1; c.gridy = 0;
		contentPane.add(diaFechaInicio, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		label = new JLabel("/");
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 0;
		contentPane.add(label, c);
		
		mesFechaInicio = new JTextField(((Integer) fechaHoy.getMonthValue()).toString());
		mesFechaInicio.setEditable(false);
		mesFechaInicio.setHorizontalAlignment(JTextField.CENTER);
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
		
		anioFechaInicio = new JTextField(((Integer) fechaHoy.getYear()).toString());
		anioFechaInicio.setEditable(false);
		anioFechaInicio.setHorizontalAlignment(JTextField.CENTER);
		c.weightx = 0.5;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 0;
		contentPane.add(anioFechaInicio, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0;
		
		
		label = new JLabel("Observaciones: ");
		c.insets = new Insets(0,10,0,0);
		c.anchor = GridBagConstraints.NORTH;
		c.gridx = 0; c.gridy = 1;

		contentPane.add(label, c);
		
		texto = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(texto);
		texto.setLineWrap(true);
		texto.setWrapStyleWord(true);
		c.insets = new Insets(0,0,0,20);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1; c.gridy = 1;
		c.gridheight = 2; c.gridwidth = 6;
		c.weightx = 0.5;
		contentPane.add(scrollPane, c);
		
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.0; c.weighty = 0.0;
		c.gridheight = 1;
		c.gridwidth = 1;
		
		button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0,10,0,0);
		c.gridx = 0;
		c.gridy = 3;
		c.weighty = 0.05;
		contentPane.add(button, c);
		
		button = new JButton("Registrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			
				frame.seCreoMantenimiento(filaSeleccionada, texto.getText());
				dispose(); 
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0,0,0,20);
		c.gridx = 6; c.gridy = 3;
		contentPane.add(button, c);
		
		
	}
	
	public JFrame getFrame() {
		return this;
	}

}