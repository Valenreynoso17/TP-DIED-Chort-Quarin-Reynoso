package interfaces.julio.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import gestores.GestorEstacion;
import interfaces.julio.otros.ModeloTablaPageRank;

public class PanelTablaPageRank extends JPanel{

	private JTable tabla;
	private JScrollPane tableContainer;
	private ModeloTablaPageRank miModelo;
	private GridBagConstraints c;
	
	private GestorEstacion gestorEstacion = GestorEstacion.getInstance();
	
	public PanelTablaPageRank() {
		
			this.setBorder(new TitledBorder (new LineBorder (Color.black, 1), "Tabla de las estaciones según el PageRank"));
		
			this.setLayout(new GridBagLayout());
			c = new GridBagConstraints();
	
			miModelo = new ModeloTablaPageRank();
			
			miModelo.cargarTablaPageRank2(gestorEstacion.getEstaciones(), 0.85);
			
			tabla = new JTable(miModelo);
			tableContainer = new JScrollPane(tabla);
			
			tabla.getTableHeader().setReorderingAllowed(false); //Para que no se muevan las columnas
			
			tabla.setRowSelectionAllowed(true);
			tabla.setColumnSelectionAllowed(false);
			
			tabla.setFocusable(false); //Para que no seleccione una sola columna
			
			tabla.getTableHeader().setResizingAllowed(false);	//Para que no puedas cambiar el tamaño de las columnas
			
			tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			ordenarTablaPorPageRank();
				
			tabla.getColumnModel().getColumn(3).setMinWidth(400);	//Para que el nombre de la columna se vea bien
			
			DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
			headerRenderer.setBackground(new Color(255,102,102));
			tabla.getColumnModel().getColumn(4).setHeaderRenderer(headerRenderer);	//Para pintar el header de la columna de importancia
		
			//PARA CENTRAR
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			tabla.setDefaultRenderer(Object.class, centerRenderer);
			tabla.setDefaultRenderer(Integer.class, centerRenderer); //Por alguna razon no lo toma sin esto
			tabla.setDefaultRenderer(Double.class, centerRenderer);
			
			c.fill = GridBagConstraints.BOTH;
			c.insets = new Insets(20, 30, 20, 30);
			c.weightx = 1.0;
			c.weighty = 1.0;
			c.gridwidth = 3;
			c.gridx = 0;
			c.gridy = 1;
			this.add(tableContainer, c);
			c.fill = GridBagConstraints.NONE;
			c.weightx = 0.1;
			c.weighty = 0.2;
			c.gridwidth = 1;
	
	}
	
	
	
	public void ordenarTablaPorPageRank() {
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(miModelo);
		tabla.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		
		sortKeys.add(new RowSorter.SortKey(4, SortOrder.DESCENDING));
		//sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
		 
		sorter.setSortKeys(sortKeys);
		sorter.sort();
		
	}



	public void setNuevoValorDeAmortiguacion(Double nuevoValor) {
		
		miModelo.limpiarTabla();
		miModelo.cargarTablaPageRank2(gestorEstacion.getEstaciones(), nuevoValor);
	}

}
