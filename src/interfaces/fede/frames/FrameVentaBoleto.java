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

	public FrameVentaBoleto(JFrame padre) {
		this.padre = padre;
		this.setTitle("Sistema de Gestión de Transporte Multimodal");
		//this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 600);
		contentPane = new PanelVentaBoleto();
		this.setContentPane(contentPane);
		
		this.setLocationRelativeTo(null);
	}

	
	public void abriVentanaAnterior() {
		padre.setVisible(true);
	}
	
	public void volverAlMenu() {
		this.dispose();
		if (padre != null) padre.setVisible(true);
	}
	
}
