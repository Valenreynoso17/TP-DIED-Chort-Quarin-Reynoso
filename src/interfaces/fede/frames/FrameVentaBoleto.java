package interfaces.fede.frames;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Estacion;
import gestores.GestorEstacion;
import gestores.GestorRuta;
import interfaces.fede.paneles.PanelVentaBoleto;

public class FrameVentaBoleto extends JFrame {

	private JPanel contentPane;
	private JFrame padre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameVentaBoleto frame = new FrameVentaBoleto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameVentaBoleto() {
		this.setTitle("Sistema de Gestión de Transporte Multimodal");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1280, 720);
		contentPane = new PanelVentaBoleto();
		this.setContentPane(contentPane);
	}

	
	public void abriVentanaAnterior() {
		padre.setVisible(true);
	}
	
	public void volverAlMenu() {
		this.dispose();
		if (padre != null) padre.setVisible(true);
	}
	
}
