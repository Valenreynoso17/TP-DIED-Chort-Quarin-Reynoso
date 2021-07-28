package interfaces.fede.ventaBoleto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import clases.Estacion;
import clases.Recorrido;
import clases.Ruta;
import gestores.GestorRecorrido;
import gestores.GestorRuta;
import interfaces.fede.frames.FrameVentaBoleto2;
import interfaces.fede.frames.FrameVentaBoleto3;
import interfaces.fede.panelesGrafos.PanelGrafico;

public class PanelVentaBoleto2 extends JPanel {
	private JButton botonSiguiente;
	private Estacion origen, destino;
	private GestorRecorrido gestorRecorridos;
	private Recorrido seleccionado;
	
	public PanelVentaBoleto2(Estacion origen, Estacion destino) {
		this.origen = origen;
		this.destino = destino;
		this.gestorRecorridos = GestorRecorrido.getInstance();
		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWeights = new double[]{0.1, 0.5, 0.1};
		gbl.rowWeights = new double[]{0.5, 0.2, 0.0, 0.0};
		this.setLayout(gbl);
		
		JPanel panelGrafico = new JPanel();
		panelGrafico.setBackground(Color.WHITE);
		panelGrafico.setPreferredSize(new Dimension(600, 400));
		
		JScrollPane spPanelGrafico = new JScrollPane(panelGrafico);		
		GridBagConstraints gbc_spPanelGrafico = new GridBagConstraints();
		gbc_spPanelGrafico.gridx = 1;
		gbc_spPanelGrafico.gridy = 0;
		gbc_spPanelGrafico.insets = new Insets(5, 5, 5, 5);
		this.add(spPanelGrafico, gbc_spPanelGrafico);
		
		List<Recorrido> recorridos = gestorRecorridos.getRecorridos(origen, destino);
		
		JTable tablaRecorridos = new JTable(new ModeloTablaRecorridos(recorridos));
		tablaRecorridos.setAutoCreateRowSorter(true);
		tablaRecorridos.getTableHeader().setReorderingAllowed(false);
		tablaRecorridos.setRowSelectionAllowed(true);
		tablaRecorridos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaRecorridos.setFocusable(false);
		tablaRecorridos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!botonSiguiente.isEnabled()) botonSiguiente.setEnabled(true);
				seleccionado = recorridos.get(tablaRecorridos.convertRowIndexToModel(tablaRecorridos.getSelectedRow()));
				System.out.println(seleccionado);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (!botonSiguiente.isEnabled()) botonSiguiente.setEnabled(true);
				seleccionado = recorridos.get(tablaRecorridos.convertRowIndexToModel(tablaRecorridos.getSelectedRow()));
				System.out.println(seleccionado);
			}
		});
		JScrollPane spTablaRecorridos = new JScrollPane(tablaRecorridos);
		spTablaRecorridos.setPreferredSize(new Dimension(500, 100));
		GridBagConstraints gbc_spTablaRecorridos = new GridBagConstraints();
		gbc_spTablaRecorridos.gridx = 1;
		gbc_spTablaRecorridos.gridy = 1;
		gbc_spTablaRecorridos.insets = new Insets(5, 5, 5, 5);
		this.add(spTablaRecorridos, gbc_spTablaRecorridos);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addActionListener(e -> volverAtras());
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.gridx = 0;
		gbc_botonAtras.gridy = 2;
		gbc_botonAtras.insets = new Insets(5, 5, 5, 5);
		this.add(botonAtras, gbc_botonAtras);
		
		botonSiguiente = new JButton("Siguiente");
		botonSiguiente.setEnabled(false);
		botonSiguiente.addActionListener(e -> {
			FrameVentaBoleto3.crearVentana((FrameVentaBoleto2)getPadre(), seleccionado);
			getPadre().dispose();
		});
		GridBagConstraints gbc_botonSiguiente = new GridBagConstraints();
		gbc_botonSiguiente.gridx = 2;
		gbc_botonSiguiente.gridy = 2;
		gbc_botonSiguiente.insets = new Insets(5, 5, 5, 5);
		this.add(botonSiguiente, gbc_botonSiguiente);
		
		

		
		
		
	}
	
	public JFrame getPadre() {
		return (JFrame) this.getTopLevelAncestor();
	}
	
	public void volverAtras() {
		getPadre().dispose();
		((FrameVentaBoleto2) getPadre()).abriVentanaAnterior();
	}
}
