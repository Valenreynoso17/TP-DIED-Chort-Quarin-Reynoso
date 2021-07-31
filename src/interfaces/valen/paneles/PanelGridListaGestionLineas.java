package interfaces.valen.paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import clases.CustomColor;
import clases.LineaDeTransporte;
import enums.EstadoLineaDeTransporte;
import gestores.GestorLineaDeTransporte;
import interfaces.valen.frames.VentanaGestionLineasDeTransporte;
import interfaces.valen.otros.ElementoListaGestionTransporte;

public class PanelGridListaGestionLineas extends JPanel{
	
	GridBagConstraints gbc;
	GestorLineaDeTransporte gestorLinea;

	public PanelGridListaGestionLineas(VentanaGestionLineasDeTransporte frame, Boolean ckbActiva, Boolean ckbNoActiva, String buscaNombre, CustomColor colorBusqueda) {
		
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(2,2,2,2);
		gbc.gridx = GridBagConstraints.RELATIVE;
		
		gestorLinea = GestorLineaDeTransporte.getInstance();
		
//		Optional<List<LineaDeTransporte>> lista = Optional.ofNullable(gestorLinea.getLineasDeTransporte());
		
		Predicate<LineaDeTransporte> filtroCheckBoxes;
		if(ckbActiva == true && ckbNoActiva == true) {
			filtroCheckBoxes = e -> true;
		}else if (ckbActiva == true) {
			filtroCheckBoxes = e -> e.estaActiva() == true;
		}else if (ckbNoActiva){
			filtroCheckBoxes = e -> e.estaActiva() == false;
		} else {
			filtroCheckBoxes = e -> false;
		}
		
		Predicate<LineaDeTransporte> filtroBusqueda = lt -> lt.getNombre().toUpperCase().contains(buscaNombre.toUpperCase());
		
		Predicate<LineaDeTransporte> filtroColor;
		if(colorBusqueda.getNombre() == "Ninguno") filtroColor = cc -> true;
		else filtroColor = lt -> lt.getColor().equals(colorBusqueda);
		
		List<LineaDeTransporte> lista = gestorLinea.getLineasDeTransporte().stream().filter(filtroCheckBoxes).filter(filtroBusqueda).filter(filtroColor).collect(Collectors.toList());
//		if(lista != null) {
			Integer valorGridy = 0;
			for(int i = 0; i < lista.size(); i++) {
				
				ElementoListaGestionTransporte auxElemento = new ElementoListaGestionTransporte(frame, lista.get(i));
				
				gbc.gridy = valorGridy;
				this.add(auxElemento, gbc);
				
				if (i % 2 == 1) valorGridy++;
			}
//		}
		
	}
}
