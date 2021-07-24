package interfaces.fede.ventaBoleto;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollBar;

public class PanelVentaBoleto extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelVentaBoleto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.2, 1.0, 0.0, 0.2, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel llbOrigen = new JLabel("Origen:");
		GridBagConstraints gbc_llbOrigen = new GridBagConstraints();
		gbc_llbOrigen.anchor = GridBagConstraints.EAST;
		gbc_llbOrigen.insets = new Insets(5, 5, 5, 5);
		gbc_llbOrigen.gridx = 0;
		gbc_llbOrigen.gridy = 0;
		add(llbOrigen, gbc_llbOrigen);
		
		JComboBox comboBoxOrigen = new JComboBox();
		GridBagConstraints gbc_comboBoxOrigen = new GridBagConstraints();
		gbc_comboBoxOrigen.anchor = GridBagConstraints.WEST;
		gbc_comboBoxOrigen.insets = new Insets(5, 5, 5, 5);
		//gbc_comboBoxOrigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxOrigen.gridx = 1;
		gbc_comboBoxOrigen.gridy = 0;
		add(comboBoxOrigen, gbc_comboBoxOrigen);
		
		JLabel lblDestino = new JLabel("Destino:");
		GridBagConstraints gbc_lblDestino = new GridBagConstraints();
		gbc_lblDestino.insets = new Insets(5, 5, 5, 5);
		gbc_lblDestino.anchor = GridBagConstraints.EAST;
		gbc_lblDestino.gridx = 3;
		gbc_lblDestino.gridy = 0;
		add(lblDestino, gbc_lblDestino);
		
		JComboBox comboBoxDestino = new JComboBox();
		GridBagConstraints gbc_comboBoxDestino = new GridBagConstraints();
		gbc_comboBoxDestino.anchor = GridBagConstraints.WEST;
		gbc_comboBoxDestino.insets = new Insets(5, 5, 5, 5);
		//gbc_comboBoxDestino.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDestino.gridx = 4;
		gbc_comboBoxDestino.gridy = 0;
		add(comboBoxDestino, gbc_comboBoxDestino);
		

		
		PanelGrafico panelGrafico = new PanelGrafico();
		/*GridBagConstraints gbc_panelGrafico = new GridBagConstraints();
		gbc_panelGrafico.fill = GridBagConstraints.BOTH;
		gbc_panelGrafico.insets = new Insets(5, 5, 5, 5);
		gbc_panelGrafico.gridx = 0;
		gbc_panelGrafico.gridy = 1;
		gbc_panelGrafico.gridwidth = 5;
		add(panelGrafico, gbc_panelGrafico);*/
		
		JScrollPane scrollPane = new JScrollPane(panelGrafico);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		gbc_scrollPane.gridwidth = 5;
		add(scrollPane, gbc_scrollPane);
		
		JButton botonAtras = new JButton("Atrás");
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.anchor = GridBagConstraints.WEST;
		gbc_botonAtras.insets = new Insets(5, 5, 5, 5);
		gbc_botonAtras.gridx = 0;
		gbc_botonAtras.gridy = 2;
		add(botonAtras, gbc_botonAtras);
		
		JButton botonSiguiente = new JButton("Siguiente");
		GridBagConstraints gbc_botonSiguiente = new GridBagConstraints();
		gbc_botonSiguiente.anchor = GridBagConstraints.EAST;
		gbc_botonSiguiente.insets = new Insets(5, 5, 5, 5);
		gbc_botonSiguiente.gridx = 4;
		gbc_botonSiguiente.gridy = 2;
		add(botonSiguiente, gbc_botonSiguiente);
		
		/*JButton botonPrueba = new JButton("Prueba");
		botonPrueba.addActionListener(e -> panelGrafico.cambiarlo());
		GridBagConstraints gbc_botonPrueba = new GridBagConstraints();
		gbc_botonPrueba.anchor = GridBagConstraints.EAST;
		gbc_botonPrueba.insets = new Insets(5, 5, 5, 5);
		gbc_botonPrueba.gridx = 3;
		gbc_botonPrueba.gridy = 2;
		add(botonPrueba, gbc_botonPrueba);*/
	}

}
