package pe.edu.upeu.examen.dao;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.examen.entity.Alumno;
import pe.edu.upeu.examen.generic.GenericDAO;

public interface AlumnoDAO extends GenericDAO<Alumno>{
	List<Map<String, Object>> readAll2();

}
