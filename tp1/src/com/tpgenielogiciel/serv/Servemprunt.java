package com.tpgenielogiciel.serv;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tpgenielogiciel.control.Adherentcontrl;
import com.tpgenielogiciel.control.Empruntcontrol;
import com.tpgenielogiciel.control.Livrecontrol;
import com.tpgenielogiciel.model.Empruntmodel;

/**
 * Servlet implementation class Servemprunt
 */
@WebServlet("/Servemprunt")
public class Servemprunt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servemprunt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession sess = request.getSession();
		Map<String ,String> erreur = new HashMap<String,String>();
		
		int ide = (int)	sess.getAttribute("idutilisateur");
		
		//Adherent adhernt = new Adherent();
		Adherentcontrl adhrc = new Adherentcontrl();
		Empruntcontrol emp = new Empruntcontrol();
		Livrecontrol liv = new Livrecontrol();
		String id = request.getParameter("idliv");
		int idliv =0;
		//String id = request.getParameter("idliv");
		
			try {
				
				 idliv = Integer.parseInt(id);
			} catch(NumberFormatException e) {
				
				System.out.println("erreur d exception ***"+e.getMessage());
			}
		
		
		String dater = emp.dateretour();
		
		
		
		Date dat1 = adhrc.datefin(ide);
		Date dat2 = emp.converti(dater);
		
		if(dat1.before(dat2))
		{
			erreur.put("date", "votre s exprimerera dans bientot");
			//request.setAttribute("erreur", erreur);
			System.out.println("erreur date ");
		}
		if(liv.qtitestock(idliv)< emp.nbrexemplaireint(idliv))
		{
			 erreur.put("stock", "tous les exemplaires correspondants a votre demande sont emprunntes");
			 System.out.println("erreur stock ");
		}
		if(emp.emprntavant(ide, idliv) >= 1)
		{
			erreur.put("quantite", "vous ne pouvez emprunter plus deux exemplaires");
			System.out.println("erreur de quantite ");
		}
		if(erreur.isEmpty())
		 {
			  Empruntmodel empr = new Empruntmodel();
			  empr.setIdadhernt(ide);
			  empr.setIdlivr(idliv);
			  empr.setDatesortie(emp.datesortie());
			  empr.setDateretour(emp.dateretour());
			  empr.setEtatemp("demande");
			  int enr =  emp.enregistrepret(empr);
			  System.out.println("enregistrment nouveau pret "+enr);
			  
			  	
			response.sendRedirect("accueil");     
			  //this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
		 }
		else {
				request.setAttribute("erreur", erreur);
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
		}
		
		
	}

}
