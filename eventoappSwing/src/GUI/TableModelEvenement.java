/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DaoClasse.EvenementDAO;
import DaoInterface.IEvenementDAO;
import Entites.Evenement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author GaiaDev
 */
public class TableModelEvenement extends AbstractTableModel{

            IEvenementDAO test = new EvenementDAO();

        String[] titres = {"Id","Titre","Lieu","date_debut","date_fin","note"};
        List<Evenement> evenements = new ArrayList<>();
        
        public TableModelEvenement (String titre){
            IEvenementDAO eventDAO = new EvenementDAO();
          //  evenements=eventDAO.DisplayAllEvent();
            evenements=eventDAO.retrievEvenementByName(titre);
        }
        
     
             public TableModelEvenement (String titre, int id){
            IEvenementDAO eventDAO = new EvenementDAO();
          //  evenements=eventDAO.DisplayAllEvent();
            evenements=eventDAO.retrievEvenementByNameandID(titre,id);
        }
        
        @Override
    public int getRowCount() {
        return evenements.size();
        
    }

    @Override
    public int getColumnCount() {
        return titres.length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0 : return evenements.get(rowIndex).getId_event();
             case 1 : return evenements.get(rowIndex).getNom_event();
               case 2 : return evenements.get(rowIndex).getLieu_event();
                   case 3 : return evenements.get(rowIndex).getDate_debut_event();
                       case 4 : return evenements.get(rowIndex).getDate_fin_event();
                       case 5 : return test.calculernote(evenements.get(rowIndex).getId_event());
                       
            default:
               return null;      
        
        
        }
        
        
    }
    
    @Override
    public String getColumnName(int column) {
        return titres[column];
    }
    
}
