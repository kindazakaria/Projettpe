package com.tpgenielogiciel.serv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpgenielogiciel.control.Adherentcontrl;
import com.tpgenielogiciel.control.Empruntcontrol;
import com.tpgenielogiciel.control.Livrecontrol;
import com.tpgenielogiciel.control.Utilisatcontrole;
import com.tpgenielogiciel.model.Empruntmodel;
import com.tpgenielogiciel.model.Livremodel;

/**
 * Servlet implementation class Servemprbi
 */
@WebServlet("/Servemprbi")
public class Servemprbi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servemprbi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		    Map<String, String> erreur = new HashMap<String, String>(); 
		    Utilisatcontrole contrluti = new Utilisatcontrole();
		    Adherentcontrl adhrc = new Adherentcontrl();
			Empruntcontrol emp = new Empruntcontrol();
			Livrecontrol liv = new Livrecontrol();
			
		    String ids = request.getParameter("idliv");
		    String nom = request.getParameter("emprunteur");
		    String prenom = request.getParameter("prenom");
		    int iduser = contrluti.utiliexist(nom, prenom);
		    
		    Date dat1 = null;
		    Date dat2 = null;
		    int idliv = 0;
		    
            String dater = emp.dateretour();
            System.out.println("************************"+dater);
            
            idliv = Integer.parseInt(ids);
		   
		   
		    
		    if(adhrc.existeA(iduser)== false)
		    {
		    	//Livrecontrol livc = new Livrecontrol();
		 	   // List<Livremodel> lis ;
		 	   // ArrayList<Livremodel> liv = new ArrayList<Livremodel>();
		 	 //  liv = livc.ensblelivre();
		         //request.setAttribute("listliv", livc.ensblelivre());
		    	 System.out.println("je suis dans la zone de la zone de false");
		    	 //request.setAttribute("messag", "vous n etes pas encore autorise a prendre des livres");
		    	 response.sendRedirect("livre");
		    	// this.getServletContext().getRequestDispatcher("/WEB-INF/livre.jsp").forward(request, response);
		    	
		    	 
		    }
		    else {
		    	dat1 = adhrc.datefin(iduser);
				 //System.out.println("************************"+);
				 dat2 = emp.converti(dater);
			    
			     idliv = Integer.parseInt(ids);   
			     System.out.println("je suis dans la zone de else");
			    
			     
			     
			     if(dat1.after(dat2))
					{	if(liv.qtitestock(idliv)> emp.nbrexemplaireint(idliv))
						{
							if(emp.emprntavant(iduser, idliv)<1)
							{
								if(erreur.isEmpty())
								 {
									  Empruntmodel empr = new Empruntmodel();
									  empr.setIdadhernt(iduser);
									  empr.setIdlivr(idliv);
									  empr.setDatesortie(emp.datesortie());
									  empr.setDateretour(emp.dateretour());
									  empr.setEtatemp("demande");
									  int enr =  emp.enregistrepret(empr);
									  System.out.println("enregistrment nouveau pret "+enr);
									  
									  request.setAttribute("succ", "une demande est effectue avec succe!!!");
									
									response.sendRedirect("livre");}
								else {
										request.setAttribute("ereurs", erreur);
									response.sendRedirect("login");
								}
								
								
							}else {
								erreur.put("pretavan", "vous ne pouvez pas emprunter le meme livre en plus de deuxx exemplaire");
							}
							
						}
						else {
							erreur.put("quantite", "tous les exemplaires ont ete empruntes");
						}
					
					}
				else {
					erreur.put("dateadherent", "impossible d emprunter soit votre abonnement est experie soit il s expire dans 3 jours");
				}
			     
		    }
		     
		    
		
	}

}
