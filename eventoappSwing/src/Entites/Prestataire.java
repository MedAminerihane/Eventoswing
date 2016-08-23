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
public class Prestataire extends Utilisateur{
    private String matriculeFiscale,description;

    public Prestataire(String matriculeFiscale, String description, int id, int tel, int nature, String nom, String adresse, String mail, String password,int enabled , int locked,String username) {
        super(id, tel, nature, nom, adresse, mail, password, enabled, locked, username);
        this.matriculeFiscale = matriculeFiscale;
        this.description=description;
    }

    public Prestataire() {
    }

    public String getMatriculeFiscale() {
        return matriculeFiscale;
    }

    public void setMatriculeFiscale(String matriculeFiscale) {
        this.matriculeFiscale = matriculeFiscale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString() + " Prestataire{" + "matriculeFiscale=" + matriculeFiscale + ", description=" + description + '}';
    }

   
    
}
