package l3m;

import java.io.File;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import l3m.LesCartes.java.Ingredient;
import l3m.LesCartes.java.Plat;
import l3m.LesCartes.java.TypeDePlat;


public class DomPlatDAO extends DomDAO<Plat>{

    public boolean create(Plat obj) {


        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element plat = doc.createElement("plat");
            doc.appendChild(plat);

            Element nom = doc.createElement("nom");
            Element ing = doc.createElement("ingredients");
            Element prix = doc.createElement("prix");
            Element type = doc.createElement("type");
            Element photo = doc.createElement("photo");

            plat.setAttribute("id", obj.getId());

                plat.appendChild(nom);
                nom.appendChild(doc.createTextNode(obj.getNom()));

                plat.appendChild(type);
                type.appendChild(doc.createTextNode(obj.getType().value()));


                plat.appendChild(prix);
                prix.appendChild(doc.createTextNode("" + obj.getPrix()));


                plat.appendChild(photo);
                photo.appendChild(doc.createTextNode("" + obj.getPhoto()));

                
                for (Ingredient s : obj.getIngredients()) {

                    plat.appendChild(ing);
                    ing.appendChild(doc.createTextNode(s.value()));
                    ing = doc.createElement("ingredients");
                }

            

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult resultat = new StreamResult(this.nomFichier+obj.getId()+".xml");

            transformer.transform(source, resultat);
            System.out.println("Fichier sauvegardé avec succès!");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

        return true;

    }

    public Plat read(int id) {

        Plat plat = null;

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.doc = builder.parse(this.nomFichier+id+".xml");

            Element root = doc.getDocumentElement();
            System.out.println("la racine est : " + root.getNodeName());

            NodeList nodes = doc.getElementsByTagName("plat");
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

                    plat = new Plat();
                    plat.setId(String.valueOf(id));
                    plat.setNom(elt.getElementsByTagName("nom").item(0).getTextContent());
                    plat.setPhoto(elt.getElementsByTagName("photo").item(0).getTextContent());
                    plat.setPrix(Double.valueOf(elt.getElementsByTagName("prix").item(0).getTextContent()));
                    plat.setType( TypeDePlat.fromValue(elt.getElementsByTagName("type").item(0).getTextContent())) ; 
                    NodeList ingredients = elt.getElementsByTagName("ingredients");
                    List<Ingredient> lesingt = new ArrayList<>();

                    for(int j = 0; j < ingredients.getLength(); j++) {

                        lesingt.add(Ingredient.fromValue(ingredients.item(j).getTextContent()));
                    }

                
                    plat.setIngredients(lesingt);

        

    }   
    
    catch (ParserConfigurationException e) {
        e.printStackTrace();
        } catch (SAXException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
    }       

        return plat ;
    }

    public boolean update(Plat obj){


        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.doc = builder.parse(this.nomFichier+obj.getId()+".xml");

            Element root = doc.getDocumentElement();
            System.out.println("la racine est : " + root.getNodeName());

            
            NodeList nodes = doc.getElementsByTagName("plat");
            Element elt = null;

            for(int j = 0; j < nodes.getLength(); j++) {
            Node fieldNode = nodes.item(j);
            Element no = (Element) fieldNode;
            String item = no.getAttribute("id");
                
            if(item.equals(obj.getId())) {
                    elt = no ; 
                }
            }

                    Node lelt =  elt.getElementsByTagName("nom").item(0);
                    lelt.setTextContent(""+obj.getNom());

                    lelt =  elt.getElementsByTagName("prix").item(0);
                    lelt.setTextContent(""+obj.getPrix());
                
                    lelt = elt.getElementsByTagName("photo").item(0);
                    lelt.setTextContent(""+obj.getPhoto());

                    lelt = elt.getElementsByTagName("type").item(0);
                    lelt.setTextContent(""+obj.getType().value());

                    List<Ingredient> lg = obj.getIngredients();
                    NodeList ingredients = elt.getElementsByTagName("ingredients");

                   
                    while( ingredients.getLength() != 0){
                    for(int j = 0; j < ingredients.getLength(); j++) {

                        Node n = ingredients.item(j);
                        elt.removeChild(n);
                        }
                    }

                
                    Element ing = doc.createElement("ingredients");

                    for (Ingredient s : lg) {

                        elt.appendChild(ing);
                        ing.appendChild(doc.createTextNode(s.value()));
                        ing = doc.createElement("ingredients");
                    }


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(doc);
        StreamResult resultat = new StreamResult(this.nomFichier+obj.getId()+".xml");

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

    public boolean delete(Plat obj){


        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.doc = builder.parse(this.nomFichier+obj.getId()+".xml");

            Element root = doc.getDocumentElement();
            System.out.println("la racine est : " + root.getNodeName());
            
              
            NodeList nodes = doc.getElementsByTagName("plat");
            Element elt = null;

            for(int j = 0; j < nodes.getLength(); j++) {
            Node fieldNode = nodes.item(j);
            Element no = (Element) fieldNode;
            String name = no.getAttribute("id");

            if(name.equals(obj.getId())) {
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
            StreamResult resultat = new StreamResult(this.nomFichier+obj.getId()+".xml");
    
            transformer.transform(source, resultat);
            System.out.println("Objet supprimé avec succès!");
            File f = new File(this.nomFichier+obj.getId()+".xml");
            f.delete();
    


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
