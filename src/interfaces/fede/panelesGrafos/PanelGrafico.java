package interfaces.fede.panelesGrafos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import clases.Dibujable;
import clases.Estacion;
import clases.Ruta;
import gestores.GestorEstacion;
import gestores.GestorFlecha;
import gestores.GestorRuta;
import interfaces.fede.dialogs.DialogInfoFlechaInactivosNoVisibles;

public class PanelGrafico extends JPanel {
	protected Integer anchoVentana, altoVentana;
	protected GestorEstacion gestorEstaciones;
	protected GestorRuta gestorRutas;
	protected GestorFlecha gestorFlechas;
	protected static Integer radioEstaciones = 20;
	protected DialogInfoFlechaInactivosNoVisibles ventanaInfoFlecha;
	protected List<Estacion> estaciones;
	protected Integer margen = 10;

	protected Float escala = 1.0f;
	protected List<Dibujable> dibujables;
	
	
	
	public PanelGrafico() {
		setBackground(Color.WHITE);
		anchoVentana = 100;
		altoVentana = 100;
		setPreferredSize(new Dimension(anchoVentana, altoVentana));
		
		gestorEstaciones = GestorEstacion.getInstance();
		gestorRutas = GestorRuta.getInstance();
		gestorFlechas = new GestorFlecha();
		
		dibujables = new ArrayList<>();
		
		Thread t1 = new Thread(() -> {
			estaciones = gestorEstaciones.getEstaciones();
			for (Estacion e : estaciones) {
	 			synchronized (dibujables) {
					dibujables.addAll(estaciones);
				}
			}
		});
		Thread t2 = new Thread(() -> {
			List<Ruta> rutas = gestorRutas.getRutas();
			for (Ruta r : rutas) {
				gestorFlechas.asignarAFlecha(r);
			}
			synchronized (dibujables) {
				dibujables.addAll(gestorFlechas.getFlechas());
			}
		});
		t1.run();
		t2.run();
		try{
			t1.join();
			t2.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	
	public void aumentarEscala() {
		this.escala *= 1.5f;
		this.setPreferredSize(new Dimension(Math.round(this.getPreferredSize().width*escala), Math.round(this.getPreferredSize().height*escala)));
		this.revalidate();
		for (Dibujable p : dibujables) {
			p.reescalar(escala);
		};
		this.repaint();
	}
	
	
	public void disminuirEscala() {
		this.setPreferredSize(new Dimension(Math.round(this.getPreferredSize().width/escala), Math.round(this.getPreferredSize().height/escala)));
		escala /= 1.5f;		
		this.revalidate();
		for (Dibujable p : dibujables) {
			p.reescalar(escala);
		};
		this.repaint();
	}
	
	public static Integer getRadioEstaciones() {
		return radioEstaciones;
	}
	
	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent (g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.scale(escala, escala);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
		dibujarGrafo(g2d);
		

	}
	
	protected void dibujarGrafo(Graphics2D g2d){
		for (Dibujable d : dibujables) {
			d.dibujarse(g2d);
			if (d instanceof Estacion) chequearPreferredSize((Estacion) d);
		}
	}
	
	protected void chequearPreferredSize(Estacion e) {
		if (this.getPreferredSize().height <= e.getPosicion().y + radioEstaciones + margen) {
			this.setPreferredSize(new Dimension(this.getPreferredSize().width , e.getPosicion().y + radioEstaciones + margen));
			revalidate();
		}
		if (this.getPreferredSize().width <= e.getPosicion().x + radioEstaciones + margen) {
			this.setPreferredSize(new Dimension(e.getPosicion().x + radioEstaciones + margen , this.getPreferredSize().height));
			revalidate();
		}
	}
	
	
}
