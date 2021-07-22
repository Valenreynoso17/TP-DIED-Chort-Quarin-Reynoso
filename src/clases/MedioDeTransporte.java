package clases;

<<<<<<< HEAD
public class MedioDeTransporte {

=======
import java.util.ArrayList;
import java.util.List;

public class MedioDeTransporte {

	private String tipo;
	
	private List<LineaDeTransporte> lineas;
	
	public MedioDeTransporte(String t) {
		this.tipo = t;
		this.lineas = new ArrayList<LineaDeTransporte>();
	}
	
	public void aniadirLinea(LineaDeTransporte l) {
		this.lineas.add(l);
	}
>>>>>>> 4676fe1 (Atributos y generadores)
}
