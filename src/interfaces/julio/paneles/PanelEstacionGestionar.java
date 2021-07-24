package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clases.Estacion;
import enums.EstadoEstacion;
import interfaces.julio.frames.EstacionAlta;
import interfaces.julio.frames.EstacionGestionar;

public class PanelEstacionGestionar extends JPanel{
	
	private JLabel label;
	private JButton button;
	private JTextField field;
	private JPanel panelBusqueda;
	//private JTable tabla;
	
	private EstacionAlta frameAlta;
	
	public PanelEstacionGestionar(EstacionGestionar frame) {
		
		this.setFont(new Font("SansSerif", Font.PLAIN, 14));
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 5), "Gestionar Estaci�n"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		panelBusqueda = new PanelEstacionBusqueda();
		c.fill = GridBagConstraints.BOTH;
		//c.gridwidth = GridBagConstraints.BOTH;
		c.gridheight = 1;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0.1;
		this.add(panelBusqueda, c);
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = GridBagConstraints.NONE;
		
		panelBusqueda = new PanelEstacionTablaResultado(frame);
		c.fill = GridBagConstraints.BOTH;
		//c.gridwidth = GridBagConstraints.BOTH;
		c.gridheight = 1;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 1;
		c.weightx = 1;
		this.add(panelBusqueda, c);
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = GridBagConstraints.NONE;
		
		button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				//frameAnterior = new MenuPrincipal??();
				//frameAnterior.setVisible(true);
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.weighty = 0.1;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		this.add(button, c);
		
		button = new JButton("Dar de alta estaci�n");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				frameAlta = new EstacionAlta();
				frameAlta.setVisible(true);
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 3;
		this.add(button, c);
		
	
	
	}
	
}
