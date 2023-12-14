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
public class FactServletHisto extends HttpServlet {

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
        
        response.setHeader("Content-disposition", "attachment; filename=facture_" + id + ".xml");
        InputStream in = null;
        OutputStream out = null;

        try {
            try {
                in = new FileInputStream(userDirectory + "/src/main/java/l3m/Factures/facture_" + id + ".xml");

                    out = response.getOutputStream();
                    IOUtils.copy(in, out);

                } finally {
                    
                in.close();
                    out.close(); 
                }

        }catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println( e.toString() );
        }
    }
}