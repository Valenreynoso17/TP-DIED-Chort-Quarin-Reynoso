package interfaces.fede.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clases.Estacion;
import clases.Recorrido;
import excepciones.SinEstacionesAccesiblesException;
import gestores.GestorEstacion;
import gestores.GestorRecorrido;
import interfaces.fede.panelesGrafos.PanelGraficoFlujoMaximo;
import interfaces.fede.panelesGrafos.PanelSeleccionOrigenDestino;

public class PanelFlujoMaximo extends JPanel {	
	private GestorEstacion gestorEstaciones;
	private GestorRecorrido gestorRecorridos;
	private PanelSeleccionOrigenDestino panelSeleccion;
	private PanelGraficoFlujoMaximo panelGraficoFlujoMaximo;
	private JScrollPane scrollPane;
	private JButton botonCalcular;
	private JTextField txtFieldFlujoMaximo;
	private Boolean flujoMaximoMostrandose;
	private Estacion origen, destino;
	
	
	public PanelFlujoMaximo() {
		flujoMaximoMostrandose = false;
		gestorEstaciones = GestorEstacion.getInstance();
		gestorRecorridos = GestorRecorrido.getInstance();
		List<Estacion> estaciones = gestorEstaciones.getEstacionesOperativas();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.1, 0.4, 0.4, 0.4, 0.4, 0.1, 0.1, 0.1};
		gridBagLayout.rowWeights = new double[]{0.1, 2.0, 2.0, 0.1, 0.1};
		setLayout(gridBagLayout);
		
		JPanel panelOrigenDestino = new JPanel();
		panelOrigenDestino.setBorder(new TitledBorder(new LineBorder(Color.black, 1) , "Seleccione estación origen y destino para calcular el flujo máximo de pasajeros"));
		GridBagLayout gbl_panelOrigenDestino = new GridBagLayout();
		gbl_panelOrigenDestino.columnWeights = new double[]{0.1, 1.0, 0.1, 1.0};
		gbl_panelOrigenDestino.rowWeights = new double[]{0.1};
		panelOrigenDestino.setLayout(gbl_panelOrigenDestino);
		
		GridBagConstraints gbc_panelOrigenDestino = new GridBagConstraints();
		gbc_panelOrigenDestino.fill = GridBagConstraints.BOTH;
		gbc_panelOrigenDestino.insets = new Insets(10, 20, 10, 20);
		gbc_panelOrigenDestino.gridx = 0;
		gbc_panelOrigenDestino.gridy = 0;
		gbc_panelOrigenDestino.gridwidth = 6;
		add(panelOrigenDestino, gbc_panelOrigenDestino);
		
		
		JLabel llbOrigen = new JLabel("Origen:");
		GridBagConstraints gbc_llbOrigen = new GridBagConstraints();
		gbc_llbOrigen.anchor = GridBagConstraints.EAST;
		gbc_llbOrigen.insets = new Insets(10, 10, 10, 10);
		gbc_llbOrigen.gridx = 0;
		gbc_llbOrigen.gridy = 0;
		panelOrigenDestino.add(llbOrigen, gbc_llbOrigen);
		

		
		JLabel lblDestino = new JLabel("Destino:");
		GridBagConstraints gbc_lblDestino = new GridBagConstraints();
		gbc_lblDestino.insets = new Insets(10, 10, 10, 10);
		gbc_lblDestino.anchor = GridBagConstraints.EAST;
		gbc_lblDestino.gridx = 2;
		gbc_lblDestino.gridy = 0;
		panelOrigenDestino.add(lblDestino, gbc_lblDestino);
		
		JComboBox<Estacion> comboBoxDestino = new JComboBox<>();
		comboBoxDestino.setEnabled(false);
		comboBoxDestino.addActionListener(e -> {
			if (flujoMaximoMostrandose) {
				int opcion = JOptionPane
						.showConfirmDialog(getPadre(), 
								"¿Desea seleccionar una nueva estacion?", 
								"Cambio de estacion", 
								JOptionPane.OK_CANCEL_OPTION, 
								JOptionPane.QUESTION_MESSAGE);
				System.out.println(opcion);
				if (opcion == JOptionPane.OK_OPTION) {
					scrollPane.setViewportView(panelSeleccion);
					flujoMaximoMostrandose = false;
					
				}
				else {
					comboBoxDestino.setSelectedItem(destino);
				}
			}
			
			if (!flujoMaximoMostrandose) {
				if (comboBoxDestino.getSelectedItem() != null) {
					destino = (Estacion)comboBoxDestino.getSelectedItem();
					panelSeleccion.pintarDestino(destino);
					botonCalcular.setEnabled(true);
				}
				else botonCalcular.setEnabled(false);
			}

		});
		GridBagConstraints gbc_comboBoxDestino = new GridBagConstraints();
		gbc_comboBoxDestino.anchor = GridBagConstraints.WEST;
		gbc_comboBoxDestino.insets = new Insets(10, 10, 10, 10);
		gbc_comboBoxDestino.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDestino.gridx = 3;
		gbc_comboBoxDestino.gridy = 0;
		panelOrigenDestino.add(comboBoxDestino, gbc_comboBoxDestino);
		
		JComboBox<Estacion> comboBoxOrigen = new JComboBox<Estacion>(estaciones.toArray(new Estacion[estaciones.size()]));
		comboBoxOrigen.setSelectedItem(null);
		comboBoxOrigen.addActionListener(e -> {
			if (flujoMaximoMostrandose) {
				int opcion = JOptionPane
						.showConfirmDialog(getPadre(), 
								"¿Desea seleccionar una nueva estacion?", 
								"Cambio de estacion", 
								JOptionPane.OK_CANCEL_OPTION, 
								JOptionPane.QUESTION_MESSAGE);
				System.out.println(opcion);
				if (opcion == JOptionPane.OK_OPTION) {
					scrollPane.setViewportView(panelSeleccion);
					flujoMaximoMostrandose = false;
					
				}
				else {
					comboBoxOrigen.setSelectedItem(origen);
				}
			}
			
			if (!flujoMaximoMostrandose) {
				try{
					List<Estacion> accesible = gestorEstaciones.getEstacionesOperativasAccesibles((Estacion)comboBoxOrigen.getSelectedItem());
					comboBoxDestino.setModel(new DefaultComboBoxModel<>(accesible.toArray(new Estacion[accesible.size()])));
					comboBoxDestino.setEnabled(true);
					comboBoxDestino.setSelectedItem(null);
				}
				catch (SinEstacionesAccesiblesException exc) {
					comboBoxDestino.setEnabled(false);
					comboBoxDestino.setSelectedItem(null);

					JOptionPane.showMessageDialog(getPadre(), exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				finally {
					origen = (Estacion) comboBoxOrigen.getSelectedItem();
					panelSeleccion.pintarOrigen(origen);
					
				}
			}
			
			
		});
		GridBagConstraints gbc_comboBoxOrigen = new GridBagConstraints();
		gbc_comboBoxOrigen.anchor = GridBagConstraints.WEST;
		gbc_comboBoxOrigen.insets = new Insets(10, 10, 10, 10);
		gbc_comboBoxOrigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxOrigen.gridx = 1;
		gbc_comboBoxOrigen.gridy = 0;
		panelOrigenDestino.add(comboBoxOrigen, gbc_comboBoxOrigen);
		
		
		
		panelSeleccion = new PanelSeleccionOrigenDestino();		
		scrollPane = new JScrollPane(panelSeleccion);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(15, 20, 15, 20);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.gridheight = 2;
		add(scrollPane, gbc_scrollPane);
		
		JLabel lblFlujoMaximo = new JLabel("Resultado");
		GridBagConstraints gbc_lblFlujoMaximo = new GridBagConstraints();
		gbc_lblFlujoMaximo.insets = new Insets(10, 10, 10, 10);
		gbc_lblFlujoMaximo.gridx = 2;
		gbc_lblFlujoMaximo.gridy = 3;
		add(lblFlujoMaximo, gbc_lblFlujoMaximo);
		
		txtFieldFlujoMaximo = new JTextField();
		txtFieldFlujoMaximo.setEditable(false);		
		GridBagConstraints gbc_txtFieldFlujoMaximo = new GridBagConstraints();
		gbc_txtFieldFlujoMaximo.insets = new Insets(10, 10, 10, 10);
		gbc_txtFieldFlujoMaximo.anchor = GridBagConstraints.WEST;
		gbc_txtFieldFlujoMaximo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldFlujoMaximo.gridx = 3;
		gbc_txtFieldFlujoMaximo.gridy = 3;
		add(txtFieldFlujoMaximo, gbc_txtFieldFlujoMaximo);
		
		JButton botonAtras = new JButton("  Atrás  ");
		botonAtras.addActionListener(e -> getPadre().dispose());
		GridBagConstraints gbc_botonAtras = new GridBagConstraints();
		gbc_botonAtras.insets = new Insets(5, 20, 10, 5);
		gbc_botonAtras.gridx = 0;
		gbc_botonAtras.gridy = 4;
		add(botonAtras, gbc_botonAtras);
		
		botonCalcular = new JButton("Calcular");
		botonCalcular.setEnabled(false);
		botonCalcular.addActionListener(e -> {
			List<Recorrido> recorridos = gestorRecorridos.getRecorridos(origen, destino);
			panelGraficoFlujoMaximo = new PanelGraficoFlujoMaximo(recorridos);
			scrollPane.setViewportView(panelGraficoFlujoMaximo);
			txtFieldFlujoMaximo.setText(String.valueOf(gestorRecorridos.calcularFlujoMaximo(recorridos)));
			flujoMaximoMostrandose = true;
		});
		GridBagConstraints gbc_botonSiguiente = new GridBagConstraints();
		gbc_botonSiguiente.insets = new Insets(5, 5, 10, 20);
		gbc_botonSiguiente.gridx = 5;
		gbc_botonSiguiente.gridy = 4;
		add(botonCalcular, gbc_botonSiguiente);
	}
	
	public JFrame getPadre() {
		return (JFrame) this.getTopLevelAncestor();
	}
}
