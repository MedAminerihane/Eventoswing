/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoInterface;

import Entites.Client;
import Entites.Evenement;
import Entites.Invitation;
import Entites.Reclamation;
import java.util.Vector;

/**
 *
 * @author IDRISS
 */
public interface IParticipation {
       //idriss
    public boolean participerEvenement(Client c, Evenement e);
    //public boolean accepterInvitation(Client c,Evenement e, String ch);
        public boolean envoyerinvitation (Client c, Evenement e);
        public Vector<Invitation> retrieveAllInvitation();

     public boolean retrieveInvitationbyid(Client c , Evenement e);
     public Boolean deleteinvitation(int d);
     public Vector<Invitation> retrieveInvitationbyclient(Client c);
     public Invitation retrieveInvitationbyclient2(int c , int e);
     public void accepterDemandeinvitation(int idc,int ide);
     public void refuserDemandeinvitation(int idc,int ide);
}
