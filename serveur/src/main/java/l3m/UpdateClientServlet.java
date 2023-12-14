package l3m;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import l3m.LesClients.java.Client;

// Je suis passé par l'itération 0 du serveur...
public class UpdateClientServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println( "" );
    }

	/*____________________________________________________________________________________________________________________
	 * doPost is expecting a HTTP parameter userId
	 * It sends back a XML serialization of the previous command with HTTP code 200 if a userId is specifyed
	 * It sends back a HTTP code 401 error if the userId is not specified or empty
	 * It sends back a HTTP code 500 error if a problem occured when accessing to the database
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		// Extract userId from HTTP parameters
        // Call the database and return result
        try {
			Client c = new Client();
			c.setId(Integer.parseInt(request.getParameter("id")));
			c.setAdresse(request.getParameter("adresse"));
			c.setEmail(request.getParameter("email"));
			c.setNom(request.getParameter("nom"));
			c.setPrenom(request.getParameter("prenom"));
			c.setPhoto( request.getParameter("photo"));
			c.setTel( request.getParameter("tel"));
			BdAccess.updateClient(c);
	        response.setStatus(HttpServletResponse.SC_OK);
	        response.getWriter().print( "created" );
        } catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().println( e.toString() );
        }
    }
}