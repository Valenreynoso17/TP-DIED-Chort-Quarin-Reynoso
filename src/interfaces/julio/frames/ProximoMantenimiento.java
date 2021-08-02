package interfaces.julio.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import interfaces.julio.paneles.PanelProximoMantenimiento;

public class ProximoMantenimiento extends JFrame{

	private JPanel contentPane;

	public ProximoMantenimiento() {
		super("Sistema de Gestión de Transporte Multimodal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new PanelProximoMantenimiento(this);
		setContentPane(contentPane);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	
	}
	
}
