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
 * @author walid
 */
public class Offre {
    private int id ;
    private String titre;
    private float prix;
    private String type;
    private String description;
    private Date date_debut;
    private Date date_fin;
    private Utilisateur prestataire;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
   
    
    public Offre(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    

    public Offre(String titre, float prix, String description, Date date_debut, Date date_fin, Utilisateur prestataire) {
        this.titre = titre;
        this.prix = prix;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Offre(int id, String titre, float prix, String description, Date date_debut, Date date_fin, Utilisateur prestataire) {
        this.id = id;
        this.titre = titre;
        this.prix = prix;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

   
    
    
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.titre);
        hash = 67 * hash + Float.floatToIntBits(this.prix);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.date_debut);
        hash = 67 * hash + Objects.hashCode(this.date_fin);
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
        final Offre other = (Offre) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.date_debut, other.date_debut)) {
            return false;
        }
        if (!Objects.equals(this.date_fin, other.date_fin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", titre=" + titre + ", prix=" + prix + ", type=" + type + ", description=" + description + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", prestataire=" + prestataire + '}';
    }
    
    public void affiche()
    {
    System.out.println(this.toString());
    }
    
}
