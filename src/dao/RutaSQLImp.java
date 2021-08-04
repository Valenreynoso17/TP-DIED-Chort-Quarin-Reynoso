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
	private String host, port, usr, psw;
	private GestorEstacion gestorEstacion;
	
	public RutaSQLImp() {
		
		this.host = "localhost";
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
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			
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
			if (rs != null) {try {rs.close();} catch (Exception e) {e.printStackTrace();}}
			if (st != null) {try {st.close();} catch (Exception e) {e.printStackTrace();}}
			if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}	
		}
		
		return lista;
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertar(List<Ruta> rutas) {
		
		String consulta = "INSERT INTO died.ruta "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
//			conn.setAutoCommit(false);
			
			for (int i = 1; i<rutas.size(); i++) consulta += ", (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			consulta += ";";
			
			st = conn.prepareStatement(consulta);
			
			for(int i = 0; i<rutas.size(); i++) {
				st.setInt(1 + (i*9), rutas.get(i).getID());
				st.setInt(2 + (i*9), rutas.get(i).getDistancia());
				st.setInt(3 + (i*9), rutas.get(i).getDuracion());
				st.setInt(4 + (i*9), rutas.get(i).getCantMaxPasajeros());
				st.setString(5 + (i*9), rutas.get(i).getStringEstado());
				st.setDouble(6 + (i*9), rutas.get(i).getCosto());
				st.setInt(7 + (i*9), rutas.get(i).getIdTrayecto());
				st.setInt(8 + (i*9), rutas.get(i).getIdEstacionOrigen());
				st.setInt(9 + (i*9), rutas.get(i).getIdEstacionDestino());
			}
			
			Integer val = st.executeUpdate();
//			conn.commit();
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
			e.printStackTrace();
		} 
		finally {
			if (st != null) {try {st.close();} catch (Exception e) {e.printStackTrace();}}
			if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}	
		}
		
	}

	@Override
	public void modificarRutas(List<Ruta> listaRutasAEditar) {
		String modificarRuta = "UPDATE died.ruta "
							 + "SET distancia = ?, duracion = ?, max_pasajeros = ?, estado = ?, costo = ?"
							 + "WHERE id = ?; ";
		String consulta = "";
		
		for (int i=0; i<listaRutasAEditar.size(); i++) {
			consulta += modificarRuta;
		}
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			conn.setAutoCommit(false);
			
			st = conn.prepareStatement(consulta);
			
			for (int i=0; i<listaRutasAEditar.size(); i++) {
				st.setInt(1 + 6*i, listaRutasAEditar.get(i).getDistancia());
				st.setInt(2 + 6*i, listaRutasAEditar.get(i).getDuracion());
				st.setInt(3 + 6*i, listaRutasAEditar.get(i).getCantMaxPasajeros());
				st.setString(4 + 6*i, listaRutasAEditar.get(i).getEstado().toString());
				st.setDouble(5 + 6*i, listaRutasAEditar.get(i).getCosto());
				st.setInt(6 + 6*i, listaRutasAEditar.get(i).getID());
			}
		
			Integer val = st.executeUpdate();
			conn.commit();
		
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} 
		finally {
			if (st != null) {try {st.close();} catch (Exception e) {e.printStackTrace();}}
			if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}	
		}
		
	}

	@Override
	public Integer getSiguienteIdRuta() {
		String obtenerID = "SELECT max(id) "
						+  "FROM died.ruta;";
		Integer id = null;
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			
			// Se realiza una consulta para encontrar el id correspondiente al siguiente trayecto
			st = conn.prepareStatement(obtenerID);
			rs = st.executeQuery();
			rs.next();
			id = rs.getInt("max");
			if (rs.wasNull()) id = 1;
			rs.close();
			st.close();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			if (rs != null) {try {rs.close();} catch (Exception e) {e.printStackTrace();}}
			if (st != null) {try {st.close();} catch (Exception e) {e.printStackTrace();}}
			if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}
		}
		
		return id;
	}

}
