/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoInterface;

import Entites.Galerie;
import java.util.Vector;

/**
 *
 * @author IDRISS
 */
public interface IGalerieDao {
    
    public boolean insertPicture(Galerie gal);
    public boolean updatePictureevent(Galerie gal);
    public boolean updatePictureoffre(Galerie gal);
    public boolean deleteReclamation(int id);
    public Galerie retrievePictureById(int id);
    public Vector<Galerie> retrieveAllPicture();
    
}
