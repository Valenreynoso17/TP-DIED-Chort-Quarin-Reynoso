package interfaces.valen.otros;

public class ElementoListaTrayecto {
	String estacionOrigen;
	String estacionDestino;
	Integer distancia;
	Integer duracion;
	Integer cantMaxPasajeros;
	Integer costo;
	String estado;
	
	public ElementoListaTrayecto(String estacionOrigen, String estacionDestino, Integer distancia, Integer duracion,
			Integer cantMaxPasajeros, Integer costo, String estado) {
		this.estacionOrigen = estacionOrigen;
		this.estacionDestino = estacionDestino;
		this.distancia = distancia;
		this.duracion = duracion;
		this.cantMaxPasajeros = cantMaxPasajeros;
		this.costo = costo;
		this.estado = estado;
	}
	
	public String getEstaciones() {
		return estacionOrigen + " - " + estacionDestino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estacionDestino == null) ? 0 : estacionDestino.hashCode());
		result = prime * result + ((estacionOrigen == null) ? 0 : estacionOrigen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ElementoListaTrayecto))
			return false;
		ElementoListaTrayecto other = (ElementoListaTrayecto) obj;
		if (estacionDestino == null) {
			if (other.estacionDestino != null)
				return false;
		} else if (!estacionDestino.equals(other.estacionDestino))
			return false;
		if (estacionOrigen == null) {
			if (other.estacionOrigen != null)
				return false;
		} else if (!estacionOrigen.equals(other.estacionOrigen))
			return false;
		return true;
	}

	public String getEstacionOrigen() {
		return estacionOrigen;
	}

	public String getEstacionDestino() {
		return estacionDestino;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public Integer getCantMaxPasajeros() {
		return cantMaxPasajeros;
	}

	public Integer getCosto() {
		return costo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstacionOrigen(String estacionOrigen) {
		this.estacionOrigen = estacionOrigen;
	}

	public void setEstacionDestino(String estacionDestino) {
		this.estacionDestino = estacionDestino;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public void setCantMaxPasajeros(Integer cantMaxPasajeros) {
		this.cantMaxPasajeros = cantMaxPasajeros;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
