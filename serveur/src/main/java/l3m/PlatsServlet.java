package l3m;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import l3m.LesCartes.java.Carte;
import l3m.LesCartes.java.Plat;

public class PlatsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        DomCarteDAO cDao = new DomCarteDAO();
        cDao.nomFichier = "./src/main/java/l3m/Menu/Carte.xml";

        DomPlatDAO p = new DomPlatDAO();
        p.nomFichier = "./src/main/java/l3m/Menu/Plat_";

        Carte carte = cDao.read(1);
        List<Plat> plats = new ArrayList<>();
        plats = carte.getPlat();

        JsonArrayBuilder platosArray = Json.createArrayBuilder();
        JsonObjectBuilder platos = Json.createObjectBuilder();

        for (int k = 0; k < plats.size(); k++) {

            JsonArrayBuilder ing = Json.createArrayBuilder();
            JsonObjectBuilder objIng = Json.createObjectBuilder();

            for (int j = 0; j < plats.get(k).getIngredients().size(); j++) {
                objIng.add("ingredient", plats.get(k).getIngredients().get(j).value());
                ing.add(objIng);
            }


            platos.add("plat",
                    Json.createArrayBuilder()
                            .add(Json.createObjectBuilder().add("id", plats.get(k).getId())
                                    .add("nom", plats.get(k).getNom())
                                    .add("type", plats.get(k).getType().value())
                                    .add("prix", String.valueOf(plats.get(k).getPrix()))
                                    .add("photo", plats.get(k).getPhoto()).add("ingredients", ing))

            );
            platosArray.add(platos);

        }

        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("plats",platosArray);
        JsonObject jsony = builder.build();
        response.getWriter().println(jsony.toString());

    }



}