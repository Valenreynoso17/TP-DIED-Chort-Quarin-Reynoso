package interfaces.valen.otros;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clases.CustomColor;
import gestores.GestorColor;

public class PanelPrincipalDialogoColorPicker extends JPanel{

	JPanel panelColores;
	JPanel panelBotones;
	GridBagConstraints gbc;
	GestorColor gestorColor;
	
	public PanelPrincipalDialogoColorPicker() {

		gestorColor = GestorColor.getInstance();
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		panelColores.setBorder(BorderFactory.createTitledBorder("Elige un color:"));
		CustomColor c1 = new CustomColor(1, "Azul", 0, 0, 255);
		ElementoDialogoColorPicker elemAux = new ElementoDialogoColorPicker(c1);
		panelColores.add(elemAux);
		
//		List<CustomColor> colores = gestorColor.getColores();
//		
//		for(CustomColor color : colores) {
//			ElementoDialogoColorPicker elemAux = new ElementoDialogoColorPicker(color);
//			panelColores.add(elemAux);
//		}
		
		gbc.weighty = 0.0;
		panelBotones = new JPanel();
		panelBotones.add(new JButton("Cancelar"));
		panelBotones.add(new JButton("Agregar un nuevo color"));
		panelBotones.add(new JButton("Seleccionar"));
		

	}
}
