/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoClasse;

import DaoInterface.IClientDao;
import Entites.Client;
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
 * @author Seif
 */
public class ClientDao implements IClientDao{
    Connection connexion = MyConnection.getInstance();
    @Override
    public boolean insertClient(Client client) {

        String requete = "INSERT INTO utilisateur (nom,adresse,email,tel,password,prenom,age,cin,nature,username,locked,enabled,username_canonical,email_canonical,salt) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1, client.getNom());
            pst.setString(2, client.getAdresse());
            pst.setString(3, client.getMail());
            pst.setInt(4, client.getTel());
            pst.setString(5, client.getPassword());
            pst.setString(6, client.getPrenom());
            pst.setInt(7, client.getAge());
            pst.setInt(8, client.getCin());
            pst.setInt(9, client.getNature());
            pst.setString(10, client.getUsername());
            pst.setInt(11, 0);
            pst.setInt(12, 1);
            pst.setString(13, client.getUsername());
            pst.setString(14, client.getMail());
            pst.setString(15, client.getPassword());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("insertion avec succÃ©e");
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateClient(Client client) {
        String requete = "UPDATE utilisateur set nom=?, adresse=?, email=?, tel=?,password=?,prenom=?,age=?,cin=? where id=?";
        try {
            PreparedStatement pst = connexion.prepareStatement(requete);
            pst.setString(1, client.getNom());
            pst.setString(2, client.getAdresse());
            pst.setString(3, client.getMail());
            pst.setInt(4, client.getTel());
            pst.setString(5, client.getPassword());
            pst.setString(6, client.getPrenom());
            pst.setInt(7, client.getAge());
            pst.setInt(8, client.getCin());
            pst.setInt(9, client.getId());
            pst.executeUpdate();
            System.out.println("Mise a jour effectuee avec succes");
        } catch (SQLException ex) {
            //Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println("erreur lors de la mise a jour" + ex.getMessage());
        }
        return true;

    }

    @Override
    public boolean deleteClient(int id) {

        String requete = "DELETE FROM utilisateur where id=? And nature=1";
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
    public Client retrieveClientById(int id) {

        Client cl = new Client();

        String requete = "select * from utilisateur where id=" + id + " And nature=1";
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            if (resultat.next()) {

                cl.setId(resultat.getInt("id"));
                cl.setNom(resultat.getString("nom"));
                cl.setAdresse(resultat.getString("adresse"));
                cl.setMail(resultat.getString("email"));
                cl.setTel(resultat.getInt("tel"));
                cl.setPassword(resultat.getString("password"));
                cl.setPrenom(resultat.getString("prenom"));
                cl.setAge(resultat.getInt("age"));
                cl.setCin(resultat.getInt("cin"));
                cl.setUsername(resultat.getString("username"));
                cl.setLocked(resultat.getInt("locked"));
                cl.setEnabled(resultat.getInt("enabled"));

            }
            return cl;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des clients " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Client> retrieveAllClient() {
        List<Client> listclient = new ArrayList<Client>();
        String requete = "select * from utilisateur where nature=1";
        try {
            Statement statement = connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Client cl = new Client();
                cl.setId(resultat.getInt("id"));
                cl.setNom(resultat.getString("nom"));
                cl.setAdresse(resultat.getString("adresse"));
                cl.setMail(resultat.getString("email"));
                cl.setTel(resultat.getInt("tel"));
                cl.setPassword(resultat.getString("password"));
                cl.setPrenom(resultat.getString("prenom"));
                cl.setAge(resultat.getInt("age"));
                cl.setCin(resultat.getInt("cin"));
                cl.setNature(resultat.getByte("nature"));
                cl.setUsername(resultat.getString("username"));
                cl.setLocked(resultat.getInt("locked"));
                cl.setEnabled(resultat.getInt("enabled"));

                listclient.add(cl);
            }
            System.out.println("succÃ©es");
            return listclient;

        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des clients" + ex.getMessage());
            return null;
        }

    }

}
