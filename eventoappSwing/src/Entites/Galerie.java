/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.Objects;

/**
 *
 * @author IDRISS
 */
public class Galerie {
    private int id;
    private String url;
    private Evenement event;
    private Offre offre;
    private int type;

    public Galerie(String url, Evenement event, int type) {
        this.url = url;
        this.event = event;
        this.type = type;
    }

    public Galerie(String url, Offre offre, int type) {
        this.url = url;
        this.offre = offre;
        this.type = type;
    }

    public Galerie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Evenement getEvent() {
        return event;
    }

    public void setEvent(Evenement event) {
        this.event = event;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.url);
        hash = 47 * hash + Objects.hashCode(this.event);
        hash = 47 * hash + Objects.hashCode(this.offre);
        hash = 47 * hash + this.type;
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
        final Galerie other = (Galerie) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.event, other.event)) {
            return false;
        }
        if (!Objects.equals(this.offre, other.offre)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Galerie{" + "id=" + id + ", url=" + url + ", event=" + event + ", offre=" + offre + ", type=" + type + '}';
    }
    
    
          
    
}
