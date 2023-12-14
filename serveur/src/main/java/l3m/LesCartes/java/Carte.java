//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.04.10 à 09:00:37 PM CEST 
//


package l3m.LesCartes.java;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Carte complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Carte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="plat" type="{http://u-ga.fr/site}Plat" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Carte", propOrder = {
    "plat"
})
public class Carte {

    private List<Plat> plat;
    private int id ; 

    /**
     * Gets the value of the plat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Plat }
     * 
     * 
     */
    public List<Plat> getPlat() {
        if (plat == null) {
            plat = new ArrayList<Plat>();
        }
        return this.plat;
    }

    public void setPlat( List<Plat> plat ) {
       this.plat = plat;
    }

    public int getIdCarte() {
        return this.id;
     }


    public void setIdCarte(int id) {
        this.id = id;
     }
}

