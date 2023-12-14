package l3m;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.simple.parser.JSONParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import l3m.LesCommandes.java.Commande;
import l3m.LesCartes.java.Plat;
import l3m.LesClients.java.*;


// Je suis passé par l'itération 0 du serveur...
public class FactServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

	/*____________________________________________________________________________________________________________________
	 * doPost is expecting a HTTP parameter userId
	 * It sends back a XML serializatipackage l3m;
     
     public class FactServlet {
     
     }on of the previous command with HTTP code 200 if a userId is specifyed
	 * It sends back a HTTP code 401 error if the userId is not specified or empty
	 * It sends back a HTTP code 500 error if a problem occured when accessing to the database
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
        String userDirectory = new File("").getAbsolutePath();
        System.out.println(userDirectory);

        response.setContentType("text/xml");
        String idcmd = request.getParameter("idcmd");
        Integer id = Integer.valueOf(idcmd);
        String jsonString = request.getParameter("nomFilms");           
        JSONParser parser = new JSONParser();
        List<String> jo;
      
        response.setHeader("Content-disposition", "attachment; filename=facture_" + id + ".xml");
        // Extract userId from HTTP parameters
        // Call the database and return result
        InputStream in = null;
        OutputStream out = null;

        try {

           

            try {


                jo = (List<String>) parser.parse(jsonString);
                CommandeDAO cmdao = new CommandeDAO();
                Commande cmd = cmdao.read(id);
                System.out.println(cmd.getId());

                int idClient = cmd.getIdClient(); 
                ClientDAO cldao = new ClientDAO(); 
                Client client = cldao.read(idClient);
                
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
    
                Document doc = builder.newDocument();
                Element fact = doc.createElement("facture");
                doc.appendChild(fact);


                Element nom = doc.createElement("nom");
                Element prenom = doc.createElement("prénom");
                Element prix = doc.createElement("prix");
                Element plat = doc.createElement("plat");
                Element plats = doc.createElement("plats");
                Element adresse = doc.createElement("adresse");
                Element tel = doc.createElement("Téléphone");
                Element email = doc.createElement("email");
                Element film = doc.createElement("film");
                Element date = doc.createElement("date");
                Element films = doc.createElement("films");


                fact.setAttribute("id", cmd.getId());

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                    LocalDateTime now = LocalDateTime.now();  
                    fact.appendChild(date);
                    date.appendChild(doc.createTextNode(dtf.format(now)));

                    fact.appendChild(nom);
                    nom.appendChild(doc.createTextNode(client.getNom()));
    
                    fact.appendChild(prenom);
                    prenom.appendChild(doc.createTextNode(client.getPrenom()));
    
                    fact.appendChild(adresse);
                    adresse.appendChild(doc.createTextNode(client.getAdresse()));
    
                    fact.appendChild(email);
                    email.appendChild(doc.createTextNode(client.getEmail()));
                
                    fact.appendChild(tel);
                    tel.appendChild(doc.createTextNode(client.getTel()));


                    DomPlatDAO p = new DomPlatDAO();
                    p.nomFichier = "./src/main/java/l3m/Menu/Plat_";

                    fact.appendChild(plats);
                    for (String s : cmd.getIdPlats()) {
                        
                                            System.out.print("le plat"+s);

                        plats.appendChild(plat);
                        Plat platActuel = p.read(Integer.valueOf(s)); 
                        plat.appendChild(doc.createTextNode(platActuel.getNom()+ "    : " +String.valueOf(platActuel.getPrix())+ " €")) ;
                        plat = doc.createElement("plat");
                    }


                    fact.appendChild(films);
                    for (String s : jo) {
    
                        films.appendChild(film);
                        film.appendChild(doc.createTextNode(s + "   : 3.75 €")) ;
                        film = doc.createElement("film");
                    }
                    
                    fact.appendChild(prix);
                    prix.appendChild(doc.createTextNode("" + cmd.getPrix()+" €"));

    
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                DOMSource source = new DOMSource(doc);

                StreamResult resultat = new StreamResult( "./src/main/java/l3m/Factures/facture_" + id + ".xml");
    
                transformer.transform(source, resultat);
                System.out.println("Fichier sauvegardé avec succès!");

                in = new FileInputStream(userDirectory + "/src/main/java/l3m/Factures/facture_" + id + ".xml");

                    out = response.getOutputStream();
                    IOUtils.copy(in, out);

                } finally {
                    
                    in.close();
                    out.close(); 
                }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e1) {
            e1.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().println( e.toString() );
        }
    }
}