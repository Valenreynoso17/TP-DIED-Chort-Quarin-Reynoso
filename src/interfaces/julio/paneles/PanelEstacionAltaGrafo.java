package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clases.Estacion;
import enums.EstadoEstacion;
import gestores.GestorEstacion;
import interfaces.fede.panelesGrafos.PanelPermiteCambiarPosicion;
import interfaces.julio.frames.EstacionAlta;
import interfaces.julio.frames.EstacionAltaGrafo;
import interfaces.julio.frames.EstacionGestionar;

public class PanelEstacionAltaGrafo extends JPanel{
	
	private JButton button;
	
	private GestorEstacion gestorEstacion = GestorEstacion.getInstance();
	
	private EstacionGestionar frameGestionar;
	private PanelPermiteCambiarPosicion panelGrafo;
	
	public PanelEstacionAltaGrafo(EstacionAltaGrafo frame, EstacionAlta frameAnterior, Estacion futuraEstacion) {
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 3), "Colocar la nueva estación en el grafo"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		panelGrafo = new PanelPermiteCambiarPosicion(futuraEstacion);
		JScrollPane scrollPane = new JScrollPane(panelGrafo);
		
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
				
				panelGrafo.cancelarCambios();
				
				frame.dispose();
				frameAnterior.setVisible(true);
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		this.add(button, c);
		
		button = new JButton("Crear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gestorEstacion.agregarEstacion(futuraEstacion);
				
				panelGrafo.guardarCambios();
				
				frame.dispose();
				frameGestionar = new EstacionGestionar();
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
		this.add(button, c);
		
	}
	
}
