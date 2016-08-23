/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOinterface;

import Entites.Utilisateur;
import Entites.Evenement;
import java.util.List;

/**
 *
 * @author GaiaDev
 */
public interface Ievaluation {
    public Boolean evaluerevenement(int note ,Evenement e,Utilisateur u);
    
    
    
}
