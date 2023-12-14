package l3m;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import l3m.LesCartes.java.Ingredient;
import l3m.LesCartes.java.Plat;
import l3m.LesCartes.java.TypeDePlat;

public class SaxDAO implements DAO<Plat> {

        protected SAXParser saxParser ;

    public boolean create(Plat obj){

            return false; 
    
    }
    
    public Plat read(int id){

        Stack<String> elements = new Stack<String>();
        Stack<Plat> objects = new Stack<Plat>();
        List<Ingredient> lesingt = new ArrayList<>();

        Plat plat = new Plat() ;

            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                saxParser = factory.newSAXParser();

                String filename = "./Menu/Plat_"+id+".xml";
                InputStream is = getClass().getResourceAsStream(filename);


                saxParser.parse(is, new DefaultHandler() {
                    @Override
                    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

                        elements.push(qName);
                        if ("plat".equals(qName)) {
                            Plat plat = new Plat();
                            objects.push(plat);
                          
                        }
                    }
    
                    @Override
                    public void endElement(String uri, String localName, String qName) throws SAXException {
                        elements.pop();
                    }
    
                    @Override
                    public void characters(char[] ch, int start, int length) throws SAXException {
    
                        String value = new String(ch, start, length);
                        if (value.length() == 0) {
                            return;
                        }
    
                        if ("nom".equals(elements.peek())) {
                            plat.setNom(value);
                        } else if ("prix".equals(elements.peek())) {
                            plat.setPrix(Double.valueOf(value));
                        } else if ("type".equals(elements.peek())) {
                            plat.setType(TypeDePlat.fromValue(value));
                        } else if ("photo".equals(elements.peek())) {
                           plat.setPhoto(value);
                        } else if ("ingredients".equals(elements.peek())) {
                            lesingt.add(Ingredient.fromValue(value));

                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

            plat.setIngredients(lesingt);
            return plat;

    }

    public boolean update(Plat obj){

            return false; 
    }

    public boolean delete(Plat obj){

            return false; 

    }
    
}