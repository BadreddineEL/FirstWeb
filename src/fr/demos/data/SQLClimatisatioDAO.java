package fr.demos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import fr.demos.metier.Climatisation;

public class SQLClimatisatioDAO implements ClimatisationDAO {

	private DataSource ds = null;

	public SQLClimatisatioDAO() throws Exception {
		// recherche dans l'annuaire du pool de connexions
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("jdbc/appliclim");

	}

	@Override
	public void sauve(Climatisation clim) throws Exception {

		// On demande une connexion au pool
		Connection cx = ds.getConnection();
		// on va pouvoir préparer notre requête SQL
		PreparedStatement psmt = cx.prepareStatement("insert into climatisation values (?,?,?,?,?)");
		// Statement stmt = cx.createStatement();
		// stmt.executeUpdate("insert into climatisation values ("+cl.getNomAppareil()+","+...
		psmt.setString(1, clim.getNomAppareil());
		psmt.setDouble(2, clim.getTemp());
		psmt.setDouble(3, clim.getPression());
		psmt.setInt(4, clim.getTauxHumidite());
		psmt.setLong(5, clim.getDatation());
		psmt.executeUpdate();
		// on rend la connexion au pool
		cx.close();

	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		Connection cx = ds.getConnection();
		PreparedStatement psmt = cx.prepareStatement("select * from climatisation");
		ResultSet rs = psmt.executeQuery();
		ArrayList<Climatisation> liste = new ArrayList<>();
		while (rs.next()) {
			String nomAppareil = rs.getString(1);
			double temperature = rs.getDouble(2);
			double pression = rs.getDouble(3);
			int tauxHumidite = rs.getInt(4);
			long datation = rs.getLong(5);
			
			Climatisation cl = new Climatisation(temperature,pression,tauxHumidite,nomAppareil);
			liste.add(cl);
			
		}
		
		return liste;
	}

	@Override
	public List<Climatisation> recherche(String critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombreClim(String critere) {
		int nb=0;
		try {
//			peu performant : en sql on peut demander directement le nb d'éléments
			List<Climatisation> liste = this.rechercheTout();
			nb = liste.size();
		} catch (Exception e) {
			
		}
		return nb;
	}

}
