package dao;

import java.awt.Point;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import clases.Estacion;
import clases.Recorrido;
import enums.EstadoEstacion;

public class EstacionPostgreSQLImpl implements EstacionDAO {
	private String ip, port, usr, psw;
	
	public EstacionPostgreSQLImpl() {
		// TODO Cambiar datos si hace falta
		this.ip = "localhost";
		this.port = "5432";
		this.usr = "postgres";
		this.psw = "DarkSouls";
	}

	@Override
	public List<Estacion> buscar() {
		List<Estacion> estaciones = new ArrayList<>();
		String consulta = "SELECT * "
						+ "FROM died.estacion;"	;
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ ip + ":" + port + "/", usr, psw);
			
			// Se realiza una consulta para encontrar el id correspondiente al siguiente recorrido
			st = conn.prepareStatement(consulta);
			rs = st.executeQuery();
			
			while(!rs.next()) {
				String id = String.valueOf(rs.getInt("id"));
				String nombre = rs.getString("nombre");
				String estado = rs.getString("estado");
				LocalTime horaApertura = rs.getTime("horarioapertura").toLocalTime();
				LocalTime horaCierre = rs.getTime("horariocierre").toLocalTime();
				Point posicion = new Point();
				posicion.x = rs.getInt("posicion_x");
				posicion.y = rs.getInt("posicion_y");
				
				// TODO falta agregarle que busque los mantenimientos
				if (estado.equals("OPERATIVA")) estaciones.add(new Estacion(id, nombre, horaApertura, horaCierre, posicion, EstadoEstacion.OPERATIVA, null));
				else estaciones.add(new Estacion(id, nombre, horaApertura, horaCierre, posicion, EstadoEstacion.EN_MANTENIMIENTO, null));
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
		
		return estaciones;
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
