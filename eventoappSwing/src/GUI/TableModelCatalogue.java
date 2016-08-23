
package GUI;

import DaoClasse.OffreDao;
import Entites.Offre;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class TableModelCatalogue extends AbstractTableModel
{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
    
        String [] titres = {"id","titre","prix","type","description","date debut","date fin","Nom prestataire"};
        List<Offre> catalogue = new ArrayList<>();
        OffreDao g=new OffreDao();
        public TableModelCatalogue (String cat){
           
            catalogue=g.Recherchebycategorie(cat);
            //System.out.println(cat);
            //catalogue.get(0).affiche();
        }
        @Override
    public String getColumnName(int column) {
        return titres[column];
    }
    
    @Override
    public int getRowCount() {
        return catalogue.size();
        
    }

    @Override
    public int getColumnCount() {
        return titres.length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0 : return catalogue.get(rowIndex).getId();
             case 1 : return catalogue.get(rowIndex).getTitre();
               case 2 : return catalogue.get(rowIndex).getPrix();
                   case 3 : return catalogue.get(rowIndex).getType();
                       case 4 : return catalogue.get(rowIndex).getDescription();
                           case 5 : return catalogue.get(rowIndex).getDate_debut();
                               case 6 : return catalogue.get(rowIndex).getDate_fin();
                                    //case 7 : return catalogue.get(rowIndex).getPrestataire().getNom();
            default:
               return null;      
        
        
        }
        
        
    }
     
   
       
}
 

