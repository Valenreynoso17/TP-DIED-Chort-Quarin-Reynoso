package interfaces.fede.dialogs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

import clases.Estacion;
import clases.Ruta;
import excepciones.LineaNoAsociadaException;
import excepciones.TrayectoNoAsociadoException;
import gestores.GestorRuta;


public class RenderInfoFlecha<E> extends JLabel implements ListCellRenderer<E> {
	public RenderInfoFlecha() {
	}
	@Override
	public Component getListCellRendererComponent(JList<? extends E> list, E value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		if (value instanceof Ruta) {
			Ruta r = (Ruta) value;
			Color colorLinea = Color.white;
			String nombreLinea = "Error";
			
			try {
				colorLinea = r.getColorLinea();
				nombreLinea = r.getNombreLinea();
			}
			catch (TrayectoNoAsociadoException exc) {
				GestorRuta gestor = GestorRuta.getInstance();
				gestor.asociarATrayectos();
				
				try {
					colorLinea = r.getColorLinea();
					nombreLinea = r.getNombreLinea();
				} catch (TrayectoNoAsociadoException e) {
					System.out.println("f");
					e.printStackTrace();
				}
				
			}
			
			if (r.activa()) {
				setForeground(colorLinea);
				setFont(list.getFont());
				setText(nombreLinea);
			}
			else {
				setForeground(new Color(90, 90, 90));
				setFont(new Font("ff", Font.ITALIC, 12));
				setText(nombreLinea + " - No activa");
			}
			
		}
			
		return this;
	}
}
			
				
