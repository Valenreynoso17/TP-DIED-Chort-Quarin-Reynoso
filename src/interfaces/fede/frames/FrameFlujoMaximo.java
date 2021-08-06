package interfaces.fede.frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.fede.paneles.PanelFlujoMaximo;
import interfaces.fede.paneles.PanelVentaBoleto;

public class FrameFlujoMaximo extends JFrame {
	private PanelFlujoMaximo contentPane;
	private JFrame padre;

	public FrameFlujoMaximo() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 600);
		contentPane = new PanelFlujoMaximo();
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
	}
}
