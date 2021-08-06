package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import clases.Estacion;
import interfaces.valen.otros.ElementoListaTrayecto;
import interfaces.valen.otros.ModeloTablaAltaResumen;
import interfaces.valen.otros.ModeloTablaProximoMantenimiento;

public class PanelTablaProximoMantenimiento extends JPanel{
	
	JScrollPane panelScroll;
	JTable tabla;
	ModeloTablaProximoMantenimiento modeloTabla;
	GridBagConstraints gbc;
	
	public PanelTablaProximoMantenimiento(PriorityQueue<Estacion> colaPrioridad) {
		this.setBorder(new TitledBorder (new LineBorder (Color.black, 1), "Información estaciones"));
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weightx = 1.0;
		
		modeloTabla = new ModeloTablaProximoMantenimiento();
		cargarDatos(colaPrioridad);
		tabla = new JTable(modeloTabla);
		tabla.getTableHeader().setReorderingAllowed(false);
		
		// Configures table's column width.
		TableColumn column = null;
	    for (int i = 0; i < 6; i++) {
	    	column = tabla.getColumnModel().getColumn(i);
	    	if (i == 0 || i == 1) column.setPreferredWidth(1);
	    	if (i == 2) column.setPreferredWidth(20);
	    	if (i == 3) column.setPreferredWidth(100);
	    }
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tabla.setDefaultRenderer(Object.class, centerRenderer);
		tabla.setDefaultRenderer(Integer.class, centerRenderer);
		tabla.setDefaultRenderer(LocalDate.class, centerRenderer);
		
		panelScroll = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(panelScroll, gbc);
	}


	public void cargarDatos(PriorityQueue<Estacion> colaPrioridad) {
	
		modeloTabla.addColumn("Posicion");
		modeloTabla.addColumn("Estación");
		modeloTabla.addColumn("Estado");
		modeloTabla.addColumn("Cantidad de mantenimientos realizados");
		modeloTabla.addColumn("Fecha inicio último mantenimiento");
		modeloTabla.addColumn("Fecha fin último mantenimiento");
		
		Integer i = 1;
		Estacion unaEstacion;
		String fechaInicio;
		String fechaFin;
		while(!colaPrioridad.isEmpty()) {
			unaEstacion = colaPrioridad.poll();
			if (unaEstacion.getFechaInicioUltimoMantenimiento().isPresent()){
				fechaInicio = unaEstacion.getFechaInicioUltimoMantenimiento().get().toString();
			} else {
				fechaInicio = "-";
			}
			if (unaEstacion.getFechaUltimoMantenimientoRealizado().isPresent()){
				fechaFin = unaEstacion.getFechaUltimoMantenimientoRealizado().get().toString();
			} else {
				fechaFin = "-";
			}
			
			modeloTabla.addRow(new Object[] {i, unaEstacion.getNombre(), unaEstacion.getEstado().toString(),
											 unaEstacion.getMantenimientos().size(),
											 fechaInicio, fechaFin});                                     
			i++;
		}
	}
}