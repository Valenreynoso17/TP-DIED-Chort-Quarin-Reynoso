package interfaces.julio.frames;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import interfaces.julio.paneles.PanelEstacionAltaGrafo;
import interfaces.julio.paneles.PanelEstacionEditar;

public class EstacionAltaGrafo extends JFrame{

	private JPanel contentPane;

	public EstacionAltaGrafo(EstacionAlta frameAnterior) {
		super("Sistema de Gesti�n de Transporte Multimodal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new PanelEstacionAltaGrafo(this, frameAnterior);
		setContentPane(contentPane);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
}