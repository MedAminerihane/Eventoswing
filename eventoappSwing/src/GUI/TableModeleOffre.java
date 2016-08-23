/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DaoClasse.OffreDao;
import DaoInterface.IOffreDao;
import Entites.Offre;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Seif
 */
public class TableModeleOffre extends AbstractTableModel{
String[] titres = {"Id","Titre","date_debut","date_fin"};

        List<Offre> offres = new ArrayList<>();

    public TableModeleOffre(String titre) {
        
        
          IOffreDao offreDAO = new OffreDao();
          //  evenements=eventDAO.DisplayAllEvent();
            offres=offreDAO.Recherchebytitre(titre);
    }
          public TableModeleOffre(String titre , int id) {
        
        
          IOffreDao offreDAO = new OffreDao();
          //  evenements=eventDAO.DisplayAllEvent();
            offres=offreDAO.retrieveByNameandID(titre, id);
    }
        
        
    @Override
    public int getRowCount() {
   return offres.size();    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0 : return offres.get(rowIndex).getId();
             case 1 : return offres.get(rowIndex).getTitre();
               case 2 : return offres.get(rowIndex).getDate_debut();
                   case 3 : return offres.get(rowIndex).getDate_fin();
                       
            default:
               return null;      
        
        
        }
        
    }

 
    @Override
    public int getColumnCount() {
   return titres.length;    }
    
@Override
     public String getColumnName(int column) {
        return titres[column];
    }
    
    
}
