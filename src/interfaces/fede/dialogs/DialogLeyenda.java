package interfaces.fede.dialogs;

import java.awt.BasicStroke;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.StrokeBorder;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.text.EditorKit;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class DialogLeyenda extends JDialog {
	public DialogLeyenda(String descripcionVentana) {
		this.setSize(new Dimension(350, 350));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Informacion");
		
		JPanel panel = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		panel.setLayout(gbl);
		
		JTextPane textPane = new JTextPane();
		//txtArea.setContentType("text/html");
		textPane.setText(descripcionVentana);
		textPane.setPreferredSize(new Dimension(270, 250));
		textPane.setMargin(new Insets(10, 10, 10, 10));
		
		SimpleAttributeSet sa = new SimpleAttributeSet();
		StyleConstants.setAlignment(sa, StyleConstants.ALIGN_JUSTIFIED);
		StyleConstants.setSpaceBelow(sa, 3);
		//StyleConstants.setLeftIndent(sa, 10);

		textPane.getStyledDocument().setParagraphAttributes(0,descripcionVentana.length(),sa,false);
		
		//txtArea.setLineWrap(true);
		//txtArea.setWrapStyleWord(true);
		textPane.setOpaque(false);
		textPane.setBorder(
				   javax.swing.BorderFactory.createCompoundBorder(
				      javax.swing.BorderFactory.createStrokeBorder(new BasicStroke(1)),
				      javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4)
				   )
				);
		textPane.setEditable(false);
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridx = 0;
		gbc_textPane.gridy = 0;
		panel.add(textPane, gbc_textPane);
		
		this.setContentPane(panel);
	}
}
