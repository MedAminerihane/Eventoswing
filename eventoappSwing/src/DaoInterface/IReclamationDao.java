/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoInterface;

import Entites.Reclamation;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author IDRISS
 */
public interface IReclamationDao {
      public boolean insertReclamation(Reclamation rec);
    public boolean updateReclamation(Reclamation rec);
    public boolean deleteReclamation(int id);
    public Reclamation retrieveReclamationById(int id);
    public Vector<Reclamation> retrieveAllReclamation();
}
