//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.04.10 à 10:44:39 AM CEST 
//


package l3m.LesCommandes.java;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java pour Commande complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Commande">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idClient" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idPlats" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="idFilms" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="adresseLivraison" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Commande", propOrder = {
    "date",
    "id",
    "idClient",
    "idPlats",
    "idFilms",
    "prix",
    "adresseLivraison"
})
public class Commande {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    private String date;
    @XmlElement(required = true)
    private String id;
    @XmlElement(required = true)
    private int idClient;
    private List<String> idPlats;
    private List<String> idFilms;
    private double prix;
    @XmlElement(required = true)
    private String adresseLivraison;

    /**
     * Obtient la valeur de la propriété date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété idClient.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Définit la valeur de la propriété idClient.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdClient(int value) {
        this.idClient = value;
    }

    /**
     * Gets the value of the idPlats property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idPlats property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdPlats().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIdPlats() {
        if (idPlats == null) {
            idPlats = new ArrayList<String>();
        }
        return this.idPlats;
    }

   

    /**
     * Gets the value of the idFilms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idFilms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdFilms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIdFilms() {
        if (idFilms == null) {
            idFilms = new ArrayList<String>();
        }
        return this.idFilms;
    }

    /**
     * Obtient la valeur de la propriété prix.
     * 
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Définit la valeur de la propriété prix.
     * 
     */
    public void setPrix(double value) {
        this.prix = value;
    }

    /**
     * Obtient la valeur de la propriété adresseLivraison.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    /**
     * Définit la valeur de la propriété adresseLivraison.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresseLivraison(String value) {
        this.adresseLivraison = value;
    }

    /**
     * Définit la valeur de la propriété IdPlats.
     * 
     */
    public void setIdPlats(List<String> idPlats){
        this.idPlats = idPlats;
    }

    /**
     * Définit la valeur de la propriété idFilms.
     * 
     */
    public void setIdFilms(List<String> idFilms){
        this.idFilms = idFilms;
    }

}