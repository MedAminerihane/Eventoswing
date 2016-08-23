/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoInterface;

import Entites.Utilisateur;
import java.util.List;

/**
 *
 * @author Seif
 */
public interface IUtilisateurDao {

    public boolean deleteUtilisateur(int id);
    public Utilisateur retrieveUtilisateurById(int id);
    public List<Utilisateur> retrieveAllUtilisateur();
    public boolean bloquerutilisateur(int id);
  
}
