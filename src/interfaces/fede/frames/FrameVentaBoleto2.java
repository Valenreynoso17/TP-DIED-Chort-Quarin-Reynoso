package interfaces.fede.frames;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Estacion;
import interfaces.fede.ventaBoleto.PanelVentaBoleto2;

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
		
		JPanel panel = new PanelVentaBoleto2(origen, destino);
		setContentPane(panel);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
	}
	

	
	public void abriVentanaAnterior() {
		padre.setVisible(true);
	}
	
	public void volverAlMenu() {
		this.dispose();
		padre.volverAlMenu();
	}
}
