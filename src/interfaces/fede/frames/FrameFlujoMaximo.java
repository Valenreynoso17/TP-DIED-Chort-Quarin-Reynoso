package interfaces.fede.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.fede.ventaBoleto.PanelVentaBoleto;

public class FrameFlujoMaximo extends JFrame {
	private JPanel contentPane;
	private JFrame padre;
	
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
	public FrameFlujoMaximo() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new PanelVentaBoleto();
		setContentPane(contentPane);
	}
}
