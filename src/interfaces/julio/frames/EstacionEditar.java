package interfaces.julio.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import interfaces.julio.paneles.PanelEstacionEditar;

public class EstacionEditar extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public EstacionEditar(Vector filaSeleccionada) {
		super("Sistema de Gestión de Transporte Multimodal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new PanelEstacionEditar(this, filaSeleccionada);
		setContentPane(contentPane);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

}
