/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.Objects;
import sun.security.util.Password;

/**
 *
 * @author majed
 */
public class Admin {
    private int id;
    private String nom,prenom,mail;
    private String pwd;
    

    public Admin() {
    }

    public Admin(String nom, String prenom,String mail, String pwd) {
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.pwd = pwd;
    }
    
    

    public Admin( int id,String nom, String prenom,String mail, String pwd ) {
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.pwd = pwd;
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Admin{" + "mail=" + mail + ", nom=" + nom + ", prenom=" + prenom + ", pwd=" + pwd + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.mail);
        hash = 83 * hash + Objects.hashCode(this.nom);
        hash = 83 * hash + Objects.hashCode(this.prenom);
        hash = 83 * hash + Objects.hashCode(this.pwd);
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
        final Admin other = (Admin) obj;
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.pwd, other.pwd)) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    

   
    
}
