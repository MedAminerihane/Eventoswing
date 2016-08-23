/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoInterface;

import Entites.Admin;
import Entites.Offre;
import java.util.List;

/**
 *
 * @author majed
 */
public interface IAdminDao {
    
    public boolean ajouterAdmin(Admin admin);
        public boolean supprimerAdmin(int id);
            public boolean modifierAdmin(Admin admin);
                public Admin rechercherAdmin(int id);
                public List<Admin> retriveAllAdmin();



}
