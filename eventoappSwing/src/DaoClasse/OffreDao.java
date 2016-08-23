/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoClasse;

import DaoInterface.IClientDao;
import DaoInterface.IOffreDao;
import DaoInterface.IUtilisateurDao;
import Entites.DemandeOffre;
import Entites.Offre;
import Entites.Prestataire;
import Entites.Utilisateur;
import Technique.MyConnection;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.ui.tabbedui.RootPanel;

/**
 *
 * @author wald
 */
public class OffreDao implements IOffreDao{
    Connection connexion = MyConnection.getInstance();
    private Object prepareStatement;

    @Override
    public void insertOffre(Offre offre) {
        String requete = "INSERT INTO offre(titre,prix,description,date_debut,date_fin,id_prestataire,categorie) VALUES(?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1, offre.getTitre());
            pst.setFloat(2, offre.getPrix());
            pst.setString(3, offre.getDescription());
            java.sql.Date d1=new java.sql.Date(offre.getDate_debut().getTime());
            java.sql.Date d2=new java.sql.Date(offre.getDate_fin().getTime());
            pst.setDate(4, d1);
            pst.setDate(5, d2);
            pst.setInt(6,offre.getPrestataire().getId());
            pst.setString(7,offre.getType());
            pst.executeUpdate();
            System.out.println("insertion effectuer avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    @Override
    public void updateOffre(Offre offre) {
        String requete = "UPDATE offre SET titre=?,"
                + "prix=?,"
                + "description=?,"
                + "date_debut=?,"
                + "date_fin=?"
                + "WHERE id="+offre.getId();
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1, offre.getTitre());
            pst.setFloat(2, offre.getPrix());
            pst.setString(3, offre.getDescription());
            java.sql.Date d1=new java.sql.Date(offre.getDate_debut().getTime());
            java.sql.Date d2=new java.sql.Date(offre.getDate_fin().getTime());
            pst.setDate(4, d1);
            pst.setDate(5, d2);
            pst.executeUpdate();
            System.out.println("Mise à jour effectuer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void deleteOffre(int d) {
        String requete = "DELETE FROM offre WHERE id="+d;
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.executeUpdate();
             System.out.println("supression effectuer avec succes");
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public Offre retrievOffreById(int id) {
        Offre offre = new Offre();
        Utilisateur u=new Utilisateur();
        String requete = "SELECT * FROM offre where id="+id;
        System.out.println(requete);
        PreparedStatement pst;
        try {
            
            pst = connexion.prepareStatement(requete);
            
            ResultSet resultat = pst.executeQuery(requete);
            while (resultat.next()) { 
                  
                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setPrix(resultat.getFloat(3));
                offre.setDescription(resultat.getString(4));
                java.sql.Date d1=new java.sql.Date(resultat.getDate(5).getTime());
                java.sql.Date d2=new java.sql.Date(resultat.getDate(6).getTime());
                offre.setDate_debut(d1);
                offre.setDate_fin(d2);
                IUtilisateurDao k=new UtilisateurDao();
                offre.setPrestataire(k.retrieveUtilisateurById(resultat.getInt(7)));
                offre.setType(resultat.getString(8));
                //offre.setCategorie(resultat.getString(9));
                System.out.println("Affichage en cours");
            
              
            }    
             return offre;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
         return null;
        }
   
    
    }
       
    @Override
    public List<Offre> DisplayAllOffre() {
        List<Offre> L = new ArrayList<>();
        String requete = "SELECT * FROM offre";
        PreparedStatement pst;
        try {
            pst = connexion.prepareStatement(requete);
            ResultSet resultat = pst.executeQuery(requete);
            while (resultat.next()) { 
                Offre offre = new Offre();
                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setPrix(resultat.getFloat(3));
                offre.setDescription(resultat.getString(4));
                offre.setDate_debut(resultat.getDate(5));
                offre.setDate_fin(resultat.getDate(6));
                L.add(offre);
            
                System.out.println("Affichage en cours");
            }
                return L;
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<String> DisplayAllCategorie() {
        List<String> L = new ArrayList<>();
        String requete = "SELECT DISTINCT categorie FROM offre";
        PreparedStatement pst;
        try {
            pst = connexion.prepareStatement(requete);
            ResultSet resultat = pst.executeQuery(requete);
            while (resultat.next()) { 
               
                L.add(resultat.getString(1));
            
                System.out.println("Affichage en cours");
            }
                return L;
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Float getmax() {
        String requete = "SELECT MAX(prix) FROM offre";
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
    
      public Float getmin() {
        String requete = "SELECT MIN(prix) FROM offre";
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
      
    @Override
  public List<Offre> Recherchebyprix(int x, int y) {
        List<Offre> L = new ArrayList<>();
        String requete = "SELECT * FROM offre where prix BETWEEN " +x+" and "+y;
        System.out.println(requete);
        PreparedStatement pst;
        try {
            
            pst = connexion.prepareStatement(requete);
            ////pst.setInt(1,x);
          //  pst.setInt(2,y);
            ResultSet resultat = pst.executeQuery(requete);
            while (resultat.next()) { 
                Offre offre = new Offre();
                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setPrix(resultat.getFloat(3));
                offre.setType(resultat.getString(4));
                offre.setDescription(resultat.getString(5));
                java.sql.Date d1=new java.sql.Date(resultat.getDate(6).getTime());
            java.sql.Date d2=new java.sql.Date(resultat.getDate(7).getTime());
                offre.setDate_debut(d1);
                offre.setDate_fin(d2);
                IUtilisateurDao k=new UtilisateurDao();
                offre.setPrestataire(k.retrieveUtilisateurById(resultat.getInt(8)));
                L.add(offre);
            
                System.out.println("Affichage en cours");
            }
                return L;
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
  public List<Offre> DisplaybyprixandCategorie(int x , int y, String cat) {
        List<Offre> L = new ArrayList<>();
        String requete = "SELECT * FROM offre o where (o.prix BETWEEN " +x+" and "+y+") and (o.categorie='"+cat+"')";
        System.out.println(requete);
        PreparedStatement pst;
        try {
            
            pst = connexion.prepareStatement(requete);
            ////pst.setInt(1,x);
          //  pst.setInt(2,y);
            ResultSet resultat = pst.executeQuery(requete);
            while (resultat.next()) { 
                Offre offre = new Offre();
                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setPrix(resultat.getFloat(3));
                offre.setType(resultat.getString(8));
                offre.setDescription(resultat.getString(4));
                java.sql.Date d1=new java.sql.Date(resultat.getDate(5).getTime());
            java.sql.Date d2=new java.sql.Date(resultat.getDate(6).getTime());
                offre.setDate_debut(d1);
                offre.setDate_fin(d2);
                IUtilisateurDao k=new UtilisateurDao();
                offre.setPrestataire(k.retrieveUtilisateurById(resultat.getInt(7)));
                L.add(offre);
            
                System.out.println("Affichage en cours");
            }
            System.out.println(L);
                return L;
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
  }
  public List<Offre> Recherchebycategorie(String cat) {
        List<Offre> L = new ArrayList<>();
        String requete = "SELECT * FROM offre where categorie='"+cat+"'";
        System.out.println(requete);
        PreparedStatement pst;
        try {
            
            pst = connexion.prepareStatement(requete);
            ////pst.setInt(1,x);
          //  pst.setInt(2,y);
            ResultSet resultat = pst.executeQuery(requete);
            while (resultat.next()) { 
                Offre offre = new Offre();
                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setPrix(resultat.getFloat(3));
                offre.setDescription(resultat.getString(4));
                java.sql.Date d1=new java.sql.Date(resultat.getDate(5).getTime());
            java.sql.Date d2=new java.sql.Date(resultat.getDate(6).getTime());
                offre.setDate_debut(d1);
                offre.setDate_fin(d2);
                IUtilisateurDao k=new UtilisateurDao();
                offre.setPrestataire(k.retrieveUtilisateurById(resultat.getInt(7)));
                offre.setType(resultat.getString(8));
                L.add(offre);
            
                System.out.println("Affichage en cours");
            }
                return L;
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Offre> Recherchebytitre(String titre) {
List<Offre> L = new ArrayList<>();
        String requete = "SELECT * FROM offre where titre like '%"+titre+"%'";
        System.out.println(requete);
        PreparedStatement pst;
        try {
            
            pst = connexion.prepareStatement(requete);
            
            ResultSet resultat = pst.executeQuery(requete);
            while (resultat.next()) { 
                Offre offre = new Offre();
                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setPrix(resultat.getFloat(3));
                offre.setDescription(resultat.getString(4));
                java.sql.Date d1=new java.sql.Date(resultat.getDate(5).getTime());
            java.sql.Date d2=new java.sql.Date(resultat.getDate(6).getTime());
                offre.setDate_debut(d1);
                offre.setDate_fin(d2);
                IUtilisateurDao k=new UtilisateurDao();
                offre.setPrestataire(k.retrieveUtilisateurById(resultat.getInt(7)));
                offre.setType(resultat.getString(8));
                L.add(offre);
            
                System.out.println("Affichage en cours");
            }
                return L;
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }

    @Override
    public List<Offre> retrieveByNameandID(String titre, int id) {
        List<Offre> L = new ArrayList<>();
        String requete = "SELECT * FROM offre where titre like '%"+titre+"%' And id_prestataire="+id;
        System.out.println(requete);
        PreparedStatement pst;
        try {
            
            pst = connexion.prepareStatement(requete);
            
            ResultSet resultat = pst.executeQuery(requete);
            while (resultat.next()) { 
                Offre offre = new Offre();
                offre.setId(resultat.getInt(1));
                offre.setTitre(resultat.getString(2));
                offre.setPrix(resultat.getFloat(3));
                offre.setDescription(resultat.getString(4));
                java.sql.Date d1=new java.sql.Date(resultat.getDate(5).getTime());
            java.sql.Date d2=new java.sql.Date(resultat.getDate(6).getTime());
                offre.setDate_debut(d1);
                offre.setDate_fin(d2);
                IUtilisateurDao k=new UtilisateurDao();
                offre.setPrestataire(k.retrieveUtilisateurById(resultat.getInt(7)));
                offre.setType(resultat.getString(8));
                L.add(offre);
            
                System.out.println("Affichage en cours");
            }
                return L;
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }


public boolean insertDemandeOffre(int idoffre,int client) {
        String requete = "INSERT INTO demandeoffre(id_offre,id_client,etat) VALUES(?,?,?)";
        
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setInt(1,idoffre);
            pst.setFloat(2,client);
            pst.setString(3,"En Attente");
            
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);

            return false;

    }
}

    @Override
    public void accepterDemandeOffre(int ido,int idc) {
        String requete = "UPDATE demandeoffre SET etat=? WHERE id_offre="+ido+" And id_client="+idc;
        
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1,"Accepté");
           
            
            pst.executeUpdate();
            System.out.println("acceptation  effectuer avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

/*public void accepterDemandeOffre(int idp,int idc) {
        String requete = "UPDATE demandeoffre SET etat=? WHERE id_prestataire="+idp+" and id_client"+idc;
        
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1,"Accepté");
           
            
            pst.executeUpdate();
            System.out.println("acceptation  effectuer avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }*/




/*public void refuserDemandeOffre(int idp,int idc) {
        String requete = "UPDATE demandeoffre SET etat=? WHERE id_prestataire="+idp+" and id_client"+idc;
        
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1,"refusé");
           
            
            pst.executeUpdate();
            System.out.println("refut  effectuer avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }*/

@Override
    public void refuserDemandeOffre(int ido,int idc) {
        String requete = "UPDATE demandeoffre SET etat=? WHERE id_offre="+ido+" AND id_client="+idc;
        System.out.println(requete);
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
    public List<DemandeOffre> afficheDemandeEnAttente() {
        List<DemandeOffre> L = new ArrayList<>();
        String requete = "SELECT * FROM demandeoffre where etat='En Attente'";
        System.out.println(requete);
        PreparedStatement pst;
        IClientDao cd =new ClientDao();
        IOffreDao od = new OffreDao();
        
        try {
            
            pst = connexion.prepareStatement(requete);
            
            ResultSet resultat = pst.executeQuery(requete);
            while (resultat.next()) { 
                            DemandeOffre d = new DemandeOffre();

                d.setClient(cd.retrieveClientById(resultat.getInt(2)));
                d.setOffre(od.retrievOffreById(resultat.getInt(1)));
                d.setEtat(resultat.getString(3));
                L.add(d);
            
                System.out.println("Affichage en cours");
            }
                return L;
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    
    
    public List<DemandeOffre> afficheMesDemandeEnAttente(int p) {
  
        List<DemandeOffre> L = new ArrayList<>();
        String requete = "SELECT * FROM demandeoffre o,offre of where (o.id_offre=of.id) AND  (o.etat='En Attente' )AND (of.id_prestataire="+p+")";
        System.out.println(requete);
        PreparedStatement pst;
        IClientDao cd =new ClientDao();
        IOffreDao od = new OffreDao();
        
        try {
            
            pst = connexion.prepareStatement(requete);
            
            ResultSet resultat = pst.executeQuery(requete);
            while (resultat.next()) { 
                DemandeOffre d = new DemandeOffre();
                d.setClient(cd.retrieveClientById(resultat.getInt(2)));
                d.setOffre(od.retrievOffreById(resultat.getInt(1)));
                d.setEtat(resultat.getString(3));
                L.add(d);
            
            }
                
           
            return L;
                
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    
    
    public List<DemandeOffre> afficheMesDemandes(Prestataire p) {
  
        List<DemandeOffre> L = new ArrayList<>();
        String requete = "SELECT * FROM demandeoffre o,offre of where (o.id_offre=of.id) AND (of.id_prestataire="+p.getId()+")";
        System.out.println(requete);
        PreparedStatement pst;
        IClientDao cd =new ClientDao();
        IOffreDao od = new OffreDao();
        
        try {
            
            pst = connexion.prepareStatement(requete);
            
            ResultSet resultat = pst.executeQuery(requete);
            while (resultat.next()) { 
                DemandeOffre d = new DemandeOffre();
                d.setClient(cd.retrieveClientById(resultat.getInt(2)));
                d.setOffre(od.retrievOffreById(resultat.getInt(1)));
                d.setEtat(resultat.getString(3));
                L.add(d);
            
            }
                
           
            return L;
                
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }

}



