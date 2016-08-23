/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author GaiaDev
 */
public class Evenement {
    
        private int id_event;
        private String nom_event;
        private String lieu_event;
        private Date date_debut_event;
        private Date date_fin_event;
        private String confidentialite_event;
        private String description_event;
        private float prix_event;
        private Utilisateur user;
        private String type_event;
        
    public Evenement() {
    }

    public Evenement(int id_event, String nom_event, String lieu_event, Date date_debut_event, Date date_fin_event, String confidentialite_event, String description_event, float prix_event, Utilisateur user, String type_event) {
        this.id_event = id_event;
        this.nom_event = nom_event;
        this.lieu_event = lieu_event;
        this.date_debut_event = date_debut_event;
        this.date_fin_event = date_fin_event;
        this.confidentialite_event = confidentialite_event;
        this.description_event = description_event;
        this.prix_event = prix_event;
        this.user = user;
        this.type_event = type_event;
    }

    public Evenement(String nom_event, String lieu_event, Date date_debut_event, Date date_fin_event, String confidentialite_event, String description_event, float prix_event, Utilisateur user, String type_event) {
        this.nom_event = nom_event;
        this.lieu_event = lieu_event;
        this.date_debut_event = date_debut_event;
        this.date_fin_event = date_fin_event;
        this.confidentialite_event = confidentialite_event;
        this.description_event = description_event;
        this.prix_event = prix_event;
        this.user = user;
        this.type_event = type_event;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.id_event;
        hash = 31 * hash + Objects.hashCode(this.nom_event);
        hash = 31 * hash + Objects.hashCode(this.lieu_event);
        hash = 31 * hash + Objects.hashCode(this.date_debut_event);
        hash = 31 * hash + Objects.hashCode(this.date_fin_event);
        hash = 31 * hash + Objects.hashCode(this.confidentialite_event);
        hash = 31 * hash + Objects.hashCode(this.description_event);
        hash = 31 * hash + Float.floatToIntBits(this.prix_event);
        hash = 31 * hash + Objects.hashCode(this.user);
        hash = 31 * hash + Objects.hashCode(this.type_event);
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
        final Evenement other = (Evenement) obj;
        if (this.id_event != other.id_event) {
            return false;
        }
        if (!Objects.equals(this.nom_event, other.nom_event)) {
            return false;
        }
        if (!Objects.equals(this.lieu_event, other.lieu_event)) {
            return false;
        }
        if (!Objects.equals(this.date_debut_event, other.date_debut_event)) {
            return false;
        }
        if (!Objects.equals(this.date_fin_event, other.date_fin_event)) {
            return false;
        }
         if (!Objects.equals(this.confidentialite_event, other.confidentialite_event)) {
            return false;
        }
        if (!Objects.equals(this.description_event, other.description_event)) {
            return false;
        }
        if (Float.floatToIntBits(this.prix_event) != Float.floatToIntBits(other.prix_event)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.type_event, other.type_event)) {
            return false;
        }
        return true;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNom_event() {
        return nom_event;
    }

    public void setNom_event(String nom_event) {
        this.nom_event = nom_event;
    }

    public String getLieu_event() {
        return lieu_event;
    }

    public void setLieu_event(String lieu_event) {
        this.lieu_event = lieu_event;
    }

    public Date getDate_debut_event() {
        return date_debut_event;
    }

    public void setDate_debut_event(Date date_debut_event) {
        this.date_debut_event = date_debut_event;
    }

    public Date getDate_fin_event() {
        return date_fin_event;
    }

    public void setDate_fin_event(Date date_fin_event) {
        this.date_fin_event = date_fin_event;
    }

    public String getConfidentialite_event() {
        return confidentialite_event;
    }

    public void setConfidentialite_event(String confidentialite_event) {
        this.confidentialite_event = confidentialite_event;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public float getPrix_event() {
        return prix_event;
    }

    public void setPrix_event(float prix_event) {
        this.prix_event = prix_event;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public String getType_event() {
        return type_event;
    }

    public void setType_event(String type_event) {
        this.type_event = type_event;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_event=" + id_event + ", nom_event=" + nom_event + ", lieu_event=" + lieu_event + ", date_debut_event=" + date_debut_event + ", date_fin_event=" + date_fin_event + ", confidentialite_event=" + confidentialite_event + ", description_event=" + description_event + ", prix_event=" + prix_event + ", user=" + user + ", type_event=" + type_event + '}';
    }
        
        
        
        
        
        
        
}