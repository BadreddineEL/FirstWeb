package fr.demos.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.Voiture;
import fr.demos.VoitureSport;
import fr.demos.metier.Climatisation;

/**
 * Servlet implementation class MaDate
 */
@WebServlet("/MaDateControleur")
public class MaDateControleur extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MaDateControleur() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			d represente le model
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("h");
			String s = sdf.format(d);
			
			Date f = new Date();
			SimpleDateFormat sdt = new SimpleDateFormat("mm");
			String g = sdt.format(f);
			
			Date e = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
			String t = sd.format(e);
//			
			Climatisation clim1 = new Climatisation(37, 1013, 30, "Salle203");
			
			Voiture v = new Voiture ("Renault","clio","11233654P","BP256ZX",3000,120000,2002);
			Voiture vs = new VoitureSport("Range Rover", "4*4", "336784N", "YU254TY", 20000, 30000, 2015, 8, "F1");
			
			
			
//			TRANSFERT DU MODEL
			request.setAttribute("Heure", s);
			request.setAttribute("Minutes", g);
			request.setAttribute("dateDuJour", t);
			request.setAttribute("clim1", clim1);
			request.setAttribute("v", v);
			request.setAttribute("voiture", vs);
			
			
			
			
//		appel de la Vue
			RequestDispatcher rd = request.getRequestDispatcher("/madateView.jsp");
			rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
