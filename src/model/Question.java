package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Question implements Evaluation,Serializable {
    protected String enonce;
    protected ArrayList<String> solutions;

    public Question(){}

    public Question(String enonce) {
        this.enonce = enonce;
        this.solutions=new ArrayList<>();
    }

    public String getEnonce() {
        return enonce;
    }

    public ArrayList<String> getSolutions() {

        return solutions;
    }

    public void ajouterSolution(String solution){

        solutions.add(solution);
    }

    public String getProposition(int i){

        return "";
    }

    public String getSolution(int i){

        return solutions.get(i);
    }


    public boolean uniciteDesQuestion(){return true;}

    public boolean verifierSolution(){return true;}

    public void toStringPrint(){}

    public double evalueQuiz(){return 0;}

    public double evalueQuestion(ArrayList<String> solution){return 0;}


}
