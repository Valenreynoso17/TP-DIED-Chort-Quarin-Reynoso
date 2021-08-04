package interfaces.julio.frames;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import interfaces.julio.paneles.PanelEstacionEditar;
import interfaces.julio.paneles.PanelEstacionEditarGrafo;

public class EstacionEditarGrafo extends JFrame{

	private JPanel contentPane;

	public EstacionEditarGrafo() {
		super("Sistema de Gestión de Transporte Multimodal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new PanelEstacionEditarGrafo(this);
		setContentPane(contentPane);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
}
