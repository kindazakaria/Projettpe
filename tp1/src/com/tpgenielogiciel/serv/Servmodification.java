package com.tpgenielogiciel.serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tpgenielogiciel.control.Affdemacont;
import com.tpgenielogiciel.control.Empruntcontrol;
import com.tpgenielogiciel.control.Livrecontrol;
import com.tpgenielogiciel.model.Livremodel;

/**
 * Servlet implementation class Servmodification
 */
@WebServlet("/Servmodification")
public class Servmodification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servmodification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Livrecontrol livc = new Livrecontrol();
		Empruntcontrol emp = new Empruntcontrol();
		
		String idli = request.getParameter("id");
		
		int id = Integer.parseInt(idli);
		
		if(emp.nbrexemplaireint(id) > 0)
		{
			request.setAttribute("delete", "les exemplaires sont empruntes.Impossible d effacer");
			//Livrecontrol livc = new Livrecontrol();
			
			Affdemacont affc = new Affdemacont();
			
			request.setAttribute("listemp", affc.affdmnd());
			request.setAttribute("listaff", affc.affemnpr());
	        request.setAttribute("listliv", livc.ensblelivre());
			this.getServletContext().getRequestDispatcher("/WEB-INF/livre.jsp").forward(request, response);
		}
		else {
			livc.DeleteLivre(id);
			response.sendRedirect("livre");
		}
		
		
		//this.getServletContext().getRequestDispatcher("/WEB-INF/livre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titre = request.getParameter("titre");
		String idliv = request.getParameter("idliv");
		String quantite = request.getParameter("quantite");
		String isbn = request.getParameter("isbn");
		String nom = request.getParameter("nom");
		String date = request.getParameter("dat");
		String cat = request.getParameter("categorie");
		
		String messagmod = "";
		int qtite = Integer.parseInt(quantite);
		int id = Integer.parseInt(idliv);
		
		
			 if(titre.trim().isEmpty() || quantite.trim().isEmpty() || isbn.trim().isEmpty() || nom.trim().isEmpty())
				 messagmod = "modification impossible avec un champ vide";
			 if(qtite <= 0)
				 messagmod = "modification impossible avec une quantite negative";
				
			 if( messagmod.equals(""))
			 	{
				      Livremodel liv = new Livremodel();
				      Livrecontrol livc = new Livrecontrol();
				      
				      liv.setIdLivre(id);
				      liv.setTitre(titre);
				      liv.setIsbn(isbn);
				      liv.setDateEdit(date);
				      liv.setCategorie(cat);
				      liv.setQuantite(quantite);
				      liv.setNomAut(nom);
				      livc.ModifierLivre(liv);
				      
				      response.sendRedirect("livre");
			 	}
			 else
				 request.getServletContext().getRequestDispatcher("/WEB-INF/livre.jsp").forward(request, response);
		}
		
		
		
	

}
