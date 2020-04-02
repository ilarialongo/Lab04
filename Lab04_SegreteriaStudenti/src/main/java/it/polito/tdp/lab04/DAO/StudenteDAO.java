package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public Studente getStudente(Integer matricola) {

		final String sql = "SELECT * FROM studente WHERE studente.matricola=?";


		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Studente stud= new Studente(rs.getInt("matricola"), rs.getString("cognome"),rs.getString("nome"), rs.getString("CDS"));
				return stud;
			}
			conn.close();	
		
			
		} catch (SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
		return null;
		
	}
	
	
	/*
	public String nomeStudente(Integer matricola) {
		final String sql = "SELECT nome FROM studente WHERE matricola=?";
		String nome="";
		try {
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				nome= rs.getString("nome");
			}
			conn.close();
			return nome;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
	public String cognomeStudente(Integer matricola) {
		final String sql = "SELECT cognome FROM studente WHERE matricola=?";
		String cognome="";
		try {
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				cognome= rs.getString("cognome");
			}
			conn.close();
			return cognome;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	*/
	
	
	public List<Corso> getCorsiStudente(Integer matricola) {
		final String sql = "SELECT c.codins, c.crediti, c.nome, c.pd "
				+ "FROM corso as c, studente as s, iscrizione i "
				+ "WHERE s.matricola=i.matricola AND c.codins=i.codins AND s.matricola=?";
		LinkedList <Corso> corsi= new LinkedList<>();
		try {
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				Corso c= new Corso(codins, numeroCrediti, nome,periodoDidattico);
				corsi.add(c);
			}
			conn.close();
			return corsi;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
