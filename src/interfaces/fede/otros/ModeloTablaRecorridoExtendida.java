package interfaces.fede.otros;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import clases.Estacion;
import clases.Recorrido;
import clases.Ruta;
import excepciones.TrayectoNoAsociadoException;
import gestores.GestorRuta;

public class ModeloTablaRecorridoExtendida extends DefaultTableModel {
	
	public ModeloTablaRecorridoExtendida(Recorrido recorrido) {
		String[] columnNames = {"Ruta", "Linea", "Distancia", "Duracion", "Precio"};
		this.setColumnIdentifiers(columnNames);
		
		List<Ruta> rutas = recorrido.getRutas();
		for (Ruta r : rutas) {
			this.setRowCount(this.getRowCount()+1);
			
			this.setValueAt(r.getOrigen().getNombre() + " --> " + r.getDestino().getNombre(), getRowCount()-1, 0);
			try{
				this.setValueAt(r.getNombreLinea(), getRowCount()-1, 1);
			}
			catch (TrayectoNoAsociadoException exc1) {
				GestorRuta gestorRutas = GestorRuta.getInstance();
				gestorRutas.asociarATrayectos();
				try {
					this.setValueAt(r.getNombreLinea(), getRowCount()-1, 1);
				}
				catch (TrayectoNoAsociadoException exc2) {
					exc2.printStackTrace();
				}
			}
			this.setValueAt(r.getDuracion(), getRowCount()-1, 2);
			this.setValueAt(r.getDistancia(), getRowCount()-1, 3);
			this.setValueAt("$" + String.format("%.2f", r.getCosto()), getRowCount()-1, 4);	
		}
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
