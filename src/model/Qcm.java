package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Qcm extends Question implements Serializable {
    private ArrayList<String> propositions;

    public Qcm() {
        super();
    }

    public Qcm(String enonce) {
        super(enonce);
        propositions = new ArrayList<>();
    }

    public String getProposition(int i) {

        return propositions.get(i);
    }

    public void ajouterProposition(String proposition){

        propositions.add(proposition);
    }

    public void toStringPrint(){
        System.out.println("enonce :"+enonce);
        System.out.println("propotions :");
        for(int i = 0 ; i < propositions.size() ; i++){
            System.out.println("\t"+(i+1)+".."+propositions.get(i));
        }

    }
    public void afficherPropositions(){

    }

    public boolean verifierSolution(){return true;}

    public double evalueQuestion(ArrayList<String> solution){


        double points=0;



        if(  (!solution.contains(propositions.get(0))&&!solutions.contains(propositions.get(0))) ||
                (solution.contains(propositions.get(0))&& solutions.contains(propositions.get(0)))){points+=1;}else points-=1;
        if(  (!solution.contains(propositions.get(1))&&!solutions.contains(propositions.get(1))) ||
                solution.contains(propositions.get(1))&& solutions.contains(propositions.get(1))){points+=1;}else points-=1;
        if(  (!solution.contains(propositions.get(2))&&!solutions.contains(propositions.get(2))) ||
                solution.contains(propositions.get(2))&& solutions.contains(propositions.get(2))){points+=1;}else points-=1;



        return points;

    }

    @Override
    public double evalueQuestion() {
        return 0;
    }
}
