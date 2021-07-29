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
		
		//int selectedIndex = ((Integer)value).intValue();
			
		/*if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}*/
		if (value instanceof Ruta) {
			setForeground(((Ruta) value).getColorLinea());
			setText(((Ruta) value).linea());
		}
			
		//Set the icon and text.  If icon was null, say so.
		
		
		setFont(list.getFont());
			
		return this;
	}
}
			
				
