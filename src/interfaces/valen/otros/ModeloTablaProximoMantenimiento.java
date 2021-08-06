package interfaces.valen.otros;

import java.time.LocalDate;

import javax.swing.table.DefaultTableModel;

public class ModeloTablaProximoMantenimiento extends DefaultTableModel{

	public boolean isCellEditable (int row, int column){
		return false;
	}
	
	/** Primera columna Boolean, segunda Integer y el resto Object */
	public Class getColumnClass(int columna){
		if (columna == 0) return Integer.class;
		if (columna == 1) return String.class;
		if (columna == 2) return String.class;
		if (columna == 3) return Integer.class;
		if (columna == 4) return String.class;
		if (columna == 5) return String.class;
		return Object.class;
	}

}
