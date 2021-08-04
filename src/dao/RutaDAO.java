package dao;

import java.util.List;

import clases.Ruta;

public interface RutaDAO {
	public List<Ruta> buscar();
	public void eliminar();
	public void insertar(List<Ruta> ruta);
	public void modificarRutas(List<Ruta> listaRutasAEditar);
	public Integer getSiguienteIdRuta();
}
