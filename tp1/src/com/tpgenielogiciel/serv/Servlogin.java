package com.tpgenielogiciel.serv;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.websocket.Session;

import com.tpgenielogiciel.control.Utilisatcontrole;
import com.tpgenielogiciel.model.Utilisatmodel;

/**
 * Servlet implementation class Servlogin
 */
@WebServlet("/Servlogin")
public class Servlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HttpSession session = request.getSession();
		
		
		request.getSession(false);
		
		// int idn = 45;
		//   session.setAttribute("idutilisateur",idn );
		 //  int aa = (int) session.getAttribute("idutilisateur");
		 //  System.out.println("aaaaaaaaaaaaaaa"+aa);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println("****************"+session);
		
		String nom = request.getParameter("nom");
		String password = request.getParameter("passwd");
		
		 Utilisatmodel utilis = new Utilisatmodel();
		 Utilisatcontrole utilisacontr = new Utilisatcontrole();
		 
			String stat = null;
		stat = utilisacontr.statutilisa(nom, password);
		
		
		//request.getSession().setAttribute("idutilisateur", idn);
		
	
		
	Map<String, String> erreur = new HashMap<String,String>();
	
	
	 
	 utilis.setNom(nom);
	 utilis.setPasswd(password);
	 
	
	
	 if(utilisacontr.existnom(utilis))
	 {
		 System.out.println("succes de connection");
	 }
	 else
		 erreur.put("nomp", "votre username n est pas correcte");
	 
		 if(utilisacontr.existmotpass(utilis))
		 {
			 System.out.println("succes mot pass");
		 }
		 else {
			 erreur.put("motpass", "votre mot de passe est incorrect");
		 }
		 	
		   if(erreur.isEmpty()) 
		   {
			   int idn = 0;
			  idn  = utilisacontr.idutilisat(nom, password);
			  System.out.println("utiliateur identifi "+idn);
			  request.getSession().setAttribute("statut", stat);
			  			if(stat.equals("Adherent"))
			  			{
			  				request.getSession().setAttribute("idutilisateur", idn);
			  				response.sendRedirect("accueil");
			  				//this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);	
			  			}
			  		
			  				
			  					if(stat.equals("bibliothecaire"))
			  					{
			  						response.sendRedirect("livre");
			  						//this.getServletContext().getRequestDispatcher("/WEB-INF/livre.jsp").forward(request, response);
			  					}
			  					if(stat.equals("admin"))
			  					 {
			  						   response.sendRedirect("admin");
			  						//this.getServletContext().getRequestDispatcher("/WEB-INF/Administrat.jsp").forward(request, response);
			  					}
			  					
			  					if(stat.equals(" "))
			  					{
			  						response.sendRedirect("login");
			  					}
			  				}
		   
		   else
		  {
			  request.setAttribute("erreur", erreur);
			  // this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
			  this.getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
			  //response.sendRedirect("login");
			   
		   } 
	 
	 			       
	}
	

}
