package interfaces.julio.otros;

import java.time.LocalTime;

import javax.swing.table.DefaultTableModel;

import enums.EstadoEstacion;

public class ModeloTabla extends DefaultTableModel{
	
	public boolean isCellEditable (int row, int column)
	   {
	       // Aquí devolvemos true o false según queramos que una celda
	       // identificada por fila,columna (row,column), sea o no editable
	       if (column == 3)
	          return true;
	       return false;
	   }
	
	/** Primera columna Boolean, segunda Integer y el resto Object */
	   public Class getColumnClass(int columna)
	   {
	      if (columna == 0) return String.class;
	      if (columna == 1) return String.class;
	      if (columna == 2) return LocalTime.class;
	      if (columna == 3) return LocalTime.class;
	      if (columna == 4) return EstadoEstacion.class; //Enum?
	      return Object.class;
	   }

}
