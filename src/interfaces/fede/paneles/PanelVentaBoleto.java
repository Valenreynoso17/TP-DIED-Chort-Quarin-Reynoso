package interfaces.fede.paneles;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clases.Estacion;
import excepciones.SinEstacionesAccesiblesException;
import gestores.GestorEstacion;
import gestores.GestorRuta;
import interfaces.fede.frames.FrameVentaBoleto;
import interfaces.fede.frames.FrameVentaBoleto2;
import interfaces.fede.panelesGrafos.PanelGrafico;
import interfaces.fede.panelesGrafos.PanelSeleccionOrigenDestino;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class PanelVentaBoleto extends JPanel {
	private GestorEstacion gestorEstaciones;
	private JButton botonSiguiente;
	private PanelSeleccionOrigenDestino panelGrafico;
	/**
	 * Create the panel.
	 */
	public PanelVentaBoleto() {
		this.setBorder(new TitledBorder(new LineBorder(Color.black, 1) , "Seleccione estación origen y destino"));
		gestorEstaciones = GestorEstacion.getInstance();
		List<Estacion> estaciones = gestorEstaciones.getEstacionesOperativas();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		//gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		//gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.1, 0.1, 0.4, 0.1, 0.4, 0.1, 0.1, 0.1};
		gridBagLayout.rowWeights = new double[]{0.0, 0.5, 0.5, 0.0};
		setLayout(gridBagLayout);
		
		
		JLabel llbOrigen = new JLabel("Origen:");
		GridBagConstraints gbc_llbOrigen = new GridBagConstraints();
		gbc_llbOrigen.anchor = GridBagConstraints.EAST;
		gbc_llbOrigen.insets = new Insets(10, 10, 10, 10);
		gbc_llbOrigen.gridx = 1;
		gbc_llbOrigen.gridy = 0;
		add(llbOrigen, gbc_llbOrigen);
		

		
		JLabel lblDestino = new JLabel("Destino:");
		GridBagConstraints gbc_lblDestino = new GridBagConstraints();
		gbc_lblDestino.insets = new Insets(10, 10, 10, 10);
		gbc_lblDestino.anchor = GridBagConstraints.EAST;
		gbc_lblDestino.gridx = 3;
		gbc_lblDestino.gridy = 0;
		add(lblDestino, gbc_lblDestino);
		
		JComboBox<Estacion> comboBoxDestino = new JComboBox<>();
		comboBoxDestino.setEnabled(false);
		comboBoxDestino.addActionListener(e -> {
			if (comboBoxDestino.getSelectedItem() != null) {
				botonSiguiente.setEnabled(true);
				panelGrafico.pintarDestino((Estacion) comboBoxDestino.getSelectedItem());
			}
			else botonSiguiente.setEnabled(false);
		});
		GridBagConstraints gbc_comboBoxDestino = new GridBagConstraints();
		gbc_comboBoxDestino.anchor = GridBagConstraints.WEST;
		gbc_comboBoxDestino.insets = new Insets(10, 10, 10, 10);
		gbc_comboBoxDestino.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDestino.gridx = 4;
		gbc_comboBoxDestino.gridy = 0;
		gbc_comboBoxDestino.ipadx = 5;
		add(comboBoxDestino, gbc_comboBoxDestino);
		
		JComboBox<Estacion> comboBoxOrigen = new JComboBox<Estacion>(estaciones.toArray(new Estacion[estaciones.size()]));
		comboBoxOrigen.setSelectedItem(null);
		comboBoxOrigen.addActionListener(e -> {
			try{
				List<Estacion> accesible = gestorEstaciones.getEstacionesOperativasAccesibles((Estacion)comboBoxOrigen.getSelectedItem());
				comboBoxDestino.setModel(new DefaultComboBoxModel<>(accesible.toArray(new Estacion[accesible.size()])));
				comboBoxDestino.setEnabled(true);
				comboBoxDestino.setSelectedItem(null);
			}
			catch (SinEstacionesAccesiblesException exc) {
				comboBoxDestino.setEnabled(false);
				comboBoxDestino.setSelectedItem(null);

				JOptionPane.showMessageDialog(getPadre(), exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			finally {
				panelGrafico.pintarOrigen((Estacion)comboBoxOrigen.getSelectedItem());
			}
		});
		GridBagConstraints gbc_comboBoxOrigen = new GridBagConstraints();
		gbc_comboBoxOrigen.anchor = GridBagConstraints.WEST;
		gbc_comboBoxOrigen.insets = new Insets(10, 10, 10, 10);
		gbc_comboBoxOrigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxOrigen.gridx = 2;
		gbc_comboBoxOrigen.gridy = 0;
		add(comboBoxOrigen, gbc_comboBoxOrigen);
		
		
		
		panelGrafico = new PanelSeleccionOrigenDestino();
		
		JScrollPane scrollPane = new JScrollPane(panelGrafico);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(15, 20, 15, 20);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.gridheight = 2;
		add(scrollPane, gbc_scrollPane);
		
		JButton botonAtras = new JButton("  Atrás  ");
		botonAtras.addActionListener(e -> getPadre().dispose());
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.fill = GridBagConstraints.HORIZONTAL;
		//gbc_botonAtras.anchor = GridBagConstraints.WEST;
		gbc_botonAtras.insets = new Insets(5, 5, 5, 5);
		gbc_botonAtras.gridx = 0;
		gbc_botonAtras.gridy = 3;
		add(botonAtras, gbc_botonAtras);
		
		botonSiguiente = new JButton("Siguiente");
		botonSiguiente.setEnabled(false);
		botonSiguiente.addActionListener(e -> {
			FrameVentaBoleto2.crearVentana((FrameVentaBoleto) getPadre(), ((Estacion) comboBoxOrigen.getSelectedItem()), ((Estacion) comboBoxDestino.getSelectedItem()));
			getPadre().dispose();
		});
		GridBagConstraints gbc_botonSiguiente = new GridBagConstraints();
		gbc_botonSiguiente.fill = GridBagConstraints.HORIZONTAL;
		//gbc_botonSiguiente.anchor = GridBagConstraints.EAST;
		gbc_botonSiguiente.insets = new Insets(5, 5, 5, 5);
		gbc_botonSiguiente.gridx = 5;
		gbc_botonSiguiente.gridy = 3;
		add(botonSiguiente, gbc_botonSiguiente);
		
		/*JButton botonZoomAdelante = new JButton("+");
		botonZoomAdelante.addActionListener(e -> panelGrafico.aumentarEscala());
		GridBagConstraints gbc_botonZoomAdelante = new GridBagConstraints();
		gbc_botonZoomAdelante.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonZoomAdelante.anchor = GridBagConstraints.SOUTH;
		gbc_botonZoomAdelante.insets = new Insets(5, 5, 5, 5);
		gbc_botonZoomAdelante.gridx = 1;
		gbc_botonZoomAdelante.gridy = 1;
		add(botonZoomAdelante, gbc_botonZoomAdelante);*/
		
		/*JButton botonZoomAtras = new JButton("-");
		botonZoomAtras.setSize(new Dimension(20, 10));
		botonZoomAtras.addActionListener(e -> panelGrafico.disminuirEscala());
		GridBagConstraints gbc_botonZoomAtras = new GridBagConstraints();
		gbc_botonZoomAtras.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonZoomAtras.anchor = GridBagConstraints.NORTH;
		gbc_botonZoomAtras.insets = new Insets(5, 5, 5, 5);
		gbc_botonZoomAtras.gridx = 1;
		gbc_botonZoomAtras.gridy = 2;
		add(botonZoomAtras, gbc_botonZoomAtras);*/
	}
	
	public JFrame getPadre() {
		return (JFrame) this.getTopLevelAncestor();
	}
}
