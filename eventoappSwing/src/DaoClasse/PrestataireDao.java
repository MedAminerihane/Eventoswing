/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoClasse;

import DaoInterface.IPrestataireDao;
import Entites.Prestataire;
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
 * @author Seif
 */
public class PrestataireDao implements IPrestataireDao{
     Connection connexion = MyConnection.getInstance();

    @Override
   
    public boolean insertPrestataire(Prestataire prestataire) {
        String requete = "INSERT INTO utilisateur (nom,adresse,email,password,tel,matricule_fiscal,description,nature,username,locked,enabled) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1, prestataire.getNom());
            pst.setString(2, prestataire.getAdresse());
            pst.setString(3, prestataire.getMail());
            pst.setInt(5, prestataire.getTel());
            pst.setString(4, prestataire.getPassword());
            pst.setString(6, prestataire.getMatriculeFiscale());
            pst.setString(7, prestataire.getDescription());
            pst.setInt(8, prestataire.getNature());

            pst.setString(9, prestataire.getUsername());
            pst.setInt(10, 0);
            pst.setInt(11, 1);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PrestataireDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("insertion avec succÃ©e");
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePrestataire(Prestataire prestataire) {
        String requete = "UPDATE utilisateur set nom=?, adresse=?, email=?, tel=?, password=?,matricule_fiscal=?, description=? where id=?";
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1, prestataire.getNom());
            pst.setString(2, prestataire.getAdresse());
            pst.setString(3, prestataire.getMail());
            pst.setInt(4, prestataire.getTel());
            pst.setString(5, prestataire.getPassword());
            pst.setString(6, prestataire.getMatriculeFiscale());
            pst.setString(7, prestataire.getDescription());
            pst.setInt(8, prestataire.getId());

            pst.executeUpdate();
            System.out.println("Mise a jour effectuee avec succes");
        } catch (SQLException ex) {
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("erreur lors de la mise a jour" + ex.getMessage());
        }
        return true;

    }

    @Override
    public boolean deletePrestataire(int id) {
        String requete = "DELETE FROM utilisateur where id=? AND nature=0";
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println("Suppression effectuee avec succes");
        } catch (SQLException ex) {
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("erreur lors de la Suppression" + ex.getMessage());
        }

        return true;

    }

    @Override
    public Prestataire retrievePrestataireById(int id) {
        Prestataire prestataire = new Prestataire();

        String requete = "select * from utilisateur where id=" + id + " And nature=0";
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            if (resultat.next()) {
                prestataire.setId(resultat.getInt("id"));
                prestataire.setNom(resultat.getString("nom"));
                prestataire.setAdresse(resultat.getString("adresse"));
                prestataire.setMail(resultat.getString("email"));
                prestataire.setTel(resultat.getInt("tel"));
                prestataire.setPassword(resultat.getString("password"));
                prestataire.setMatriculeFiscale(resultat.getString("matricule_fiscal"));
                prestataire.setDescription(resultat.getString("description"));
                prestataire.setUsername(resultat.getString("username"));
                prestataire.setLocked(resultat.getInt("locked"));
                prestataire.setEnabled(resultat.getInt("enabled"));

            }
            return prestataire;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des prestataires " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Prestataire> retrieveAllPrestataire() {
        List<Prestataire> listprestataire = new ArrayList<>();
        String requete = "select * from utilisateur where nature=0";
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Prestataire ps = new Prestataire();
                ps.setId(resultat.getInt("id"));
                ps.setNom(resultat.getString("nom"));
                ps.setAdresse(resultat.getString("adresse"));
                ps.setMail(resultat.getString("email"));
                ps.setTel(resultat.getInt("tel"));
                ps.setPassword(resultat.getString("password"));
                ps.setMatriculeFiscale(resultat.getString("matricule_fiscal"));
                ps.setDescription(resultat.getString("description"));
                ps.setNature(resultat.getByte("nature"));
                ps.setUsername(resultat.getString("username"));

                ps.setLocked(resultat.getInt("locked"));
                ps.setEnabled(resultat.getInt("enabled"));

                listprestataire.add(ps);
            }
            System.out.println("succÃ©es");
            return listprestataire;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des prestataires" + ex.getMessage());
            return null;
        }

    }

    public Prestataire retrievEvenementByName(String titre) {
        String requete = "SELECT * FROM utilisateur where titre =" + titre;
        Prestataire ps = new Prestataire();
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                ps.setId(resultat.getInt("id"));
                ps.setNom(resultat.getString("nom"));
                ps.setAdresse(resultat.getString("adresse"));
                ps.setMail(resultat.getString("email"));
                ps.setTel(resultat.getInt("tel"));
                ps.setPassword(resultat.getString("password"));
                ps.setMatriculeFiscale(resultat.getString("matricule_fiscal"));
                ps.setDescription(resultat.getString("description"));
                ps.setNature(resultat.getByte("nature"));

                ps.setUsername(resultat.getString("username"));

                ps.setLocked(resultat.getInt("locked"));
                ps.setEnabled(resultat.getInt("enabled"));
                System.out.println("rÃ©cupÃ©ration du prestataire en cours..");
            }
            return ps;
        } catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors du chargement du prestataire :( ");
            return null;
        }
    }

    @Override
    public Prestataire retrievePrestataireByName(String titre) {
        String requete = "SELECT * FROM utilisateur where titre =" + titre;
        Prestataire ps = new Prestataire();
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                ps.setId(resultat.getInt("id"));
                ps.setNom(resultat.getString("nom"));
                ps.setAdresse(resultat.getString("adresse"));
                ps.setMail(resultat.getString("email"));
                ps.setTel(resultat.getInt("tel"));
                ps.setPassword(resultat.getString("password"));
                ps.setMatriculeFiscale(resultat.getString("matricule_fiscal"));
                ps.setDescription(resultat.getString("description"));
                ps.setNature(resultat.getByte("nature"));
 ps.setUsername(resultat.getString("username"));

                ps.setLocked(resultat.getInt("locked"));
                ps.setEnabled(resultat.getInt("enabled"));
                System.out.println("Affichage en cours tt");
            }
            return ps;

        } catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erreur lors du chargement des Evenements");
            return null;
        }
    }

}
