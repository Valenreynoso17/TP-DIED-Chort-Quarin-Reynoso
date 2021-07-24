package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import clases.Estacion;
import interfaces.julio.frames.EstacionEditar;
import interfaces.julio.frames.EstacionGestionar;
import interfaces.julio.otros.ModeloTabla;

public class PanelEstacionTablaResultado extends JPanel{

	private JLabel label;
	private JButton button;
	private JTextField field;
	private JPanel panelBusqueda;
	private JTable tabla;
	
	private EstacionEditar frameEdicion;
	
	private Vector filaSeleccionada;
	private Integer nroFilaSeleccionada;
	
	//PopUp borrarEstacion;?
	
	public PanelEstacionTablaResultado(EstacionGestionar frame) {
	
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 2), "Resultado"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		ModeloTabla miModelo = new ModeloTabla();
		cargarModelo(miModelo);
		tabla = new JTable(miModelo);
		JScrollPane tableContainer = new JScrollPane(tabla);
		
		tabla.setRowSelectionAllowed(true);
		tabla.setColumnSelectionAllowed(false);
		
		prueba(miModelo);
		
		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println(miModelo.getDataVector().elementAt(tabla.getSelectedRow()));
				
				filaSeleccionada = miModelo.getDataVector().elementAt(tabla.getSelectedRow());
				nroFilaSeleccionada = tabla.getSelectedRow();
			}
		});
		

		
		//PARA CENTRAR
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tabla.setDefaultRenderer(Object.class, centerRenderer);
		
		//this.add(tableContainer, BorderLayout.CENTER);
		c.fill = GridBagConstraints.BOTH;
		//c.anchor = GridBagConstraints.CENTER;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		this.add(tableContainer, c);
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.1;
		c.weighty = 0.1;
		c.gridwidth = 1;
		
		
		button = new JButton("Editar Estaci�n");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(filaSeleccionada == null) {
					JOptionPane.showMessageDialog(frame,
						    "Debe seleccionar una fila a ser editada.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}else {
				
				frame.dispose();
				frameEdicion = new EstacionEditar(filaSeleccionada);
				frameEdicion.setVisible(true);
			}
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		this.add(button, c);
		
		button = new JButton("Borrar Estaci�n");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(filaSeleccionada == null) {
					JOptionPane.showMessageDialog(frame,
						    "Debe seleccionar una fila a ser borrada.",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}else {
					
				Object[] options = {"Cancelar", "Borrar"};
				
				int n = JOptionPane.showOptionDialog(frame,
				"�Realmente desea borrar la estaci�n "+filaSeleccionada.elementAt(1)+" del sistema?",
				"Borrar Estaci�n",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
				
				//System.out.println(n);
				
				if(n == 1) {
					System.out.println("Apret� borrar");
					miModelo.removeRow(nroFilaSeleccionada);
				}
				else {
					System.out.println("Apret� cancelar o cerr� la ventana");
				}
			}
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
		this.add(button, c);
	}

	public static void cargarModelo(ModeloTabla miModelo) {
	
	miModelo.addColumn("Id");
	miModelo.addColumn("Nombre");
	miModelo.addColumn("Hora de apertura");
	miModelo.addColumn("Hora de cierre");
	miModelo.addColumn("Estado");
}

	public static void prueba(ModeloTabla miModelo) {
	
	Estacion[] estaciones = new Estacion[5];
	
	estaciones[0] = new Estacion("1", "A", LocalTime.of(8, 05), LocalTime.of(18, 45));
	estaciones[1] = new Estacion("2", "B", LocalTime.of(8, 15), LocalTime.of(15, 25));
	estaciones[2] = new Estacion("3", "C", LocalTime.of(11, 25), LocalTime.of(23, 45));
	estaciones[3] = new Estacion("4", "D", LocalTime.of(10, 35), LocalTime.of(20, 05));
	estaciones[4] = new Estacion("5", "E", LocalTime.of(9, 55), LocalTime.of(14, 50));
	
	for(int i = 0; i < estaciones.length; i++)
	miModelo.addRow(
			new Object[] {estaciones[i].getId(), estaciones[i].getNombre(), estaciones[i].getHorarioApertura(), estaciones[i].getHorarioCierre(), estaciones[i].getEstado()}
			);
}

}