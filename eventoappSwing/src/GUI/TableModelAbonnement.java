/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import DaoClasse.AbonnementDAO;
import DaoInterface.Igererabonnement;
import Entites.Abonnement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Seif
 */
public class TableModelAbonnement extends AbstractTableModel{
     String[] titres = {"Id","Type","date_debut","date_fin","prestatire"};
             List<Abonnement> abonnements = new ArrayList<>();


   public TableModelAbonnement (){
       Igererabonnement iAbon = new AbonnementDAO();
       abonnements= iAbon.DisplayAllAbonnement();
      
        }
        
        @Override
    public int getRowCount() {
        return abonnements.size();
        
    }

    @Override
    public int getColumnCount() {
        return titres.length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0 : return abonnements.get(rowIndex).getId();
             case 1 : return abonnements.get(rowIndex).getType();
               case 2 : return abonnements.get(rowIndex).getDate_debut();
                   case 3 : return abonnements.get(rowIndex).getDate_fin();
                       case 4 : return abonnements.get(rowIndex).getPrestataire().getNom();
                       
            default:
               return null;      
        
        
        }
        
        
    }
    
    @Override
    public String getColumnName(int column) {
        return titres[column];
    }
}
