/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import DaoInterface.Igererabonnement;
import Technique.MyConnection;
import Entites.Abonnement;
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
 * @author user
 */
public class AbonnementDAO implements Igererabonnement {
    
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GaiaDev
 */

    Connection connexion = MyConnection.getInstance();

    public void ajouterabonnement(Abonnement abonnement,Utilisateur prest) {
        String requete = "INSERT INTO abonnement (type,date_debut,date_fin,id_prest)"
                + " VALUES(?,?,?,?)";
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            
            pst.setString(1, abonnement.getType());
            java.sql.Date d1=new java.sql.Date(abonnement.getDate_debut().getTime());
            java.sql.Date d2=new java.sql.Date(abonnement.getDate_fin().getTime());
            pst.setDate(2,d1);
            pst.setDate(3,d2);
            pst.setInt(4, prest.getId());
            
            pst.executeUpdate();
              }
        catch (SQLException ex) {
            Logger.getLogger(AbonnementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }

    public void ajouterabonnement(Abonnement abonnement) {
        String requete = "INSERT INTO abonnement (id,type,date_debut,date_fin,id_prest)"
                + " VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            
            pst.setInt(1,abonnement.getId() );
            pst.setString(2, abonnement.getType());
            java.sql.Date d1=new java.sql.Date(abonnement.getDate_debut().getTime());
            java.sql.Date d2=new java.sql.Date(abonnement.getDate_fin().getTime());
            pst.setDate(3,d1);
            pst.setDate(4,d2);
            pst.setInt(5,abonnement.getPrestataire().getId());
            pst.executeUpdate();
              }
        catch (SQLException ex) {
            Logger.getLogger(AbonnementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         }

   
    

   
    public void supprimerabonnement(int id) {
        
        String requete = "DELETE FROM abonnement WHERE id =" + id;
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
             pst.executeUpdate();
            System.out.println("Supression effectuer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void modifierabonnement(Abonnement a) {
        String requete = "UPDATE abonnement SET type=?,"
                   + "date_debut=?,"
                   + "date_fin=?,"
                   + "WHERE id="+a.getId() ;
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            
            pst.setString(1, a.getType());
             java.sql.Date d1=new java.sql.Date(a.getDate_debut().getTime());
            java.sql.Date d2=new java.sql.Date(a.getDate_fin().getTime());
            pst.setDate(2, d1);
            pst.setDate(3, d2);
       
           
            System.out.println("Mise à jour effectuer avec succes");
            }
        catch (SQLException ex) {
            Logger.getLogger(Abonnement.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors de la mise à jour");   
        }
    }

    
    public Abonnement retrievEvenementById(int id) {
        Abonnement abonnement = new Abonnement();
        UtilisateurDao x= new UtilisateurDao();
        try {
        ResultSet result = this.connexion.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM abonnement WHERE id = " + id);
        if(result.first())
        abonnement.setId(id);
        abonnement.setType(result.getString(2));
        abonnement.setDate_debut(result.getDate(3));
        abonnement.setDate_fin(result.getDate(4));
        abonnement.setPrestataire(x.retrieveUtilisateurById(result.getInt(5)));
        } catch (SQLException e) {
        System.out.println("erreur"+ e.getMessage());
        }
        return abonnement;
    }

    @Override
    public List<Abonnement> DisplayAllAbonnement() {
        List<Abonnement> listeAbonnement = new ArrayList<>();
        String requete = "SELECT * FROM abonnement";
        UtilisateurDao x =new UtilisateurDao();
        
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {   
                
                Abonnement abonnement = new Abonnement();
                abonnement.setId(resultat.getInt(1));
                abonnement.setType(resultat.getString(2));
                abonnement.setDate_debut(resultat.getDate(3));
                abonnement.setDate_fin(resultat.getDate(4));
                abonnement.setPrestataire(x.retrieveUtilisateurById(resultat.getInt(5)));
                
                
               
                listeAbonnement.add(abonnement);
                System.out.println("Affichage en cours");
            }
            return  listeAbonnement;
        } catch (SQLException ex) {
            Logger.getLogger(AbonnementDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors du chargement des Evenements");
            return null;
        }
        
    }
    
    
}


