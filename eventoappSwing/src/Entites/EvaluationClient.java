package Entites;

import java.util.Objects;

public class EvaluationClient {
    private int id;
    private Utilisateur user;
    private Evenement event;
    private int note;
    
    public EvaluationClient()
    {}
    
    public EvaluationClient(int id , Utilisateur u ,Evenement v ,int note)
    {
    this.id=id;
    this.user=u;
    this.event=v;
    this.note=note;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
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
        final EvaluationClient other = (EvaluationClient) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
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

    public Evenement getEvent() {
        return event;
    }

    public void setEvent(Evenement event) {
        this.event = event;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
    
    
    
    
    
}
