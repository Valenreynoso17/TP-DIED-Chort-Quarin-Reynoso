package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import clases.Estacion;
import enums.EstadoEstacion;
import gestores.GestorEstacion;
import interfaces.julio.frames.EstacionAlta;
import interfaces.julio.frames.EstacionEditar;
import interfaces.julio.frames.EstacionGestionar;
import interfaces.julio.frames.MenuPrincipal;
import interfaces.julio.frames.PageRank;
import interfaces.julio.otros.ModeloTablaEstaciones;
import interfaces.julio.otros.ModeloTablaPageRank;

public class PanelPageRank extends JPanel{

	private JComboBox<String> comboBox;
	private JButton button;
	private JLabel label;

	private JTable tabla;
	private JScrollPane tableContainer;
	private ModeloTablaPageRank miModelo;
	
	private GestorEstacion gestorEstacion = GestorEstacion.getInstance();
	
	public PanelPageRank(PageRank frame) {
		
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 3), "Page Rank de las estaciones"));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		miModelo = new ModeloTablaPageRank();
		
		miModelo.cargarTablaPageRank(gestorEstacion.getEstaciones());
		
		tabla = new JTable(miModelo);
		tableContainer = new JScrollPane(tabla);
		
		tabla.getTableHeader().setReorderingAllowed(false); //Para que no se muevan las columnas
		
		tabla.setRowSelectionAllowed(true);
		tabla.setColumnSelectionAllowed(false);
		
		tabla.setFocusable(false); //Para que no seleccione una sola columna
		
		tabla.getTableHeader().setResizingAllowed(false);	//Para que no puedas cambiar el tamaño de las columnas
		
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//tabla.setAutoCreateRowSorter(true);	//Para que se ordenen
		
		ordenarTablaPorPageRank();
			
		tabla.getColumnModel().getColumn(3).setMinWidth(500);	//Para que el nombre de la columna se vea bien

		//PARA CENTRAR
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tabla.setDefaultRenderer(Object.class, centerRenderer);
		tabla.setDefaultRenderer(Integer.class, centerRenderer); //Por alguna razon no lo toma sin esto
//		
		c.fill = GridBagConstraints.BOTH;
//		label = new JLabel("Para la próxima versión.");
//		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(30, 30, 30, 30);
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		this.add(tableContainer, c);
		c.fill = GridBagConstraints.NONE;
		c.weightx = 0.1;
		c.weighty = 0.2;
		c.gridwidth = 1;
		
		
		button = new JButton("Volver");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				new MenuPrincipal();
			}
		});
		c.insets = new Insets(0,100,20,0);
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 0;
		c.gridy = 1;
		this.add(button, c);
		
		
	}
	
	
	public void ordenarTablaPorPageRank() {
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(miModelo);
		tabla.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		
		sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
		 
		sorter.setSortKeys(sortKeys);
		sorter.sort();
		
	}

	
}
