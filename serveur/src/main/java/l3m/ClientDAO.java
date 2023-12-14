/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l3m;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import l3m.LesClients.java.Client;




public class ClientDAO extends SqlDAO<Client>{
    private static final String INSERT = "INSERT INTO users (id, nom, prenom, photo,email,tel, adresse) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE users SET nom=?, prenom=?, photo=?, tel =?, adresse=? WHERE id=?";
    private static final String DELETE = "DELETE FROM users WHERE id=?";
    private static final String DELETEAssoc = "DELETE FROM associationsId WHERE idClient=?";
    private static final String SELECT = "SELECT * FROM users WHERE id=?";
 
  
    public ClientDAO(){
        super();
    }
    
    public boolean create(Client obj){
        
      
        try {

            PreparedStatement logps = ConnectionBuilder.getInstance().prepareStatement(SELECT);
            logps.setInt(1, obj.getId());
 
            ResultSet resultSet = logps.executeQuery();
            int theID = 0;
            while(resultSet.next()){ 
                theID = resultSet.getInt("id") ; 
            }
            PreparedStatement ps = ConnectionBuilder.getInstance().prepareStatement(INSERT);
            if (obj.getId() != Integer.valueOf(theID)){
           
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getNom());
            ps.setString(3, obj.getPrenom());
            ps.setString(4, obj.getPhoto());
            ps.setString(5, obj.getEmail());
            ps.setString(6, obj.getTel());
            ps.setString(7, obj.getAdresse());
            ps.executeUpdate();
            ps.close(); 
            System.out.println("Client : " + obj.getPrenom() + " " + obj.getNom() +  " " + "a bien été ajouté à la BD.");
                
            }
            resultSet.close();
            logps.close();    

        } catch (SQLException e) {
            System.out.println(e);         
            return false;
        }
        return true;
  
    }
    
    @Override
    public Client read(int id){
        Client user = null;
 
        try {
            PreparedStatement ps = ConnectionBuilder.getInstance().prepareStatement(SELECT);
            ps.setString(1, Integer.toString(id));
 
            ResultSet resultSet = ps.executeQuery();
 
            if(resultSet.next()) {
 
                user = new Client();
                
                user.setId(Integer.valueOf(resultSet.getString("id")));
                user.setNom(resultSet.getString("nom"));
                user.setPrenom(resultSet.getString("prenom"));
                user.setPhoto(resultSet.getString("photo"));
                user.setEmail(resultSet.getString("email"));
                user.setTel(resultSet.getString("tel"));
                user.setAdresse(resultSet.getString("adresse"));
                
 
           }
           System.out.println("RESULTAT -> " + user.toString());
            resultSet.close();
            ps.close();
 
        } catch (SQLException e) {
            System.out.println(e);

        } 
 
        return user;
 
  
       
    }
    
    public boolean update(Client obj){
        try {
            
            
            PreparedStatement ps = ConnectionBuilder.getInstance().prepareStatement(UPDATE);
            ps.setString(1, obj.getNom());
            ps.setString(2, obj.getPrenom());
            ps.setString(3, obj.getPhoto());
            ps.setString(4, obj.getTel());
            ps.setString(5, obj.getAdresse());
            ps.setInt(6, obj.getId());
            ps.executeUpdate();
            ps.close();   
            System.out.println("Client avec id : " + obj.getId() + " a bien été mis à jour dans la BD.");
        } catch (SQLException e) {
            System.out.println(e);         
            return false;
        }
        return true; 
    }
    
    
    public boolean delete(Client obj){
         try {
             
            PreparedStatement ps1 = ConnectionBuilder.getInstance().prepareStatement(DELETEAssoc);
            ps1.setInt(1, obj.getId());
            ps1.executeUpdate();
            ps1.close();

            PreparedStatement ps = ConnectionBuilder.getInstance().prepareStatement(DELETE);
            ps.setInt(1, obj.getId());
 
            ps.executeUpdate();
            ps.close();
 
            System.out.println("Client avec id : " + obj.getId() + " a bien été supprimé de la BD.");
 
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
         return true;
    }
 
}