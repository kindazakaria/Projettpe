package com.tpgenielogiciel.control;

import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tpgenielogiciel.model.Empruntsimodel;

public class empruntsimp {
	
bdd based;
ResultSet resultat;
Statement stat;

		public empruntsimp() {
			super();
			based = new bdd();
     }

// methode permettant de determiner les livres retourne
/*		
public ArrayList<Empruntsimodel> listemp(int idah)	
{
	ArrayList<Empruntsimodel> emplis = new ArrayList<Empruntsimodel>();
	
	Empruntsimodel epmodel = new Empruntsimodel();
	String etat = "retourne";
	
	try {
		PreparedStatement ps = based.connect().prepareStatement(
"select nom,prenom,titre,datesor,dateret from utilisateur,livres,emprunt where utilisateur.id = emprunt.id and emprunt.id = livres.id  and emprunt.etatemp = ?  and emprunt.id = ?");
		
		ps.setInt(1, idah);
		ps.setString(2, etat);
		
		 resultat = ps.executeQuery();
		 
		 while(resultat.next())
		 {
			 epmodel.setNonAdherent(resultat.getString("nom"));
			 epmodel.setPrenomAdherent(resultat.getString("prenom"));
			 epmodel.setTitreliv(resultat.getString("titre"));
			 epmodel.setDatesortie(resultat.getString("datesor"));
			 epmodel.setDateretour(resultat.getString("dateret"));
			 
			 emplis.add(epmodel);
		 }
		 
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("erreur de liste********"+e.getMessage());
	}
	
	return emplis;
}*/
		
		public  ArrayList<Empruntsimodel> listemp(int idah)
		{
			System.out.println("la requete est ok********");
				ArrayList<Empruntsimodel> listpret = new ArrayList<Empruntsimodel>();
				
				String etat = "retourne";
				System.out.println("la requete est ok********");
				
				try {
					stat = based.connect().createStatement();
					System.out.println("la requete est ok********");
					resultat = stat.executeQuery("select titre,nom,datesor,dateret from livres,emprunt where livres.id = emprunt.idliv and emprunt.idemp = "+idah+" and etatemp = '"+etat+"'");
					System.out.println("la requete est ok********");
					
					while(resultat.next())
					{
						Empruntsimodel emp = new Empruntsimodel();
						emp.setTitreliv(resultat.getString("titre"));
						emp.setNomAut(resultat.getString("nom"));
						emp.setDateretour(resultat.getString("datesor"));
						emp.setDateretour(resultat.getString("dateret"));
						
						listpret.add(emp);
						System.out.println(" tetechargement ok******* ");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("erreur array empruntsimp****"+e.getMessage());
				}
				
				return listpret;
		}
		
		public ArrayList<Empruntsimodel> demand(int idah)
		{
			ArrayList<Empruntsimodel> demnd = new ArrayList<Empruntsimodel>();
			String etat = "demande";
			
			try {
				//PreparedStatement ps = based.connect().prepareStatement("select livres.titre,livres.nom,emprunt.datesor from livres,emprunt where livres.id = emprunt.idliv and  emprunt.idemp = ? and etatemp = ?");
				//ps.setInt(1, idah);
				//ps.setString(2, etat);
					stat = based.connect().createStatement();
					resultat = stat.executeQuery("Select titre,nom,datesor from livres,emprunt where livres.id = idliv and idemp = "+idah+" and etatemp = '"+etat+"' ");
				
				//resultat = ps.executeQuery();
				while(resultat.next())
				{
					Empruntsimodel emp = new Empruntsimodel();
					
					emp.setTitreliv(resultat.getString("titre"));
					emp.setNomAut(resultat.getString("nom"));
					emp.setDatesortie(resultat.getString("datesor"));
					System.out.println("***********"+emp.getNomAut());
					System.out.println("***********"+emp.getTitreliv());
					System.out.println("***********"+emp.getDatesortie());
					
					demnd.add(emp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("erreur sur demande emprunt "+e.getMessage());
			}
			
			return demnd;
		}

		// methode permettant de renvoie la liste des listes en possession de l emprunteur
		public ArrayList<Empruntsimodel> demdrendre(int idah)
		
		{
			 String etat = "emprunt";
			 
			ArrayList<Empruntsimodel> rendre = new ArrayList<Empruntsimodel>();
			
			try {
				PreparedStatement ps = based.connect().prepareStatement(" select titre,livres.nom as nom, datesor,dateret from livres , emprunt where livres.id = emprunt.idliv and idemp = "+idah+" and etatemp = '"+etat+"'");
				 resultat = ps.executeQuery();
				 
				 	while(resultat.next())
				 	{
				 		Empruntsimodel empl = new Empruntsimodel();
				 		
				 		empl.setTitreliv(resultat.getString("titre"));
				 		empl.setNomAut(resultat.getString("nom"));
				 		empl.setDatesortie(resultat.getString("datesor"));
				 		empl.setDateretour(resultat.getString("dateret"));
				 		
				 		System.out.println("**************** retour" +empl.getDateretour());
				 		
				 		rendre.add(empl);
				 	}
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("erreur emprunt****"+e.getMessage());
			}
					return rendre;
		}
		
		// methode permettant de determnier l ensemble des livres  en attente de validation
		public ArrayList<Empruntsimodel> affchpret()
		{
			 String etat = "demande";
			//String req = " select utilisateur.nom,prenom,titre,livres.nom,datesor form utilisateur,livres,emprunt where
					//utilisateur.id = adherents.idliv and livres.id = adherents.idliv and utilisateur.id = emprunt.idemp and etatemp='"+etat+"'";
			
			ArrayList<Empruntsimodel> empr =  new ArrayList<Empruntsimodel>();
			
			PreparedStatement ps;
			try {
				ps = based.connect().prepareStatement("select utilisateur.nom,prenom,titre,livres.nom as aut ,datesor from utilisateur,livres,emprunt where utilisateur.id = emprunt.idemp and livres.id = emprunt.idliv and  etatemp='"+etat+"'");
						
				resultat = ps.executeQuery();
				
					while(resultat.next())
					{
						Empruntsimodel emp = new Empruntsimodel();
						
						 emp.setNonAdherent(resultat.getString("nom"));
						 emp.setPrenomAdherent(resultat.getString("prenom"));
						 emp.setTitreliv(resultat.getString("titre"));
						 emp.setNomAut(resultat.getString("aut"));
						 emp.setDatesortie(resultat.getString("datesor"));
						 
						 empr.add(emp);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
				return empr;
		}

}
