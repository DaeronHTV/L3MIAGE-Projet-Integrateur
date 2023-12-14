//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.04.10 à 09:00:37 PM CEST 
//


package l3m.LesCartes.java;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour TypeDePlat.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="TypeDePlat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Entree"/>
 *     &lt;enumeration value="Plat"/>
 *     &lt;enumeration value="Dessert"/>
 *     &lt;enumeration value="Boisson"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TypeDePlat", namespace = "http://u-ga.fr/site")
@XmlEnum
public enum TypeDePlat {

    @XmlEnumValue("Entree")
    ENTREE("Entree"),
    @XmlEnumValue("Plat")
    PLAT("Plat"),
    @XmlEnumValue("Dessert")
    DESSERT("Dessert"),
    @XmlEnumValue("Boisson")
    BOISSON("Boisson");
    private String value;

    TypeDePlat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeDePlat fromValue(String v) {
        for (TypeDePlat c: TypeDePlat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    public void setType(TypeDePlat type){

        String t = type.value();
        this.value = t ;
    }

}
