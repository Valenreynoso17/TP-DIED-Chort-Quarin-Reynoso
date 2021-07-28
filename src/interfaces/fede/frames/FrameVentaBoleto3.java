package interfaces.fede.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.Estacion;
import clases.Recorrido;
import interfaces.fede.ventaBoleto.PanelVentaBoleto2;
import interfaces.fede.ventaBoleto.PanelVentaBoleto3;

public class FrameVentaBoleto3 extends JFrame {
	private JFrame padre;
	
	public static void crearVentana(JFrame padre, Recorrido recorrido) {
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
	
	public FrameVentaBoleto3(JFrame padre, Recorrido recorrido) {
		this.padre = padre;
		
		JPanel panel = new PanelVentaBoleto3(recorrido);
		setContentPane(panel);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
	}
	
	public void abriVentanaAnterior() {
		padre.setVisible(true);
	}
}
