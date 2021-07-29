package clases;

import java.awt.Graphics2D;

public interface Dibujable {
	public abstract void dibujarse(Graphics2D g2d);
	public abstract void reescalar(Float escala);
}
