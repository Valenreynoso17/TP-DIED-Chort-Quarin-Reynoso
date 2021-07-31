package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import clases.Estacion;
import clases.Recorrido;

public class EstacionPostgreSQLImpl implements EstacionDAO {
	private String ip, port, usr, psw;
	
	@Override
	public List<Estacion> buscar() {
		// TODO Cambiar datos si hace falta
		this.ip = "localhost";
		this.port = "5432";
		this.usr = "postgres";
		this.psw = "DarkSouls";
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ ip + ":" + port + "/", usr, psw);
			
			// Se realiza una consulta para encontrar el id correspondiente al siguiente recorrido
			st = conn.prepareStatement(obtenerID);
			rs = st.executeQuery();
			rs.next();
			id = rs.getInt("max");
			if (rs.wasNull()) id = 1;
			else id += 1;
			rs.close();
			st.close();
			
			
			st = conn.prepareStatement(insercionRecorrido + insercionBoleto);
			st.setInt(1, id);
			st.setInt(2, recorrido.getDistancia());
			st.setInt(3, recorrido.getDuracion());
			st.setDouble(4, recorrido.getCosto());
			st.setInt(5, Integer.parseInt(recorrido.getOrigen().getId()));
			st.setInt(6, 2);
			st.setInt(7, boleto.getNroBoleto());
			st.setString(8, boleto.getNombreCliente());
			st.setString(9, boleto.getCorreoCliente());
			System.out.println(boleto.getFechaVenta());
			st.setDate(10, Date.valueOf(boleto.getFechaVenta()));
			st.setInt(11, id);		
			st.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			if (rs != null) {
				try {
					rs.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}	
		}
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		
	}
	
}
