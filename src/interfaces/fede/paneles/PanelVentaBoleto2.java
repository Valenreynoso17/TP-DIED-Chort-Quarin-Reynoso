package interfaces.fede.paneles;

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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import clases.Estacion;
import clases.Recorrido;
import clases.Ruta;
import gestores.GestorRecorrido;
import gestores.GestorRuta;
import interfaces.fede.frames.FrameVentaBoleto2;
import interfaces.fede.frames.FrameVentaBoleto3;
import interfaces.fede.otros.ModeloTablaRecorridoExtendida;
import interfaces.fede.otros.ModeloTablaRecorridos;
import interfaces.fede.otros.RenderPrecios;
import interfaces.fede.panelesGrafos.PanelGrafico;
import interfaces.fede.panelesGrafos.PanelPermiteCambiarPosicion;
import interfaces.fede.panelesGrafos.PanelPintaSoloVisibles;
import interfaces.fede.panelesGrafos.PanelPintaTodo;
import interfaces.fede.panelesGrafos.PanelSeleccionOrigenDestino;
import interfaces.fede.panelesGrafos.PanelSoloEntreOrigenDestino;

public class PanelVentaBoleto2 extends JPanel {
	private JButton botonSiguiente;
	private Estacion origen, destino;
	private GestorRecorrido gestorRecorridos;
	private Recorrido seleccionado;
	private JTable tablaRecorridoExtendido;
	
	public PanelVentaBoleto2(Estacion origen, Estacion destino) {
		this.setBorder(new TitledBorder(new LineBorder(Color.black, 1) , "Seleccione un recorrido"));
		
		this.origen = origen;
		this.destino = destino;
		this.gestorRecorridos = GestorRecorrido.getInstance();
		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWeights = new double[]{0.1, 0.8, 0.8, 0.1};
		gbl.rowWeights = new double[]{0.1, 15.0, 0.1, 15.0, 0.1};
		this.setLayout(gbl);
		
		List<Recorrido> recorridos = gestorRecorridos.getRecorridos(origen, destino);
		
		PanelSoloEntreOrigenDestino panelGrafico = new PanelSoloEntreOrigenDestino(recorridos);
		
		JScrollPane spPanelGrafico = new JScrollPane(panelGrafico);		
		spPanelGrafico.setPreferredSize(new Dimension(600, 400));
		GridBagConstraints gbc_spPanelGrafico = new GridBagConstraints();
		gbc_spPanelGrafico.gridx = 2;
		gbc_spPanelGrafico.gridy = 0;
		gbc_spPanelGrafico.gridheight = 4;
		gbc_spPanelGrafico.insets = new Insets(20, 5, 20, 5);
		gbc_spPanelGrafico.fill = GridBagConstraints.BOTH;
		this.add(spPanelGrafico, gbc_spPanelGrafico);
		
		
		JLabel lblTablaRecorridos = new JLabel("Recorridos disponibles");
		GridBagConstraints gbc_lblTablaRecorridos = new GridBagConstraints();
		gbc_lblTablaRecorridos.gridx = 1;
		gbc_lblTablaRecorridos.gridy = 0;
		gbc_lblTablaRecorridos.anchor = GridBagConstraints.WEST;
		gbc_lblTablaRecorridos.insets = new Insets(10, 5, 5, 5);
		this.add(lblTablaRecorridos, gbc_lblTablaRecorridos);
		
		
		ModeloTablaRecorridos modeloTablaRecorrido = new ModeloTablaRecorridos(recorridos);
		JTable tablaRecorridos = new JTable(modeloTablaRecorrido);
		tablaRecorridos.setDefaultRenderer(Double.class, new RenderPrecios());
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
				tablaRecorridoExtendido.setModel(new ModeloTablaRecorridoExtendida(seleccionado));
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (!botonSiguiente.isEnabled()) botonSiguiente.setEnabled(true);
				seleccionado = recorridos.get(tablaRecorridos.convertRowIndexToModel(tablaRecorridos.getSelectedRow()));
				tablaRecorridoExtendido.setModel(new ModeloTablaRecorridoExtendida(seleccionado));
			}
		});
		
		
		
		JScrollPane spTablaRecorridos = new JScrollPane(tablaRecorridos);
		spTablaRecorridos.setPreferredSize(new Dimension(400, 100));
		GridBagConstraints gbc_spTablaRecorridos = new GridBagConstraints();
		gbc_spTablaRecorridos.gridx = 1;
		gbc_spTablaRecorridos.gridy = 1;
		gbc_spTablaRecorridos.insets = new Insets(10, 10, 20, 10);
		gbc_spTablaRecorridos.fill = GridBagConstraints.BOTH;
		this.add(spTablaRecorridos, gbc_spTablaRecorridos);
		
		
		/*JPanel panelTablaRecorridos = new JPanel();	
		panelTablaRecorridos.add(spTablaRecorridos);
		panelTablaRecorridos.setBorder(new TitledBorder(new LineBorder(Color.black, 1) , "Recorridos disponibles"));
		GridBagConstraints gbc_panelTablaRecorridos = new GridBagConstraints();
		gbc_panelTablaRecorridos.gridx = 1;
		gbc_panelTablaRecorridos.gridy = 0;
		gbc_panelTablaRecorridos.insets = new Insets(5, 5, 5, 5);
		this.add(panelTablaRecorridos, gbc_panelTablaRecorridos);*/
		
		JLabel lbltablaRecorridoExtendido = new JLabel("Mas información recorridos");
		GridBagConstraints gbc_lbltablaRecorridoExtendido = new GridBagConstraints();
		gbc_lbltablaRecorridoExtendido.gridx = 1;
		gbc_lbltablaRecorridoExtendido.gridy = 2;
		gbc_lbltablaRecorridoExtendido.anchor = GridBagConstraints.WEST;
		gbc_lbltablaRecorridoExtendido.insets = new Insets(10, 5, 5, 5);
		this.add(lbltablaRecorridoExtendido, gbc_lbltablaRecorridoExtendido);
		
		
		tablaRecorridoExtendido = new JTable(new ModeloTablaRecorridoExtendida(gestorRecorridos.recorridoSinRutas()));
		tablaRecorridoExtendido.getTableHeader().setReorderingAllowed(false);
		tablaRecorridoExtendido.setRowSelectionAllowed(false);
		tablaRecorridoExtendido.setFocusable(false);
		
		JScrollPane spTablaRecorridoExtendido = new JScrollPane(tablaRecorridoExtendido);
		spTablaRecorridoExtendido.setPreferredSize(new Dimension(400, 100));
		GridBagConstraints gbc_spTablaRecorridoExtendido = new GridBagConstraints();
		gbc_spTablaRecorridoExtendido.gridx = 1;
		gbc_spTablaRecorridoExtendido.gridy = 3;
		gbc_spTablaRecorridoExtendido.insets = new Insets(10, 10, 20, 10);
		gbc_spTablaRecorridoExtendido.fill = GridBagConstraints.BOTH;
		this.add(spTablaRecorridoExtendido, gbc_spTablaRecorridoExtendido);
		
		/*JPanel panelTablaRecorridoExtendido = new JPanel();	
		panelTablaRecorridoExtendido.add(spTablaRecorridoExtendido);
		panelTablaRecorridoExtendido.setBorder(new TitledBorder(new LineBorder(Color.black, 1) , "Mas informacion recorrido"));
		GridBagConstraints gbc_panelTablaRecorridoExtendido = new GridBagConstraints();
		gbc_panelTablaRecorridoExtendido.gridx = 1;
		gbc_panelTablaRecorridoExtendido.gridy = 1;
		gbc_panelTablaRecorridoExtendido.insets = new Insets(5, 5, 5, 5);
		this.add(panelTablaRecorridoExtendido, gbc_panelTablaRecorridoExtendido);*/
		
		JButton botonAtras = new JButton("  Atrás  ");
		botonAtras.addActionListener(e -> volverAtras());
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.gridx = 0;
		gbc_botonAtras.gridy = 4;
		gbc_botonAtras.insets = new Insets(5, 20, 10, 5);
		this.add(botonAtras, gbc_botonAtras);
		
		botonSiguiente = new JButton("Siguiente");
		botonSiguiente.setEnabled(false);
		botonSiguiente.addActionListener(e -> {
			FrameVentaBoleto3.crearVentana((FrameVentaBoleto2)getPadre(), seleccionado);
			getPadre().dispose();
		});
		GridBagConstraints gbc_botonSiguiente = new GridBagConstraints();
		gbc_botonSiguiente.gridx = 3;
		gbc_botonSiguiente.gridy = 4;
		gbc_botonSiguiente.insets = new Insets(5, 5, 10, 20);
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
