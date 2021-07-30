package interfaces.valen.otros;

import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPrincipalDialogoColorPicker extends JPanel{

	public PanelPrincipalDialogoColorPicker() {

		JLabel labelElige = new JLabel("Elige un color:");
		this.add(labelElige);
		this.add(new Button("hola?"));
		
	}
}
