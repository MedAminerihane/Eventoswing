/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoInterface;

import Entites.Prestataire;
import java.util.List;

/**
 *
 * @author Seif
 */
public interface IPrestataireDao {
    
    public boolean insertPrestataire(Prestataire prestataire);
    public boolean updatePrestataire(Prestataire prestataire);
    public boolean deletePrestataire(int id);
    public Prestataire retrievePrestataireById(int id);
    public List<Prestataire> retrieveAllPrestataire();
    public Prestataire retrievePrestataireByName(String titre);
}
