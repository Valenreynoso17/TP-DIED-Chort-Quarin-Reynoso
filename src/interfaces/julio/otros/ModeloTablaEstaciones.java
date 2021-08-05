package interfaces.julio.otros;

import java.time.LocalTime;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import clases.Estacion;
import enums.EstadoEstacion;

public class ModeloTablaEstaciones extends DefaultTableModel{
	
	public ModeloTablaEstaciones() {
		this.addColumn("Id"); 
		this.addColumn("Nombre"); 
		this.addColumn("Hora de apertura");
		this.addColumn("Hora de cierre"); 
		this.addColumn("Estado");
	}
	
	   public Class getColumnClass(int columna)
	   {
	      if (columna == 0) return Integer.class;
	      if (columna == 1) return String.class;
	      if (columna == 2) return LocalTime.class;
	      if (columna == 3) return LocalTime.class;
	      if (columna == 4) return EstadoEstacion.class;
	      return Object.class;
	   }

	public void limpiarTabla() {

		this.setRowCount(0); //Elimino todas las filas de la tabla
	}
	
	public void cargarEstaciones(List<Estacion> estaciones) {
		
		for(Estacion e : estaciones) {
			this.addRow(new Object[] {e.getId()
									, e.getNombre()
									, LocalTime.of(e.getHorarioApertura().getHour(), e.getHorarioApertura().getMinute())
									, LocalTime.of(e.getHorarioCierre().getHour(), e.getHorarioCierre().getMinute())
									, e.getEstado()});
		}

	}
	
}
