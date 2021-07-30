package interfaces.fede.panelesGrafos;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

import clases.Estacion;
import clases.Ruta;


public class RenderInfoFlecha<E> extends JLabel implements ListCellRenderer<E> {
	public RenderInfoFlecha() {
	}
	@Override
	public Component getListCellRendererComponent(JList<? extends E> list, E value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		if (value instanceof Ruta) {
			Ruta r = (Ruta) value;
			setForeground(r.getColorLinea());
			setText(r.linea());
			
		}
			
		setFont(list.getFont());
			
		return this;
	}
}
			
				
