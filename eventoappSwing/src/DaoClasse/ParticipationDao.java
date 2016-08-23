/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import DaoInterface.IClientDao;
import DaoInterface.IEvenementDAO;
import DaoInterface.IParticipation;
import Entites.Client;
import Entites.Evenement;
import Entites.Invitation;
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
public class ParticipationDao  implements IParticipation{
            Connection connexion= MyConnection.getInstance();
            IClientDao iCl = new ClientDao();
            IEvenementDAO iVent = new EvenementDAO();

    
    @Override
    public boolean participerEvenement(Client client, Evenement e) {
        String requete="INSERT INTO invitation (evenement,participant,etat) VALUES (?,?,?)";

        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        
        pst.setInt(2, client.getId());
        pst.setInt(1, e.getId_event());
        pst.setString(3,"accepté");
       
       
        pst.executeUpdate();
        }
        catch (SQLException ex){
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE,null,ex);
        }
        System.out.println("participation acceptée");
        return true;}
    
    


    @Override
    /*public boolean accepterInvitation(Client c, Evenement e, String ch) {

String requete="UPDATE invitation set etat=? where evenement=? and participant=?";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setString(1, ch);
        pst.setInt(2,e.getId_event());
                pst.setInt(3,c.getId());

        pst.executeUpdate();
            System.out.println("Mise a jour effectuee avec succes");
        }
        catch (SQLException ex){
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("erreur lors de la mise a jour"+ex.getMessage());
        }     
                return true;    }*/

    public Vector<Invitation> retrieveAllInvitation() {
        Vector<Invitation> listRec =new Vector<Invitation>();
        String requete ="select * from invitation i, evenement e,utilisateur u where i.evenement=e.id and i.participant=u.id";
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next())
            {
                Invitation invitation = new Invitation();
                
                Client cl = new Client();
                cl.setId(resultat.getInt("participant"));
                cl  =  iCl.retrieveClientById(cl.getId());
                
                
                Evenement event = new Evenement();
                event.setId_event(resultat.getInt("evenement"));
                event = iVent.retrievEvenementById(event.getId_event());
                
                invitation.setClient(cl);
                invitation.setEvent(event);
                
                      
          invitation.setEtat( resultat.getString("etat"));
          invitation.setDateInvitation(resultat.getDate("date_invitation"));

                
                listRec.add(invitation);
            }
            return listRec;
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des invitations"+ex.getMessage());
            return null;
        }
    
    }

    @Override
    public boolean retrieveInvitationbyid(Client c, Evenement e) {
String requete ="select * from invitation i, evenement e, utilisateur u where i.evenement=" + e.getId_event()+" and i.participant="+c.getId();
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Invitation invitation = new Invitation();
            
            if (resultat.next()) {
                return true;
            }else
                return false;
          /*  while (resultat.next())
            {
              //  Invitation invitation = new Invitation();
                
                Client cl = new Client();
                cl.setId(resultat.getInt("participant"));
                cl  =  iCl.retrieveClientById(cl.getId());
                
                
                Evenement event = new Evenement();
                event.setId_event(resultat.getInt("evenement"));
                event = iVent.retrievEvenementById(event.getId_event());
                
                invitation.setClient(cl);
                invitation.setEvent(event);
                
                      
          invitation.setEtat( resultat.getString("etat"));
          invitation.setDateInvitation(resultat.getDate("date_invitation"));

                
                  
            }*/
         //return invitation;
            
            
        }catch (SQLException ex){
            System.out.println("erreur lors du chargement des invitations"+ex.getMessage());
            return true;
        }
        
        
        }

            @Override
    public boolean envoyerinvitation (Client c, Evenement e) {

String requete="INSERT INTO invitation (evenement,participant,etat) VALUES (?,?,?)";
        try{
        PreparedStatement pst = connexion.prepareStatement(requete);
        pst.setString(3,"En Attente");
        pst.setInt(1,e.getId_event());
                pst.setInt(2,c.getId());

        pst.executeUpdate();
            System.out.println("insertion effectuee avec succes");
        }
        catch (SQLException ex){
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("erreur lors de l'insertion"+ex.getMessage());
        }     
                return true;    }
    
    public Boolean deleteinvitation(int d){
        
        
        String requete = "DELETE FROM invitation WHERE evenement="+d;
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
             pst.executeUpdate();
            System.out.println("Supression effectuer avec succes");
            return  true;
            
        } catch (SQLException ex) {
            Logger.getLogger(EvenementDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
            @Override
    public Vector<Invitation> retrieveInvitationbyclient(Client c) {
        Vector<Invitation> listRec2 =new Vector<Invitation>();
      String requete ="select * from invitation where participant="+c.getId();
        try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
           
            
            
               while (resultat.next())
            {
                Invitation invitation = new Invitation();
                
                Client cl = new Client();
                cl.setId(resultat.getInt("participant"));
                cl  =  iCl.retrieveClientById(cl.getId());
                
                
                Evenement event = new Evenement();
                event.setId_event(resultat.getInt("evenement"));
                event = iVent.retrievEvenementById(event.getId_event());
                
                invitation.setClient(cl);
                invitation.setEvent(event);
                
                      
          invitation.setEtat( resultat.getString("etat"));
          invitation.setDateInvitation(resultat.getDate("date_invitation"));

                
                listRec2.add(invitation);
            }
               return listRec2;
        
        }
        catch (Exception ex){
            System.out.println("erreur lors du chargement des invitations"+ex.getMessage());
           return null;
        }
        
        
        
        
        
    
}
    
    
            @Override
    public void accepterDemandeinvitation(int idc,int ide) {
        String requete = "UPDATE invitation SET etat=? WHERE evenement="+ide+" and participant="+idc;
        
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1,"Accepté");
           
            
            pst.executeUpdate();
            System.out.println("acceptation  effectuer avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
            @Override
     public void refuserDemandeinvitation(int idc,int ide) {
        String requete = "UPDATE invitation SET etat=? WHERE evenement="+ide+" and participant="+idc;
        
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1,"Refusé");
           
            
            pst.executeUpdate();
            System.out.println("refut  effectuer avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
            @Override
     public Invitation retrieveInvitationbyclient2(int c , int e) {
      String requete ="select * from invitation where participant="+c+" and evenement="+e;
       Invitation invitation = new Invitation();
                       Evenement event = new Evenement();
       Client cl = new Client();
      try{
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
           
            
            if(resultat.next())
                
            {
                cl.setId(resultat.getInt("participant"));
                cl  =  iCl.retrieveClientById(cl.getId());
                
                
                event.setId_event(resultat.getInt("evenement"));
                event = iVent.retrievEvenementById(event.getId_event());
                
                invitation.setClient(cl);
                invitation.setEvent(event);
                
                      
          invitation.setEtat( resultat.getString("etat"));
          invitation.setDateInvitation(resultat.getDate("date_invitation"));

                
                return invitation;
        
        }
            return null;}
        catch (Exception ex){
            System.out.println("erreur lors du chargement des invitations"+ex.getMessage());
           return null;
        }
        
        
        
        
        
    
}
}
