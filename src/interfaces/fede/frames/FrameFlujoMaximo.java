package interfaces.fede.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.fede.paneles.PanelFlujoMaximo;
import interfaces.fede.paneles.PanelVentaBoleto;

public class FrameFlujoMaximo extends JFrame {
	private PanelFlujoMaximo contentPane;
	private JFrame padre;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameFlujoMaximo frame = new FrameFlujoMaximo();
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
	public FrameFlujoMaximo() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new PanelFlujoMaximo();
		setContentPane(contentPane);
	}
}
