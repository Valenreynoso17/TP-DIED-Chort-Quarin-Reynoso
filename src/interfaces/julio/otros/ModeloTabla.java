package interfaces.julio.otros;

import java.time.LocalTime;

import javax.swing.table.DefaultTableModel;

import enums.EstadoEstacion;

public class ModeloTabla extends DefaultTableModel{
	
	public boolean isCellEditable (int row, int column)
	   {
	       return false;
	   }
	
	/** Primera columna Boolean, segunda Integer y el resto Object */
	   public Class getColumnClass(int columna)
	   {
	      if (columna == 0) return Integer.class;
	      if (columna == 1) return String.class;
	      if (columna == 2) return LocalTime.class;
	      if (columna == 3) return LocalTime.class;
	      if (columna == 4) return EstadoEstacion.class;
	      return Object.class;
	   }

}
