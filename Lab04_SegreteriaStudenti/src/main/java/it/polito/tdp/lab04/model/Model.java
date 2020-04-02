package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;


public class Model {
	CorsoDAO dao;
	StudenteDAO daoStud;
	public Model() {
		this.dao= new CorsoDAO();
		this.daoStud= new StudenteDAO();
		}
	
	public List<Corso> getTuttiICorsi() {
		return dao.getTuttiICorsi();
	}
	
	/* public String nomeStudente(Integer matricola) {
		return daoStud.nomeStudente(matricola);
	}
	
	public String cognomeStudente(Integer matricola) {
		return daoStud.cognomeStudente(matricola);
	}
	*/
	public Studente getStudente (Integer matricola) {
		return daoStud.getStudente(matricola);
	}
	
	public String getStudentiIscrittiAlCorso(Corso corso) {
		List<Studente> studenti= dao.getStudentiIscrittiAlCorso(corso);
		String sTemp="";
		   for(Studente s: studenti) {
			  
			   if (sTemp=="") {
			   sTemp= s.toString();
		   }
			   else {
				   sTemp+="\n"+s.toString();
			   }
			   
		   } 
		   return sTemp;
	   }
	
	public String getCorsiStudente(Integer matricola) {
		List<Corso> corsi= daoStud.getCorsiStudente(matricola);
		String sTemp="";
		   for(Corso c: corsi) {
			  
			   if (sTemp=="") {
			   sTemp= c.getCodins()+" "+c.getNome()+" "+c.getCrediti()+" "+c.getPd();
		   }
			   else {
				   sTemp+="\n"+c.getCodins()+" "+c.getNome()+" "+c.getCrediti()+" "+c.getPd();
			   }
			   
		   } 
		   return sTemp;
	}
	
	public boolean isIscritto(Corso corso, Integer matricola) {
		return dao.isIscritto(corso, matricola);
	}

}
