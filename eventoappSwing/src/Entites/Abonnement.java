/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.Date;



public class Abonnement {
  private  int id;
  private String type;
  Date date_debut;
  Date date_fin;
  Utilisateur prestataire;
public Abonnement()
{}

    public Abonnement(String type, Date date_debut, Date date_fin, Utilisateur id_prest) {
        this.type = type;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prestataire = id_prest;
    }



public Abonnement(int id,String type,Date a ,Date b ,Utilisateur id_prest)
{
this.id=id;
this.type=type;
this.date_debut=a;
this.date_fin=b;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
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
        final Abonnement other = (Abonnement) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Utilisateur getPrestataire() {
        return prestataire;
    }

    public void setPrestataire(Utilisateur prestataire) {
        this.prestataire = prestataire;
    }

    

    




}