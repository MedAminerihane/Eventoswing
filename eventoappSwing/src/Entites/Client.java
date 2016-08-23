/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entites;

import java.sql.Date;



/**
 *
 * @author Seif
 */
public class Client extends Utilisateur{
    private String prenom;
    private int age,cin;

    public Client() {
    }

    public Client(String prenom, int age, int cin, int id, int tel, int nature, String nom, String adresse, String mail, String password, int locked , int enabled, String username) {
        super(id, tel, nature, nom, adresse, mail, password, enabled, locked, username );
        this.prenom = prenom;
        this.age = age;
        this.cin = cin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    @Override
    public String toString() {
        return super.toString() + " Client{" + "prenom=" + prenom + ", age=" + age + ", cin=" + cin + '}';
    }
    
    
}
