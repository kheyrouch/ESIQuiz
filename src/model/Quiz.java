package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Quiz implements Evaluation, Serializable {

    private String nom;
    private ArrayList<Notion> listeDesNotion;
    private LocalDate startDate;
    private LocalDate endDate;

    public Quiz(){
        this.listeDesNotion= new ArrayList<>();
    }


    public Quiz(String nom, LocalDate startDate,LocalDate endDate) {
        this.nom = nom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.listeDesNotion= new ArrayList<>();
    }

    public Quiz(String nom) {
        this.nom = nom;
        this.listeDesNotion= new ArrayList<>();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setInfo(){

    }

    public void supprimerNotion(String titre){

        for (Notion notion: this.getListeDesNotion()
             ) {
            if (notion.getTitre().equals(titre)){
                this.getListeDesNotion().remove(notion);
            }
        } {

        }

    };



    public String visualiserponse(){return "r";}

    public double evalueQuestion(){return 0.0;}



    public void ajouterNotion(Notion notion){
        this.listeDesNotion.add( notion);
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Notion> getListeDesNotion() {
        return listeDesNotion;
    }

    public void setListeDesNotion(ArrayList<Notion> listeDesNotion) {
        this.listeDesNotion = listeDesNotion;
    }

    public double evalueQuiz(){

        return 0;
    }

    public double evalueQuestion(ArrayList<String> solution){return 0;}

    public Boolean checkDate(){
        LocalDate date=LocalDate.now();
        if (date.isAfter(startDate) && date.isBefore(endDate)){

            return true;

        }else return false;



    }

    public String getStartDateString() {
        String chainne= startDate.getYear()+"/"+(startDate.getMonthValue())
                +"/"+(startDate.getDayOfMonth());
        return chainne;
    }


    public String getEndDateString() {
        String chainne=(endDate.getYear()+"/"+endDate.getMonthValue()+"/"+endDate.getDayOfMonth());

        return chainne;
    }


}
