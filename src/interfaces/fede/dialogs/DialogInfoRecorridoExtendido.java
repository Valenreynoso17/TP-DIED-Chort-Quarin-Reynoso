package interfaces.fede.dialogs;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import clases.Recorrido;
import interfaces.fede.ventaBoleto.ModeloTablaRecorridoExtendida;

public class DialogInfoRecorridoExtendido extends JDialog {
	public DialogInfoRecorridoExtendido(Recorrido recorrido) {
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		this.setSize(300, 250);
		this.setLocationRelativeTo(null);
		this.setTitle("Info recorrido " + recorrido.toString());
		
		ModeloTablaRecorridoExtendida modeloTabla = new ModeloTablaRecorridoExtendida(recorrido);
		JTable tablaRecorrido = new JTable(modeloTabla);
		tablaRecorrido.getTableHeader().setReorderingAllowed(false);
		tablaRecorrido.setRowSelectionAllowed(false);
		tablaRecorrido.setFocusable(false);
		
		JScrollPane scrollPane = new JScrollPane(tablaRecorrido);
		this.setContentPane(scrollPane);
	}
}
