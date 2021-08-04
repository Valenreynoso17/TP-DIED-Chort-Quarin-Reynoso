package interfaces.fede.otros;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderPrecios extends DefaultTableCellRenderer {
	public void setValue(Object value) {
		setHorizontalAlignment(SwingConstants.RIGHT);
		setText((value != null && value instanceof Double) ? "$" + String.format("%.2f", (Double) value) : "");
	}
}
