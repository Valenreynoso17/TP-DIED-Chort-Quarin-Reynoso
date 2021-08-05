package dao;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clases.LineaDeTransporte;
import clases.Recorrido;
import clases.Trayecto;
import enums.EstadoLineaDeTransporte;
import gestores.GestorColor;
import gestores.GestorTrayecto;

public class LineaDeTransporteSQLImp implements LineaDeTransporteDAO{

	GestorColor gestorColor;
	GestorTrayecto gestorTrayecto;
	
	public LineaDeTransporteSQLImp() {
		gestorColor = GestorColor.getInstance();
		gestorTrayecto = GestorTrayecto.getInstance();
	}
	
	@Override
	public List<LineaDeTransporte> buscar() {
		
		List<LineaDeTransporte> lista = new ArrayList<LineaDeTransporte>();
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
//			conn.setAutoCommit(false);
			
			// Consulta para obtener todas las lineas de trayecto
			st = conn.prepareStatement("SELECT * "
									 + "FROM died.linea_de_transporte AS linea, died.color AS color, died.trayecto AS trayecto "
									 + "WHERE linea.id_color = color.id AND linea.id = trayecto.id_linea_de_transporte;");
			
			rs = st.executeQuery();
//			conn.commit();
			
			while(rs.next()) {
				LineaDeTransporte auxLinea = new LineaDeTransporte(rs.getInt("id"),rs.getString("nombre"),gestorColor.buscarColorPorNombre(rs.getString("nombre_color")), EstadoLineaDeTransporte.valueOf(rs.getString("estado")), gestorTrayecto.buscarTrayectoPorId(rs.getInt("id_trayecto")));
				lista.add(auxLinea);
			}
			
		}catch (SQLException e) {
//			conn.rollback();
		}catch (ClassNotFoundException e) {e.printStackTrace();}
		finally {
			if (rs != null) {try {rs.close();} catch (Exception e) {e.printStackTrace();}}
			if (st != null) {try {st.close();} catch (Exception e) {e.printStackTrace();}}
			if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}
		}

		return lista;
	}

	@Override
	public void eliminar(LineaDeTransporte lineaDeTransporte) {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			conn.setAutoCommit(false);
			
			// Borrar una tupla de la tabla
			st = conn.prepareStatement("DELETE FROM died.linea_de_transporte " +
									   "WHERE id = (?);");
			st.setInt(1, lineaDeTransporte.getId());
			
			Integer nro = st.executeUpdate();
			conn.commit();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally {
			if (rs != null) {try {rs.close();} catch (Exception e) {e.printStackTrace();}}
			if (st != null) {try {st.close();} catch (Exception e) {e.printStackTrace();}}
			if (conn != null) {try {conn.close();} catch (Exception e) {e.printStackTrace();}}
		}
	}

	@Override
	public void insertar(LineaDeTransporte lineaDeTransporte) {
		String consulta = "INSERT INTO died.linea_de_transporte "
						+ "VALUES (?, ?, ?, ?);";

		Connection conn = null;
		PreparedStatement st = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			conn.setAutoCommit(false);
			
			st = conn.prepareStatement(consulta);
			st.setInt(1, lineaDeTransporte.getId());
			st.setString(2, lineaDeTransporte.getNombre());
			st.setInt(3, lineaDeTransporte.getIdColor());
			st.setString(4, lineaDeTransporte.getEstado().toString());
		
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
	public void modificar(LineaDeTransporte lineaDeTransporte) {
		String consulta = "UPDATE died.linea_de_transporte "
						+ "SET nombre = ?, id_color = ?, estado = ?"
						+ "WHERE id = ?; ";
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			conn.setAutoCommit(false);
			
			st = conn.prepareStatement(consulta);
			st.setString(1, lineaDeTransporte.getNombre());
			st.setInt(2, lineaDeTransporte.getIdColor());
			st.setString(3, lineaDeTransporte.getEstado().toString());
			st.setInt(4, lineaDeTransporte.getId());
		
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
	public Integer getUltimoIdLinea() {
		String obtenerID = "SELECT max(id) "
						+  "FROM died.linea_de_transporte;";
		Integer id = null;
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			
			// Se realiza una consulta para encontrar el id correspondiente a la siguiente lineaDeTransporte
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


