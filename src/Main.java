import control.Login;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Apprenant;
import model.Formateur;
import model.Formation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Main extends Application {


    public static Formation load(){

        Formation formation= new Formation();
        try {
            FileInputStream fis = new FileInputStream("quiz.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            formation=(Formation) ois.readObject();
            System.out.println("load done");
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return formation;
    }

    public static void save(Formation formation){
        try {


            FileOutputStream fos = new FileOutputStream("quiz.bin");
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(formation);
            System.out.print("cbn la serialisation est terminer");
            os.close();
            System.out.print("fermeture");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{




        Parent root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 315, 426));
        primaryStage.show();
    }


    public static void main(String[] args) {

        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("d/MM/yyyy");

        String date = "16/08/2016";

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatterDate);
        Formateur formateur= new Formateur("Islem","Aich",localDate,"Mohammed","11111");
        Formation formation= new Formation();
        formation = load();

        formateur.ajouterFormation(formation);
        Login.formateur = formateur;

        launch(args);

        Apprenant apprenant = new Apprenant();
        apprenant = formateur.getFormation().getListeDesApprenants().get(0);
        apprenant.checkQuizs(formateur.getListeDesQuiz());
        apprenant.getStatistic();

        save(formateur.getFormation());
    }
}
