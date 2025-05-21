package pe.edu.upeu.examen.test;

import pe.edu.upeu.examen.config.Conexion;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(Conexion.getConexion()!=null) {
			System.out.println("Conectado");
		}
	}

}
