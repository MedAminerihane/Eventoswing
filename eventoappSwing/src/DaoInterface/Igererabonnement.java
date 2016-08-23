/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoInterface;

import Entites.Abonnement;
import Entites.Utilisateur;
import java.util.List;



/**
 *
 * @author user
 */
public interface Igererabonnement {
        public void ajouterabonnement(Abonnement abonnement);
        public void supprimerabonnement(int id);
        public void modifierabonnement(Abonnement a);
         public Abonnement retrievEvenementById(int id);
    public List<Abonnement> DisplayAllAbonnement();
        public void ajouterabonnement(Abonnement abonnement,Utilisateur prest);

    
}
