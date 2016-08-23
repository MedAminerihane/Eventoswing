/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoInterface;

import Entites.Evenement;
import java.util.List;

/**
 *
 * @author GaiaDev
 */
public interface IEvenementDAO {
 
    /**
     *
     * @param evenement
     */
    public void insertEvenement(Evenement evenement);
    public void updateEvenement(Evenement evenement);
    public void deleteEvenement(int d);
    public Evenement retrievEvenementById(int id);
    public List<Evenement> DisplayAllEvent();
    
         public List<Evenement> retrievEvenementByName(String nom);
          public List<Evenement> retrievEvenementByNameandID(String titre, int id);
          public Float calculernote(int e);
                    public int retrievEventIdMax();

          
}