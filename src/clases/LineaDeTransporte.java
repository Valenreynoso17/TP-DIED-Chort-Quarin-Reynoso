package clases;

<<<<<<< HEAD
public class LineaDeTransporte {

=======
import java.util.ArrayList;
import java.util.List;

import enums.ColorLinea;
import enums.EstadoRuta;

public class LineaDeTransporte {

	private String id;  //Tiene sentido que le asigne el usuario el id?
	private String nombre;
	private ColorLinea color;
	private EstadoRuta estado; //VER
	
	private MedioDeTransporte medio;
	private List<Trayecto> trayectos;
	
	public LineaDeTransporte(String i, String n, ColorLinea c, EstadoRuta e, MedioDeTransporte m) {
		this.id = i;
		this.nombre = n;
		this.color = c;
		this.estado = e;
		this.medio = m;
		this.trayectos = new ArrayList<Trayecto>();
	}
	
	public void aniadirTrayecto(Trayecto t) {
		this.trayectos.add(t);
	}
>>>>>>> 4676fe1 (Atributos y generadores)
}
