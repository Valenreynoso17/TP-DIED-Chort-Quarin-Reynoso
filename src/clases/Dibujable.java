package clases;

import java.awt.Graphics2D;
import java.awt.Shape;

public interface Dibujable {
	public abstract void dibujarse(Graphics2D g2d);
	public abstract void reescalar(Float escala);
	public abstract Boolean visible();
	public abstract Shape getHitbox();
}
