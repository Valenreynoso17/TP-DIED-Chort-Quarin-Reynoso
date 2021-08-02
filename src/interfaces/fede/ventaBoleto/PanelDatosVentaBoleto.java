package interfaces.fede.ventaBoleto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.MaskFormatter;

import clases.Boleto;
import clases.Recorrido;
import excepciones.InputInvalidaException;
import excepciones.InputVacioException;
import gestores.GestorBoleto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;

public class PanelDatosVentaBoleto extends JPanel {
	private JTextField txtFFechaVenta;
	private JTextField txtFCorreoCliente;
	private JTextField txtFNombreCliente;
	private JTextField txtFDestino;
	private JTextField txtFOrigen;
	private JTextField txtFPrecio;
	
	private Recorrido recorrido;
	private GestorBoleto gestorBoletos;
	private Integer nroBoleto;
	private LocalDate fechaActual;
	
	public PanelDatosVentaBoleto(Recorrido recorrido) {
		this.recorrido = recorrido;
		this.gestorBoletos = GestorBoleto.getInstance();
		
		this.setPreferredSize(new Dimension(800, 600));
		this.setBorder(new TitledBorder(new LineBorder(Color.black, 1) , "Datos de la venta"));
		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWeights = new double[]{0.2, 1.0, 0.2, 1.0};
		gbl.rowWeights = new double[]{0.5, 0.5, 1.0, 0.2};
		this.setLayout(gbl);
		
		JLabel lblNroBoleto = new JLabel("Nro. boleto");
		GridBagConstraints gbc_lblNroBoleto = new GridBagConstraints();
		//gbc_lblNroBoleto.anchor = GridBagConstraints.EAST;
		gbc_lblNroBoleto.gridx = 0;
		gbc_lblNroBoleto.gridy = 0;
		gbc_lblNroBoleto.insets = new Insets(5, 10, 5, 5);
		this.add(lblNroBoleto, gbc_lblNroBoleto);
		
		nroBoleto = GestorBoleto.getSiguienteNroBoleto();
		JTextField txtFNroBoleto = new JTextField(nroBoleto.toString());
		txtFNroBoleto.setEditable(false);
		GridBagConstraints gbc_txtFNroBoleto = new GridBagConstraints();
		gbc_txtFNroBoleto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFNroBoleto.gridx = 1;
		gbc_txtFNroBoleto.gridy = 0;
		gbc_txtFNroBoleto.insets = new Insets(5, 5, 5, 5);
		this.add(txtFNroBoleto, gbc_txtFNroBoleto);
		
		JLabel lblFechaVenta = new JLabel("Fecha de venta");
		GridBagConstraints gbc_lblFechaVenta = new GridBagConstraints();
		gbc_lblFechaVenta.insets = new Insets(5, 5, 5, 5);
		gbc_lblFechaVenta.anchor = GridBagConstraints.EAST;
		gbc_lblFechaVenta.gridx = 2;
		gbc_lblFechaVenta.gridy = 0;
		add(lblFechaVenta, gbc_lblFechaVenta);
		
		fechaActual = LocalDate.now();
		txtFFechaVenta = new JTextField(fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		txtFFechaVenta.setEditable(false);
		GridBagConstraints gbc_txtFFechaVenta = new GridBagConstraints();
		gbc_txtFFechaVenta.insets = new Insets(5, 5, 5, 5);
		gbc_txtFFechaVenta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFFechaVenta.gridx = 3;
		gbc_txtFFechaVenta.gridy = 0;
		add(txtFFechaVenta, gbc_txtFFechaVenta);
		
		// Panel datos cliente y sus componentes
		JPanel panelDatosCliente = new JPanel();
		//panelDatosCliente.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1) , "Datos del cliente", 0, Font.PLAIN, Color.GRAY));
		panelDatosCliente.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), "Datos del cliente"));
		GridBagConstraints gbc_panelDatosCliente = new GridBagConstraints();
		gbc_panelDatosCliente.gridwidth = 4;
		gbc_panelDatosCliente.insets = new Insets(5, 5, 5, 5);
		gbc_panelDatosCliente.fill = GridBagConstraints.BOTH;
		gbc_panelDatosCliente.gridx = 0;
		gbc_panelDatosCliente.gridy = 1;
		add(panelDatosCliente, gbc_panelDatosCliente);
		GridBagLayout gbl_panelDatosCliente = new GridBagLayout();
		gbl_panelDatosCliente.columnWeights = new double[]{0.2, 1.0, 0.2, 1.0};
		gbl_panelDatosCliente.rowWeights = new double[]{0.0};
		panelDatosCliente.setLayout(gbl_panelDatosCliente);
		
		JLabel lblNombreCliente = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombreCliente = new GridBagConstraints();
		gbc_lblNombreCliente.anchor = GridBagConstraints.EAST;
		gbc_lblNombreCliente.insets = new Insets(5, 5, 5, 5);
		gbc_lblNombreCliente.gridx = 0;
		gbc_lblNombreCliente.gridy = 0;
		panelDatosCliente.add(lblNombreCliente, gbc_lblNombreCliente);
		
		
		
		txtFNombreCliente = new JTextField();	
		GridBagConstraints gbc_txtFNombreCliente = new GridBagConstraints();
		gbc_txtFNombreCliente.insets = new Insets(5, 5, 5, 5);
		gbc_txtFNombreCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFNombreCliente.gridx = 1;
		gbc_txtFNombreCliente.gridy = 0;
		panelDatosCliente.add(txtFNombreCliente, gbc_txtFNombreCliente);
		
		
		
		JLabel lblCorreoCliente = new JLabel("Correo electronico");
		GridBagConstraints gbc_lblCorreoCliente = new GridBagConstraints();
		gbc_lblCorreoCliente.insets = new Insets(5, 5, 5, 5);
		gbc_lblCorreoCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCorreoCliente.gridx = 2;
		gbc_lblCorreoCliente.gridy = 0;
		panelDatosCliente.add(lblCorreoCliente, gbc_lblCorreoCliente);
		
		txtFCorreoCliente = new JTextField();
		GridBagConstraints gbc_txtFCorreoCliente = new GridBagConstraints();
		gbc_txtFCorreoCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFCorreoCliente.insets = new Insets(5, 5, 5, 5);
		gbc_txtFCorreoCliente.gridx = 3;
		gbc_txtFCorreoCliente.gridy = 0;
		panelDatosCliente.add(txtFCorreoCliente, gbc_txtFCorreoCliente);
		
		// Panel datos recorrido y sus componentes
		JPanel panelDatosRecorrido = new JPanel();
		panelDatosRecorrido.setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), "Datos del recorrido"));
		GridBagConstraints gbc_panelDatosRecorrido = new GridBagConstraints();
		gbc_panelDatosRecorrido.gridwidth = 4;
		gbc_panelDatosRecorrido.insets = new Insets(5, 5, 5, 5);
		gbc_panelDatosRecorrido.fill = GridBagConstraints.BOTH;
		gbc_panelDatosRecorrido.gridx = 0;
		gbc_panelDatosRecorrido.gridy = 2;
		add(panelDatosRecorrido, gbc_panelDatosRecorrido);
		GridBagLayout gbl_panelDatosRecorrido = new GridBagLayout();
		gbl_panelDatosRecorrido.columnWeights = new double[]{0.2, 1.0, 0.2, 1.0};
		gbl_panelDatosRecorrido.rowWeights = new double[]{0.2, 0.1, 1.0};
		panelDatosRecorrido.setLayout(gbl_panelDatosRecorrido);
		
		JLabel lblEstacionOrigen = new JLabel("Estacion origen");
		GridBagConstraints gbc_lblEstacionOrigen = new GridBagConstraints();
		gbc_lblEstacionOrigen.insets = new Insets(5, 5, 5, 5);
		gbc_lblEstacionOrigen.anchor = GridBagConstraints.EAST;
		gbc_lblEstacionOrigen.gridx = 0;
		gbc_lblEstacionOrigen.gridy = 0;
		panelDatosRecorrido.add(lblEstacionOrigen, gbc_lblEstacionOrigen);
		
		txtFOrigen = new JTextField(recorrido.getOrigen().getNombre());
		txtFOrigen.setEditable(false);
		GridBagConstraints gbc_txtFOrigen = new GridBagConstraints();
		gbc_txtFOrigen.insets = new Insets(5, 5, 5, 5);
		gbc_txtFOrigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFOrigen.gridx = 1;
		gbc_txtFOrigen.gridy = 0;
		panelDatosRecorrido.add(txtFOrigen, gbc_txtFOrigen);
		
		JLabel lblEstacionDestino = new JLabel("Estacion destino");
		GridBagConstraints gbc_lblEstacionDestino = new GridBagConstraints();
		gbc_lblEstacionDestino.insets = new Insets(5, 5, 5, 5);
		gbc_lblEstacionDestino.anchor = GridBagConstraints.EAST;
		gbc_lblEstacionDestino.gridx = 2;
		gbc_lblEstacionDestino.gridy = 0;
		panelDatosRecorrido.add(lblEstacionDestino, gbc_lblEstacionDestino);
		
		txtFDestino = new JTextField(recorrido.getDestino().getNombre());
		txtFDestino.setEditable(false);
		GridBagConstraints gbc_txtFDestino = new GridBagConstraints();
		gbc_txtFDestino.insets = new Insets(5, 5, 5, 5);
		gbc_txtFDestino.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFDestino.gridx = 3;
		gbc_txtFDestino.gridy = 0;
		panelDatosRecorrido.add(txtFDestino, gbc_txtFDestino);
		
		JLabel lblRecorrido = new JLabel("Recorrido");
		GridBagConstraints gbc_lblRecorrido = new GridBagConstraints();
		gbc_lblRecorrido.insets = new Insets(5, 5, 5, 5);
		gbc_lblRecorrido.gridx = 0;
		gbc_lblRecorrido.gridy = 1;
		panelDatosRecorrido.add(lblRecorrido, gbc_lblRecorrido);
		
		ModeloTablaRecorridoExtendida modeloTabla = new ModeloTablaRecorridoExtendida(recorrido);
		JTable tablaRecorrido = new JTable(modeloTabla);
		tablaRecorrido.getTableHeader().setReorderingAllowed(false);
		tablaRecorrido.setRowSelectionAllowed(false);
		tablaRecorrido.setFocusable(false);
		
		JScrollPane scrollPane = new JScrollPane(tablaRecorrido);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(5, 5, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panelDatosRecorrido.add(scrollPane, gbc_scrollPane);
		
		JLabel lblPrecio = new JLabel("Precio total");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(5, 5, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 3;
		add(lblPrecio, gbc_lblPrecio);
		
		txtFPrecio = new JTextField("$" + String.format("%.2f", recorrido.getCosto()));		
		txtFPrecio.setEditable(false);
		GridBagConstraints gbc_txtFPrecio = new GridBagConstraints();
		gbc_txtFPrecio.insets = new Insets(5, 5, 5, 5);
		gbc_txtFPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFPrecio.gridx = 1;
		gbc_txtFPrecio.gridy = 3;
		add(txtFPrecio, gbc_txtFPrecio);
	}
	
	
	public void validarCamposNoVacios() throws InputVacioException {
		String error = "";
		if (txtFNombreCliente.getText().isEmpty() || txtFNombreCliente.getText().isBlank()) error += "\n - Nombre";
		if (txtFCorreoCliente.getText().isEmpty() || txtFCorreoCliente.getText().isBlank()) error += "\n - Correo";
			
			
		if (!error.isEmpty()) throw new InputVacioException(error);
	}
	
	public void validarNombre() throws InputInvalidaException {
		if (!txtFNombreCliente.getText().matches("[a-zA-Z ]+")) throw new InputInvalidaException();
	}
	
	public void validarCorreo() throws InputInvalidaException {
		if (!txtFCorreoCliente.getText().matches("[a-zA-Z0-9()<>@,;:\\\"ç%&]+@[a-z]+[.][a-z]+")) throw new InputInvalidaException();
	}
	
	public void crearBoleto() {
		gestorBoletos.cargarBoleto(nroBoleto, txtFCorreoCliente.getText(), txtFNombreCliente.getText(), fechaActual, recorrido);
	}
}
