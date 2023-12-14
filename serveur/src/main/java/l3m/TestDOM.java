package l3m;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import l3m.DomPlatDAO;

import l3m.DomCarteDAO;
import l3m.LesCartes.java.Carte;
import l3m.LesCartes.java.Ingredient;
import l3m.LesCartes.java.Plat;
import l3m.LesCartes.java.TypeDePlat;

public class TestDOM {

  public static void main(String[] args) {

    DomPlatDAO p = new DomPlatDAO();
    p.nomFichier = "./serveur/src/main/java/l3m/Menu/Plat_";
    int attrId = 0 ; 
    // Plat 0: Salade de Thon
    Plat p0 = new Plat();
    p0.setId(String.valueOf(attrId));
    p0.setNom("Salade De Thon");
    p0.setPrix(6.50);
    p0.setType(TypeDePlat.ENTREE);
    p0.setPhoto("https://cdn.pratico-pratiques.com/app/uploads/sites/2/2018/08/29095920/salade-nicoise-au-thon.jpeg");
    List<Ingredient> ing0 = new ArrayList<>();
    ing0.add(Ingredient.SALADE);
    ing0.add(Ingredient.THON);
    ing0.add(Ingredient.POMME_DE_TERRE);
    ing0.add(Ingredient.TOMATE);
    ing0.add(Ingredient.OLIVE);
    ing0.add(Ingredient.OEUF);
    p0.setIngredients(ing0);
    attrId++;
    // Plat 1: Salade Caesar
    Plat p1 = new Plat();
    p1.setId(String.valueOf(attrId++));
    p1.setNom("Salade Caesar");
    p1.setPrix(6.50);
    p1.setType(TypeDePlat.ENTREE);
    p1.setPhoto("https://img.nutrissime.tv/uploads/hq6nosfoyd.jpg");
    List<Ingredient> ing1 = new ArrayList<>();
    ing1.add(Ingredient.SALADE);
    ing1.add(Ingredient.POULET);
    ing1.add(Ingredient.PARMESAN);
    ing1.add(Ingredient.CROUTONS);
    p1.setIngredients(ing1);

    // Plat 2: Salade à l'italienne
    Plat p2 = new Plat();
    p2.setId(String.valueOf(attrId++));
    p2.setNom("Salade à l'Italienne");
    p2.setPrix(6.50);
    p2.setType(TypeDePlat.ENTREE);
    p2.setPhoto("https://www.menusalacartedezoe.com/wp-content/uploads/2018/06/Salade-italienne-roquette-et-coppa-3.jpg");
    List<Ingredient> ing2 = new ArrayList<>();
    ing2.add(Ingredient.SALADE);
    ing2.add(Ingredient.JAMBON_CRU);
    ing2.add(Ingredient.TOMATE);
    ing2.add(Ingredient.PARMESAN);
    p2.setIngredients(ing2);

    // Plat 3: Quiche Lorraine
    Plat p3 = new Plat();
    p3.setId(String.valueOf(attrId++));
    p3.setNom("Quiche Lorraine");
    p3.setPrix(3.50);
    p3.setType(TypeDePlat.ENTREE);
    p3.setPhoto("https://www.regilait.com/wp-content/uploads/Recette-de-quiche-lorraine.jpg");
    List<Ingredient> ing3 = new ArrayList<>();
    ing3.add(Ingredient.SALADE);
    ing3.add(Ingredient.JAMBON_CRU);
    ing3.add(Ingredient.TOMATE);
    ing3.add(Ingredient.PARMESAN);
    p3.setIngredients(ing3);

    // Plat 4: Brick aux crevettes et piment x5
    Plat p4 = new Plat();
    p4.setId(String.valueOf(attrId++));
    p4.setNom("Samoussas aux crevettes et au piment X5");
    p4.setPrix(5.00);
    p4.setType(TypeDePlat.ENTREE);
    p4.setPhoto("https://img.cuisineaz.com/400x320/2016-03-06/i37644-samoussa-au-saumon-cream-cheese-et-roquette.jpg");
    List<Ingredient> ing4 = new ArrayList<>();
    ing4.add(Ingredient.CREVETTE);
    ing4.add(Ingredient.PIMENT);
    p4.setIngredients(ing4);

    // Plat 5: Salade de pâtes
    Plat p5 = new Plat();
    p5.setId(String.valueOf(attrId++));
    p5.setNom("Salade de pâtes");
    p5.setPrix(5.00);
    p5.setType(TypeDePlat.ENTREE);
    p5.setPhoto("https://static.750g.com/images/600-600/9e6558fd7bd4d5cb7e45ce48f0c3d39f/comment-faire-une-salade-de-pates-comme-en-italie.jpg");
    List<Ingredient> ing5 = new ArrayList<>();
    ing5.add(Ingredient.PATES);
    ing5.add(Ingredient.MOZZARELLA);
    ing5.add(Ingredient.TOMATE);
    ing5.add(Ingredient.OLIVE);
    p5.setIngredients(ing5);

    // Plat 6: Macédoine de légumes
    Plat p6 = new Plat();
    p6.setId(String.valueOf(attrId++));
    p6.setNom("Macédoine de légumes");
    p6.setPrix(5.00);
    p6.setType(TypeDePlat.ENTREE);
    p6.setPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRbqchouKgL2N7SILowKzUo3CiNTR4RDJ51NZJpXV78Yo-KNY4v&usqp=CAU");
    List<Ingredient> ing6 = new ArrayList<>();
    ing6.add(Ingredient.POMME_DE_TERRE);
    ing6.add(Ingredient.CAROTTE);
    ing6.add(Ingredient.PETIT_POIS);
    ing6.add(Ingredient.HARICOT_VERT);
    p6.setIngredients(ing6);

    // Plat 7: Carottes rapées
    Plat p7 = new Plat();
    p7.setId(String.valueOf(attrId++));
    p7.setNom("Carottes rapées");
    p7.setPrix(3.50);
    p7.setType(TypeDePlat.ENTREE);
    p7.setPhoto("https://epicetoorecettes.fr/img/recettes/grande/recette-carottes-rap-es-au-carvi.jpg");
    List<Ingredient> ing7 = new ArrayList<>();
    ing7.add(Ingredient.POMME_DE_TERRE);
    ing7.add(Ingredient.CAROTTE);
    ing7.add(Ingredient.PETIT_POIS);
    ing7.add(Ingredient.HARICOT_VERT);
    p7.setIngredients(ing7);

    // Plat 8: Melon et Jambon Cru
    Plat p8 = new Plat();
    p8.setId(String.valueOf(attrId++));
    p8.setNom("Melon et Jambon Cru");
    p8.setPrix(4.75);
    p8.setType(TypeDePlat.ENTREE);
    p8.setPhoto("https://recettes.de/images/blogs/du-potager-a-la-marmite/melon-et-jambon-cru-idee-de-presentation-n-2.640x480.jpg");
    List<Ingredient> ing8 = new ArrayList<>();
    ing8.add(Ingredient.MELON);
    ing8.add(Ingredient.JAMBON_CRU);
    p8.setIngredients(ing8);

    // Plat 9: Pastèque
    Plat p9 = new Plat();
    p9.setId(String.valueOf(attrId++));
    p9.setNom("Pastèque");
    p9.setPrix(3.50);
    p9.setType(TypeDePlat.ENTREE);
    p9.setPhoto("https://p9.storage.canalblog.com/95/90/462641/78653999_o.jpg");

    // Plat 10: Pizza Margherita
    Plat p10 = new Plat();
    p10.setId(String.valueOf(attrId++));
    p10.setNom("Pizza Margherita");
    p10.setPrix(8.90);
    p10.setType(TypeDePlat.PLAT);
    p10.setPhoto("https://www.bofrost.fr/medias/xpizza-margherita-09146-1.jpg-W720xH450R1.6,qcontext=bWFzdGVyfHByb2R1Y3QtaW1hZ2VzfDQ1MjEyOXxpbWFnZS9qcGVnfHByb2R1Y3QtaW1hZ2VzL2g2MS9oYWQvODgxNTg5NTI0ODkyNi5qcGd8ZGNkNGJmZGQ4N2Q3NmVkZjBiNTQ2OTA2Mzg5ZWI3MmEwMGU2NjgyYzYyMGIxMzNkMjg2ZDJhNTZhYzU3NGUzOQ.pagespeed.ic.4bC4smJbNR.jpg");
    List<Ingredient> ing10 = new ArrayList<>();
    ing10.add(Ingredient.SAUCE_TOMATE);
    ing10.add(Ingredient.MOZZARELLA);
    ing10.add(Ingredient.OLIVE);
    ing10.add(Ingredient.ORIGAN);
    p10.setIngredients(ing10);

    // Plat 11: Pizza 4 fromages
    Plat p11 = new Plat();
    p11.setId(String.valueOf(attrId++));
    p11.setNom("Pizza 4 fromages");
    p11.setPrix(10.50);
    p11.setType(TypeDePlat.PLAT);
    p11.setPhoto("https://recette.supertoinette.com/152868/b/pizza-4-fromages.jpg");
    List<Ingredient> ing11 = new ArrayList<>();
    ing11.add(Ingredient.SAUCE_TOMATE);
    ing11.add(Ingredient.PARMESAN);
    ing11.add(Ingredient.MOZZARELLA);
    ing11.add(Ingredient.GORGONZOLA);
    ing11.add(Ingredient.CHÈVRE);
    p11.setIngredients(ing11);

    // Plat 12: Pizza au saumon
    Plat p12 = new Plat();
    p12.setId(String.valueOf(attrId++));
    p12.setNom("Pizza au saumon");
    p12.setPrix(10.25);
    p12.setType(TypeDePlat.PLAT);
    p12.setPhoto("https://www.lesavoureux.com/wp-content/uploads/2019/02/pizza-saumon.jpg");
    List<Ingredient> ing12 = new ArrayList<>();
    ing12.add(Ingredient.SAUMON);
    ing12.add(Ingredient.GRUYÈRE);
    ing12.add(Ingredient.CRÈME_FRAÎCHE);
    p12.setIngredients(ing12);

    // Plat 13: Risotto aux champignons
    Plat p13 = new Plat();
    p13.setId(String.valueOf(attrId++));
    p13.setNom("Risotto aux champignons");
    p13.setPrix(9.45);
    p13.setType(TypeDePlat.PLAT);
    p13.setPhoto("https://www.cookomix.com/wp-content/uploads/2018/04/risotto-poulet-champignons-thermomix-1280x720.jpg");
    List<Ingredient> ing13 = new ArrayList<>();
    ing13.add(Ingredient.RISOTTO);
    ing13.add(Ingredient.CHAMPIGNON);
    ing13.add(Ingredient.PARMESAN);
    p13.setIngredients(ing13);

    // Plat 14: Lasagnes
    Plat p14 = new Plat();
    p14.setId(String.valueOf(attrId++));
    p14.setNom("Lasagnes");
    p14.setPrix(9.50);
    p14.setType(TypeDePlat.PLAT);
    p14.setPhoto("https://img.cuisineaz.com/400x320/2016-11-14/i19403-lasgnes-bolognaise-facile.jpg");
    List<Ingredient> ing14 = new ArrayList<>();
    ing14.add(Ingredient.PATES_DE_LASAGNES);
    ing14.add(Ingredient.TOMATE);
    ing14.add(Ingredient.VIANDE_HACHÉE);
    ing14.add(Ingredient.BÉCHAMEL);
    ing14.add(Ingredient.GRUYÈRE);
    p14.setIngredients(ing14);

    // Plat 15: Riz et Poulet Coco et Curry
    Plat p15 = new Plat();
    p15.setId(String.valueOf(attrId++));
    p15.setNom("Riz et Poulet Coco et Curry");
    p15.setPrix(12.50);
    p15.setType(TypeDePlat.PLAT);
    p15.setPhoto("https://www.recette360.com/wp-content/uploads/2018/04/Poulet-au-curry-et-lait-de-coco-cookeo.jpg");
    List<Ingredient> ing15 = new ArrayList<>();
    ing15.add(Ingredient.RIZ);
    ing15.add(Ingredient.POULET);
    ing15.add(Ingredient.COCO);
    ing15.add(Ingredient.CURRY);
    p15.setIngredients(ing15);

    // Plat 16: Tartiflette
    Plat p16 = new Plat();
    p16.setId(String.valueOf(attrId++));
    p16.setNom("Tartiflette");
    p16.setPrix(11.50);
    p16.setType(TypeDePlat.PLAT);
    p16.setPhoto("https://www.cuisine-blog.fr/wp-content/uploads/2017/11/fotolia_60240140_subscription_xxl.jpg");
    List<Ingredient> ing16 = new ArrayList<>();
    ing16.add(Ingredient.POMME_DE_TERRE);
    ing16.add(Ingredient.LARDONS);
    ing16.add(Ingredient.REBLOCHON);
    p16.setIngredients(ing16);

    // Plat 17: Couscous
    Plat p17 = new Plat();
    p17.setId(String.valueOf(attrId++));
    p17.setNom("Couscous");
    p17.setPrix(9.90);
    p17.setType(TypeDePlat.PLAT);
    p17.setPhoto("https://cache.marieclaire.fr/data/photo/w1000_c17/cuisine/4l/couscous-facile.jpg");
    List<Ingredient> ing17 = new ArrayList<>();
    ing17.add(Ingredient.SEMOULE);
    ing17.add(Ingredient.POULET);
    ing17.add(Ingredient.MERGUEZ);
    ing17.add(Ingredient.TOMATE);
    ing17.add(Ingredient.CAROTTE);
    ing17.add(Ingredient.NAVETS);
    ing17.add(Ingredient.COURGETTES);
    ing17.add(Ingredient.POIS_CHICHES);
    p17.setIngredients(ing17);

    // Plat 18: Sushi
    Plat p18 = new Plat();
    p18.setId(String.valueOf(attrId++));
    p18.setNom("Sushi");
    p18.setPrix(4.90);
    p18.setType(TypeDePlat.PLAT);
    p18.setPhoto("https://www.atelierdeschefs.com/media/recette-e12941-sushi-de-saumon-fume-et-creme-acidulee.jpg");
    List<Ingredient> ing18 = new ArrayList<>();
    ing18.add(Ingredient.RIZ);
    ing18.add(Ingredient.SAUMON);
    p18.setIngredients(ing18);

    // Plat 19: Burger au bacon et cheddar
    Plat p19 = new Plat();
    p19.setId(String.valueOf(attrId++));
    p19.setNom("Burger au bacon et cheddar");
    p19.setPrix(7.80);
    p19.setType(TypeDePlat.PLAT);
    p19.setPhoto("https://kiwings-images-prod.s3-eu-west-1.amazonaws.com/recipes/56c72437724f5.jpeg");
    List<Ingredient> ing19 = new ArrayList<>();
    ing19.add(Ingredient.STEAK_HACHÉ);
    ing19.add(Ingredient.BACON);
    ing19.add(Ingredient.CHEDDAR);
    ing19.add(Ingredient.OIGNONS);
    ing19.add(Ingredient.TOMATE);
    ing19.add(Ingredient.SALADE);
    ing19.add(Ingredient.KETCHUP);
    p19.setIngredients(ing19);

    // Plat 20: Frites
    Plat p20 = new Plat();
    p20.setId(String.valueOf(attrId++));
    p20.setNom("Frites");
    p20.setPrix(3.50);
    p20.setType(TypeDePlat.PLAT);
    p20.setPhoto("https://i.f1g.fr/media/madame/orig/sites/default/files/img/2017/11/la-frite-est-elle-belge-ou-francaise-.jpg");

    // Plat 21: Tiramisu au Spéculoos
    Plat p21 = new Plat();
    p21.setId(String.valueOf(attrId++));
    p21.setNom("Tiramisu au Spéculoos");
    p21.setPrix(5.20);
    p21.setType(TypeDePlat.DESSERT);
    p21.setPhoto("https://odelices.ouest-france.fr/images/recettes/tiramisu_aux_speculoos-970x1024.jpg");
    List<Ingredient> ing21 = new ArrayList<>();
    ing21.add(Ingredient.MASCARPONE);
    ing21.add(Ingredient.CAFE);
    ing21.add(Ingredient.SPÉCULOOS);
    p21.setIngredients(ing21);

    // Plat 22: Mousse au chocolat
    Plat p22 = new Plat();
    p22.setId(String.valueOf(attrId++));
    p22.setNom("Mousse au chocolat");
    p22.setPrix(3.90);
    p22.setType(TypeDePlat.DESSERT);
    p22.setPhoto("https://cdn.pratico-pratiques.com/app/uploads/sites/2/2018/08/29100453/mousse-au-chocolat-et-baileys.jpeg");

    // Plat 23: Crumble aux Pommes
    Plat p23 = new Plat();
    p23.setId(String.valueOf(attrId++));
    p23.setNom("Crumble aux Pommes");
    p23.setPrix(5.30);
    p23.setType(TypeDePlat.DESSERT);
    p23.setPhoto("https://img.cuisineaz.com/400x320/2013-12-20/i95136-crumble-facile-aux-pommes-express.jpg");
    List<Ingredient> ing23 = new ArrayList<>();
    ing23.add(Ingredient.POMME);
    ing23.add(Ingredient.CANNELLE);
    p23.setIngredients(ing23);

    // Plat 24: Crêpes au sucre
    Plat p24 = new Plat();
    p24.setId(String.valueOf(attrId++));
    p24.setNom("Crêpes au sucre");
    p24.setPrix(2.00);
    p24.setType(TypeDePlat.DESSERT);
    p24.setPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTZ3c5nYyF4A9DJmtQcBYandPu29Sszk0kVRZ6xA5rY-iKytMPm&usqp=CAU");

    // Plat 25: Crêpes au Nutella
    Plat p25 = new Plat();
    p25.setId(String.valueOf(attrId++));
    p25.setNom("Crêpes au Nutella");
    p25.setPrix(3.00);
    p25.setType(TypeDePlat.DESSERT);
    p25.setPhoto("https://jevouschouchoute.fr/wp-content/uploads/2017/01/nutella-tefal2-jvc-jevouschouchoute.png");

    // Plat 26: Crêpes à la confiture de fraise
    Plat p26 = new Plat();
    p26.setId(String.valueOf(attrId++));
    p26.setNom("Crêpes à la confiture de fraise");
    p26.setPrix(3.00);
    p26.setType(TypeDePlat.DESSERT);
    p26.setPhoto("https://i.pinimg.com/originals/91/78/5b/91785b29c44be3c55fd71025a35f842a.jpg");

    // Plat 27: Gauffre au sucre
    Plat p27 = new Plat();
    p27.setId(String.valueOf(attrId++));
    p27.setNom("Gauffre au sucre");
    p27.setPrix(3.00);
    p27.setType(TypeDePlat.DESSERT);
    p27.setPhoto("https://www.generation-souvenirs.com/23204-thickbox_default/gaufre-au-sucre.jpg");

    // Plat 28: Gauffre au Nutella
    Plat p28 = new Plat();
    p28.setId(String.valueOf(attrId++));
    p28.setNom("Gauffre au Nutella");
    p28.setPrix(4.00);
    p28.setType(TypeDePlat.DESSERT);
    p28.setPhoto("https://rankeat.fr/uploads/categ_plats/1051/1602/557/562_534/1.jpg");

    // Plat 29: Gauffre à la confiture de fraise
    Plat p29 = new Plat();
    p29.setId(String.valueOf(attrId++));
    p29.setNom("Gauffre à la confiture de fraise");
    p29.setPrix(4.00);
    p29.setType(TypeDePlat.DESSERT);
    p29.setPhoto("https://thumbs.dreamstime.com/b/gaufres-douces-viennoises-avec-de-la-confiture-de-fraise-68053564.jpg");

    // Plat 30: Tartelette aux fraises
    Plat p30 = new Plat();
    p30.setId(String.valueOf(attrId++));
    p30.setNom("Tartelette aux fraises");
    p30.setPrix(2.90);
    p30.setType(TypeDePlat.DESSERT);
    p30.setPhoto("https://empreintesucree.fr/wp-content/uploads/2017/05/1-tartelettes-fraises-recette-patisserie-empreinte-sucree.jpg");

    // Plat 31: Tartelette aux pommes
    Plat p31 = new Plat();
    p31.setId(String.valueOf(attrId++));
    p31.setNom("Tartelette aux pommes");
    p31.setPrix(2.90);
    p31.setType(TypeDePlat.DESSERT);
    p31.setPhoto("https://p5.storage.canalblog.com/53/15/233083/98769202.jpg");

    // Plat 32: Pizza dessert
    Plat p32 = new Plat();
    p32.setId(String.valueOf(attrId++));
    p32.setNom("Pizza dessert");
    p32.setPrix(5.50);
    p32.setType(TypeDePlat.DESSERT);
    p32.setPhoto("https://www.sparksandbloom.com/wp-content/uploads/2017/06/Feu-de-camps-Pizza.jpg");
    List<Ingredient> ing32 = new ArrayList<>();
    ing32.add(Ingredient.NUTELLA);
    ing32.add(Ingredient.COULIS_DE_CHOCOLAT);
    ing32.add(Ingredient.FRAISES);
    ing32.add(Ingredient.GUIMAUVE);
    p32.setIngredients(ing32);

    // Plat 33: Salade de Fruits
    Plat p33 = new Plat();
    p33.setId(String.valueOf(attrId++));
    p33.setNom("Salade de Fruits");
    p33.setPrix(4.90);
    p33.setType(TypeDePlat.DESSERT);
    p33.setPhoto("https://cdn.pratico-pratiques.com/app/uploads/sites/3/2019/11/27115447/salade-de-fruits.jpg");
    List<Ingredient> ing33 = new ArrayList<>();
    ing33.add(Ingredient.CERISE);
    ing33.add(Ingredient.KIWI);
    ing33.add(Ingredient.BANANE);
    ing33.add(Ingredient.RAISIN);
    ing33.add(Ingredient.FRAMBOISE);
    ing33.add(Ingredient.POMME);
    p33.setIngredients(ing33);

    // Plat 34: Crème brulée
    Plat p34 = new Plat();
    p34.setId(String.valueOf(attrId++));
    p34.setNom("Crème brulée");
    p34.setPrix(4.50);
    p34.setType(TypeDePlat.DESSERT);
    p34.setPhoto("https://assets.afcdn.com/recipe/20161201/4190_w648h414c1cx2705cy1803.jpg");

    // Plat 35: Café
    Plat p35 = new Plat();
    p35.setId(String.valueOf(attrId++));
    p35.setNom("Café");
    p35.setPrix(1.50);
    p35.setType(TypeDePlat.BOISSON);
    p35.setPhoto("https://thumbs.dreamstime.com/b/caf%C3%A9-%C3%A0-emporter-ouvert-dans-le-support-le-couvercle-est-pr%C3%A8s-27962794.jpg");

    // Plat 36: Chocolat Chaud
    Plat p36 = new Plat();
    p36.setId(String.valueOf(attrId++));
    p36.setNom("Chocolat Chaud");
    p36.setPrix(2.90);
    p36.setType(TypeDePlat.BOISSON);
    p36.setPhoto("https://photos.zodio.fr/zodio-magento/sheet_thematic/1/1539009506_10131479_Z-600x450.jpg");
    List<Ingredient> ing36 = new ArrayList<>();
    ing36.add(Ingredient.LAIT);
    ing36.add(Ingredient.CACAO);
    ing36.add(Ingredient.GUIMAUVE);
    p36.setIngredients(ing36);

    // Plat 37: Coca-Cola
    Plat p37 = new Plat();
    p37.setId(String.valueOf(attrId++));
    p37.setNom("Coca-Cola");
    p37.setPrix(2.30);
    p37.setType(TypeDePlat.BOISSON);
    p37.setPhoto("https://www.staples.fr/content/images/product/72255-00H_1_xnl.jpg");

    // Plat 38: Oasis Tropical
    Plat p38 = new Plat();
    p38.setId(String.valueOf(attrId++));
    p38.setNom("Oasis Tropical");
    p38.setPrix(2.30);
    p38.setType(TypeDePlat.BOISSON);
    p38.setPhoto("https://www.clicmarket.fr/4567-large_default/24-canettes-d-oasis-tropical-33-cl.jpg");

    // Plat 39: Sprite
    Plat p39 = new Plat();
    p39.setId(String.valueOf(attrId++));
    p39.setNom("Sprite");
    p39.setPrix(2.30);
    p39.setType(TypeDePlat.BOISSON);
    p39.setPhoto("https://www.jpg.fr/content/images/product/56351-00J_1_xnl.jpg");

    // Plat 40: Perrier
    Plat p40 = new Plat();
    p40.setId(String.valueOf(attrId++));
    p40.setNom("Perrier");
    p40.setPrix(2.00);
    p40.setType(TypeDePlat.BOISSON);
    p40.setPhoto("https://prod.isg.bruneau.media/OMM/Images_Basse_Definition/ZoomHD/16/91/16919.jpg?width=2000&height=2000&mode=Default&quality=85&scale=upscalecanvas");

    // Plat 41: Thé à la menthe
    Plat p41 = new Plat();
    p41.setId(String.valueOf(attrId++));
    p41.setNom("Thé à la menthe");
    p41.setPrix(2.90);
    p41.setType(TypeDePlat.BOISSON);
    p41.setPhoto("https://www.entreprendre.fr/wp-content/uploads/visu_1444902404.jpg");

    // Plat 42: Jus d'Orange
    Plat p42 = new Plat();
    p42.setId(String.valueOf(attrId++));
    p42.setNom("Jus d'Orange");
    p42.setPrix(2.30);
    p42.setType(TypeDePlat.BOISSON);
    p42.setPhoto("https://cdn.metro-group.com/fr/fr_pim_397337001002_01.png?w=400&h=400&mode=pad");

    // Plat 43: Jus de Pommes
    Plat p43 = new Plat();
    p43.setId(String.valueOf(attrId++));
    p43.setNom("Jus de Pommes");
    p43.setPrix(2.30);
    p43.setType(TypeDePlat.BOISSON);
    p43.setPhoto("https://cdn.metro-group.com/fr/fr_pim_397338001002_01.png?w=400&h=400&mode=pad");

    // Plat 44: Ice-Tea
    Plat p44 = new Plat();
    p44.setId(String.valueOf(attrId++));
    p44.setNom("Ice-Tea");
    p44.setPrix(2.30);
    p44.setType(TypeDePlat.BOISSON);
    p44.setPhoto("https://prod.isg.bruneau.media/OMM/Images_Basse_Definition/ZoomHD/70/81/98/708198.jpg?width=2000&height=2000&mode=Default&quality=85&scale=upscalecanvas");

    // Plat 45: Mojito
    Plat p45 = new Plat();
    p45.setId(String.valueOf(attrId++));
    p45.setNom("Mojito");
    p45.setPrix(6.50);
    p45.setType(TypeDePlat.BOISSON);
    p45.setPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS6Lrs4kWlsP2Li9qJ5jJ5gQ3l0Xvz3DZjrL3CWJPoRwOP4ULYz&usqp=CAU");
    List<Ingredient> ing45 = new ArrayList<>();
    ing45.add(Ingredient.RHUM);
    ing45.add(Ingredient.MENTHE);
    ing45.add(Ingredient.EAU_GAZEUSE);
    ing45.add(Ingredient.CITRON);
    ing45.add(Ingredient.SUCRE);
    p45.setIngredients(ing45);

    // Plat 46: Redbull
    Plat p46 = new Plat();
    p46.setId(String.valueOf(attrId++));
    p46.setNom("Redbull");
    p46.setPrix(2.90);
    p46.setType(TypeDePlat.BOISSON);
    p46.setPhoto("https://www.carrefour.fr/media/540x540/Photosite/PGC/BOISSONS/9002490233655_PHOTOSITE_20170919_161101_4.jpg?placeholder=1");

    // Plat 47: Bière Heineken
    Plat p47 = new Plat();
    p47.setId(String.valueOf(attrId++));
    p47.setNom("Bière Heineken");
    p47.setPrix(3.50);
    p47.setType(TypeDePlat.BOISSON);
    p47.setPhoto("https://www.clicmarket.fr/2925-large_default/24-canettes-de-biere-blonde-5-heineken-50-cl.jpg");

    // Plat 48: Piña Colada
    Plat p48 = new Plat();
    p48.setId(String.valueOf(attrId++));
    p48.setNom("Piña Colada");
    p48.setPrix(6.50);
    p48.setType(TypeDePlat.BOISSON);
    p48.setPhoto("https://t2.uc.ltmcdn.com/fr/images/4/3/1/comment_faire_une_pina_colada_sans_alcool_1134_orig.jpg");
    List<Ingredient> ing48 = new ArrayList<>();
    ing48.add(Ingredient.RHUM);
    ing48.add(Ingredient.JUS_D_ANANAS);
    ing48.add(Ingredient.CRÈME_COCO);
    p48.setIngredients(ing48);

    // Plat 49: Cocktail Sex On The Beach
    Plat p49 = new Plat();
    p49.setId(String.valueOf(attrId++));
    p49.setNom("Cocktail Sex On The Beach");
    p49.setPrix(6.40);
    p49.setType(TypeDePlat.BOISSON);
    p49.setPhoto("https://keeprecipes.com/sites/keeprecipes/files/imagecache/recipe_large/sex-on-the-beach-cocktail.jpg");
    List<Ingredient> ing49 = new ArrayList<>();
    ing49.add(Ingredient.VODKA);
    ing49.add(Ingredient.JUS_D_ORANGE);
    ing49.add(Ingredient.JUS_D_ANANAS);
    ing49.add(Ingredient.FRUIT_DE_LA_PASSION);
    ing49.add(Ingredient.PAPAYE);
    ing49.add(Ingredient.PÊCHE);
    ing49.add(Ingredient.MELON);
    p49.setIngredients(ing49);

    // Plat 50: Cocktail Paradise Dream
    Plat p50 = new Plat();
    p50.setId(String.valueOf(attrId++));
    p50.setNom("Cocktail Paradise Dream");
    p50.setPrix(5.90);
    p50.setType(TypeDePlat.BOISSON);
    p50.setPhoto("https://ekladata.com/_fyIyzLGMXpDJZnSbyLAY1EAFUM.png");
    List<Ingredient> ing50 = new ArrayList<>();
    ing50.add(Ingredient.JUS_D_ANANAS);
    ing50.add(Ingredient.FRAISES);
    ing50.add(Ingredient.FRAMBOISE);
    ing50.add(Ingredient.GRENADINE);
    ing50.add(Ingredient.PÊCHE);
    p50.setIngredients(ing50);

    // Plat 51: Cocktail Caipirinha
    Plat p51 = new Plat();
    p51.setId(String.valueOf(attrId++));
    p51.setNom("Cocktail Caipirinha");
    p51.setPrix(6.50);
    p51.setType(TypeDePlat.BOISSON);
    p51.setPhoto("https://i0.wp.com/www.letopdelhumour.fr/wp-content/uploads/2017/12/caipirinha-cocktail.jpg?resize=400%2C300");
    List<Ingredient> ing51 = new ArrayList<>();
    ing51.add(Ingredient.CACHACA);
    ing51.add(Ingredient.CITRON);
    p51.setIngredients(ing51);

    // Plat 52: Cocktail Koyo
    Plat p52 = new Plat();
    p52.setId(String.valueOf(attrId++));
    p52.setNom("Cocktail Koyo");
    p52.setPrix(5.70);
    p52.setType(TypeDePlat.BOISSON);
    p52.setPhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRoeXmQWyxq09JtNlEnBLBLQfWKIT7PI4dXPqMSMDWBJidoLh9K&usqp=CAU");
    List<Ingredient> ing52 = new ArrayList<>();
    ing52.add(Ingredient.JUS_D_ANANAS);
    ing52.add(Ingredient.FRAISES);
    ing52.add(Ingredient.MELON);
    ing52.add(Ingredient.BANANE);
    ing52.add(Ingredient.VANILLE);
    p52.setIngredients(ing52);

    // Création des plats dans le DOM
    p.create(p0);
    p.create(p1);
    p.create(p2);
    p.create(p3);
    p.create(p4);
    p.create(p5);
    p.create(p6);
    p.create(p7);
    p.create(p8);
    p.create(p9);
    p.create(p10);
    p.create(p11);
    p.create(p12);
    p.create(p13);
    p.create(p14);
    p.create(p15);
    p.create(p16);
    p.create(p17);
    p.create(p18);
    p.create(p19);
    p.create(p20);
    p.create(p21);
    p.create(p22);
    p.create(p23);
    p.create(p24);
    p.create(p25);
    p.create(p26);
    p.create(p27);
    p.create(p28);
    p.create(p29);
    p.create(p30);
    p.create(p31);
    p.create(p32);
    p.create(p33);
    p.create(p34);
    p.create(p35);
    p.create(p36);
    p.create(p37);
    p.create(p38);
    p.create(p39);
    p.create(p40);
    p.create(p41);
    p.create(p42);
    p.create(p43);
    p.create(p44);
    p.create(p45);
    p.create(p46);
    p.create(p47);
    p.create(p48);
    p.create(p49);
    p.create(p50);
    p.create(p51);
    p.create(p52);
    
    DomCarteDAO po = new DomCarteDAO();
    po.nomFichier = "./serveur/src/main/java/l3m/Menu/Carte.xml";
    Carte c = new Carte();
    List<Plat> cp = new ArrayList<>();
    cp.add(p0);
    cp.add(p1);
    cp.add(p2);
    cp.add(p3);
    cp.add(p4);
    cp.add(p5);
    cp.add(p6);
    cp.add(p7);
    cp.add(p8);
    cp.add(p9);
    cp.add(p10);
    cp.add(p11);
    cp.add(p12);
    cp.add(p13);
    cp.add(p14);
    cp.add(p15);
    cp.add(p16);
    cp.add(p17);
    cp.add(p18);
    cp.add(p19);
    cp.add(p20);
    cp.add(p21);
    cp.add(p22);
    cp.add(p23);
    cp.add(p24);
    cp.add(p25);
    cp.add(p26);
    cp.add(p27);
    cp.add(p28);
    cp.add(p29);
    cp.add(p30);
    cp.add(p31);
    cp.add(p32);
    cp.add(p33);
    cp.add(p34);
    cp.add(p35);
    cp.add(p36);
    cp.add(p37);
    cp.add(p38);
    cp.add(p39);
    cp.add(p40);
    cp.add(p41);
    cp.add(p42);
    cp.add(p43);
    cp.add(p44);
    cp.add(p45);
    cp.add(p46);
    cp.add(p47);
    cp.add(p48);
    cp.add(p49);
    cp.add(p50);
    cp.add(p51);
    cp.add(p52);
    c.setPlat(cp);
    c.setIdCarte(1);
    po.create(c);

    // Carte cc = po.read(2);
    /*
     * for(Plat pap : cc.getPlat()){
     * 
     * System.out.println(pap.getIngredients().get(1).value());
     * 
     * 
     * }
     */
    // po.create(c);
    // po.update(c);
    // po.delete(c);
    // Carte cn = po.read(1);
    // System.out.println("id : "+ cn.getPlat().get(0).getPrix());

    //  Carte cc = po.read(2);
    /*     for(Plat pap : cc.getPlat()){

            System.out.println(pap.getIngredients().get(1).value());


        }*/
   // po.create(c);
   // po.update(c);
   // po.delete(c);
   //Carte cn =  po.read(1);
  //System.out.println("id : "+ cn.getPlat().get(0).getPrix());

    /*SaxDAO sx = new SaxDAO() ; 
    Plat sexyPlat = sx.read(0);
    System.out.println(sexyPlat.getIngredients().get(1).value());
    System.out.println(sexyPlat.getType().value());*/
  }
}
