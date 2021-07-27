package interfaces.fede.ventaBoleto;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import clases.Estacion;
import clases.Recorrido;

public class ModeloTablaRecorridos extends DefaultTableModel {
	private List<Recorrido> recorridos;
	
	public ModeloTablaRecorridos(List<Recorrido> recorridos) {
		this.recorridos = recorridos;
		String[] columnNames = {"Recorrido", "Duración", "Distancia", "Precio"};
		this.setColumnIdentifiers(columnNames);
		
		for (Recorrido r : recorridos) {
			String valor = "";
			this.setRowCount(this.getRowCount()+1);
			
			List<Estacion> estaciones = r.getEstacionesRecorridas();
			for (int i=0; i<estaciones.size()-1; i++) {
				valor += estaciones.get(i).getNombre() + " - "; 
			}
			valor += estaciones.get(estaciones.size()-1).getNombre();
			
			this.setValueAt(valor, getRowCount()-1, 0);
			this.setValueAt(r.getDuracion(), getRowCount()-1, 1);
			this.setValueAt(r.getDistancia(), getRowCount()-1, 2);
			this.setValueAt("$" + String.format("%.2f", r.getCosto()), getRowCount()-1, 3);		
		}
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	
	
	
}
