package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.Dimension;
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
	
	public PanelListadoGestionLineas() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder("Listado"));
		
		// Primer componente - JTextField
		JTextField textoBusqueda = new JTextField("Busca una línea por nombre");
		textoBusqueda.setMaximumSize(new Dimension(200,20));
		this.add(textoBusqueda);
		
		// Segundo componente - Panel con 2 checkboxes y un colorPicker
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(500,40));
		
		JCheckBox checkBoxActiva = new JCheckBox("Activa");
		panel.add(checkBoxActiva);
		
		JCheckBox checkBoxNoActiva = new JCheckBox("No activa");
		panel.add(checkBoxNoActiva);
		
		// TODO: Ver el tema del color
		JLabel labelColor = new JLabel("Color:");
		panel.add(labelColor);
		ColorPicker colorPicker = new ColorPicker((JFrame) this.getTopLevelAncestor());
		panel.add(colorPicker);
		this.add(panel);
		
		// Tercer componente - Lista
		ElementoListaGestionTransporte e1 = new ElementoListaGestionTransporte("Linea Verde", "Activa");
		ElementoListaGestionTransporte e2 = new ElementoListaGestionTransporte("Linea Amarilla", "No activa");
		ElementoListaGestionTransporte e3 = new ElementoListaGestionTransporte("Linea Roja", "No activa");
		ElementoListaGestionTransporte e4 = new ElementoListaGestionTransporte("Linea Azul", "No activa");
		ElementoListaGestionTransporte e5 = new ElementoListaGestionTransporte("Linea Juancho", "No activa");
		ElementoListaGestionTransporte e6 = new ElementoListaGestionTransporte("Linea Naranja", "Activa");
		ElementoListaGestionTransporte e7 = new ElementoListaGestionTransporte("Linea Mariano", "No activa");
		ElementoListaGestionTransporte e8 = new ElementoListaGestionTransporte("Linea Pepe", "No activa");
		ElementoListaGestionTransporte e9 = new ElementoListaGestionTransporte("Linea El domingo", "No activa");
		ElementoListaGestionTransporte e10 = new ElementoListaGestionTransporte("Linea Agus", "No activa");
		ElementoListaGestionTransporte e11 = new ElementoListaGestionTransporte("Linea Azul", "No activa");
		ElementoListaGestionTransporte e12 = new ElementoListaGestionTransporte("Linea Juancho", "No activa");
		ElementoListaGestionTransporte e13 = new ElementoListaGestionTransporte("Linea Naranja", "Activa");
		ElementoListaGestionTransporte e14 = new ElementoListaGestionTransporte("Linea Mariano", "No activa");
		ElementoListaGestionTransporte e15 = new ElementoListaGestionTransporte("Linea Pepe", "No activa");
		ElementoListaGestionTransporte e16 = new ElementoListaGestionTransporte("Linea El domingo", "No activa");
		ElementoListaGestionTransporte e17 = new ElementoListaGestionTransporte("Linea Agus", "No activa");
		
		JPanel panelGridLista = new JPanel(new GridLayout(0, 2));
		panelGridLista.add(e1);
//		panelGridLista.add(e2);
//		panelGridLista.add(e3);
//		panelGridLista.add(e4);
//		panelGridLista.add(e5);
//		panelGridLista.add(e6);
//		panelGridLista.add(e7);
//		panelGridLista.add(e8);
//		panelGridLista.add(e9);
//		panelGridLista.add(e10);
//		panelGridLista.add(e11);
//		panelGridLista.add(e12);
//		panelGridLista.add(e13);
//		panelGridLista.add(e14);
//		panelGridLista.add(e15);
//		panelGridLista.add(e16);
//		panelGridLista.add(e17);
		
		JScrollPane panelScrollLista = new JScrollPane(panelGridLista, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(panelScrollLista);
	}
}
