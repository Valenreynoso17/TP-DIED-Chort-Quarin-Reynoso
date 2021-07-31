package interfaces.valen.otros;

import java.awt.Button;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DialogoColorPicker extends JDialog{
	
	PanelPrincipalDialogoColorPicker panelPrincipal;
	
	public DialogoColorPicker(JFrame parent, boolean modal) {
		super(parent, modal);
		
		this.setLocationRelativeTo(parent);
		this.setBounds(100,50,500,200);
		this.setTitle("Selector de color");
		
		panelPrincipal = new PanelPrincipalDialogoColorPicker();
		
		this.setContentPane(panelPrincipal);
		this.setVisible(true);
	}

}
