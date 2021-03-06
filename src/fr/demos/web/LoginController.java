package fr.demos.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Afficher la page (l'utilisateur ne connait pas la jsp)

		RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
		boolean erreur = false;

		HttpSession session = request.getSession();

		String action = request.getParameter("action");

		if (action != null && action.equals("OK")) {
			String nom = request.getParameter("nom");

			nom = nom.trim(); // verification pas d'espace dans nom **
			if (nom == null || nom.equals("")) {

				erreur = true;
				request.setAttribute("nomInvalide", "nom obligatoire");
			} else {
				session.setAttribute("nom", nom);
				rd = request.getRequestDispatcher("/ListClimatisationController"); // ne
																					// pas
																					// appeler
																					// la
																					// jsp,
																					// faut
																					// passer
																					// par
																					// le
																					// controleur//
			}
		}
		rd.forward(request, response);
	}

}