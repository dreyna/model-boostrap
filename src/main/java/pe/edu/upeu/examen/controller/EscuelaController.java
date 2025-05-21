package pe.edu.upeu.examen.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.examen.dao.EscuelaDAO;
import pe.edu.upeu.examen.daoImpl.EscuelaDaoImpl;
import pe.edu.upeu.examen.entity.Escuela;

/**
 * Servlet implementation class EscuelaController
 */
@WebServlet("/escuela")
public class EscuelaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EscuelaDAO cdao = new EscuelaDaoImpl();
    private Gson gson = new Gson();  

    public EscuelaController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		 int op = Integer.parseInt(request.getParameter("opc"));
		 
		 switch(op) {
		 case 1:out.println(gson.toJson(cdao.readAll()));  break;
		 case 2: int idc = Integer.parseInt(request.getParameter("id"));
			 out.println(gson.toJson(cdao.read(idc)));  break;
		 case 3:
			 Escuela cat1 = new Escuela();
			 cat1.setNombre(request.getParameter("nombre"));
			 out.println(gson.toJson(cdao.create(cat1)));  break;
		 case 4:Escuela cat2 = new Escuela();
		     cat2.setIdescuela(Integer.parseInt(request.getParameter("id")));
		     cat2.setNombre(request.getParameter("nombre"));
			 out.println(gson.toJson(cdao.update(cat2)));  break;
		 case 5:out.println(gson.toJson(cdao.delete(Integer.parseInt(request.getParameter("id")))));  break;
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
