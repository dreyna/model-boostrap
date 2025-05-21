package pe.edu.upeu.examen.generic;

import java.util.List;

public interface GenericDAO<T> {
	int create(T t);
	int update(T t);
	int delete(int id);
	T read(int id);
	List<T> readAll();
}
