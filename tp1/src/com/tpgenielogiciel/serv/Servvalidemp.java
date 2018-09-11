package com.tpgenielogiciel.serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpgenielogiciel.control.Empruntcontrol;
import com.tpgenielogiciel.control.Livrecontrol;
import com.tpgenielogiciel.control.Utilisatcontrole;

/**
 * Servlet implementation class Servvalidemp
 */
@WebServlet("/Servvalidemp")
public class Servvalidemp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servvalidemp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nomadh" );
		String prenom = request.getParameter("prenoma");
		String idlivr = request.getParameter("idliv");
		
		int idli = Integer.parseInt(idlivr);
		
		
		Utilisatcontrole iduser = new Utilisatcontrole();
		Empruntcontrol eprnt = new Empruntcontrol();
		

		int  id = iduser.utiliexist(nom, prenom);
		eprnt.mislivr(id, idli);
		
		
		response.sendRedirect("livre");
		
		//this.getServletContext().getRequestDispatcher("/WEB-INF/livre.jsp").forward(request, response);
		
		//System.out.println("erreur nom ***********"+nom);
		//System.out.println("erreur nom ***********"+prenom);
		//System.out.println("erreur nom ***********"+titre);
		//System.out.println("erreur nom ***********"+auteur);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
