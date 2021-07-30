package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import interfaces.valen.frames.VentanaGestionLineasDeTransporte;
import interfaces.valen.otros.ColorPicker;
import interfaces.valen.otros.ElementoListaGestionTransporte;
import interfaces.valen.otros.TextPrompt;

public class PanelListadoGestionLineas extends JPanel{
	
	JTextField textoBusqueda;
	JPanel panel;
	JCheckBox checkBoxActiva;
	JCheckBox checkBoxNoActiva;
	JLabel labelColor;
	ColorPicker colorPicker;
	GridBagConstraints gbc;
	
	public PanelListadoGestionLineas(VentanaGestionLineasDeTransporte frame) {
		
		this.setBorder(BorderFactory.createTitledBorder("Listado"));
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		
		// Primer componente - JTextField
		textoBusqueda = new JTextField();
		TextPrompt tpTextoBusqueda = new TextPrompt("Busca una línea por nombre", textoBusqueda);
		textoBusqueda.setPreferredSize(new Dimension(200,20));
		this.add(textoBusqueda, gbc);
		
		// Segundo componente - Panel con 2 checkboxes y un colorPicker
		panel = new JPanel();
		panel.setMinimumSize(new Dimension(300,40));
		
		checkBoxActiva = new JCheckBox("Activa");
		panel.add(checkBoxActiva);
		
		checkBoxNoActiva = new JCheckBox("No activa");
		panel.add(checkBoxNoActiva);
		
		labelColor = new JLabel("Color:");
		panel.add(labelColor);
		colorPicker = new ColorPicker(frame, Color.WHITE);
		panel.add(colorPicker);
		this.add(panel, gbc);
		
		// Tercer componente - Lista
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		PanelGridListaGestionLineas panelGridLista = new PanelGridListaGestionLineas(frame);		
		JScrollPane panelScrollLista = new JScrollPane(panelGridLista, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(panelScrollLista, gbc);
	}
}
