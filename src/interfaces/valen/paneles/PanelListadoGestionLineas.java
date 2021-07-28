package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import interfaces.valen.otros.ColorPicker;
import interfaces.valen.otros.ElementoListaGestionTransporte;

public class PanelListadoGestionLineas extends JPanel{
	
	JTextField textoBusqueda;
	JPanel panel;
	JCheckBox checkBoxActiva;
	JCheckBox checkBoxNoActiva;
	JLabel labelColor;
	ColorPicker colorPicker;
	GridBagConstraints gbc;
	
	public PanelListadoGestionLineas() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder("Listado"));
		
		// Primer componente - JTextField
		textoBusqueda = new JTextField("Busca una línea por nombre");
		textoBusqueda.setMaximumSize(new Dimension(200,20));
		this.add(textoBusqueda);
		
		// Segundo componente - Panel con 2 checkboxes y un colorPicker
		panel = new JPanel();
		panel.setMaximumSize(new Dimension(500,40));
		
		checkBoxActiva = new JCheckBox("Activa");
		panel.add(checkBoxActiva);
		
		checkBoxNoActiva = new JCheckBox("No activa");
		panel.add(checkBoxNoActiva);
		
		// TODO: Ver el tema del color
		labelColor = new JLabel("Color:");
		panel.add(labelColor);
		colorPicker = new ColorPicker((JFrame) this.getTopLevelAncestor());
		panel.add(colorPicker);
		this.add(panel);
		
		// Tercer componente - Lista
		PanelGridListaGestionLineas panelGridLista = new PanelGridListaGestionLineas();		
		JScrollPane panelScrollLista = new JScrollPane(panelGridLista, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(panelScrollLista);
	}
}
