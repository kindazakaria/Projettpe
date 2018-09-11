package com.tpgenielogiciel.serv;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tpgenielogiciel.control.Affdemacont;
import com.tpgenielogiciel.control.Empruntcontrol;
import com.tpgenielogiciel.control.Livrecontrol;
import com.tpgenielogiciel.control.Utilisatcontrole;
import com.tpgenielogiciel.control.empruntsimp;
import com.tpgenielogiciel.model.Livremodel;

/**
 * Servlet implementation class ServLivre
 */
@WebServlet("/ServLivre")
public class ServLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServLivre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession sessio = request.getSession();
		//int idh = (int) sessio.getAttribute("idutilisateur");
		Livrecontrol livc = new Livrecontrol();
		
		Affdemacont affc = new Affdemacont();
		//Utilisatcontrole util = new Utilisatcontrole();
		// request.setAttribute("profil", util.nompren(idh));
		 
		request.setAttribute("listemp", affc.affdmnd());
		request.setAttribute("listaff", affc.affemnpr());
        request.setAttribute("listliv", livc.ensblelivre());
        
       
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/livre.jsp").forward(request, response);
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Map<String,String> erreur = new HashMap<String,String>();
		Livremodel liv = new Livremodel();
		Livrecontrol livc = new Livrecontrol();
		Affdemacont aff = new Affdemacont();

		//Livrecontrol livc = new Livrecontrol();
		
		Affdemacont affc = new Affdemacont();
		//Empruntcontrol emp = new Empruntcontrol();
				
		
		String isbn = request.getParameter("isbn");
		String titre = request.getParameter("titre");
		String dat = request.getParameter("dat");
		String nom = request.getParameter("nom");
		String categorie = request.getParameter("categorie");
		String quantit = request.getParameter("quantite");
		
		
		
		//controle des differents recus de la vue
		
		if(isbn.trim().isEmpty() || titre.trim().isEmpty() || dat.trim().isEmpty() || nom.trim().isEmpty()||categorie.trim().isEmpty()|| quantit.trim().isEmpty())
		{
			erreur.put("vide", "L'un des  champs est vide");
			
		}
		else {
			liv.setTitre(titre);
			liv.setNomAut(nom);

			
			
				if(livc.existnc(liv))
				{
					erreur.put("existence", "cet livre est dja reference dans le systeme");
				}
		}
		
			if(erreur.isEmpty())
			{
				liv.setIsbn(isbn);
				liv.setTitre(titre);
				liv.setDateEdit(dat);
				liv.setNomAut(nom);
				liv.setCategorie(categorie);
				liv.setQuantite(quantit);
				livc.AjouterLivre(liv);
				request.setAttribute("message", "un livre vient d etre ajoute avec succs");
				request.setAttribute("emprnt",aff.affemnpr() );
			}
			else {
					request.setAttribute("error", erreur);
			}
		
			request.setAttribute("listemp", affc.affdmnd());
			request.setAttribute("listaff", affc.affemnpr());
	        request.setAttribute("listliv", livc.ensblelivre());
				
			this.getServletContext().getRequestDispatcher("/WEB-INF/livre.jsp").forward(request, response);
				
	}

}
