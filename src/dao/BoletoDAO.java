package dao;

import java.util.List;

import clases.Boleto;

public interface BoletoDAO {
	public List<Boleto> buscar();
	public void eliminar();
	public void insertar(Boleto boleto) ;
	public void modificar();
	public Integer getUltimoNroBoleto();
}
