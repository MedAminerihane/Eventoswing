/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entites;

/**
 *
 * @author Seif
 */
public class DemandeOffre {
    String etat;
    Client client;
    Offre offre;



    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public DemandeOffre(int id, String etat, Client client, Offre offre) {
     
        this.etat = etat;
        this.client = client;
        this.offre = offre;
    }

    public DemandeOffre() {
    }


    @Override
    public String toString() {
        return   "client= " + client.getNom() + ", offre= " + offre.getTitre();
    }

  
    
}
