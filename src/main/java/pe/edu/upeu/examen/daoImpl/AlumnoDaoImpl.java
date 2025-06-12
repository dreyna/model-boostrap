package pe.edu.upeu.examen.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.edu.upeu.examen.config.Conexion;
import pe.edu.upeu.examen.dao.AlumnoDAO;
import pe.edu.upeu.examen.entity.Alumno;
import pe.edu.upeu.examen.entity.Escuela;

public class AlumnoDaoImpl implements AlumnoDAO{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx;
	
	@Override
	public int create(Alumno t) {
		String SQL = "INSERT INTO alumno (nombres, apellidos) VALUES(?,?)";
		int x = 0;
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, t.getNombres());
			ps.setString(2, t.getApellidos());
			x = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return x;
	}

	@Override
	public int update(Alumno t) {
		String SQL = "UPDATE alumno SET nombres=?, nombres=? WHERE idalumno=?";
		int x = 0;
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, t.getNombres());
			ps.setString(2, t.getApellidos());
			ps.setInt(3, t.getIdalumno());
			x = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return x;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
				String SQL = "DELETE FROM alumno WHERE idalumno=?";
				int x = 0;
				try {
					cx = Conexion.getConexion();
					ps = cx.prepareStatement(SQL);
					ps.setInt(1, id);
					x = ps.executeUpdate();
				} catch (SQLException e) {
					// TODO: handle exception
					System.out.println("Error: "+e);
				}
				return x;
	}

	@Override
	public Alumno read(int id) {
		String SQL = "SELECT *FROM alumno WHERE idalumno=?";
		int x = 0;
		Alumno cat = new Alumno();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				cat.setIdalumno(rs.getInt("idalumno"));
				cat.setNombres(rs.getString("nombres"));
				cat.setApellidos(rs.getString("apellidos"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return cat;
	}

	@Override
	public List<Alumno> readAll() {
		String SQL = "SELECT *FROM alumno";
		int x = 0;
		List<Alumno> lista = new ArrayList<>();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while(rs.next()) {
				Alumno cat = new Alumno();
				cat.setIdalumno(rs.getInt("idalumno"));
				cat.setNombres(rs.getString("nombres"));
				cat.setApellidos(rs.getString("apellidos"));
				lista.add(cat);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> readAll2() {
		String SQL = "select a.idalumno, a.nombres, a.apellidos, e.idescuela, e.nombre from alumno a "
				+ "inner join escuela e on a.idescuela= e.idescuela";
		int x = 0;
		List<Map<String, Object>> lista = new ArrayList<>();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map map = new HashMap<>();
				map.put("idalumno",rs.getInt("idalumno"));
				map.put("nombres",rs.getString("nombres"));
				map.put("apellidos",rs.getString("apellidos"));
				map.put("idescuela",rs.getInt("idescuela"));
				map.put("nombre",rs.getString("nombre"));
				lista.add(map);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return lista;
	}

}
