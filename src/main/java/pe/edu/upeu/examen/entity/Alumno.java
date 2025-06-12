package pe.edu.upeu.examen.entity;

public class Alumno {
 private int idalumno;
 private String nombres;
 private String apellidos;
 private int idescuela;
public Alumno() {
	super();
}

public Alumno(int idalumno, String nombres, String apellidos, int idescuela) {
	super();
	this.idalumno = idalumno;
	this.nombres = nombres;
	this.apellidos = apellidos;
	this.idescuela = idescuela;
}

public int getIdalumno() {
	return idalumno;
}

public void setIdalumno(int idalumno) {
	this.idalumno = idalumno;
}

public String getNombres() {
	return nombres;
}

public void setNombres(String nombres) {
	this.nombres = nombres;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public int getIdescuela() {
	return idescuela;
}

public void setIdescuela(int idescuela) {
	this.idescuela = idescuela;
}


 
}
