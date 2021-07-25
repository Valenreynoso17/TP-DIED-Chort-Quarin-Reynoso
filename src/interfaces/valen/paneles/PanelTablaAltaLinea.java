package interfaces.valen.paneles;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelTablaAltaLinea extends JPanel{

	JScrollPane panelScroll;
	JTable tabla;
	String[] nombreColumnas = {	"Estación origen", "Estación destino", "Distancia",
								"Duración de viaje", "Cantidad máxima de pasajeros",
								"Estado ruta", "Costo"};
	Object[][] data = {{"A", "B", 100, 50, 80, "Activo", 35}};
	public PanelTablaAltaLinea() {
		
		tabla = new JTable(data, nombreColumnas);
		
		panelScroll = new JScrollPane(tabla);
		
		this.add(panelScroll);
	}
}
