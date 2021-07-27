package interfaces.valen.otros;

import java.awt.Button;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogoColorPicker extends JDialog{
	
	JPanel panelPrincipal;
	
	
	public DialogoColorPicker(JFrame parent, boolean modal) {
		super(parent, modal);
		
		panelPrincipal = new JPanel();
		JLabel labelElige = new JLabel("Elige un color:");
		panelPrincipal.add(labelElige);
		panelPrincipal.add(new Button("hola?"));
		
		
		this.setContentPane(panelPrincipal);
		this.setVisible(true);
	}

}
