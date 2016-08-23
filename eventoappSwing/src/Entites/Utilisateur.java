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
public class Utilisateur {
    protected int id,tel,nature,enabled,locked;
    protected String nom,adresse,mail,password,username;
    

    public Utilisateur(int id, int tel, int nature, String nom, String adresse, String mail, String password, int enabled, int locked, String username) {
        this.id = id;
        this.tel = tel;
        this.nature = nature;
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.password = password;
        this.enabled=enabled;
        this.locked=locked;
        this.username=username;
        
    }

    public Utilisateur() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", tel=" + tel + ", nature=" + nature + ", nom=" + nom + ", adresse=" + adresse + ", mail=" + mail + ", password=" + password  + '}';
    }
    
    
}
