package fr.demos.data;

import java.util.List;

import fr.demos.metier.Climatisation;

//	Data Acces Object
public interface ClimatisationDAO {
	
	void sauve(Climatisation clim) throws Exception;
	List<Climatisation> rechercheTout () throws Exception;
	List<Climatisation> recherche (String critere) throws Exception;
	int nombreClim(String critere); 
	
	

}
