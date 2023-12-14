//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.04.14 à 12:20:29 PM CEST 
//


package l3m.LesCartes.java;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour Ingredient.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="Ingredient">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Tomate"/>
 *     &lt;enumeration value="Mozzarella"/>
 *     &lt;enumeration value="Olive"/>
 *     &lt;enumeration value="Gruyère"/>
 *     &lt;enumeration value="Salade"/>
 *     &lt;enumeration value="Jambon Cru"/>
 *     &lt;enumeration value="Parmesan"/>
 *     &lt;enumeration value="Lardons"/>
 *     &lt;enumeration value="Gruyère"/>
 *     &lt;enumeration value="Crevette"/>
 *     &lt;enumeration value="Piment"/>
 *     &lt;enumeration value="Pates"/>
 *     &lt;enumeration value="Pomme de Terre"/>
 *     &lt;enumeration value="Carotte"/>
 *     &lt;enumeration value="Petit pois"/>
 *     &lt;enumeration value="Haricot vert"/>
 *     &lt;enumeration value="Persil"/>
 *     &lt;enumeration value="Crevette"/>
 *     &lt;enumeration value="Sauce tomate"/>
 *     &lt;enumeration value="Origan"/>
 *     &lt;enumeration value="Gorgonzola"/>
 *     &lt;enumeration value="Chèvre"/>
 *     &lt;enumeration value="Saumon"/>
 *     &lt;enumeration value="Crème fraîche"/>
 *     &lt;enumeration value="Champignon"/>
 *     &lt;enumeration value="Risotto"/>
 *     &lt;enumeration value="Pates de lasagnes"/>
 *     &lt;enumeration value="Viande hachée"/>
 *     &lt;enumeration value="Béchamel"/>
 *     &lt;enumeration value="Poulet"/>
 *     &lt;enumeration value="Coco"/>
 *     &lt;enumeration value="Curry"/>
 *     &lt;enumeration value="Reblochon"/>
 *     &lt;enumeration value="Semoule"/>
 *     &lt;enumeration value="Merguez"/>
 *     &lt;enumeration value="Navets"/>
 *     &lt;enumeration value="Courgettes"/>
 *     &lt;enumeration value="Pois chiches"/>
 *     &lt;enumeration value="Riz"/>
 *     &lt;enumeration value="Steak haché"/>
 *     &lt;enumeration value="Bacon"/>
 *     &lt;enumeration value="Cheddar"/>
 *     &lt;enumeration value="Oignons"/>
 *     &lt;enumeration value="Ketchup"/>
 *     &lt;enumeration value="Mascarpone"/>
 *     &lt;enumeration value="Cafe"/>
 *     &lt;enumeration value="Spéculoos"/>
 *     &lt;enumeration value="Chocolat"/>
 *     &lt;enumeration value="Pomme"/>
 *     &lt;enumeration value="Cannelle"/>
 *     &lt;enumeration value="Nutella"/>
 *     &lt;enumeration value="Chantilly"/>
 *     &lt;enumeration value="Confiture"/>
 *     &lt;enumeration value="Sucre"/>
 *     &lt;enumeration value="Fraises"/>
 *     &lt;enumeration value="Coulis de chocolat"/>
 *     &lt;enumeration value="Guimauve"/>
 *     &lt;enumeration value="Poire"/>
 *     &lt;enumeration value="Kiwi"/>
 *     &lt;enumeration value="Cerise"/>
 *     &lt;enumeration value="Banane"/>
 *     &lt;enumeration value="Raisin"/>
 *     &lt;enumeration value="Framboise"/>
 *     &lt;enumeration value="Pastèque"/>
 *     &lt;enumeration value="Melon"/>
 *     &lt;enumeration value="Menthe"/>
 *     &lt;enumeration value="Rhum"/>
 *     &lt;enumeration value="Citron"/>
 *     &lt;enumeration value="Sucre"/>
 *     &lt;enumeration value="Eau gazeuse"/>
 *     &lt;enumeration value="Jus d'Orange"/>
 *     &lt;enumeration value="Jus d'Ananas"/>
 *     &lt;enumeration value="Fruit de la passion"/>
 *     &lt;enumeration value="Papaye"/>
 *     &lt;enumeration value="Pêche"/>
 *     &lt;enumeration value="Grenadine"/>
 *     &lt;enumeration value="Cachaca"/>
 *     &lt;enumeration value="Vanille"/>
 *     &lt;enumeration value="Crème Coco"/>
 *     &lt;enumeration value="Oeuf"/>
 *     &lt;enumeration value="Croutons"/>
 *     &lt;enumeration value="Thon"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Ingredient", namespace = "http://u-ga.fr/site")
@XmlEnum
public enum Ingredient {

    @XmlEnumValue("Tomate")
    TOMATE("Tomate"),
    @XmlEnumValue("Mozzarella")
    MOZZARELLA("Mozzarella"),
    @XmlEnumValue("Olive")
    OLIVE("Olive"),
    @XmlEnumValue("Gruy\u00e8re")
    GRUYÈRE("Gruy\u00e8re"),
    @XmlEnumValue("Salade")
    SALADE("Salade"),
    @XmlEnumValue("Jambon Cru")
    JAMBON_CRU("Jambon Cru"),
    @XmlEnumValue("Parmesan")
    PARMESAN("Parmesan"),
    @XmlEnumValue("Lardons")
    LARDONS("Lardons"),
    @XmlEnumValue("Crevette")
    CREVETTE("Crevette"),
    @XmlEnumValue("Piment")
    PIMENT("Piment"),
    @XmlEnumValue("Pates")
    PATES("Pates"),
    @XmlEnumValue("Pomme de Terre")
    POMME_DE_TERRE("Pomme de Terre"),
    @XmlEnumValue("Carotte")
    CAROTTE("Carotte"),
    @XmlEnumValue("Petit pois")
    PETIT_POIS("Petit pois"),
    @XmlEnumValue("Haricot vert")
    HARICOT_VERT("Haricot vert"),
    @XmlEnumValue("Persil")
    PERSIL("Persil"),
    @XmlEnumValue("Sauce tomate")
    SAUCE_TOMATE("Sauce tomate"),
    @XmlEnumValue("Origan")
    ORIGAN("Origan"),
    @XmlEnumValue("Gorgonzola")
    GORGONZOLA("Gorgonzola"),
    @XmlEnumValue("Ch\u00e8vre")
    CHÈVRE("Ch\u00e8vre"),
    @XmlEnumValue("Saumon")
    SAUMON("Saumon"),
    @XmlEnumValue("Cr\u00e8me fra\u00eeche")
    CRÈME_FRAÎCHE("Cr\u00e8me fra\u00eeche"),
    @XmlEnumValue("Champignon")
    CHAMPIGNON("Champignon"),
    @XmlEnumValue("Risotto")
    RISOTTO("Risotto"),
    @XmlEnumValue("Pates de lasagnes")
    PATES_DE_LASAGNES("Pates de lasagnes"),
    @XmlEnumValue("Viande hach\u00e9e")
    VIANDE_HACHÉE("Viande hach\u00e9e"),
    @XmlEnumValue("B\u00e9chamel")
    BÉCHAMEL("B\u00e9chamel"),
    @XmlEnumValue("Poulet")
    POULET("Poulet"),
    @XmlEnumValue("Coco")
    COCO("Coco"),
    @XmlEnumValue("Curry")
    CURRY("Curry"),
    @XmlEnumValue("Reblochon")
    REBLOCHON("Reblochon"),
    @XmlEnumValue("Semoule")
    SEMOULE("Semoule"),
    @XmlEnumValue("Merguez")
    MERGUEZ("Merguez"),
    @XmlEnumValue("Navets")
    NAVETS("Navets"),
    @XmlEnumValue("Courgettes")
    COURGETTES("Courgettes"),
    @XmlEnumValue("Pois chiches")
    POIS_CHICHES("Pois chiches"),
    @XmlEnumValue("Riz")
    RIZ("Riz"),
    @XmlEnumValue("Steak hach\u00e9")
    STEAK_HACHÉ("Steak hach\u00e9"),
    @XmlEnumValue("Bacon")
    BACON("Bacon"),
    @XmlEnumValue("Cheddar")
    CHEDDAR("Cheddar"),
    @XmlEnumValue("Oignons")
    OIGNONS("Oignons"),
    @XmlEnumValue("Ketchup")
    KETCHUP("Ketchup"),
    @XmlEnumValue("Mascarpone")
    MASCARPONE("Mascarpone"),
    @XmlEnumValue("Cafe")
    CAFE("Cafe"),
    @XmlEnumValue("Sp\u00e9culoos")
    SPÉCULOOS("Sp\u00e9culoos"),
    @XmlEnumValue("Chocolat")
    CHOCOLAT("Chocolat"),
    @XmlEnumValue("Pomme")
    POMME("Pomme"),
    @XmlEnumValue("Cannelle")
    CANNELLE("Cannelle"),
    @XmlEnumValue("Nutella")
    NUTELLA("Nutella"),
    @XmlEnumValue("Chantilly")
    CHANTILLY("Chantilly"),
    @XmlEnumValue("Confiture")
    CONFITURE("Confiture"),
    @XmlEnumValue("Sucre")
    SUCRE("Sucre"),
    @XmlEnumValue("Fraises")
    FRAISES("Fraises"),
    @XmlEnumValue("Coulis de chocolat")
    COULIS_DE_CHOCOLAT("Coulis de chocolat"),
    @XmlEnumValue("Guimauve")
    GUIMAUVE("Guimauve"),
    @XmlEnumValue("Poire")
    POIRE("Poire"),
    @XmlEnumValue("Kiwi")
    KIWI("Kiwi"),
    @XmlEnumValue("Cerise")
    CERISE("Cerise"),
    @XmlEnumValue("Banane")
    BANANE("Banane"),
    @XmlEnumValue("Raisin")
    RAISIN("Raisin"),
    @XmlEnumValue("Framboise")
    FRAMBOISE("Framboise"),
    @XmlEnumValue("Past\u00e8que")
    PASTÈQUE("Past\u00e8que"),
    @XmlEnumValue("Melon")
    MELON("Melon"),
    @XmlEnumValue("Menthe")
    MENTHE("Menthe"),
    @XmlEnumValue("Rhum")
    RHUM("Rhum"),
    @XmlEnumValue("Citron")
    CITRON("Citron"),
    @XmlEnumValue("Eau gazeuse")
    EAU_GAZEUSE("Eau gazeuse"),
    @XmlEnumValue("Jus d'Orange")
    JUS_D_ORANGE("Jus d'Orange"),
    @XmlEnumValue("Jus d'Ananas")
    JUS_D_ANANAS("Jus d'Ananas"),
    @XmlEnumValue("Fruit de la passion")
    FRUIT_DE_LA_PASSION("Fruit de la passion"),
    @XmlEnumValue("Papaye")
    PAPAYE("Papaye"),
    @XmlEnumValue("P\u00eache")
    PÊCHE("P\u00eache"),
    @XmlEnumValue("Grenadine")
    GRENADINE("Grenadine"),
    @XmlEnumValue("Cachaca")
    CACHACA("Cachaca"),
    @XmlEnumValue("Vanille")
    VANILLE("Vanille"),
    @XmlEnumValue("Cr\u00e8me Coco")
    CRÈME_COCO("Cr\u00e8me Coco"),
    @XmlEnumValue("Oeuf")
    OEUF("Oeuf"),
    @XmlEnumValue("Croutons")
    CROUTONS("Croutons"),
    @XmlEnumValue("Thon")
    THON("Thon"),
    @XmlEnumValue("Lait")
    LAIT("Lait"),
    @XmlEnumValue("Vodka")
    VODKA("Vodka"),
    @XmlEnumValue("Cacao")
    CACAO("Cacao");
    private String value;

    Ingredient(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Ingredient fromValue(String v) {
        for (Ingredient c: Ingredient.values()) {
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
