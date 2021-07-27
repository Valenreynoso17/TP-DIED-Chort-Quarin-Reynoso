package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import interfaces.valen.otros.ModeloTablaAltaResumen;

public class PanelTablaAltaLinea extends JPanel{

	JScrollPane panelScroll;
	JTable tabla;
	TableModel modeloTabla;
	GridBagConstraints gbc;
	
//	int[] columnsWidth = {200, 25, 25, 25, 25, 25, 25, 25, 50};
	Object[][] data = {{"A", "B", 100, 50, 80, "Activo", 35}};
	
	public PanelTablaAltaLinea() {
		
		this.setBorder(BorderFactory.createTitledBorder("Resumen - Trayecto"));
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weightx = 1.0;
		
		modeloTabla = new ModeloTablaAltaResumen();
		tabla = new JTable(modeloTabla);
		
		
		
//		// Configures table's column width.
//        int i = 0;
//        for (int width : columnsWidth) {
//            TableColumn column = tabla.getColumnModel().getColumn(i++);
//            column.setMinWidth(width);
//            column.setMaxWidth(width);
//            column.setPreferredWidth(width);
//        }
//		tabla.setAutoCreateRowSorter(true);
//		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		tabla.doLayout();
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		tabla.setDefaultRenderer(Object.class, centerRenderer);
		
		panelScroll = new JScrollPane(tabla);
		
		this.add(panelScroll, gbc);
	}
}
