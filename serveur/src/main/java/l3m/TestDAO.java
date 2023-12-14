package l3m;

import java.util.ArrayList;
import java.util.List;

import l3m.LesCartes.java.Plat;
import l3m.LesClients.java.Client;
import l3m.LesCommandes.java.Commande;

public class TestDAO {

    public static void main(String[] args){


    ClientDAO p = new ClientDAO();
    Client c = new Client();
    c.setId(11);
    c.setEmail("truc@much");
    c.setTel("0102024405");
    c.setNom("Forever");
    c.setPrenom("Michel");
    c.setAdresse("Rue ToNight");
    c.setPhoto("une photo disco");
    //p.create(c);
    // Client cc = p.read(1022);
    // System.out.println(cc.getId());
     p.delete(c);
     //p.update(c);

     CommandeDAO ap = new CommandeDAO();
     Commande ac = new Commande();
     
    List<String> test1 = new ArrayList<String>();
    test1.add("StarWars7");
    test1.add("StarWars5");

    List<String> test2 = new ArrayList<String>(); 
    test2.add("53");
    test2.add("49");
    test2.add("50");
     ac.setAdresseLivraison("rue de machin batiment machinde");
     ac.setDate("2019-12-16");
     ac.setId("800");
     ac.setIdClient(1022);
     ac.setIdFilms(test1);
     ac.setIdPlats(test2);
     //  ap.create(ac);
     //  ap.update(ac);
     // Commande common = ap.read(801);
     // System.out.println(common.getPrix());
     // System.out.println(common.getIdPlats().get(0));
     // System.out.println(common.getIdFilms().get(0));
     //DomPlatDAO pp = new DomPlatDAO();
     //pp.nomFichier = "./serveur/src/main/java/l3m/Menu/Plat_";
     //pp.read(Integer.valueOf( common.getIdPlats().get(2)));
     //System.out.println(common.getIdFilms().get(0));
     ap.delete(ac);
     
     }
}


