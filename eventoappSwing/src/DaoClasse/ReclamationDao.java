/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import DaoInterface.IReclamationDao;
import Entites.Reclamation;
import Technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IDRISS
 */
public class ReclamationDao implements IReclamationDao{

        Connection connexion= MyConnection.getInstance();

    @Override
    public boolean insertReclamation(Reclamation rec) {
String requete="INSERT INTO reclamation ( `Contenu`,`id_expediteur`) VALUES (?,?)";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        

        pst.setString(1,rec.getContenuReclamation());
        pst.setInt(2, rec.getExpediteur().getId());
       
        pst.executeUpdate();
                    System.out.println("Ajout effectuee avec succes");

        }
        catch (SQLException ex){
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        return true;
        }    

    @Override
    public boolean updateReclamation(Reclamation rec) {
String requete="UPDATE reclamation set Contenu=? where id_expediteur=?";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setInt(2,rec.getExpediteur().getId());
        pst.setString(1,rec.getContenuReclamation());
        pst.executeUpdate();
            System.out.println("Mise a jour effectuee avec succes");
        }
        catch (SQLException ex){
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("erreur lors de la mise a jour"+ex.getMessage());
        }     
                return true;

    }

    @Override
    public boolean deleteReclamation(int id) {
        String requete="DELETE FROM reclamation where id=?";
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
    public Reclamation retrieveReclamationById(int id) {
                        Reclamation rec = new Reclamation();
                        

        String requete ="select * from reclamation where id="+id;
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            if (resultat.next())
            {
                rec.setIdReclamation(resultat.getInt(1));
                rec.setDateReclamation(resultat.getDate(2));
                rec.setContenuReclamation(resultat.getString(3));
            }
            return rec;
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des reclamations "+ex.getMessage());
            return null;
        }
        }

    @Override
    public Vector<Reclamation> retrieveAllReclamation() {
        Vector<Reclamation> listRec =new Vector<Reclamation>();
        String requete ="select * from reclamation";
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next())
            {
                Reclamation rec = new Reclamation();
                rec.setIdReclamation(resultat.getInt(1));
                rec.setDateReclamation(resultat.getDate(2));
                rec.setContenuReclamation(resultat.getString(3));

                
                listRec.add(rec);
            }
            return listRec;
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des reclamations"+ex.getMessage());
            return null;
        }
    
    }
    
}
