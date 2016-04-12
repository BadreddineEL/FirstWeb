package fr.demos.web;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.data.ClimatisationDAO;
import fr.demos.data.SQLClimatisatioDAO;
import fr.demos.metier.Climatisation;

/**
 * Servlet implementation class ClimatisationController
 */
@WebServlet("/ClimatisationController")
public class ClimatisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClimatisationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/SaisieClimatisation.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean erreur = false;
		RequestDispatcher rd = request.getRequestDispatcher("/SaisieClimatisation.jsp");

		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		if (action != null && action.equals("Enregistrer")) {
			String temperatureStr = request.getParameter("temperature");
			String pressionStr = request.getParameter("pression");
			String NomAppareil = request.getParameter("nomAppareil");
			String tauxHumiditeStr = request.getParameter("tauxHumidite");

			// Conversion

			double temperature = 0;
			double pression = 0;
			int tauxHumidite = 0;

			try {

				temperature = Double.parseDouble(temperatureStr);

			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("temperatureErreur", "nombre incorrecte");
			}

			try {

				pression = Double.parseDouble(pressionStr);

			} catch (NumberFormatException ex) {
				erreur = true;
				request.setAttribute("pressionErreur", "nombre incorrecte");
			}

			try {

				tauxHumidite = Integer.parseInt(tauxHumiditeStr);

			} catch (NumberFormatException x) {
				erreur = true;
				request.setAttribute("tauxHumiditeErreur", "nombre incorrecte");
			}

			request.setAttribute("temperature", temperatureStr);
			
			request.setAttribute("pression", pressionStr);
			request.setAttribute("nomAppareil", NomAppareil);
			request.setAttribute("tauxHumidite", tauxHumiditeStr);


			// validation
			if (NomAppareil == null || NomAppareil.equals("")) {
				erreur = true;
				request.setAttribute("NomAppareilErreur", "nom d'appareil obligatoire");
			}
			if (!erreur) {
				Climatisation clim = new Climatisation(temperature, pression, tauxHumidite, NomAppareil);
				
				
				try {
//					System.out.println("avant sauve");
					ClimatisationDAO dao =new SQLClimatisatioDAO();
					dao.sauve(clim);
					rd = request.getRequestDispatcher("/succesClimatisation.jsp");
				} catch (Exception e) {
					e.printStackTrace(); 
					request.setAttribute("sauvegardeErreur", e.getMessage());
					rd = request.getRequestDispatcher("/SaisieClimatisation.jsp");
				}

		
			}

		}
		rd.forward(request, response);
	}
}
