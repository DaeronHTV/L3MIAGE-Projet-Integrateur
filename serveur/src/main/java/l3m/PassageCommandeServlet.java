package l3m;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import l3m.LesCommandes.java.Commande;
import l3m.CommandeDAO;

public class PassageCommandeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(request);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        try{
           
            String date = request.getParameter("date");
            int idClient = Integer.parseInt(request.getParameter("idClient"));

            String jsonFilms = request.getParameter("idFilms");           
            JSONParser parser = new JSONParser();
            List<String> joFilms = (List<String>) parser.parse(jsonFilms);
            
            String jsonplats = request.getParameter("idPlats");           
            List<String> joPlats = (List<String>) parser.parse(jsonplats);
           

            String adresseLivraison = request.getParameter("adresseLivraison");

            Commande UneCommande = new Commande();
            UneCommande.setDate(date);
            UneCommande.setIdClient(idClient);
            UneCommande.setIdPlats(joPlats);
            UneCommande.setIdFilms(joFilms);
            
            UneCommande.setAdresseLivraison(adresseLivraison);

            String idCommande = BdAccess.createCommande(UneCommande);
            response.setStatus(HttpServletResponse.SC_OK);
            System.out.println(idCommande);
            response.getWriter().print(""+idCommande); 

        }catch(Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println(e.toString());
        }
	}
      
}