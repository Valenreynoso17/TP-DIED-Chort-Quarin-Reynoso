package clases;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BotonInfo implements Dibujable {
	private BufferedImage imagen;
	private Point posSuperior, tam;
	
	public BotonInfo() {
		posSuperior = new Point(5, 5);
		tam = new Point(20, 20);
		
		File imageSrc = new File("icon.png");
		try {
			imagen = ImageIO.read(imageSrc);
		}
		catch (IOException exc) {
			exc.printStackTrace();
		}
	}
	
	
	@Override
	public void dibujarse(Graphics2D g2d) {
		g2d.drawImage(imagen, posSuperior.x, posSuperior.y, posSuperior.x + tam.x, posSuperior.y + tam.y, 4, 0, 606, 600, null);

	}

	@Override
	public void reescalar(Float escala) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean visible() {
		return true;
	}

	@Override
	public Shape getHitbox() {
		return new Ellipse2D.Double(posSuperior.getX(), posSuperior.getY(), tam.getX(), tam.getY());
	}



}
