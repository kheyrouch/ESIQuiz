package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Qo extends Question implements Serializable {

    private double pointVrai=1;
    public Qo(String enonce) {
        super(enonce);
    }


    public void toStringPrint(){
        System.out.println("enonce :"+enonce);
    }

    public boolean verifierSolution(){return true;}

    public double evalueQuestion(ArrayList<String> solution){
        if(this.solutions.get(0)==solution.get(0)){
            return  1;
        }else return -1;
    }

    @Override
    public double evalueQuestion() {
        return 0;
    }
}
