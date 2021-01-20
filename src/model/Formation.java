package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Formation implements Serializable {


    protected String nom;
    protected String description;
    protected LocalDate dateDebut;
    protected LocalDate dateFin;
    protected ArrayList<Apprenant> listeDesApprenants;
    protected ArrayList<Quiz> listeDesQuiz ;


    public Formation() {
    }

    public Formation(String nom , String description, LocalDate dateDebut, LocalDate dateFin) {
        this.nom = nom;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.listeDesQuiz=new ArrayList<>();
        this.listeDesApprenants=new ArrayList<>();
    }

    public Formation(String nom) {
        this.nom = nom;
        this.listeDesQuiz=new ArrayList<>();
        this.listeDesApprenants=new ArrayList<Apprenant>();
    }

    public void modifierFormation(String nom , String description, LocalDate dateDebut, LocalDate dateFin){
        this.setNom(nom);
        this.setDescription(description);
        this.setDateDebut(dateDebut);
        this.setDateFin(dateFin);
    }

    public void supprimerFormation(){

    }

    public boolean verifierUniciteFormation(){return true;}

    public void ajouterQuiz(Quiz quiz){
        this.listeDesQuiz.add(quiz);
    }

    public void ajouterNotion(){


    }

    public void ajouterQuestion(){


    }

    public void ajouterApprenant(Apprenant apprenant){
        this.listeDesApprenants.add(apprenant);
    }

    public void supprimerQuiz(String nom){
        for (Quiz quiz: this.getListeDesQuiz()
             ) {
            if (quiz.getNom().equals(nom) ){
                this.getListeDesQuiz().remove(quiz);
            }
        }

    };

    public void supprimerApprenant(String nom){
        for (Apprenant apprenant: this.getListeDesApprenants()
        ) {
            if (apprenant.getNom().equals(nom)){
                this.getListeDesQuiz().remove(apprenant);
            }
        }
    }

    public ArrayList<Quiz> getListeDesQuiz() {
        return listeDesQuiz;
    }

    public void setListeDesQuiz(ArrayList<Quiz> listeDesQuiz) {
        this.listeDesQuiz = listeDesQuiz;
    }
    /*public void modifierApprenants(String userName){
        if(this.listeDesApprenants.
    };*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public ArrayList<Apprenant> getListeDesApprenants() {
        return listeDesApprenants;
    }


}
