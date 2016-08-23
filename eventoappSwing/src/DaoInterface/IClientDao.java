/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DaoInterface;

import Entites.Client;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Seif
 */
public interface IClientDao {
    
    public boolean insertClient(Client client);
    public boolean updateClient(Client client);
    public boolean deleteClient(int id);
    public Client retrieveClientById(int id);
    public List<Client> retrieveAllClient();
    
}
