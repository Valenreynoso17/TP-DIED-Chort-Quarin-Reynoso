package interfaces.valen.otros;

import javax.swing.table.AbstractTableModel;

public class ModeloTablaAltaResumen extends AbstractTableModel{

	String[] nombreColumnas = {"Estación origen", "Estación destino", "Distancia",
			"Duración de viaje", "Cantidad máxima de pasajeros",
			"Estado ruta", "Costo"};
	
	// TODO: Ver como le paso los datos
	
	// TODO
	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public int getColumnCount() {
		return nombreColumnas.length;
	}

	// TODO
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}
	
	@Override
	public String getColumnName(int col) {
		return nombreColumnas[col].toString();
	}
	
	@Override
	public boolean isCellEditable(int row, int col){
		return false; 
    }
	
//	public Class getColumnClass(int c) {
//        return getValueAt(0, c).getClass();
//    }

}
