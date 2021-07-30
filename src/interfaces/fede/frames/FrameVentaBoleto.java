package interfaces.fede.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Estacion;
import enums.EstadoEstacion;
import enums.EstadoRuta;
import gestores.GestorEstacion;
import gestores.GestorRuta;
import interfaces.fede.ventaBoleto.PanelVentaBoleto;

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

	
	public void abriVentanaAnterior() {
		padre.setVisible(true);
	}
	
	public void volverAlMenu() {
		this.dispose();
		if (padre != null) padre.setVisible(true);
	}

	/*
	 * Para probar el grafico a ver si funca
	 */
	public static void pruebaGrafico() {
		GestorEstacion gestor = GestorEstacion.getInstance();
		GestorRuta gestor2 = GestorRuta.getInstance();
		
		gestor.agregarEstacion("1", "A", null, null, new Point(50, 70));
		gestor.agregarEstacion("2", "B", null, null, new Point(180, 50));
		gestor.agregarEstacion("3", "C", null, null, new Point(180, 150));
		gestor.agregarEstacion("4", "D", null, null, new Point(300, 50));
		gestor.agregarEstacion("5", "E", null, null, new Point(300, 150));
		gestor.agregarEstacion("6", "F", null, null, new Point(450, 100));
		gestor.agregarEstacion("7", "G", null, null, new Point(200, 300));
		gestor.agregarEstacion("8", "X", null, null, new Point(700, 300));
		
		List<Estacion> estaciones = gestor.getEstaciones();
		//estaciones.get(1).setEstado(EstadoEstacion.EN_MANTENIMIENTO);
		//estaciones.get(5).setEstado(EstadoEstacion.EN_MANTENIMIENTO);
		
		gestor2.agregarRuta(estaciones.get(0), estaciones.get(1), 2, 2, 2, EstadoRuta.ACTIVA, 2);
		gestor2.agregarRuta(estaciones.get(0), estaciones.get(2), 2, 2, 2, EstadoRuta.ACTIVA, 2);
		gestor2.agregarRuta(estaciones.get(0), estaciones.get(6), 2, 2, 2, EstadoRuta.ACTIVA, 2);
		gestor2.agregarRuta(estaciones.get(1), estaciones.get(3), 2, 2, 2, EstadoRuta.ACTIVA, 2);
		gestor2.agregarRuta(estaciones.get(2), estaciones.get(4), 2, 2, 2, EstadoRuta.ACTIVA, 2);
		gestor2.agregarRuta(estaciones.get(3), estaciones.get(5), 2, 2, 2, EstadoRuta.ACTIVA, 2);
		gestor2.agregarRuta(estaciones.get(4), estaciones.get(5), 2, 2, 2, EstadoRuta.ACTIVA, 2);
		gestor2.agregarRuta(estaciones.get(6), estaciones.get(7), 2, 2, 2, EstadoRuta.ACTIVA, 2);
		gestor2.agregarRuta(estaciones.get(7), estaciones.get(5), 2, 2, 2, EstadoRuta.ACTIVA, 2);
		gestor2.agregarRuta(estaciones.get(6), estaciones.get(5), 2, 2, 2, EstadoRuta.NO_ACTIVA, 2);
		gestor2.agregarRuta(estaciones.get(6), estaciones.get(5), 2, 2, 2, EstadoRuta.ACTIVA, 2);
	}
	
}
