package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Apprenant extends Compte implements Serializable {
    private String adresse;
    private ArrayList<DataQuiz> dataQuizs;
    public Apprenant() {this.dataQuizs=new ArrayList<DataQuiz>();}


    public Apprenant(String nom, String prenom, LocalDate dateNaissance, String userName, String passWord, String adresse) {
        super(nom, prenom, dateNaissance, userName, passWord);
        this.adresse = adresse;
        this.dataQuizs=new ArrayList<DataQuiz>();
    }


    public void checkQuizs(ArrayList<Quiz> quizs){
        Scanner sc =new Scanner(System.in);
        ArrayList<String>  solution=new ArrayList<>();
        double pointTotal=0,tauxFinal;
        int i,j,solu,tab[]=new int[3];
        for (i=0 ;i<quizs.size();i++){
            System.out.println((1+i)+".."+quizs.get(i).getNom()+"\t"
                    +quizs.get(i).getStartDateString()+"\t"+quizs.get(i).getEndDateString());
        }
        System.out.print("Quelle quiz voullez vous choisir :");
        i=sc.nextInt();
        if (quizs.get(i-1).checkDate()==true){
            ArrayList<Notion> notions=quizs.get(i-1).getListeDesNotion();
            for (int l = 0 ;l < notions.size() ; l++){
                System.out.println((l+1)+".."+notions.get(l).getTitre());
            }
            System.out.print("Quelle notion voullez vous choisir :");
            j=sc.nextInt();
            ArrayList<Question> questions=notions.get(j-1).getListeDesQuestion();
            for (int k = 0 ;k < questions.size() ; k++){
                solution.clear();
                questions.get(k).toStringPrint();
                if (questions.get(k).getClass().getName()=="model.Qo"){
                    System.out.print("entrez votre reponse : ");
                    solution.add(sc.next());
                    pointTotal+=questions.get(k).evalueQuestion(solution);
                }else if(questions.get(k).getClass().getName()=="model.Qcu") {

                    System.out.print("entrez le numero De la Reponse juste :");
                    solution.add(questions.get(k).getProposition(sc.nextInt()-1));
                    pointTotal += questions.get(k).evalueQuestion(solution);
                }else {

                    System.out.print("entrez votre reponses de cette façon 'R1R2R3' :");
                    solu=sc.nextInt();
                    if (solu>99)            { tab[2]=solu%10;tab[1]=(solu/10)%10;tab[0]=solu/100;}
                    if (solu>9 && solu<99)  { tab[2]=0      ;tab[1]=solu%10     ;tab[0]=solu/10 ;}
                    if (solu<9)             { tab[2]=0      ;tab[1]=0           ;tab[0]=solu    ;}
                    solution.add(questions.get(k).getProposition((tab[0])-1));
                    if(tab[1]!=0)solution.add(questions.get(k).getProposition((tab[1])-1));
                    if(tab[2]!=0)solution.add(questions.get(k).getProposition((tab[2])-1));

                    pointTotal += questions.get(k).evalueQuestion(solution);
                }
            }
            if (pointTotal<0)pointTotal=0;else pointTotal=pointTotal/3;
            tauxFinal=nbNotionRepondu(quizs.get(i-1).getNom())*100/notions.size();
            dataQuizs.add(new DataQuiz(quizs.get(i-1).getNom(), notions.get(j-1).getTitre(),
                    Double.toString((pointTotal*100)/notions.get(j-1).getNbQuestion())
                    ,Double.toString((tauxFinal))));

            MAJTauxDeReussite(quizs.get(i-1).getNom(),tauxFinal);
        }
    }

    public int nbNotionRepondu(String nomQuiz){
        int nb=1;
        for (int i=0;i<dataQuizs.size();i++){
            nb+=dataQuizs.get(i).checkNom(nomQuiz);
        }
        return nb;
    }

    public double evalueQuiz(String nomQuiz){
        double noteQuiz=0,note;

        for (int i=0;i<dataQuizs.size();i++){
            note = dataQuizs.get(i).getNoteOf(nomQuiz);
            if (note>=0) {
                noteQuiz += note;

            }
        }
        return (noteQuiz)/2;
    }

    public void MAJTauxDeReussite(String nomQuiz,double tauxFinal){
        for (int i=0;i<dataQuizs.size();i++){
            dataQuizs.get(i).MAJ(nomQuiz,Double.toString(tauxFinal));
        }
    }

    public void getStatistic(){
        for (int i=0;i<dataQuizs.size();i++){
            dataQuizs.get(i).toStringPrint();
            System.out.println("note quiz : "+evalueQuiz(dataQuizs.get(i).getNomQuiz()));
        }
    }

    public String getAdresse() {
        return adresse;
    }



    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }






}
