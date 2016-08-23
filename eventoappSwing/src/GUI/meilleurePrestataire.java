/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DaoClasse.EvenementDAO;
import DaoClasse.PrestataireDao;
import DaoClasse.UtilisateurDao;
import DaoInterface.IEvenementDAO;
import DaoInterface.IPrestataireDao;
import DaoInterface.IUtilisateurDao;
import Entites.Evenement;
import Entites.Prestataire;
import Entites.Utilisateur;
import Technique.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author GaiaDev
 */
public class meilleurePrestataire {
    
    DefaultPieDataset dataset;//Dataset qui va contenir les Données
    JFreeChart graphe;        //Graphe
    ChartPanel cp;   //Panel
    IUtilisateurDao userDAO = new UtilisateurDao();
    List<Utilisateur> utilisateurs = new ArrayList<>();

    public  ChartPanel getCp() {
        return cp;
    }

    public  void setCp(ChartPanel cp) {
        this.cp = cp;
    }
    
    
 
    public meilleurePrestataire() throws SQLException {
        
            dataset = new DefaultPieDataset();
            Connection connexion = MyConnection.getInstance();
            String requete ="select * from evaluationprestataire";
            Statement statement= connexion.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next())
            { 
                
            dataset.setValue(userDAO.retrieveUtilisateurById(resultat.getInt(2)).getNom()+" : "+resultat.getInt(3),
                    resultat.getInt(3) );
            
            }
        graphe = ChartFactory.createPieChart3D("Les notes des prestataires", dataset,true ,true ,false);
        cp = new ChartPanel(graphe);
        
    }
   
}
