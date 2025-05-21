package pe.edu.upeu.examen.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.examen.config.Conexion;
import pe.edu.upeu.examen.dao.EscuelaDAO;
import pe.edu.upeu.examen.entity.Escuela;

public class EscuelaDaoImpl implements EscuelaDAO{
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection cx;
	@Override
	public int create(Escuela t) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO escuela (nombre) VALUES(?)";
		int x = 0;
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, t.getNombre());
			x = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return x;
	}

	@Override
	public int update(Escuela t) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE escuela SET nombre=? WHERE idescuela=?";
		int x = 0;
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setString(1, t.getNombre());
			ps.setInt(2, t.getIdescuela());
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
		String SQL = "DELETE FROM escuela WHERE idescuela=?";
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
	public Escuela read(int id) {
		// TODO Auto-generated method stub
		String SQL = "SELECT *FROM escuela WHERE idescuela=?";
		int x = 0;
		Escuela cat = new Escuela();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				cat.setIdescuela(rs.getInt("idescuela"));
				cat.setNombre(rs.getString("nombre"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return cat;
	}

	@Override
	public List<Escuela> readAll() {
		// TODO Auto-generated method stub
		String SQL = "SELECT *FROM escuela";
		int x = 0;
		List<Escuela> lista = new ArrayList<>();
		try {
			cx = Conexion.getConexion();
			ps = cx.prepareStatement(SQL);
			rs = ps.executeQuery();
			while(rs.next()) {
				Escuela cat = new Escuela();
				cat.setIdescuela(rs.getInt("idescuela"));
				cat.setNombre(rs.getString("nombre"));
				lista.add(cat);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: "+e);
		}
		return lista;
	}

}
