/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import DaoInterface.IAdminDao;
import Entites.Admin;
import Entites.Reclamation;
import Technique.MyConnection;
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
 * @author majed
 */
public class AdminDao implements IAdminDao {
        Connection connexion= MyConnection.getInstance();

    @Override
    public boolean ajouterAdmin(Admin admin) {
        String requete="INSERT INTO administrateur ( `nom`,`prenom`,`mail`,`password`) VALUES (?,?,?,?)";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        

   
        pst.setString(1, admin.getNom());
        pst.setString(2, admin.getPrenom());
        pst.setString(3, admin.getMail());
        pst.setString(4, admin.getPwd());
        
       
        pst.executeUpdate();
                    System.out.println("Ajout effectuee avec succes");

        }
        catch (SQLException ex){
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        return true;

    
    }

    @Override
    public boolean supprimerAdmin(int id) {
         String requete="DELETE FROM administrateur where id=?";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setInt(1,id);
       
        pst.executeUpdate();
            System.out.println("Suppression effectuee avec succes");
        }
        catch (SQLException ex){
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("erreur lors de la Suppression"+ex.getMessage());
        }     
        
        
   return true;
    
    }

    @Override
    public boolean modifierAdmin(Admin admin) {
        String requete= "UPDATE administrateur SET nom=?, prenom=?, mail=?, password=? WHERE id=?";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setString(1, admin.getNom());
        pst.setString(2, admin.getPrenom());
        pst.setString(3, admin.getMail());
        pst.setString(4, admin.getPwd());
        pst.setInt(5, admin.getId());
        pst.executeUpdate();
            System.out.println("Mise a jour effectuee avec succes");
        }
        catch (SQLException ex){
            //Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("erreur lors de la mise a jour"+ex.getMessage());
        }     
                return true;

    
    }

    @Override
    public Admin rechercherAdmin(int id) {
                       Admin adm = new Admin();

        String requete ="select * from administrateur where id="+id;
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            if (resultat.next())
            {
                adm.setId(resultat.getInt(1));
                adm.setNom(resultat.getString(2));
                adm.setPrenom(resultat.getString(3));
                adm.setMail(resultat.getString(4));
                adm.setPwd(resultat.getString(5));
            }
          
            return adm;
            
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des reclamations "+ex.getMessage());
            return null;
        }
       
    }
   
        @Override
    public List<Admin> retriveAllAdmin() {
         List<Admin> listeAdmins = new ArrayList<>();
        String requete = "SELECT * FROM administrateur";
        
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {   
                
                Admin admin = new Admin();
                admin.setId(resultat.getInt(1));
                admin.setNom(resultat.getString(2));
                admin.setPrenom(resultat.getString(3));
                admin.setMail(resultat.getString(4));
                admin.setPwd(resultat.getString(5));
                
               
                listeAdmins.add(admin);
                System.out.println("Affichage en cours");
            }
            return  listeAdmins;
        } catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors du chargement des Evenements");
            return null;
        }
        
    }

}
