package interfaces.fede.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Recorrido;
import interfaces.fede.paneles.PanelVentaBoleto3;

public class FrameVentaBoleto3 extends JFrame {
	private FrameVentaBoleto2 padre;
	
	public static void crearVentana(FrameVentaBoleto2 padre, Recorrido recorrido) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameVentaBoleto3 frame = new FrameVentaBoleto3(padre, recorrido);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FrameVentaBoleto3(FrameVentaBoleto2 padre, Recorrido recorrido) {
		this.padre = padre;
		this.setTitle("Sistema de Gestión de Transporte Multimodal");
		JPanel panel = new PanelVentaBoleto3(recorrido);
		this.setContentPane(panel);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 1280, 720);
	}
	
	public void abriVentanaAnterior() {
		padre.setVisible(true);
	}
	
	public void volverAlMenu() {
		this.dispose();
		padre.volverAlMenu();
	}
}
