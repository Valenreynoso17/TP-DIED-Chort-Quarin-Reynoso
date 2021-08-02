package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
	private PageRank framePageRank;
	private ProximoMantenimiento frameProximoMantenimiento;	
	private VentanaGestionLineasDeTransporte frameLineaGestionar;
	
	public PanelMenuPrincipal(MenuPrincipal frame) {
		
	this.setBorder(new TitledBorder (new LineBorder (Color.black, 3), "Menú principal"));
	
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
		}
	});
	c.gridy = 3;
	this.add(button, c);
	
	button = new JButton("Flujo máximo");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			frame.dispose();
			//frameEstacionGestionar = new EstacionGestionar();
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
	
	Font fuente2 =new Font("Monospaced", Font.ITALIC, 10);	//TODO: Ver si se puede cambiar el tamaño de "fuente"

	label = new JLabel("Chort Julio - Quarin Federico - Reynoso Valentín");
	
	label.setFont(fuente2);
	c.anchor = GridBagConstraints.SOUTH;
	c.gridy = 0;
	c.weighty = 0.0;
	c.weightx = 0.0;
	this.add(label, c);

	}
	
}
