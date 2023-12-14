package l3m;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.PreparedStatement;

import l3m.LesClients.java.Client;
import l3m.LesCommandes.java.Commande;

public class BdAccess {

    static final String CONN_URL = "jdbc:oracle:thin:@im2ag-oracle.e.ujf-grenoble.fr:1521:im2ag";
    static final String USR = "varinier";
    static final String PWD = "2eKSrGx6T5";

    static String authentifyUser(Client c, String uid) throws SQLException {
        
        int idClient = BdAccess.getIdClientFromUID(uid);

        if (idClient == -1) {
            createClient(c, uid);
            idClient = BdAccess.getIdClientFromUID(uid);
        }
        ClientDAO manager = new ClientDAO();
        Client client = manager.read(idClient);
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        String cli = gson.toJson(client);
        return "{\"client\":"+ cli + ", \"commandes\":"+ BdAccess.getAllCommandesForID(uid)+"}";
    }

    static void createClient(Client c, String uid) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection(CONN_URL, USR, PWD);
        conn.setAutoCommit(true);
        Statement requete = conn.createStatement(); // création du descripteur de requête
        ResultSet resultat = requete.executeQuery("SELECT MAX(idClient) as max FROM associationsId");
        int idClient = -1;
        if (resultat.next()) {
            idClient = resultat.getInt("max");
            idClient++;
        }
        requete.close();
        resultat.close();
        conn.close();
        ClientDAO manager = new ClientDAO();
        c.setId(idClient);
        manager.create(c);
        PreparedStatement ps = ConnectionBuilder.getInstance()
                .prepareStatement("INSERT INTO associationsId VALUES(?,?)");
        ps.setString(1, uid);
        ps.setInt(2, idClient);

        ps.executeQuery();
        ps.close();
    }

    static String createCommande(Commande c) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection(CONN_URL, USR, PWD);
        conn.setAutoCommit(true);
        Statement requete = conn.createStatement(); // création du descripteur de requête
        ResultSet resultat = requete.executeQuery("SELECT MAX(id) as max FROM commandes");
        int idcommande = -1;
        if (resultat.next()) {
            idcommande = resultat.getInt("max");
            idcommande++;
        }
        requete.close();
        resultat.close();
        conn.close();

        CommandeDAO manager = new CommandeDAO();
        c.setId(""+idcommande);
        manager.create(c);
        String id = String.valueOf(idcommande); 
        return id;
    }

    static int getIdClientFromUID(String uid) throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection(CONN_URL, USR, PWD);
        conn.setAutoCommit(true);
        PreparedStatement ps = ConnectionBuilder.getInstance().prepareStatement("SELECT * FROM associationsId WHERE uidClient = ?");
        ps.setString(1, uid);
        ResultSet resultat = ps.executeQuery();
        int idClient = -1;
        if(resultat.next()){
            idClient = resultat.getInt("idClient");
        }
        ps.executeUpdate();
        ps.close();
        resultat.close();
        conn.close();
        return idClient;
    }

    static String getAllCommandesForID(String uid) throws SQLException {
        String allCommandes = "";
        int idClient = getIdClientFromUID(uid);
        CommandeDAO managerCommande = new CommandeDAO();
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        ArrayList<Integer> allIdsCommandes = getAllIdCommandesForIdClient(idClient);
        ArrayList<Commande> commandes = new ArrayList<Commande>();
        for (Integer idCom : allIdsCommandes) {
            commandes.add(managerCommande.read(idCom));
        }
        allCommandes = gson.toJson(commandes);
        return allCommandes;
    }

    private static ArrayList<Integer> getAllIdCommandesForIdClient(int idClient) throws SQLException {
        ArrayList<Integer> allIds = new ArrayList<Integer>();
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection(CONN_URL, USR, PWD);
        conn.setAutoCommit(true);
        PreparedStatement ps = ConnectionBuilder.getInstance().prepareStatement("SELECT id FROM commandes WHERE idClient = ?");
        ps.setInt(1, idClient);
        ResultSet resultat = ps.executeQuery();
        while(resultat.next()){
            allIds.add(resultat.getInt("id"));
        }
        return allIds;
    }

	static void updateClient(Client c) {
        ClientDAO manager = new ClientDAO();
        manager.update(c);
	}

}