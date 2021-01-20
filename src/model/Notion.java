package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Notion implements Serializable {
    private String titre;
    private String description;
    private int nbQuestion;
    private ArrayList< Question> listeDesQuestion;

    public Notion(){
        this.listeDesQuestion = new ArrayList<>();
    }

    public Notion(String titre, String description , int nbQuestion) {
        this.titre = titre;
        this.description = description;
        this.nbQuestion = nbQuestion;
        this.listeDesQuestion = new ArrayList<>();
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public int getNbQuestion() {
        return nbQuestion;
    }

    public void setNbQuestion(int nbQuestion) {
        this.nbQuestion = nbQuestion;
    }

    public ArrayList<Question> getListeDesQuestion() {
        return listeDesQuestion;
    }

    public void setListeDesQuestion(ArrayList<Question> listeDesQuestion) {
        this.listeDesQuestion = listeDesQuestion;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public void ajouterQuestion(Question question){
        listeDesQuestion.add(question);
    }

    public void modifierNotion(){}

    public void supprimerNotion(){}

    public void supprimerQuestion(String nom){
        for (Question question: this.getListeDesQuestion()
             ) {

            if (question.getEnonce().equals(nom)){
                this.getListeDesQuestion().remove(question);
            }

        }
    }
}
