package l3m;

import java.io.IOException;
import java.util.ArrayList;
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

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import l3m.LesCartes.java.Carte;
import l3m.LesCartes.java.Ingredient;
import l3m.LesCartes.java.Plat;
import l3m.LesCartes.java.TypeDePlat;


public class DomCarteDAO extends DomDAO<Carte> {

    public boolean create(Carte obj) {


        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element carte = doc.createElement("carte");
            carte.setAttribute("id", ""+obj.getIdCarte());
            doc.appendChild(carte);

            Element plat = doc.createElement("plat");
            Element nom = doc.createElement("nom");
            Element ing = doc.createElement("ingredients");
            Element prix = doc.createElement("prix");
            Element type = doc.createElement("type");
            Element photo = doc.createElement("photo");

            List<Plat> plats = new ArrayList<>();
            plats = obj.getPlat();

            for (Plat s : plats) {

                carte.appendChild(plat);

                plat.setAttribute("id", s.getId());

                plat.appendChild(nom);
                nom.appendChild(doc.createTextNode(s.getNom()));
                nom = doc.createElement("nom");

                plat.appendChild(type);
                type.appendChild(doc.createTextNode(s.getType().value()));
                type = doc.createElement("type");

                plat.appendChild(prix);
                prix.appendChild(doc.createTextNode("" + s.getPrix()));
                prix = doc.createElement("prix");

                plat.appendChild(photo);
                photo.appendChild(doc.createTextNode("" + s.getPhoto()));
                photo = doc.createElement("photo");

               for (Ingredient c : s.getIngredients()) {

                    plat.appendChild(ing);
                    ing.appendChild(doc.createTextNode(c.value()));
                    ing = doc.createElement("ingredients");
                }


                plat = doc.createElement("plat");

            }
           
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            
            DOMSource source = new DOMSource(doc);
            StreamResult resultat = new StreamResult(this.nomFichier);

            transformer.transform(source, resultat);
            System.out.println("Fichier sauvegardé avec succès!");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

        return true;

    }

    public Carte read(int id) {

        Carte c = null;

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.doc = builder.parse(this.nomFichier);

            Element root = doc.getDocumentElement();
            System.out.println("la racine est : " + root.getNodeName());
            
            NodeList nodes = doc.getElementsByTagName("carte");
            Element elt = null;

            for(int j = 0; j < nodes.getLength(); j++) {
            Node fieldNode = nodes.item(j);
            Element no = (Element) fieldNode;
            NamedNodeMap attributes = fieldNode.getAttributes();
            Node attr = attributes.getNamedItem("id");
            if(attr.getTextContent().equals(String.valueOf(id))){
                    elt = no ; 
                }
            }
            List<Plat> plats = new ArrayList<>();


            NodeList nodeList = elt.getElementsByTagName("plat");

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element plato = (Element) node;
                    Plat plat = new Plat();
                    plat.setId(plato.getAttribute("id"));
                    plat.setNom(plato.getElementsByTagName("nom").item(0).getTextContent());
                    plat.setPhoto(plato.getElementsByTagName("photo").item(0).getTextContent());
                    plat.setPrix(Double.valueOf(plato.getElementsByTagName("prix").item(0).getTextContent()));
                    plat.setType( TypeDePlat.fromValue(plato.getElementsByTagName("type").item(0).getTextContent())) ; 
                    NodeList ingredients = plato.getElementsByTagName("ingredients");
                    List<Ingredient> lesingt = new ArrayList<>();

                    for(int j = 0; j < ingredients.getLength(); j++) {

                        lesingt.add(Ingredient.fromValue(ingredients.item(j).getTextContent()));
                    }

                
                    plat.setIngredients(lesingt);

                    plats.add(plat);

                }     
        } 
    
       
        c = new Carte() ;
        c.setIdCarte(id);
        c.setPlat(plats);
        

    }   
    
    catch (ParserConfigurationException e) {
        e.printStackTrace();
        } catch (SAXException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
    }       

        return c ;
    }

    public boolean update(Carte obj){

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.doc = builder.parse(this.nomFichier);

            Element root = doc.getDocumentElement();
            System.out.println("la racine est : " + root.getNodeName());


            Element plat = doc.createElement("plat");
            Element nom = doc.createElement("nom");
            Element ing = doc.createElement("ingredients");
            Element prix = doc.createElement("prix");
            Element type = doc.createElement("type");
            Element photo = doc.createElement("photo");


            List<Plat> plats = new ArrayList<>();
            plats = obj.getPlat();
 
            NodeList nodes = doc.getElementsByTagName("carte");
            Element carte = null;

            for(int j = 0; j < nodes.getLength(); j++) {
            Node fieldNode = nodes.item(j);
            Element no = (Element) fieldNode;
            NamedNodeMap attributes = fieldNode.getAttributes();
            Node attr = attributes.getNamedItem("id");
            if(attr.getTextContent().equals(""+obj.getIdCarte())){
                    carte = no ; 
                }
            }

            NodeList nodeList = carte.getElementsByTagName("plat");





            for (int i = 0; i < plats.size(); i++) {

                Node node = nodeList.item(i);
                Element elt = (Element) node;
                if(i<nodeList.getLength()){

        
                    Node lelt =  elt.getElementsByTagName("nom").item(0);
                    lelt.setTextContent(""+obj.getPlat().get(i).getNom());
                    
                    lelt =  elt.getElementsByTagName("prix").item(0);
                    lelt.setTextContent(""+obj.getPlat().get(i).getPrix());
                
                    lelt = elt.getElementsByTagName("photo").item(0);
                    lelt.setTextContent(""+obj.getPlat().get(i).getPhoto());

                    lelt = elt.getElementsByTagName("type").item(0);
                    lelt.setTextContent(""+obj.getPlat().get(i).getType().value());

                                    
                    List<Ingredient> lg = obj.getPlat().get(i).getIngredients();
                    NodeList ingredients = elt.getElementsByTagName("ingredients");

                
                    while( ingredients.getLength() != 0){
                    for(int j = 0; j < ingredients.getLength(); j++) {

                        Node n = ingredients.item(j);
                        elt.removeChild(n);
                        }
                    }

            
                    for (Ingredient s : lg) {

                        elt.appendChild(ing);
                        ing.appendChild(doc.createTextNode(s.value()));
                        ing = doc.createElement("ingredients");
                    }
                  
                }else{


                    carte.appendChild(plat);

                    plat.appendChild(nom);
                    nom.setTextContent(""+obj.getPlat().get(i).getNom());
                    nom = doc.createElement("nom");

                    plat.appendChild(prix);
                    prix.setTextContent(""+obj.getPlat().get(i).getPrix());
                    prix = doc.createElement("prix");

                    plat.appendChild(photo);
                    photo.setTextContent(""+obj.getPlat().get(i).getPhoto());
                    photo = doc.createElement("photo");

                    plat.appendChild(type);
                    type.setTextContent(""+obj.getPlat().get(i).getType().value());
                    type = doc.createElement("type");
                                    
                    List<Ingredient> lg = obj.getPlat().get(i).getIngredients();

                    for (Ingredient s : lg) {

                        plat.appendChild(ing);
                        ing.appendChild(doc.createTextNode(s.value()));
                        ing = doc.createElement("ingredients");
                    }
                    
                    plat = doc.createElement("plat");

                }
        }

        int j = plats.size();
            while( j < nodeList.getLength() ){

                Node node = nodeList.item(j);
                Element elt = (Element) node;
                Node parent = elt.getParentNode();
                parent.removeChild(elt);
                parent.normalize();
                j++; 
            }

            if(nodeList.getLength() != plats.size() ){

                Node node = nodeList.item(plats.size());
                Element elt = (Element) node;
                Node parent = elt.getParentNode();
                parent.removeChild(elt);
                parent.normalize();


            }



        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(doc);
        StreamResult resultat = new StreamResult(this.nomFichier);

        transformer.transform(source, resultat);
        System.out.println("Fichier mis à jour avec succès!");

    }   
    
    catch (ParserConfigurationException e) {
        e.printStackTrace();
        } catch (SAXException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        } catch (TransformerException tfe) {
        tfe.printStackTrace();
    }

        return true ;
    


    }

    public boolean delete(Carte obj){


        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.doc = builder.parse(this.nomFichier);

            Element root = doc.getDocumentElement();
            System.out.println("la racine est : " + root.getNodeName());
           
            NodeList nodes = doc.getElementsByTagName("carte");
            Element elt = null;

            for(int j = 0; j < nodes.getLength(); j++) {
            Node fieldNode = nodes.item(j);
            Element no = (Element) fieldNode;
            String name = no.getAttribute("id");

            if(name.equals(String.valueOf(obj.getIdCarte()))) {
                    elt = no ; 

                }
            }

            Node parent = elt.getParentNode();
            parent.removeChild(elt);
            parent.normalize();
             
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult resultat = new StreamResult(this.nomFichier);
    
            transformer.transform(source, resultat);
            System.out.println("Objet supprimé avec succès!");
    


    }   
    
    catch (ParserConfigurationException e) {
        e.printStackTrace();
        } catch (SAXException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        } catch (TransformerException tfe) {
        tfe.printStackTrace();
    }     

        return true ;
    



    }


}
