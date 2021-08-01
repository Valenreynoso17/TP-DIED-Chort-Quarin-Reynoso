package clases;

import java.awt.Color;

public class CustomColor extends Color{
	
	Integer id;
	String nombreColor;	
	
	public CustomColor(Integer id, String nombreColor, Integer r, Integer g, Integer b) {
		super(r,g,b);
		this.id = id;
		this.nombreColor = nombreColor;
	}
	
	public String getNombre() {
		return nombreColor;
	}

	@Override
	public String toString() {
		return "CustomColor [id=" + id + ", nombreColor=" + nombreColor + "]";
	}
	
	
	
}
