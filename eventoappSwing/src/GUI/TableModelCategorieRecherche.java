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
 * @author user
 */
public class TableModelCategorieRecherche extends AbstractTableModel
{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
    
        String [] titres = {"id","titre","prix","type","description","date debut","date fin","Nom prestataire"};
        List<Offre> offre = new ArrayList<>();
        OffreDao k=new OffreDao();
        public TableModelCategorieRecherche (int x, int y , String cat){
           
            offre=k.DisplaybyprixandCategorie(x,y,cat);
            
        }

        @Override
    public String getColumnName(int column) {
        return titres[column];
    }
    
    @Override
    public int getRowCount() {
        return offre.size();
        
    }

    @Override
    public int getColumnCount() {
        return titres.length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0 : return offre.get(rowIndex).getId();
             case 1 : return offre.get(rowIndex).getTitre();
               case 2 : return offre.get(rowIndex).getPrix();
                   case 3 : return offre.get(rowIndex).getType();
                       case 4 : return offre.get(rowIndex).getDescription();
                           case 5 : return offre.get(rowIndex).getDate_debut();
                               case 6 : return offre.get(rowIndex).getDate_fin();
                                    case 7 : return offre.get(rowIndex).getPrestataire().getNom();
            default:
               return null;      
        
        
        }
        
        
    }
     
   
       
}
