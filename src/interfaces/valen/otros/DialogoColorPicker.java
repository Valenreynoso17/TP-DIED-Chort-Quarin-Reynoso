package interfaces.valen.otros;

import java.awt.Button;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogoColorPicker extends JDialog{
	
	PanelPrincipalDialogoColorPicker panelPrincipal;
	
	public DialogoColorPicker(JFrame parent, JPanel panel, boolean modal) {
		super(parent, modal);
		
		this.setBounds(200,200,700,500);
		this.setTitle("Selector de color");
		
		panelPrincipal = new PanelPrincipalDialogoColorPicker(this, panel);
		
		this.setContentPane(panelPrincipal);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

}
