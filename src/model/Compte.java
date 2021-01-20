package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public abstract class Compte implements Serializable {
    protected String nom;
    protected String prenom;
    protected LocalDate dateNaissance;
    protected String userName;
    protected String passWord;

    public Compte() {}

    public Compte(String nom, String prenom, LocalDate dateNaissance, String userName, String passWord) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
