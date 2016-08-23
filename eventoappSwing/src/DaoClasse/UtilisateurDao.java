/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoClasse;

import DaoInterface.IUtilisateurDao;
import Entites.Galerie;
import Entites.Utilisateur;
import Technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seif
 */
public class UtilisateurDao implements IUtilisateurDao{
  Connection connexion = MyConnection.getInstance();
  
    @Override
   public boolean deleteUtilisateur(int id) {
        String requete = "DELETE FROM utilisateur where id=? ";
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1, id);

            pst.executeUpdate();
            //  System.out.println("Suppression effectuee avec succes");
        } catch (SQLException ex) {
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("erreur lors de la Suppression" + ex.getMessage());
        }

        return true;

    }

    @Override
    public Utilisateur retrieveUtilisateurById(int id) {
        Utilisateur u = new Utilisateur();

        String requete = "select * from utilisateur where id=" + id;
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            if (resultat.next()) {

                u.setId(resultat.getInt("id"));
                u.setNom(resultat.getString("nom"));
                u.setAdresse(resultat.getString("addresse"));
                u.setMail(resultat.getString("email"));
                u.setTel(resultat.getInt("tel"));
                u.setPassword(resultat.getString("password"));
                u.setNature(resultat.getByte("nature"));
                u.setLocked(resultat.getInt("locked"));
                u.setEnabled(resultat.getInt("enabled"));
                u.setUsername(resultat.getString("username"));

            }
            return u;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des utilisateurs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Utilisateur> retrieveAllUtilisateur() {

        List<Utilisateur> listuser = new ArrayList<>();
        String requete = "select * from utilisateur";
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Utilisateur u = new Utilisateur();
                u.setId(resultat.getInt("id"));
                u.setNom(resultat.getString("nom"));
                u.setAdresse(resultat.getString("addresse"));
                u.setMail(resultat.getString("email"));
                u.setTel(resultat.getInt("tel"));
                u.setPassword(resultat.getString("password"));

                u.setNature(resultat.getByte("nature"));
                u.setLocked(resultat.getInt("locked"));
                u.setEnabled(resultat.getInt("enabled"));
                u.setUsername(resultat.getString("username"));
                listuser.add(u);
            }
            System.out.println("succÃ©es select");
            return listuser;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des utilisateurs" + ex.getMessage());
            return null;
        }

    }

    
    public boolean bloquerutilisateur(int id) {
       String requete="UPDATE utilisateur set locked=? where id=?";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setInt(1,1);
        pst.setInt(2,id);
        pst.executeUpdate();
            System.out.println("Mise a jour effectuee avec succes");
        }
        catch (SQLException ex){
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("erreur lors de la mise a jour"+ex.getMessage());
        }     
                return true;

}
    
}