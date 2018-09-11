package com.tpgenielogiciel.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tpgenielogiciel.model.Affdemamodel;

public class Affdemacont {
	
	bdd base;
	ResultSet resultat;
	
	
	public Affdemacont() {
		//super();
		 base = new bdd();
	}
	
		public ArrayList<Affdemamodel> affdmnd ()
		{
			ArrayList<Affdemamodel> contnu = new ArrayList<Affdemamodel>();
			String etat = "demande";
			
			try {
				PreparedStatement ps = base.connect().prepareStatement("select utilisateur.nom,prenom,titre,livres.id,livres.nom as aut ,datesor from utilisateur,livres,emprunt where utilisateur.id = emprunt.idemp and livres.id = emprunt.idliv and  etatemp='"+etat+"'");
				
				resultat = ps.executeQuery();
				
				while(resultat.next())
				{
					Affdemamodel emp = new Affdemamodel();
					
					
					emp.setNom(resultat.getString("nom"));
					emp.setPrenom(resultat.getString("prenom"));
					emp.setTitreliv(resultat.getString("titre"));
					emp.setIdliv(resultat.getInt("id"));
					emp.setNomaut(resultat.getString("aut"));
					emp.setDatesor(resultat.getString("datesor"));
					
					contnu.add(emp);
				}
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("erreur affichage liste **** "+e.getMessage());
			}
			
			return contnu;
		}
	
		
		public ArrayList<Affdemamodel> affemnpr ()
		{
			ArrayList<Affdemamodel> contnu = new ArrayList<Affdemamodel>();
			String etat = "emprunt";
			
			try {
				PreparedStatement ps = base.connect().prepareStatement("select utilisateur.nom,prenom,titre,livres.id ,livres.nom as aut ,datesor,dateret as dat from utilisateur,livres,emprunt where utilisateur.id = emprunt.idemp and livres.id = emprunt.idliv and  etatemp='"+etat+"'");
				
				resultat = ps.executeQuery();
				
				while(resultat.next())
				{
					Affdemamodel empl = new Affdemamodel();
					
					
					empl.setNom(resultat.getString("nom"));
					empl.setPrenom(resultat.getString("prenom"));
					empl.setTitreliv(resultat.getString("titre"));
					empl.setIdliv(resultat.getInt("id"));
					empl.setNomaut(resultat.getString("aut"));
					empl.setDatesor(resultat.getString("datesor"));
					empl.setDateret(resultat.getString("dat"));
					
					
					//System.out.println("***************** affichag pret"+resultat.getString("nom"));
					contnu.add(empl);
				}
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("erreur affichage liste **** "+e.getMessage());
			}
			
			return contnu;
		}

}
