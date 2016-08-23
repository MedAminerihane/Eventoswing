/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import DaoClasse.ParticipationDao;
import DaoInterface.IParticipation;
import Entites.Client;
import Entites.Invitation;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author GaiaDev
 */
public class TableModelInvitation extends AbstractTableModel{


        String[] titres = {"Id Evenement","Nom Evenement","Date Invitation","Etat"};
        List<Invitation> inv=new ArrayList<Invitation>();
        
        public TableModelInvitation (Client c){
            IParticipation parti = new ParticipationDao();
          //  evenements=eventDAO.DisplayAllEvent();
            inv=parti.retrieveInvitationbyclient(c);
        }
        
     
         
        
        @Override
    public int getRowCount() {
        return inv.size();
        
    }

    @Override
    public int getColumnCount() {
        return titres.length;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0: return inv.get(rowIndex).getEvent().getId_event();
            case 1 : return inv.get(rowIndex).getEvent().getNom_event();
             case 2 : return inv.get(rowIndex).getDateInvitation();
               case 3 : return inv.get(rowIndex).getEtat();
                       
            default:
               return null;      
        
        
        }
        
        
    }
    
    @Override
    public String getColumnName(int column) {
        return titres[column];
    }
    
}
