package interfaces.fede.otros;

import java.awt.Color;

public class GamaColor {
	private Color relleno, borde;
	public final static GamaColor AZUL = new GamaColor(new Color(39, 75, 211), new Color(3, 25, 111));
	public final static GamaColor VERDE = new GamaColor(new Color(14, 186, 67), new Color(8, 109, 39));
	public final static GamaColor GRIS = new GamaColor(new Color(194, 194, 194), new Color(100, 100, 100));
	
	public GamaColor(Color relleno, Color borde) {
		this.relleno = relleno;
		this.borde = borde;
	}
	
	public Color getBorde() {
		return this.borde;
	}
	
	public Color getRelleno() {
		return this.relleno;
	}
}	
