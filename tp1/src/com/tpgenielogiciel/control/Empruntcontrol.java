package com.tpgenielogiciel.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
//import java.text.FieldPosition;
//import java.text.ParsePosition;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.tpgenielogiciel.model.Empruntmodel;

//import org.postgresql.ds.common.BaseDataSource;

public class Empruntcontrol {
	Statement stat;
	ResultSet resultat;
	bdd base ;
	
	// methode permettant de determiner la date d emprunt d un livre
	
	public Empruntcontrol() {
		 base = new bdd();
		 
	}

	public String datesortie()
	{
		String datesortie = null;
		
		Date dat = new Date();
		SimpleDateFormat datesort = new SimpleDateFormat("dd/MM/yyyy");
		 datesortie = datesort.format(dat);
		 
		 return datesortie;
	}
	
// methode permettant de calculer la date de retour.la method fait plus trois jours la date de sortie
	public String dateretour()
	{
		String dateretour = null;
		
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar calen = new GregorianCalendar();
		Date datjr = new Date();
		calen.setTime(datjr);
		calen.add(GregorianCalendar.DAY_OF_WEEK, +4);
		
		dateretour = df.format(calen.getTime());
		
		return dateretour;
	}
	// methode qui convertit un String en date
	public Date converti (String dat)
	{
		Date d = null;
		SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
		try {
			d = sfd.parse(dat);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("erreur conversion date "+e.getMessage());
		}
		
			return d;
		
	}
	
	
	// methode permettant de calculer le nombre d exemplaire d un livre emprunte
	
	public int nbrexemplaireint(int idli)
	{
		int nbrexple =0;
		
		
		try {
			stat = base.connect().createStatement();
			resultat = stat.executeQuery("select count(idliv) as nbre from emprunt  where idliv = "+idli+" ");
			if(resultat.next())
				nbrexple = resultat.getInt("nbre");
			
		} catch (SQLException e) {
			System.out.println("erreur de nombre exemplaire"+e.getMessage());
		}
		
		
		return nbrexple;
	}
	
	// methode qui permet de compare deux dates. elle prend en entree deux et renvoi a la sortie un boolean
	
	public boolean comparedatn(Date datretourliv,Date datexprirabon)
	{
		boolean resuldat = datretourliv.before(datexprirabon);
		
		return resuldat;
	}
	
	// methode permettant de verifier si un adherent n a pas le meme livre avnt
	public int emprntavant(int idadh,int idliv)
	{
		int multip = 0;
		
		try {
			stat = base.connect().createStatement();
			resultat = stat.executeQuery("select count(idliv) as nbre from emprunt where idemp ="+idadh+" and idliv = "+idliv+" ");
			if(resultat.next())
				multip = resultat.getInt("nbre") ;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("pret avant **********"+multip);
		System.out.println("pret avant **********"+idliv);
		return multip;	
	}
	
	//  methode permettant d'enregistrer une nouvelle demande d emprunt
	public int enregistrepret (Empruntmodel mode)
	{
		int retourins = 0;
		try {
			PreparedStatement ps = base.connect().prepareStatement("INSERT INTO emprunt (idemp,idliv,datesor,dateret,etatemp) VALUES (?,?,?,?,?) ");
			
			ps.setInt(1, mode.getIdadhernt());
			ps.setInt(2, mode.getIdlivr());
			ps.setString(3, mode.getDatesortie());
			ps.setString(4, mode.getDateretour());
			ps.setString(5, mode.getetatemp());
			
			retourins = ps.executeUpdate();
			
			System.out.println("enregistrement encours************ methode enrgistrment");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("erreur enrgistrment pret"+e.getMessage());
		}
		
		System.out.println("enregistrement retour valeur************ methode enrgistrment");
		return retourins;
		
	}
	
	// methode permettant de confirmer le retour d un livre prete
	public int confiretour (int idemp,int idliv)
	{ int retou =0;
		// String etat = "retourne";
		try {
			PreparedStatement ps = base.connect().prepareStatement("DELETE  from emprunt where idemp = ?  And idliv = ? ");
			
			ps.setInt(1, idemp);
			ps.setInt(2, idliv);
			
			 retou = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println("erreur udpdate********"+retou);
		}
		
			return retou;
	}
	
	// methode permettant de faire  un update d un emprunt
	
	public int mislivr (int idemp,int idliv)
	{
		int mise = 0;
		//String etat = "emprunt"
		 String req = "update emprunt set etatemp = ? where idemp = ? and idliv = ? ";
		
		try {
			PreparedStatement ps = base.connect().prepareStatement(req);
			ps.setString(1, "emprunt");
			ps.setInt(2, idemp);
			ps.setInt(3, idliv);
			
			mise = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			System.out.println("erreur de mise a jour des emprunts"+e.getMessage());
		}
		
		return mise;
	}
}
