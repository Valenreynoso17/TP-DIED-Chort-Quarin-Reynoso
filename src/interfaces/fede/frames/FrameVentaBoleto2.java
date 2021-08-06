package interfaces.fede.frames;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Estacion;
import interfaces.fede.paneles.PanelVentaBoleto2;

public class FrameVentaBoleto2 extends JFrame {
	private FrameVentaBoleto padre;
	
	
	public static void crearVentana(FrameVentaBoleto padre, Estacion origen, Estacion destino) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameVentaBoleto2 frame = new FrameVentaBoleto2(padre, origen, destino);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FrameVentaBoleto2(FrameVentaBoleto padre, Estacion origen, Estacion destino) {
		this.padre = padre;
		this.setTitle("Sistema de Gestión de Transporte Multimodal");
		JPanel panel = new PanelVentaBoleto2(origen, destino);
		this.setContentPane(panel);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(1024, 600);
		
		this.setLocationRelativeTo(null);
	}
	

	
	public void abriVentanaAnterior() {
		padre.setVisible(true);
	}
	
	public void volverAlMenu() {
		this.dispose();
		padre.volverAlMenu();
	}
}
