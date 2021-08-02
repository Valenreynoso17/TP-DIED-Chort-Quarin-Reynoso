package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import interfaces.valen.otros.ElementoListaTrayecto;
import interfaces.valen.otros.ModeloTablaAltaResumen;

public class PanelTablaAltaLinea extends JPanel{

	JScrollPane panelScroll;
	JTable tabla;
	ModeloTablaAltaResumen modeloTabla;
	GridBagConstraints gbc;
	
	public PanelTablaAltaLinea(List<ElementoListaTrayecto> listaTrayecto) {
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weightx = 1.0;
		
		modeloTabla = new ModeloTablaAltaResumen();
		cargarDatos(listaTrayecto);
		tabla = new JTable(modeloTabla);
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setAutoCreateRowSorter(true);
		
		// Configures table's column width.
		TableColumn column = null;
        for (int i = 0; i < 7; i++) {
        	column = tabla.getColumnModel().getColumn(i);
        	if (i == 4) column.setPreferredWidth(120);
        }
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tabla.setDefaultRenderer(Object.class, centerRenderer);
		
		panelScroll = new JScrollPane(tabla);
		
		this.add(panelScroll, gbc);
	}
	
	public void cargarDatos(List<ElementoListaTrayecto> listaTrayecto) {
		
		modeloTabla.addColumn("Estación origen");
		modeloTabla.addColumn("Estación destino");
		modeloTabla.addColumn("Distancia");
		modeloTabla.addColumn("Duración de viaje");
		modeloTabla.addColumn("Cantidad máxima de pasajeros");
		modeloTabla.addColumn("Estado ruta");
		modeloTabla.addColumn("Costo");
		
		for(ElementoListaTrayecto unElemento : listaTrayecto) {
			modeloTabla.addRow(new Object[] {unElemento.getEstacionOrigen(), unElemento.getEstacionDestino(),
											 unElemento.getDistancia(), unElemento.getDuracion(),
											 unElemento.getCantMaxPasajeros(), unElemento.getEstado(),
											 unElemento.getCosto()});
		}
	}
}
