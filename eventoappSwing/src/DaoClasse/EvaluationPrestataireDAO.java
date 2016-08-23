/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOclasse;
import Technique.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOinterface.Ievaluation;
import DAOinterface.Ievaluationp;
import Entites.Evenement;
import Entites.Utilisateur;

/**
 *
 * @author user
 */
public class EvaluationPrestataireDAO implements Ievaluationp {
    
    Connection connexion = MyConnection.getInstance();
    
    public void evaluerprestataire(int note ,Utilisateur e,Utilisateur prestataire){
        
        String requete = "INSERT INTO evaluationprestataire (id_user,id_prestataire,note) VALUES(?,?,?)";
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1, e.getId());
            pst.setInt(2, prestataire.getId());
            pst.setInt(3, note);
            pst.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(EvaluationClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
