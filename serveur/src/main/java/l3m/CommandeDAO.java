/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l3m;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import l3m.LesCartes.java.Plat;
import l3m.LesCommandes.java.Commande;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CommandeDAO extends SqlDAO<Commande>{
    
    private static final String SELECT = "SELECT * FROM commandes  WHERE id=?";
    
    public CommandeDAO(){
       super();
    }
    
    public boolean create(Commande obj){
       
        try {         
          

            String INSERTCmd = "INSERT INTO commandes (id, dateCommande , idClient, prix, adresseLivraison) "
            + "VALUES (?, ?, ?, ?, ?)";
            
            String INSERTPlat = "INSERT INTO platsCommandes (idCommande , idPlat, quantite) "
            + "VALUES (?, ?, ?)";

            String INSERTFilm = "INSERT INTO filmCommandes (idCommande , idFilm, quantite) "
            + "VALUES (?, ?, ?)";

            PreparedStatement ps = ConnectionBuilder.getInstance().prepareStatement(INSERTCmd);
            PreparedStatement ps2 = ConnectionBuilder.getInstance().prepareStatement(INSERTPlat);
            PreparedStatement ps3 = ConnectionBuilder.getInstance().prepareStatement(INSERTFilm);

            ps.setString(1, obj.getId());
            ps.setDate(2, Date.valueOf(obj.getDate()) );
            ps.setInt(3, obj.getIdClient());

            double prixcmd = 0; 

            if(obj.getIdPlats().size() > 0 ){
                for(int i=0 ; i< obj.getIdPlats().size() ; i++){

                    String d = obj.getIdPlats().get(i);
                    SaxDAO sx = new SaxDAO(); 
                    Plat o = sx.read(Integer.valueOf(d));
                    prixcmd +=  o.getPrix();
                        
                    }
            }

            if(obj.getIdFilms().size() > 0 ){        
                prixcmd += obj.getIdFilms().size()*3.75; 

            }

            ps.setDouble(4, prixcmd);
            ps.setString(5, obj.getAdresseLivraison());

            ps.executeUpdate();

            ps.close(); 
            System.out.println("Commande : " + obj.getId() + " " + obj.getPrix() +  " " + "a bien été ajouté à la BD Cmd.");
            

            if(obj.getIdPlats().size() > 0 ){
                
                List<String> array = new ArrayList<>();
                array = obj.getIdPlats().stream().distinct().collect(Collectors.toList());


                for(int i=0 ; i< array.size() ; i++){

                        ps2.setString(1, obj.getId());
                        ps2.setString(2, array.get(i));
                        ps2.setInt(3, Collections.frequency(obj.getIdPlats(), array.get(i)));
                        ps2.executeUpdate();    
                 

                }

            ps2.close(); 
            }

            System.out.println("Commande : " + obj.getId() + " " + obj.getPrix() +  " " + "a bien été ajouté à la BD CmdPlat.");

            if(obj.getIdFilms().size() > 0 ){        

                List<String> filmos = new ArrayList<>() ; 
                filmos = obj.getIdFilms().stream().distinct().collect(Collectors.toList());

                for(int i=0 ; i< filmos.size() ; i++){

                    ps3.setString(1, obj.getId());
                    ps3.setString(2, filmos.get(i));
                    ps3.setInt(3, Collections.frequency( obj.getIdFilms(),  filmos.get(i)));
                    ps3.executeUpdate();

                }
                ps3.close(); 
            }
            System.out.println("Commande : " + obj.getId() + " " + obj.getPrix() +  " " + "a bien été ajouté à la BD CmdFilm.");

            
            
        } catch (SQLException e) {
            System.out.println(e);         
            return false;
        }
        return true;
    }

      
    @Override
     public Commande read(int id){
        Commande comm = null;
 
        try {


            String SELECTcmd = "SELECT * FROM commandes WHERE id=?";
            String SELECTplats = "SELECT * FROM  platsCommandes  WHERE idCommande=?";
            String SELECTfilms = "SELECT * FROM filmCommandes  WHERE idCommande=?"; 


            PreparedStatement ps = ConnectionBuilder.getInstance().prepareStatement(SELECTcmd);
            ps.setString(1, Integer.toString(id));
 
            ResultSet resultSet = ps.executeQuery();
            comm = new Commande();
            while(resultSet.next()){ 
            comm.setDate(resultSet.getString("dateCommande"));
            comm.setId(resultSet.getString("id"));
            comm.setIdClient(Integer.parseInt(resultSet.getString("idClient")));
            comm.setPrix(resultSet.getDouble("prix"));
            comm.setAdresseLivraison(resultSet.getString("adresseLivraison"));
            }
            ps.executeUpdate();
            ps.close();

            PreparedStatement ps1 = ConnectionBuilder.getInstance().prepareStatement(SELECTplats);
            ps1.setString(1, comm.getId());
            

            ResultSet resultSet1 = ps1.executeQuery();
           
            List<String> idPlats = new ArrayList<>();

            while(resultSet1.next()){ 

                String idPlatActuel = resultSet1.getString("idPlat");
                int q = Integer.valueOf(resultSet1.getString("quantite"));

                for(int i=0 ; i<q ; i++){

                    idPlats.add(idPlatActuel);
                }

            }
         
            comm.setIdPlats(idPlats);


            ps1.executeUpdate();
            ps1.close();

            PreparedStatement ps2 = ConnectionBuilder.getInstance().prepareStatement(SELECTfilms);
            ps2.setString(1, comm.getId());
            

            ResultSet resultSet2 = ps2.executeQuery();
            List<String> idFilmos = new ArrayList<>();

            while(resultSet2.next()){ 

                String idFilmsActuel = resultSet2.getString("idFilm");
                int quantitefilms = Integer.valueOf(resultSet2.getString("quantite"));

    
                for(int i=0 ; i<quantitefilms ; i++){

                    idFilmos.add(idFilmsActuel);

                }

            }

            comm.setIdFilms(idFilmos);
        
            ps2.executeUpdate();
            ps2.close();

        } catch (SQLException e) {
            System.out.println(e);

        }
 
        return comm;
    }



    
    public boolean update(Commande obj){  

         try {
           

            String UPDATEcmd = "UPDATE commandes SET dateCommande=?, idClient=?, prix=?, adresseLivraison=? WHERE id=?";
              
            String INSERTPlat = "INSERT INTO platsCommandes (idCommande , idPlat, quantite) "
            + "VALUES (?, ?, ?)";

            String INSERTFilm = "INSERT INTO filmCommandes (idCommande , idFilm, quantite) "
            + "VALUES (?, ?, ?)";

            PreparedStatement ps = ConnectionBuilder.getInstance().prepareStatement(UPDATEcmd);
            
            ps.setDate(1, Date.valueOf(obj.getDate()) );
            ps.setInt(2, obj.getIdClient());
            
            double prixcmd = 0 ; 
            for(int i=0 ; i< obj.getIdPlats().size() ; i++){

                String d = obj.getIdPlats().get(i);
                SaxDAO sx = new SaxDAO(); 
                Plat o = sx.read(Integer.valueOf(d));
                prixcmd +=  o.getPrix();
                    
            }

            prixcmd += obj.getIdFilms().size()*3.75; 

            ps.setDouble(3, prixcmd);
            ps.setString(4, obj.getAdresseLivraison());
            ps.setString(5, obj.getId());

            ps.executeUpdate();
            ps.close();
            System.out.println("Commande : " + obj.getId() + " " + obj.getPrix() +  " " + "a bien été mis à jour dans la BD.");

            PreparedStatement ps2delete = ConnectionBuilder.getInstance().prepareStatement("DELETE FROM platsCommandes WHERE idCommande=?");
            for(int i=0 ; i< obj.getIdPlats().size() ; i++){

                ps2delete.setString(1, obj.getId());
                ps2delete.executeUpdate();

            }
            ps2delete.close();

            PreparedStatement ps2 = ConnectionBuilder.getInstance().prepareStatement(INSERTPlat);
        
            if(obj.getIdPlats().size() > 0 ){
                
                List<String> array = new ArrayList<>();
                array = obj.getIdPlats().stream().distinct().collect(Collectors.toList());


                for(int i=0 ; i< array.size() ; i++){

                        ps2.setString(1, obj.getId());
                        ps2.setString(2, array.get(i));
                        ps2.setInt(3, Collections.frequency(obj.getIdPlats(), array.get(i)));
                        ps2.executeUpdate();    
                 

                }

            ps2.close(); 
            }
            System.out.println("Commande : " + obj.getId() + " " + obj.getPrix() +  " " + "a bien été mis à jour dans la BDPlat.");

            PreparedStatement ps3delete = ConnectionBuilder.getInstance().prepareStatement("DELETE FROM filmCommandes WHERE idCommande=?");
            for(int i=0 ; i< obj.getIdFilms().size() ; i++){

                ps3delete.setString(1, obj.getId());
                ps3delete.executeUpdate();

            }
            ps3delete.close();

            PreparedStatement ps3 = ConnectionBuilder.getInstance().prepareStatement(INSERTFilm);
            if(obj.getIdFilms().size() > 0 ){        

                List<String> filmos = new ArrayList<>() ; 
                filmos = obj.getIdFilms().stream().distinct().collect(Collectors.toList());

                for(int i=0 ; i< filmos.size() ; i++){

                    ps3.setString(1, obj.getId());
                    ps3.setString(2, filmos.get(i));
                    ps3.setInt(3, Collections.frequency( obj.getIdFilms(),  filmos.get(i)));
                    ps3.executeUpdate();

                }
                ps3.close(); 
            }
            System.out.println("Commande : " + obj.getId() + " " + obj.getPrix() +  " " + "a bien été mis à jour dans la BDFilms.");


        } catch (SQLException e) {
            System.out.println(e);         
            return false;
        }
        return true; 
    }
    
     public boolean delete(Commande obj){
        try {

            String DELETEcmd = "DELETE FROM commandes WHERE id=?";
            String DELETEplats = "DELETE FROM platsCommandes WHERE idCommande=?";
            String DELETEfilms = "DELETE FROM filmCommandes WHERE idCommande=?";

            PreparedStatement ps2 = ConnectionBuilder.getInstance().prepareStatement(DELETEplats);
            for(int i=0 ; i< obj.getIdPlats().size() ; i++){

                ps2.setString(1, obj.getId());
                ps2.executeUpdate();

            }
            ps2.close();

            System.out.println("Commande avec id : " + obj.getId() + " a bien été supprimé de la BDPlat."); 

            PreparedStatement ps = ConnectionBuilder.getInstance().prepareStatement(DELETEfilms);

            for(int i=0 ; i< obj.getIdFilms().size() ; i++){

                ps.setString(1, obj.getId());
                ps.executeUpdate();

            }
            ps.close(); 

            System.out.println("Commande avec id : " + obj.getId() + " a bien été supprimé de la BDFilm."); 
            PreparedStatement ps3 = ConnectionBuilder.getInstance().prepareStatement(DELETEcmd);
            ps3.setString(1, obj.getId());
            ps3.executeUpdate();
            ps3.close(); 
            System.out.println("Commande avec id : " + obj.getId() + " a bien été supprimé de la BD."); 
     
           

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
         return true;
    }

     
}