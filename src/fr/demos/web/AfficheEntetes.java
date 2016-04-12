package fr.demos.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AfficheEntetes
 */
@WebServlet("/AfficheEntetes")
public class AfficheEntetes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheEntetes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Enumeration<String> nomsEntete = request.getHeaderNames();
		
//	Objectif:	Afficher le nom de chaque entête et sa valeur
		
		out.println("<html>");
		out.println("<body>");
		out.println("Entêtes<hr>");
		while(nomsEntete.hasMoreElements()){  // tant qu'il y a "encore" des elements je boucle.
			String nom =nomsEntete.nextElement(); // je récupére mes éléments avec nextElement.
			out.println(nom + " : " + request.getHeader(nom));	
			out.println("<br/>");
		}

		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
