package model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Formateur extends Compte implements Serializable {


    private Formation formation;

    public Formateur() {
    }


    public ArrayList<Quiz> getListeDesQuiz() {

        return formation.getListeDesQuiz();
    }

    public Formateur(String nom, String prenom, LocalDate dateNaissance, String userName, String passWord) {
        super(nom, prenom, dateNaissance, userName, passWord);
    }

    public void ajouterFormation(Formation formation) {
            this.formation = formation;

    }



    public void modifierFormation() {
    }

    public void afficheQuiz() {
    }

    public void afficheClassements() {
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public void supprimerFormation() {
        this.formation = null;

    }
}

