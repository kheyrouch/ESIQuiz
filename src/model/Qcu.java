package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Qcu extends Question implements Serializable {
    private ArrayList<String> propositions;

    public Qcu(String enonce) {
        super(enonce);
        propositions = new ArrayList<>();
    }

    public ArrayList<String> getPropositions() {
        return propositions;
    }

    public void ajouterProposition(String proposition){
        propositions.add(proposition);
    }

    public void afficherPropositions(){
        for(int i = 0 ; i < propositions.size() ; i++){
            System.out.println(propositions.get(i));
        }
    }

    public String getProposition(int i) {

        return propositions.get(i);
    }

    public void toStringPrint(){
        System.out.println("enonce :"+enonce);
        System.out.println("propotions :");
        for(int i = 0 ; i < propositions.size() ; i++){
            System.out.println("\t"+(i+1)+".."+propositions.get(i));
        }

    }
    public boolean verifierSolution(){return true;};

    public double evalueQuestion(ArrayList<String> solution){

        if (this.solutions.get(0)==solution.get(0)){return 1;}else return -1;
    }

    @Override
    public double evalueQuestion() {
        return 0;
    }
}
