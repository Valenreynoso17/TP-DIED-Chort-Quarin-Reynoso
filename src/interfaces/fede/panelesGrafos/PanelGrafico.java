package interfaces.fede.panelesGrafos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import clases.Dibujable;
import clases.Estacion;
import clases.Flecha;
import clases.Ruta;
import gestores.GestorEstacion;
import gestores.GestorFlecha;
import gestores.GestorRuta;

public abstract class PanelGrafico extends JPanel {
	protected Integer anchoVentana, altoVentana;
	protected GestorEstacion gestorEstaciones;
	protected GestorRuta gestorRutas;
	protected GestorFlecha gestorFlechas;
	protected static Integer radioEstaciones = 20;
	protected DialogInfoFlechaInactivosNoVisibles ventanaInfoFlecha;

	protected Float escala = 1.0f;
	protected List<Dibujable> dibujables;
	
	
	
	public PanelGrafico() {
		setBackground(Color.WHITE);
		anchoVentana = 800;
		altoVentana = 600;
		setPreferredSize(new Dimension(anchoVentana, altoVentana));
		
		gestorEstaciones = GestorEstacion.getInstance();
		gestorRutas = GestorRuta.getInstance();
		gestorFlechas = new GestorFlecha();
		
		dibujables = new ArrayList<>();
		
		Thread t1 = new Thread(() -> {
			List<Estacion> estaciones = gestorEstaciones.getEstaciones();
			synchronized (dibujables) {
				dibujables.addAll(estaciones);
			}
		});
		Thread t2 = new Thread(() -> {
			List<Ruta> rutas = gestorRutas.getRutas();
			for (Ruta r : rutas) {
				//if (r.activa() && r.getOrigen().operativa() && r.getDestino().operativa()) {
					gestorFlechas.asignarAFlecha(r);
				//}
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
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Flecha> flechas = gestorFlechas.getFlechas();
				if (ventanaInfoFlecha == null || !ventanaInfoFlecha.isVisible()) {
					for (Flecha f : flechas) {
						if (f.getHitbox().contains(e.getPoint())) {
							ventanaInfoFlecha = new DialogInfoFlechaInactivosNoVisibles(f);
							ventanaInfoFlecha.setVisible(true);
						}
					}
				}
			}
		});
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				List<Flecha> flechas = gestorFlechas.getFlechas();
				Boolean existeAlguna = false;
				for (Flecha f : flechas) {
					if (f.getHitbox().contains(e.getPoint())) {
						existeAlguna = true;
						break;
					}
				}
				if (existeAlguna) setCursor(new Cursor(Cursor.HAND_CURSOR)); 
				else setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
		});

	}

	
	public void aumentarEscala() {
		this.escala *= 1.5f;
		this.setPreferredSize(new Dimension(Math.round(anchoVentana*escala), Math.round(altoVentana*escala)));
		this.revalidate();
		for (Dibujable p : dibujables) {
			p.reescalar(escala);
		};
		this.repaint();
	}
	
	
	public void disminuirEscala() {
		escala /= 1.5f;
		this.setPreferredSize(new Dimension(Math.round(anchoVentana*escala), Math.round(altoVentana*escala)));
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
	
	protected abstract void dibujarGrafo(Graphics2D g2d); /*{
		for (Dibujable d : dibujables) {
			d.dibujarse(g2d);
		}
	}*/
	
	/*protected void dibujarEstacion(Graphics2D g2d, Estacion e) {
		Point pos = e.getPosicion();
		
		
		g2d.setColor(new Color(39, 75, 211));
		g2d.fillOval(pos.x-radioEstaciones, pos.y-radioEstaciones, 2*radioEstaciones, 2*radioEstaciones);	
		g2d.setColor(new Color(3, 25, 111));
		g2d.setStroke(new BasicStroke(1.0f));
		g2d.drawOval(pos.x-radioEstaciones, pos.y-radioEstaciones, 2*radioEstaciones, 2*radioEstaciones);
		g2d.setColor(Color.BLACK);
		g2d.drawString(e.getNombre(), pos.x, pos.y);
		
	}
	
	//Dibuja la flecha que simboliza una ruta entre dos estaciones, con su respectivo color
	protected void dibujarRuta(Graphics2D g2d, Ruta r) {
		Point posEstOrigen, posEstDestino, origenFlecha, destinoFlecha;
		Double anguloFlecha;
		Integer descX, descY;
		
		// Se obtiene la posicion de las estaciones origen y destino
		posEstOrigen = r.getOrigen().getPosicion();
		posEstDestino = r.getDestino().getPosicion();
		
		// Se obtiene la direccion de la flecha
		anguloFlecha = Math.atan((posEstDestino.getY()-posEstOrigen.getY())/(posEstDestino.getX()-posEstOrigen.getX()));
		
		// Se corrige la direccion en los casos donde la estacion de origen esta mas a la derecha que la estacion destino
		if ((posEstDestino.getX()-posEstOrigen.getX()) < 0) {
			if (anguloFlecha > 0) anguloFlecha += Math.PI;
			else anguloFlecha -= Math.PI;
		}
		
		// Como la flecha no empieza ni termina en el centro exacto de las estaciones se calcula estos valores
		// que al operarlos con los centro de las estaciones permiten obtener los puntos de origen y destino de la flecha
		descX = (int) Math.round(Math.cos(anguloFlecha) * radioEstaciones);
		descY = (int) Math.round(Math.sin(anguloFlecha) * radioEstaciones);
		
		origenFlecha = new Point(posEstOrigen.x + descX, posEstOrigen.y + descY);
		destinoFlecha = new Point(posEstDestino.x - descX, posEstDestino.y - descY);
		
		dibujarFlecha(g2d, origenFlecha, destinoFlecha, r.getColorLinea(), anguloFlecha);
	}
	
	protected void dibujarFlecha(Graphics2D g2d, Point inicio, Point fin, Color color, Double angulo) {
		Point aux1, aux2;
		Double apertura = Math.atan(anchoFlecha/largoFlecha);
		Double hipotenusa = Math.sqrt(largoFlecha*largoFlecha + anchoFlecha*anchoFlecha);
		aux1 = new Point((int)Math.round(fin.x - Math.cos(angulo+apertura)*hipotenusa), (int)Math.round(fin.y - Math.sin(angulo+apertura)*hipotenusa));
		aux2 = new Point((int)Math.round(fin.x - Math.cos(angulo-apertura)*hipotenusa), (int)Math.round(fin.y - Math.sin(angulo-apertura)*hipotenusa));
		int[] x = {fin.x, aux1.x, aux2.x};
		int[] y = {fin.y, aux1.y, aux2.y};
		
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(1));
		g2d.drawLine(inicio.x, inicio.y, fin.x, fin.y);
		
		g2d.fillPolygon(x, y, 3);
	}*/
	
	
}
