/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DaoClasse.OffreDao;
import DaoInterface.IOffreDao;
import Entites.DemandeOffre;
import Entites.Prestataire;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Seif
 */

public class TableModelDemandeOffre extends AbstractTableModel{
    
        String[] titres = {"Id offre" , "Id Client","Titre","Client","Prestataire","Etat"};
        List<DemandeOffre> demandes = new ArrayList<>();
         IOffreDao i = new OffreDao();
        Prestataire p = new Prestataire();
    
       
        

    public TableModelDemandeOffre(int pi) {
        
       demandes=i.afficheMesDemandeEnAttente(pi);
    
    }
    
     public TableModelDemandeOffre(Prestataire p) {
        
       demandes=i.afficheMesDemandes(p);
    
    }
     
  
        

    @Override
    public int getRowCount() {
   return demandes.size();    }

    @Override
    public int getColumnCount() {
 return titres.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
   switch(columnIndex){
            case 0 : return demandes.get(rowIndex).getOffre().getId();
            case 1 :  return demandes.get(rowIndex).getClient().getId();
             case 2 : return demandes.get(rowIndex).getOffre().getTitre();
               case 3 : return demandes.get(rowIndex).getClient().getNom();
                   case 4 : return demandes.get(rowIndex).getOffre().getPrestataire().getNom();
                       case 5 : return demandes.get(rowIndex).getEtat();
                       
            default:
               return null;      
        
    }
   
}
    @Override
    public String getColumnName(int column) {
        return titres[column];
    }
    
}