package interfaces.fede.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Estacion;
import gestores.GestorEstacion;
import gestores.GestorRuta;
import interfaces.fede.ventaBoleto.PanelVentaBoleto;

public class FrameVentaBoleto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebaGrafico();
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
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new PanelVentaBoleto();
		setContentPane(contentPane);
		//this.pack();
	}

	/*
	 * Para probar el grafico a ver si funca
	 */
	public static void pruebaGrafico() {
		GestorEstacion gestor = GestorEstacion.getInstance();
		GestorRuta gestor2 = GestorRuta.getInstance();
		
		gestor.agregarEstacion("123", "A", null, null, new Point(50, 50));
		gestor.agregarEstacion("124", "B", null, null, new Point(100, 50));
		gestor.agregarEstacion("125", "C", null, null, new Point(678, 500));
		gestor.agregarEstacion("125", "C", null, null, new Point(500, 100));
		gestor.agregarEstacion("125", "C", null, null, new Point(100, 400));
		gestor.agregarEstacion("125", "C", null, null, new Point(100, 300));
		List<Estacion> estaciones = gestor.getEstaciones();
		
		gestor2.agregarRuta(estaciones.get(0), estaciones.get(1), 2, 2, 2, null, 2);
		gestor2.agregarRuta(estaciones.get(1), estaciones.get(2), 2, 2, 2, null, 2);
		//gestor2.agregarRuta(estaciones.get(0), estaciones.get(2), 2, 2, 2, null, 2);
		gestor2.agregarRuta(estaciones.get(2), estaciones.get(0), 2, 2, 2, null, 2);
		//gestor2.agregarRuta(estaciones.get(3), estaciones.get(4), 2, 2, 2, null, 2);
		gestor2.agregarRuta(estaciones.get(4), estaciones.get(3), 2, 2, 2, null, 2);
		gestor2.agregarRuta(estaciones.get(5), estaciones.get(4), 2, 2, 2, null, 2);
	}
}
