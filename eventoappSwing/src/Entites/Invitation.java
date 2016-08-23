/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author IDRISS
 */
public class Invitation {
   
    private Evenement event;
    private Client client;
    private Date dateInvitation;
    private String etat;

    public Invitation() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.event);
        hash = 31 * hash + Objects.hashCode(this.client);
        hash = 31 * hash + Objects.hashCode(this.dateInvitation);
        hash = 31 * hash + Objects.hashCode(this.etat);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Invitation other = (Invitation) obj;
        if (!Objects.equals(this.event, other.event)) {
            return false;
        }
        if (!Objects.equals(this.client, other.client)) {
            return false;
        }
        if (!Objects.equals(this.dateInvitation, other.dateInvitation)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  event.getNom_event() +"     "+event.getUser().getNom()+"     "+  dateInvitation +"     "+  etat;
    }

 

    public Evenement getEvent() {
        return event;
    }

    public void setEvent(Evenement event) {
        this.event = event;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateInvitation() {
        return dateInvitation;
    }

    public void setDateInvitation(Date dateInvitation) {
        this.dateInvitation = dateInvitation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

   
    
    
}
