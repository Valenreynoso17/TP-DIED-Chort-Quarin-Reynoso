package dao;

import java.awt.Point;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import clases.Estacion;
import clases.Mantenimiento;
import enums.EstadoEstacion;

public class MantenimientoPostgreSQLImpl implements MantenimientoDAO{

	@Override
	public List<Mantenimiento> buscar() {
		List<Mantenimiento> mantenimientos = new ArrayList<>();
		String consulta = "SELECT * "
						+ "FROM died.mantenimiento "
						+ "ORDER BY id"	;
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			
			st = conn.prepareStatement(consulta);
			rs = st.executeQuery();
			
			
			while(rs.next()) {				
				Integer id = rs.getInt("id");
				LocalDate fechaInicio = rs.getDate("fecha_inicio").toLocalDate();					
				String nombre = rs.getString("observaciones");
				Integer idEstacion = rs.getInt("id_estacion");
				
				if(rs.getDate("fecha_fin") == null)
					mantenimientos.add(new Mantenimiento(id, fechaInicio, nombre, idEstacion));
				else {
					LocalDate fechaFin = rs.getDate("fecha_fin").toLocalDate();
					mantenimientos.add(new Mantenimiento(id, fechaInicio, fechaFin, nombre, idEstacion));
				}
				
				//mantenimientos.add(new Mantenimiento(id, fechaInicio, fechaFin, nombre, idEstacion));
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
		
		return mantenimientos;
	}

	@Override
	public void eliminar(Mantenimiento mantenimiento) {
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			conn.setAutoCommit(false);
			
			// Borrar una tupla de la tabla
			st = conn.prepareStatement("DELETE FROM died.mantenimiento " +
									   "WHERE id = (?);");
			st.setInt(1, mantenimiento.getId());
			
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
	public void insertar(Mantenimiento mantenimiento) {
		//Tener en cuenta que copie y pegue de boleto
		String obtenerID = 		"SELECT max(id)"
							+ 	"FROM died.mantenimiento;";

		String insercionEstacion = 	"INSERT INTO died.mantenimiento "
								+ 	"VALUES (?, ?, ?, ?, ?);";
		Integer id = null;
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// TODO Falta cargar la relacion con ruta
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			
			// Se realiza una consulta para encontrar el id correspondiente a la siguiente estación
			st = conn.prepareStatement(obtenerID);
			rs = st.executeQuery();
			rs.next();
			id = rs.getInt("max");
			if (rs.wasNull()) id = 1;
			else id += 1;
			rs.close();
			st.close();
			
			
			st = conn.prepareStatement(insercionEstacion);
			st.setInt(1, id);
			st.setDate(2, Date.valueOf(mantenimiento.getFechaInicio()));
			st.setString(3, mantenimiento.getObservaciones());
			st.setInt(4, mantenimiento.getIdEstacion());
			st.setDate(5, null);
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
	public void modificar(Mantenimiento mantenimiento, LocalDate fF) {

		String modificacionEstacion = 	"UPDATE died.mantenimiento "
									+ 	"SET 	fecha_fin = ? "
									+ 	"WHERE id = ?; ";
		
		Connection conn = null;
		PreparedStatement st = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://"+ host + ":" + port + "/", usr, psw);
			
			
			st = conn.prepareStatement(modificacionEstacion);
			st.setDate(1, Date.valueOf(fF));
			st.setInt(2, mantenimiento.getId());	
			st.executeUpdate();
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
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
	public Integer getUltimoIdMantenimiento() {
		String obtenerID = "SELECT max(id) "
						+  "FROM died.mantenimiento;";
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
