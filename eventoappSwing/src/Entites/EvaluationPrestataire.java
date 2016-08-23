package Entites;

import java.util.Objects;

public class EvaluationPrestataire {
    private int id;
    private Utilisateur user;
    private Utilisateur presataire;
    private int note;
    
    public EvaluationPrestataire()
    {}
    
    public EvaluationPrestataire(int id , Utilisateur  u ,Utilisateur v ,int note)
    {
    this.id=id;
    this.user=u;
    this.presataire=v;
    this.note=note;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
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
        final EvaluationPrestataire other = (EvaluationPrestataire) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EvaluationPrestataire{" + "id=" + id + ", user=" + user + ", presataire=" + presataire + ", note=" + note + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Utilisateur getPresataire() {
        return presataire;
    }

    public void setPresataire(Utilisateur presataire) {
        this.presataire = presataire;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
    
    
}

   