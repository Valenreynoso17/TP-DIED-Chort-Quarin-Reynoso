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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombreColor == null) ? 0 : nombreColor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof CustomColor))
			return false;
		CustomColor other = (CustomColor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombreColor == null) {
			if (other.nombreColor != null)
				return false;
		} else if (!nombreColor.equals(other.nombreColor))
			return false;
		return true;
	}
	
	
	
}
