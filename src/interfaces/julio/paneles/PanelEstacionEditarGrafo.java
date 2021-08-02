package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import interfaces.julio.frames.EstacionEditarGrafo;
import interfaces.julio.frames.EstacionGestionar;

public class PanelEstacionEditarGrafo extends JPanel{
	
	private EstacionGestionar frameAnterior;
	
	private JButton button;
	
	public PanelEstacionEditarGrafo(EstacionEditarGrafo frame) {
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 3), "Editar las posiciones de las estaciones en el grafo"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		button = new JButton("Fede cambiame");
		JScrollPane scrollPane = new JScrollPane(button);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		this.add(scrollPane, c);
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.1;
		c.weighty = 0.1;
		c.gridwidth = 1;
		
		
		button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				frameAnterior = new EstacionGestionar();
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		this.add(button, c);
		
		button = new JButton("Confirmar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				frameAnterior = new EstacionGestionar();
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
		this.add(button, c);
		
	}
	

}