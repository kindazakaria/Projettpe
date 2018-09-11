package com.tpgenielogiciel.serv;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tpgenielogiciel.control.Adherentcontrl;
import com.tpgenielogiciel.control.Livrecontrol;
import com.tpgenielogiciel.control.Utilisatcontrole;
import com.tpgenielogiciel.control.empruntsimp;
import com.tpgenielogiciel.model.Empruntsimodel;
import com.tpgenielogiciel.model.Livremodel;

/**
 * Servlet implementation class ServAccueil
 */
@WebServlet("/ServAccueil")
public class ServAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServAccueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessio = request.getSession();
		ArrayList<Empruntsimodel> empl = new ArrayList<Empruntsimodel>();
		int idh = (int) sessio.getAttribute("idutilisateur");
		//System.out.println("*************"+idh);
		
		empruntsimp emp = new empruntsimp();
		Livrecontrol livc = new Livrecontrol();
		Utilisatcontrole util = new Utilisatcontrole();
		Adherentcontrl adhc = new Adherentcontrl();
		
	      
	      if(emp.demand(idh).isEmpty())
	    	  if(emp.demdrendre(idh).isEmpty())
	    	  {
	    		//  Date dat =  adhc.datefin(idh);
	    			
	    			//SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
	    		// String datr = sf.format(dat);
	    		  request.setAttribute("lisemp",livc.ensblelivre() );
	    		  //request.setAttribute("pret", empl);
	    		  request.setAttribute("profil", util.nompren(idh));
	    	      //request.setAttribute("expr", dat);
	    		  System.out.println(" niveau 1");
	    		  
	    	  }
	    	  else {
	    		  Date dat =  adhc.datefin(idh);
	    			
	    			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
	    			 String datr = sf.format(dat);
	    		  request.setAttribute("lisemp",livc.ensblelivre() );
	    		 // request.setAttribute("pret", empl);
	    		  request.setAttribute("emprt", emp.demdrendre(idh));
	    		  request.setAttribute("profil", util.nompren(idh));
	    	      request.setAttribute("expr", datr);
	    	      System.out.println("************* taill*"+emp.demdrendre(idh).size());
	    	      System.out.println(" niveau 2");
	    	  }
	      else {
	    	  Date dat =  adhc.datefin(idh);
	  		
	  		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
	  		 String datr = sf.format(dat);
	    	  request.setAttribute("lisemp",livc.ensblelivre() );
    		  request.setAttribute("pret", empl);
    		  request.setAttribute("emprt", emp.demdrendre(idh));
    		  request.setAttribute("pretenc", emp.demand(idh));
    		  request.setAttribute("profil", util.nompren(idh));
    	      request.setAttribute("expr", datr);
    	      
    	      System.out.println(" niveau 3");
	      }
	      
	      
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String catego = request.getParameter("categorie");
		String titr = request.getParameter("titre");
		
		//ArrayList<Livremodel> lis = new ArrayList<Livremodel>();
		
		Livrecontrol liv = new Livrecontrol();
		//liv.rechercheLiv(catego, titr);
		int nbre = liv.rechercheLiv(catego, titr).size();
		
		request.setAttribute("nmbre",nbre);
		request.setAttribute("rechliv",liv.rechercheLiv(catego, titr));
			
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
		
	}

}
