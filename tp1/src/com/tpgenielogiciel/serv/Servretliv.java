package com.tpgenielogiciel.serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpgenielogiciel.control.Empruntcontrol;
import com.tpgenielogiciel.control.Utilisatcontrole;

/**
 * Servlet implementation class Servretliv
 */
@WebServlet("/Servretliv")
public class Servretliv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servretliv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idliv = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		Utilisatcontrole utilc = new Utilisatcontrole();
		Empruntcontrol emp = new Empruntcontrol();
		int idut = utilc.utiliexist(nom, prenom);
		
		int idli = Integer.parseInt(idliv);
		 emp.confiretour(idut, idli);
		
		
		response.sendRedirect("livre");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
