/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import DaoInterface.IClientDao;
import Technique.MyConnection;
import DaoInterface.IEvenementDAO;
import Entites.Evenement;
import Entites.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GaiaDev
 */
public class EvenementDAO implements IEvenementDAO{
    Connection connexion = MyConnection.getInstance();

    @Override
    public void insertEvenement(Evenement evenement) {
        String requete = "INSERT INTO `evenement`( `titre`, `lieu`, `date_debut`, `date_fin`, `confidentialite`, "
                + "`description`, `prix`, `createur`, `Type`) VALUES (?,?,?,?,?,?,?,?,?)";
        
       
        
                
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            
            
            pst.setString(1, evenement.getNom_event());
            pst.setString(2, evenement.getLieu_event());
            java.sql.Date d1=new java.sql.Date( evenement.getDate_debut_event().getTime());
            java.sql.Date d2=new java.sql.Date(evenement.getDate_fin_event().getTime());
            pst.setDate(3, d1);
            pst.setDate(4, d2);
            pst.setString(5,evenement.getConfidentialite_event());
            pst.setString(6,evenement.getDescription_event());
            pst.setFloat(7,evenement.getPrix_event());
            pst.setInt(8,evenement.getUser().getId());
            pst.setString(9,evenement.getType_event());
            pst.executeUpdate();
              }
        catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }

    @Override
    public void updateEvenement(Evenement evenement) {
           String requete = "UPDATE `evenement` SET `titre`=?,"
                   + "`lieu`=?,"
                   + "`date_debut`=?,"
                   + "`date_fin`=?,"
                   + "`confidentialite`=?,"
                   + "`description`=?,"
                   + "`prix`=?,"
                   + "`createur`=?,"
                   + "`Type`=? WHERE `id`="+evenement.getId_event() ;
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1, evenement.getNom_event());
            pst.setString(2, evenement.getLieu_event());
            java.sql.Date d1=new java.sql.Date( evenement.getDate_debut_event().getTime());
            java.sql.Date d2=new java.sql.Date(evenement.getDate_fin_event().getTime());
            pst.setDate(3, d1);
            pst.setDate(4, d2);
            pst.setString(5,evenement.getConfidentialite_event());
            pst.setString(6,evenement.getDescription_event());
            pst.setFloat(7,evenement.getPrix_event());
            pst.setInt(8,evenement.getUser().getId());
            pst.setString(9,evenement.getType_event());
            pst.executeUpdate();
            
            System.out.println("Mise à jour effectuer avec succes");
            }
        catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors de la mise à jour");   
        }
         
    }

    @Override
    public void deleteEvenement(int id) {
        
        String requete = "DELETE FROM evenement WHERE id =" + id;
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
             pst.executeUpdate();
            System.out.println("Supression effectuer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @Override
    public Evenement retrievEvenementById(int id) {
        Evenement event = new Evenement();
        try {
        ResultSet result = this.connexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM evenement WHERE id = " + id);
        if(result.first()){
            Utilisateur user = new Utilisateur();
            IClientDao iCl= new ClientDao();
            user.setId(result.getInt(9));
            user = iCl.retrieveClientById(user.getId());
        event = new Evenement(id, result.getString(2), result.getString(3), 
                result.getDate(4), result.getDate(5), result.getString(6), result.getString(7), result.getFloat(8), user, result.getString(10));
        }} catch (SQLException e) {
        System.out.println("erreur"+ e.getMessage());
        }
        return event;
    }

 
    @Override
    public List<Evenement> DisplayAllEvent() {
         List<Evenement> listeEvenements = new ArrayList<>();
        String requete = "SELECT * FROM evenement";
        
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {   
                
                Evenement event = new Evenement();
                event.setId_event(resultat.getInt(1));
                event.setNom_event(resultat.getString(2));
                event.setLieu_event(resultat.getString(3));
                event.setDate_debut_event(resultat.getDate(4));
                event.setDate_fin_event(resultat.getDate(5) );
                event.setConfidentialite_event(resultat.getString(6));
                 event.setDescription_event(resultat.getString(7));
                event.setPrix_event(resultat.getFloat(8));
                Utilisateur u = new Utilisateur();
                u.setId(resultat.getInt(9));
                event.setUser(u);
                event.setType_event(resultat.getString(10));
                
               
                listeEvenements.add(event);
                System.out.println("Affichage en cours");
            }
            return  listeEvenements;
        } catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors du chargement des Evenements");
            return null;
        }
        
    }

  

    @Override
    public List<Evenement> retrievEvenementByName(String titre) {
       List<Evenement> listeEvenements = new ArrayList<>();
        String requete = "SELECT * FROM evenement where titre like '%"+titre+"%'";
        
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
             while (resultat.next()) {   
                Evenement event = new Evenement();
                event.setId_event(resultat.getInt(1));
                event.setNom_event(resultat.getString(2));
                event.setLieu_event(resultat.getString(3));
                event.setDate_debut_event(resultat.getDate(4));
                event.setDate_fin_event(resultat.getDate(5) );
                event.setConfidentialite_event(resultat.getString(6));
                event.setDescription_event(resultat.getString(7));
                event.setPrix_event(resultat.getFloat(8));
                
                Utilisateur u = new Utilisateur();
                u.setId(resultat.getInt(9));
                event.setUser(u);
                event.setType_event(resultat.getString(10));
               
                listeEvenements.add(event);
                System.out.println("Affichage en cours tt");
            }
            return  listeEvenements;
        } catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors du chargement des Evenements");
            return null;
        }
        }

    @Override
    public List<Evenement> retrievEvenementByNameandID(String titre, int id) {
 List<Evenement> listeEvenements = new ArrayList<>();
        String requete = "SELECT * FROM evenement where titre like '%"+titre+"%' And createur="+id;
        
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
             while (resultat.next()) {   
                Evenement event = new Evenement();
                event.setId_event(resultat.getInt(1));
                event.setNom_event(resultat.getString(2));
                event.setLieu_event(resultat.getString(3));
                event.setDate_debut_event(resultat.getDate(4));
                event.setDate_fin_event(resultat.getDate(5) );
                event.setConfidentialite_event(resultat.getString(6));
                event.setDescription_event(resultat.getString(7));
                event.setPrix_event(resultat.getFloat(8));
                
                Utilisateur u = new Utilisateur();
                u.setId(resultat.getInt(9));
                event.setUser(u);
                event.setType_event(resultat.getString(10));
               
                listeEvenements.add(event);
                System.out.println("Affichage en cours tt");
            }
            return  listeEvenements;
        } catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors du chargement des Evenements");
            return null;
        }    
    
    }
    
    @Override
     public Float calculernote(int e) {
        String requete = "SELECT AVG(note) FROM evaluationevenement where id_evenement="+e;
        PreparedStatement pst;
        try {
            pst = connexion.prepareStatement(requete);
            ResultSet resultat = pst.executeQuery(requete);
           if (resultat.next())
           { 
               return resultat.getFloat(1);
                
           }
           else
           {
               return 0F;
           }
               
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     
     
     public int retrievEventIdMax() {
        int x;
        
          String requete ="SELECT MAX(id) FROM evenement";
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            if (resultat.next())
            {
                x=resultat.getInt(1);
                
            return x;

            }
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des reclamations "+ex.getMessage());
        }
        return -1;
   }
    
}
