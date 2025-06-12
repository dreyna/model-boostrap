package pe.edu.upeu.examen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.examen.dao.AlumnoDAO;
import pe.edu.upeu.examen.daoImpl.AlumnoDaoImpl;
import pe.edu.upeu.examen.entity.Alumno;

/**
 * Servlet implementation class AlumnoController
 */
@WebServlet("/alumno")
public class AlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AlumnoDAO adao = new AlumnoDaoImpl();  
    private Gson gson = new Gson();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
	    int op = Integer.parseInt(request.getParameter("opc"));
	    switch(op) {
		 case 1:out.println(gson.toJson(adao.readAll()));  break;
		 case 2: int idc = Integer.parseInt(request.getParameter("id"));
			 out.println(gson.toJson(adao.read(idc)));  break;
		 case 3:
			 Alumno cat1 = new Alumno();
			 cat1.setNombres(request.getParameter("nombres"));
			 cat1.setNombres(request.getParameter("apellidos"));
			 cat1.setIdescuela(Integer.parseInt(request.getParameter("idescuela")));
			 out.println(gson.toJson(adao.create(cat1)));  break;
		 case 4:Alumno cat2 = new Alumno();
		     cat2.setIdalumno(Integer.parseInt(request.getParameter("idalumno")));
		     cat2.setNombres(request.getParameter("nombres"));
			 cat2.setApellidos(request.getParameter("apellidos"));
			 cat2.setIdescuela(Integer.parseInt(request.getParameter("idescuela")));
			 out.println(gson.toJson(adao.update(cat2)));  break;
		 case 5:out.println(gson.toJson(adao.delete(Integer.parseInt(request.getParameter("id")))));  break;
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
