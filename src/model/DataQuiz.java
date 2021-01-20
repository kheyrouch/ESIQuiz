package model;

import java.io.Serializable;

public class DataQuiz implements Serializable {
    private String nomQuiz;
    private String nomNotion;
    private String tauxReuss;
    private String tauxAccomQuiz;

    public DataQuiz(){}

    public DataQuiz(String nomQuiz,String nomNotion, String tauxReuss, String tauxAccomQuiz) {
        this.nomQuiz   = nomQuiz  ;
        this.nomNotion = nomNotion;
        this.tauxReuss = tauxReuss;
        this.tauxAccomQuiz = tauxAccomQuiz;
    }



    public String getNomQuiz() {
        return nomQuiz;
    }

    public void toStringPrint(){
        System.out.println("nom du Quiz : "+nomQuiz+"\nnom du notion : "+nomNotion
                +"\ntaux de reussite de la Notion : "+tauxReuss+"\ntaux d accomplition : "+tauxAccomQuiz);
    }

    public int checkNom(String nomQuiz){
        if(this.nomQuiz==nomQuiz)return 1;
        else return 0;
    }

    public void MAJ(String nomQuiz ,String tauxAccomQuiz){
        if(this.nomQuiz==nomQuiz)this.tauxAccomQuiz=tauxAccomQuiz;
    }

    public double getNoteOf(String nomQuiz){
        if (this.nomQuiz==nomQuiz) return Double.valueOf(tauxReuss);
        else return -1;

    }

}
