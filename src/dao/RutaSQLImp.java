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
import enums.EstadoRuta;
import gestores.GestorEstacion;

public class RutaSQLImp implements RutaDAO{
	private String ip, port, usr, psw;
	private GestorEstacion gestorEstacion;
	
	public RutaSQLImp() {
		// TODO Cambiar datos si hace falta
		this.ip = "localhost";
		this.port = "5432";
		this.usr = "postgres";
		this.psw = "ChortQuarinReynoso";
		
		gestorEstacion = GestorEstacion.getInstance();
	}
	
	@Override
	public List<Ruta> buscar() {
		
		List<Ruta> lista = new ArrayList<Ruta>();
		
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
				Ruta rutaAux = new Ruta(rs.getInt("id"), rs.getInt("id_trayecto"), gestorEstacion.getEstacionPorId(rs.getInt("id_estacion_origen")), gestorEstacion.getEstacionPorId(rs.getInt("id_estacion_destino")), rs.getInt("distancia"), rs.getInt("duracion"), rs.getInt("max_pasajeros"), EstadoRuta.valueOf(rs.getString("estado")), rs.getDouble("costo"));
				lista.add(rutaAux);
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
		
		return lista;
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
