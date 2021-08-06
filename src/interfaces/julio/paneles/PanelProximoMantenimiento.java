package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.UnmappableCharacterException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clases.Estacion;
import clases.Mantenimiento;
import gestores.GestorEstacion;
import interfaces.julio.frames.MenuPrincipal;
import interfaces.julio.frames.ProximoMantenimiento;
import interfaces.valen.paneles.PanelGroupBoxProximoMantenimiento;
import interfaces.valen.paneles.PanelTablaProximoMantenimiento;

public class PanelProximoMantenimiento extends JPanel{

	private PanelGroupBoxProximoMantenimiento panelProxMantenimiento;
	private PanelTablaProximoMantenimiento panelTabla;
	private JButton botonVolver;
	private GridBagConstraints gbc;
	
	public PanelProximoMantenimiento(ProximoMantenimiento frame) {
		
		GestorEstacion gestorEstacion = GestorEstacion.getInstance();
		PriorityQueue<Estacion> heapEstaciones = new PriorityQueue<Estacion>((e1, e2) -> e1.compareTo(e2));

		for(Estacion unaEstacion: gestorEstacion.getEstaciones()) {
			heapEstaciones.add(unaEstacion);
		}
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		Optional<Estacion> estAux = Optional.ofNullable(heapEstaciones.peek()); 
		estAux.ifPresentOrElse(e -> panelProxMantenimiento = new PanelGroupBoxProximoMantenimiento(e), () -> panelProxMantenimiento =  new PanelGroupBoxProximoMantenimiento());
		this.add(panelProxMantenimiento, gbc);
		
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		panelTabla = new PanelTablaProximoMantenimiento(heapEstaciones);
		this.add(panelTabla, gbc);
		
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5,50,5,5);
		botonVolver = new JButton("Volver");
		botonVolver.addActionListener(e -> {frame.dispose();
											new MenuPrincipal();});
		this.add(botonVolver, gbc);
		
	}
	
}
