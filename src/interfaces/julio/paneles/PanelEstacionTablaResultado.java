package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import clases.Estacion;
import gestores.GestorEstacion;
import interfaces.julio.frames.EstacionEditar;
import interfaces.julio.frames.EstacionEditarGrafo;
import interfaces.julio.frames.EstacionGestionar;
import interfaces.julio.otros.ModeloTablaEstaciones;

public class PanelEstacionTablaResultado extends JPanel{

	private JLabel label;
	private JButton botonEditar, botonBorrar, botonEditarGrafo;
	private JTextField field;
	private JPanel panelBusqueda;
	private JTable tabla;
	private ModeloTablaEstaciones miModelo;
	
	private Vector filaSeleccionada = null;
	private Integer nroFilaSeleccionada;
	private JScrollPane tableContainer;
	
	private EstacionEditar frameEdicion;
	private EstacionEditarGrafo frameEditarGrafo;
	
	Predicate<Estacion> filtroId, filtroNombre, filtroHoraApertura, filtroMinutoApertura, filtroHoraCierre, filtroMinutoCierre;
	
	private GestorEstacion gestorEstacion = GestorEstacion.getInstance();
	
	public PanelEstacionTablaResultado(EstacionGestionar frame) {
	
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 1), "Resultado"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		miModelo = new ModeloTablaEstaciones();
		
		miModelo.cargarEstaciones(gestorEstacion.getEstaciones());
		
		tabla = new JTable(miModelo);
		tableContainer = new JScrollPane(tabla);
		
		tabla.getTableHeader().setReorderingAllowed(false); //Para que no se muevan las columnas
		
		tabla.setRowSelectionAllowed(true);
		tabla.setColumnSelectionAllowed(false);
		
		tabla.setFocusable(false); //Para que no seleccione una sola columna
		
		tabla.getTableHeader().setResizingAllowed(false);	//Para que no puedas cambiar el tamaño de las columnas
		
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tabla.setAutoCreateRowSorter(true);	//Para que se ordenen
		
		tabla.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {				
				filaSeleccionada = miModelo.getDataVector().elementAt(tabla.getSelectedRow());
				nroFilaSeleccionada = tabla.getSelectedRow();
				botonEditar.setEnabled(true);
				botonBorrar.setEnabled(true);
			}
		});
		

		
		//PARA CENTRAR
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tabla.setDefaultRenderer(Object.class, centerRenderer);
		tabla.setDefaultRenderer(Integer.class, centerRenderer); //Por alguna razon no lo toma sin esto
		
		//this.add(tableContainer, BorderLayout.CENTER);
		c.fill = GridBagConstraints.BOTH;
		//c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 30, 0, 30);
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		this.add(tableContainer, c);
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.1;
		c.weighty = 0.1;
		c.gridwidth = 1;
		
		
		botonEditar = new JButton("Editar Estación");
		botonEditar.setEnabled(false);	//Deshabilitado por defecto
		botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				frameEdicion = new EstacionEditar(filaSeleccionada);
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		this.add(botonEditar, c);
		
		botonBorrar = new JButton("Borrar Estación");
		botonBorrar.setEnabled(false); 		//Deshabilitado por defecto
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				Object[] options = {"Cancelar", "Borrar"};
				
				int n = JOptionPane.showOptionDialog(frame,
				"¿Realmente desea borrar la estación "+filaSeleccionada.elementAt(1)+" del sistema?\n" +
				"Tenga en cuenta que esto va a eliminar TODAS las rutas que lleguen\n" +
				"o salgan de la estación seleccionada y sus mantenimientos pasados/actuales.",
				"Borrar Estación",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,     //do not use a custom Icon
				options,  //the titles of buttons
				options[0]); //default button title
				
				if(n == 1) { //Apreta "borrar"					
					gestorEstacion.eliminarEstacion((Integer) filaSeleccionada.elementAt(0));
					
					miModelo.removeRow(nroFilaSeleccionada);
					filaSeleccionada = null;
					botonEditar.setEnabled(false);
					botonBorrar.setEnabled(false);
				}
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
		this.add(botonBorrar, c);
		
		botonEditarGrafo = new JButton("Editar grafo de estaciones");
		botonEditarGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				frameEditarGrafo = new EstacionEditarGrafo();
			}
		});
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 1;
		this.add(botonEditarGrafo, c);
	}
	
	public void actualizarTabla(String[] campos) {
		
		miModelo.limpiarTabla();
		
		filtroId = (campos[0] == null) ? e -> true : e -> e.getId().toString().contains(campos[0]);
		
		filtroNombre = (campos[1] == null) ? e -> true : e -> e.getNombre().toUpperCase().contains(campos[1].toUpperCase()); 
		
		filtroHoraApertura = (campos[2] == null) ? e -> true : e -> ((Integer) e.getHorarioApertura().getHour()).toString().contains(campos[2]); // == (Integer.parseInt(campos[2]));
		
		filtroMinutoApertura = (campos[3] == null) ? e -> true : e -> ((Integer) e.getHorarioApertura().getMinute()).toString().contains(campos[3]); // == (Integer.parseInt(campos[3]));
		
		filtroHoraCierre = (campos[4] == null) ? e -> true : e -> ((Integer) e.getHorarioCierre().getHour()).toString().contains(campos[4]); // == (Integer.parseInt(campos[4]));
		
		filtroMinutoCierre = (campos[5] == null) ? e -> true : e -> ((Integer)e.getHorarioCierre().getMinute()).toString().contains(campos[5]); // == (Integer.parseInt(campos[5])); 
		
		List<Estacion> estaciones = gestorEstacion.getEstaciones().stream().filter(filtroId)
																		   .filter(filtroNombre)
																		   .filter(filtroHoraApertura)
																		   .filter(filtroMinutoApertura)
																		   .filter(filtroHoraCierre)
																		   .filter(filtroMinutoCierre)
																		   .collect(Collectors.toList());
		miModelo.cargarEstaciones(estaciones);
		
	}

}