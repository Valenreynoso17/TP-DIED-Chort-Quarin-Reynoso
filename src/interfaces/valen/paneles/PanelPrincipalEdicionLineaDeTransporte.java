package interfaces.valen.paneles;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clases.CustomColor;
import clases.LineaDeTransporte;
import excepciones.DatosRutaInvalidosException;
import excepciones.InputInvalidaException;
import excepciones.InputVacioException;
import excepciones.NombreColorEnUsoException;
import excepciones.TrayectoInvalidoException;
import excepciones.TrayectoVacioException;
import gestores.GestorLineaDeTransporte;
import interfaces.fede.panelesGrafos.PanelGrafico;
import interfaces.valen.frames.VentanaEdicionLineaDeTransporte;
import interfaces.valen.frames.VentanaSiguienteAltaLineaDeTransporte;

public class PanelPrincipalEdicionLineaDeTransporte extends JPanel{
	
	PanelDatosLineaDeTransporte panelDatosLinea;
	PanelDatosTrayectoLineaDeTransporte panelDatosTrayecto;
	PanelBotonesEdicionLinea panelBotones;
	GridBagConstraints gbc = new GridBagConstraints();
	LineaDeTransporte lineaDeTransporte;
	VentanaEdicionLineaDeTransporte frame;
	
	public PanelPrincipalEdicionLineaDeTransporte(VentanaEdicionLineaDeTransporte frame, LineaDeTransporte lineaDeTransporte) {
		
		this.frame = frame;
		this.lineaDeTransporte = lineaDeTransporte;
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		// GridBag de 3x1
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		
		// Primer componente - panel datos linea
		gbc.gridy = 0;
		panelDatosLinea = new PanelDatosLineaDeTransporte(frame, lineaDeTransporte);
		this.add(panelDatosLinea, gbc);
		
		// Segundo componente - panel datos trayecto
		gbc.gridy = 1;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		
		panelDatosTrayecto = new PanelDatosTrayectoLineaDeTransporte(lineaDeTransporte);
		JScrollPane panelScrollDatosTrayecto = new JScrollPane(panelDatosTrayecto, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelScrollDatosTrayecto.setBorder(new TitledBorder (new LineBorder (Color.black, 1), "Datos del trayecto"));
		this.add(panelScrollDatosTrayecto, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weighty = 0.0;
		
		gbc.insets = new Insets(5, 5, 5, 5);
		// Tercer componente - panel botones
		gbc.gridy = 2;
		panelBotones = new PanelBotonesEdicionLinea(frame, this);
		this.add(panelBotones, gbc);
		
	}
	
	public void actualizarDatos() {
		
		try {
			String nuevoNombre = panelDatosLinea.getNuevoNombre();
			String nuevoEstado = panelDatosLinea.getNuevoEstado();
			CustomColor nuevoColor = panelDatosLinea.getNuevoColor();
			
			nombreLineaEstaVacia(nuevoNombre);
			datosLineaValido(nuevoNombre, nuevoColor);
			nombreColorEnUso(nuevoNombre, nuevoColor);		
			
			List<ElementoListaEdicionLineaDeTransporte> listaElementos = panelDatosTrayecto.recuperarDatos();
			
			for(ElementoListaEdicionLineaDeTransporte unElemento : listaElementos) {
				this.rutaCamposVacios(unElemento.getStringOrigen(),unElemento.getStringDestino(), unElemento.getDistancia(), unElemento.getDuracion(), unElemento.getCantMaxPasajeros(), unElemento.getCosto());
				this.rutasDatosValidos(unElemento.getDistancia(), unElemento.getDuracion(), unElemento.getCantMaxPasajeros(), unElemento.getCosto());
			}
			
			GestorLineaDeTransporte gestorLinea = GestorLineaDeTransporte.getInstance();
			gestorLinea.editarLineaDeTransporte(lineaDeTransporte, nuevoNombre, nuevoEstado, nuevoColor, listaElementos);
			
		}catch (InputVacioException IVE) {
		
			JOptionPane.showMessageDialog(frame,
										  "Faltan completar los siguientes campos:\n\n"+IVE.getMessage(),
										  "Error",
										  JOptionPane.ERROR_MESSAGE);
		}catch (InputInvalidaException IIE) {
		
			JOptionPane.showMessageDialog(frame,
										  IIE.getMessage() + "- El nombre de la línea debe contener menos de 30 caracteres. \n"
										  				   + "- El color seleccionado debe ser un color válido. \n",	
										  "Error",
										  JOptionPane.ERROR_MESSAGE);
			
		} catch (NombreColorEnUsoException NCEUE) {
			
			JOptionPane.showMessageDialog(frame,
					  					  NCEUE.getMessage(),	
					  					  "Error",
					  					  JOptionPane.ERROR_MESSAGE);
			
		}catch (DatosRutaInvalidosException DRIE) {
		
			JOptionPane.showMessageDialog(frame,
										  DRIE.getMessage() ,	
										  "Error",
										  JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void nombreLineaEstaVacia(String nombre) throws InputVacioException{
		String error = "";
		boolean algunoVacio = false;
		
		if(nombre.isEmpty()) {
			error += "- Nombre línea\n";
			algunoVacio = true;
		}
		
		if(algunoVacio) {
			
			throw new InputVacioException(error);
		}
			
				
	}
	
	public void datosLineaValido(String nombreLinea, CustomColor colorL) throws InputInvalidaException{
		
		if(!(nombreLinea.length() <= 30 && colorL.getNombre() != "Ninguno")) {
			throw new InputInvalidaException();
		}
		
	}
	
	public void nombreColorEnUso(String nomb, CustomColor col) throws NombreColorEnUsoException{
		GestorLineaDeTransporte gestorLinea = GestorLineaDeTransporte.getInstance();
		Optional<LineaDeTransporte> optionalLinea = gestorLinea.getLineasDeTransporte().stream().filter(lt -> !lt.equals(lineaDeTransporte) && (lt.getNombre().equals(nomb) || lt.getColor().equals(col))).findAny();
		
		if (!optionalLinea.isEmpty()) {
			throw new NombreColorEnUsoException();
		}
	}
	
	public void rutaCamposVacios(String o, String d, String dist, String dur, String cantMax, String cost) throws InputVacioException{
		String error = "En la ruta entre " + o + " y " + d + ": \n";
		boolean algunoVacio = false;
		
		if(dist.isEmpty()) {
			error += "- Distancia\n";
			algunoVacio = true;
		}
		
		if(dur.isEmpty()) {
			error += "- Duración\n";
			algunoVacio = true;
		}
		
		if(cantMax.isEmpty()) {
			error += "- Cantidad máxima de pasajeros\n";
			algunoVacio = true;
		}
		
		if(cost.isEmpty()) {
			error += "- Costo\n";
			algunoVacio = true;
		}
		
		if(algunoVacio) {
			
			throw new InputVacioException(error);
		}
			
				
	}
	
	public void rutasDatosValidos(String dist, String dur, String cantPasa, String costo) throws DatosRutaInvalidosException{
		
		// Checkear que son todos numeros y mayores a 0
		try {
			if(!(Integer.parseInt(dist) >= 0 && Integer.parseInt(dur) >= 0 && Integer.parseInt(cantPasa) >= 0 && Double.parseDouble(costo) >= 0)) {
				throw new DatosRutaInvalidosException("Los campos de todas las rutas tienen que cumplir las siguientes restricciones: \n"
		  				   + "- La distancia debe ser un número entero mayor a 0. \n"
  				   		   + "- La duración del viaje debe ser un número entero mayor a 0. \n"
  				   		   + "- La cantidad máxima de pasajeros debe ser un número entero mayor a 0. \n"
  				   		   + "- El costo debe ser un número mayor 0. \n");
			}
		}catch (NumberFormatException nfe) {
			throw new DatosRutaInvalidosException("Los campos de todas las rutas tienen que cumplir las siguientes restricciones: \n"
	  				   							+ "- La distancia debe ser un número entero mayor a 0. \n"
	  				   							+ "- La duración del viaje debe ser un número entero mayor a 0. \n"
	  				   							+ "- La cantidad máxima de pasajeros debe ser un número entero mayor a 0. \n"
	  				   							+ "- El costo debe ser un número mayor 0. \n");
		}
	}

}
