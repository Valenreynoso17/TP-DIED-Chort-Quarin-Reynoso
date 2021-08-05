package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import interfaces.fede.frames.FrameFlujoMaximo;
import interfaces.fede.frames.FrameVentaBoleto;
import interfaces.julio.frames.EstacionGestionar;
import interfaces.julio.frames.MenuPrincipal;
import interfaces.julio.frames.PageRank;
import interfaces.julio.frames.ProximoMantenimiento;
import interfaces.valen.frames.VentanaGestionLineasDeTransporte;

public class PanelMenuPrincipal extends JPanel{
	
	private JButton button;
	private JLabel label;
	
	private Dimension dimEstandar = new Dimension(350,40);
	
	private EstacionGestionar frameEstacionGestionar;
	private VentanaGestionLineasDeTransporte frameLineaGestionar;
	private FrameVentaBoleto frameVentaBoleto;
	private FrameFlujoMaximo frameFlujoMaximo;
	private PageRank framePageRank;
	private ProximoMantenimiento frameProximoMantenimiento;	
	
	public PanelMenuPrincipal(MenuPrincipal frame) {
	
	this.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	Font fuente=new Font("Monospaced", Font.BOLD, 36);
	
	label = new JLabel("TP DIED 2021");
	label.setFont(fuente);
	c.anchor = GridBagConstraints.CENTER;
	c.gridx = 0; c.gridy = 0;
	c.weighty = 0.4;
	this.add(label, c);
	c.weighty = 0.1;
	
	button = new JButton("Gestionar estaciones");
	button.setBorder(new LineBorder (Color.black, 1));
	button.setPreferredSize(dimEstandar);
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			frameEstacionGestionar = new EstacionGestionar();
		}
	});
	c.gridy = 1;
	this.add(button, c);
	
	button = new JButton("Gestionar líneas de transporte");
	button.setBorder(new LineBorder (Color.black, 1));
	button.setPreferredSize(dimEstandar);
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose(); 
			frameLineaGestionar = new VentanaGestionLineasDeTransporte();
		}
	});
	c.gridy = 2;
	this.add(button, c);
	
	button = new JButton("Comprar boleto");
	button.setBorder(new LineBorder (Color.black, 1));
	button.setPreferredSize(dimEstandar);
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			frameVentaBoleto = new FrameVentaBoleto();
			frameVentaBoleto.setVisible(true);
		}
	});
	c.gridy = 3;
	this.add(button, c);
	
	button = new JButton("Flujo máximo");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			frameFlujoMaximo = new FrameFlujoMaximo();
			frameFlujoMaximo.setVisible(true);
		}
	});
	button.setBorder(new LineBorder (Color.black, 1));
	button.setPreferredSize(dimEstandar);
	c.gridy = 4;
	this.add(button, c);
	
	button = new JButton("Page Rank de Estaciones");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			framePageRank = new PageRank();
		}
	});
	button.setBorder(new LineBorder (Color.black, 1));
	button.setPreferredSize(dimEstandar);
	c.gridy = 5;
	this.add(button, c);
	
	button = new JButton("Próximo mantenimiento");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			frameProximoMantenimiento = new ProximoMantenimiento();
		}
	});
	button.setBorder(new LineBorder (Color.black, 1));
	button.setPreferredSize(dimEstandar);
	c.gridy = 6;
	this.add(button, c);
	
	button = new JButton("SALIR");
	button.setPreferredSize(dimEstandar);
	button.setBackground(new Color(255,102,102));
	button.setBorder(new LineBorder (Color.black, 1));
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
		}
	});
	c.gridy = 7;
	this.add(button, c);
	
	Font fuente2 =new Font("Monospaced", Font.ITALIC, 12);	

	label = new JLabel("Chort Julio - Quarin Federico - Reynoso Valentín");
	
	label.setFont(fuente2);
	c.anchor = GridBagConstraints.SOUTH;
	c.gridy = 0;
	c.weighty = 0.0;
	c.weightx = 0.0;
	this.add(label, c);
	
	label = new JLabel("V1.0");
	label.setFont(fuente2);
	c.gridy = 8;
	this.add(label, c);

	}
	
}
