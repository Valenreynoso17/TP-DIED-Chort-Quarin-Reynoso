package interfaces.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import interfaces.otros.ElementoListaGestionTransporte;

public class PanelListadoGestionLineas extends JPanel{
	
	public PanelListadoGestionLineas() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createTitledBorder("Listado"));
		
		// Primer componente - JTextField
		JTextField textoBusqueda = new JTextField("Busca una línea por nombre");
		textoBusqueda.setPreferredSize(new Dimension(200,20));
		this.add(textoBusqueda);
		
		// Segundo componente - Panel con 2 checkboxes y un colorPicker
		JPanel panel = new JPanel();
		
		JCheckBox checkBoxActiva = new JCheckBox("Activa");
		panel.add(checkBoxActiva);
		
		JCheckBox checkBoxNoActiva = new JCheckBox("No activa");
		panel.add(checkBoxNoActiva);
		
		// TODO: Ver el tema del color
//		JColorChooser colorChooser = new JColorChooser();
//		panel.add(colorChooser);
		this.add(panel);
		
		// Tercer componente - Lista
		ElementoListaGestionTransporte e1 = new ElementoListaGestionTransporte("Linea Verde", "Activa");
		ElementoListaGestionTransporte e2 = new ElementoListaGestionTransporte("Linea Amarilla", "No activa");
		ElementoListaGestionTransporte e3 = new ElementoListaGestionTransporte("Linea Roja", "No activa");
		ElementoListaGestionTransporte e4 = new ElementoListaGestionTransporte("Linea Azul", "No activa");
		ElementoListaGestionTransporte e5 = new ElementoListaGestionTransporte("Linea Juancho", "No activa");
		
		JPanel panelGridLista = new JPanel(new GridLayout(2,2));
		panelGridLista.add(e1);
		panelGridLista.add(e2);
		panelGridLista.add(e3);
		panelGridLista.add(e4);
		panelGridLista.add(e5);
		
		JScrollPane panelScrollLista = new JScrollPane(panelGridLista);
		panelScrollLista.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		this.add(panelScrollLista);
	}
}
