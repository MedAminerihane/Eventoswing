package GUI;

import DaoClasse.EvenementDAO;
import DaoInterface.IEvenementDAO;
import Entites.Evenement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class StatistiquesNbParticipant extends JFrame  {
    DefaultPieDataset dataset;//Dataset qui va contenir les Données
    JFreeChart graphe;        //Graphe
    ChartPanel cp;   //Panel
    IEvenementDAO eventDAO = new EvenementDAO();
    List<Evenement> evenements = new ArrayList<>();
    
     public StatistiquesNbParticipant() {
         
        dataset = new DefaultPieDataset();
        evenements = eventDAO.DisplayAllEvent();
         for (Evenement evenement : evenements) 
         {
        dataset.setValue(evenement.getNom_event()+" : " + evenement.getPrix_event() ,
                evenement.getPrix_event()); 
         }
        graphe = ChartFactory.createPieChart3D("Top événements", dataset,true ,true ,false);
        cp = new ChartPanel(graphe);
        
    }

    public ChartPanel getCp() {
        return cp;
    }

    public void setCp(ChartPanel cp) {
        this.cp = cp;
    }

   
	 
} 