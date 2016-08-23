/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import DaoInterface.IGalerieDao;
import Entites.Evenement;
import Entites.Galerie;
import Entites.Offre;
import Technique.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IDRISS
 */
public class GalerieDao implements IGalerieDao{

        Connection connexion= MyConnection.getInstance();

   @Override
    public boolean insertPicture(Galerie gal) {
       String requete="INSERT INTO galerie (`url`,`id_evennement`,`type`) VALUES (?,?,?)";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        

        pst.setString(1,gal.getUrl());
        
        pst.setInt(2, gal.getEvent().getId_event());
        
       
      
              pst.setInt(3, gal.getType());

        pst.executeUpdate();
                    System.out.println("Ajout effectuee avec succes");

        }
        catch (SQLException ex){
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        return true;}

    @Override
    public boolean updatePictureevent(Galerie gal) {
       String requete="UPDATE galerie set url=? where id_evennement="+gal.getEvent().getId_event()+" and type=0";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
      
        pst.setString(1,gal.getUrl());
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
    public boolean updatePictureoffre(Galerie gal) {
       String requete="UPDATE galerie set url=? where id_offre="+gal.getOffre().getId()+" and type=1";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
      
        pst.setString(1,gal.getUrl());
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
       String requete="DELETE FROM galerie where id=?";
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
    public Galerie retrievePictureById(int id) {
       Galerie gal = new Galerie();
                        

        String requete ="select * from galerie where (id_evennement="+id+" and type=0) or (id_offre="+id+" and type=1)";
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            if (resultat.next())
            {
                Evenement event= new Evenement();
                Offre off = new Offre();
                off.setId(resultat.getInt(4));
                event.setId_event(resultat.getInt(3));
                gal.setId(resultat.getInt(1));
                gal.setUrl(resultat.getString(2));
                gal.setEvent(event);
                gal.setOffre(off);
                gal.setType(resultat.getInt(5));
                                System.out.println("ligne table");

            }
            System.out.println(gal);
            return gal;
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des photos "+ex.getMessage());
            return null;
        }}


    @Override
    public Vector<Galerie> retrieveAllPicture() {
         Vector<Galerie> listGal =new Vector<Galerie>();
        String requete ="select * from galerie";
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next())
            {
                Galerie gal = new Galerie();
                gal.setId(resultat.getInt(1));
                gal.setUrl(resultat.getString(2));
               Evenement event= new Evenement();
                Offre off = new Offre();
                off.setId(resultat.getInt(4));
                event.setId_event(resultat.getInt(3));
         
                gal.setEvent(event);
                gal.setOffre(off);
                gal.setType(resultat.getByte(5));

                System.out.println("ligne table");
                listGal.add(gal);
            }
            return listGal;
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des photos"+ex.getMessage());
            return null;
        }}
    
}
