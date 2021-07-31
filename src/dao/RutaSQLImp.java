package dao;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import clases.Estacion;
import clases.Ruta;
import enums.EstadoEstacion;

public class RutaSQLImp implements RutaDAO{
	private String ip, port, usr, psw;
	
	public RutaSQLImp() {
		// TODO Cambiar datos si hace falta
		this.ip = "localhost";
		this.port = "5432";
		this.usr = "postgres";
		this.psw = "DarkSouls";
	}
	
	@Override
	public List<Ruta> buscar() {
		List<Ruta> rutas = new ArrayList<>();
		String consulta = "SELECT * "
						+ "FROM died.ruta;"	;
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ ip + ":" + port + "/", usr, psw);
			
			// Se realiza una consulta para encontrar el id correspondiente al siguiente recorrido
			st = conn.prepareStatement(consulta);
			rs = st.executeQuery();
			
			
			while(rs.next()) {	
			}
			
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
		
		return rutas;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertar(Ruta ruta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar() {
		// TODO Auto-generated method stub
		
	}

}
