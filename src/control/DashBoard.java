package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.*;

import tableView.*;

import java.io.IOException;
import java.time.LocalDate;

public class DashBoard {


    @FXML
    private HBox hbox_foramtion;

    @FXML
    private Label hbox_quiz;

    @FXML
    private HBox hbox_aprren;

    @FXML
    private Label hbox_appren;

    @FXML
    private HBox hbox_foramtion1;

    @FXML
    private Label hbox_parametre;

    @FXML
    private Pane pane_Quiz;

    @FXML
    private Label label_formation;

    @FXML
    private Pane pane_appren;

    @FXML
    private Label label_formation1;

    @FXML
    private JFXButton btn_ajouter_quiz;

    @FXML
    private TableView<Quiz2> table_quiz;

    @FXML
    private  TableColumn<Quiz2,String> table_quiz_nom;


    @FXML
    private  TableColumn<Quiz2,LocalDate> table_quiz_debut;


    @FXML
    private  TableColumn<Quiz2,LocalDate> table_quiz_fin;

    @FXML
    private JFXButton btn_ajouter_app;

    @FXML
    private JFXButton btn_supp_supp;

    @FXML
    private TableView<Apprennant2> table_appren;

    @FXML
    private TableColumn<Apprennant2, String> table_appren_nom;

    @FXML
    private TableColumn<Apprennant2, String> table_appren_prenom;

    @FXML
    private TableColumn<Apprennant2, String> table_appren_adresse;

    @FXML
    private TableColumn<Apprennant2, LocalDate> table_appren_date;

    @FXML
    private JFXButton btn_modifier_app;

    @FXML
    private JFXButton btn_modifier_quiz;

    @FXML
    private JFXTextField txt_nomFor;

    @FXML
    private JFXDatePicker date_debut_formation;

    @FXML
    private JFXDatePicker date_fin_formation;

    @FXML
    private JFXButton btn_formation_modifier;

    @FXML
    private Pane pane_parametre;



    @FXML
    public void initialize() {
        label_formation.setText(Login.formateur.getFormation().getNom());
        label_formation1.setText(Login.formateur.getFormation().getNom());
        txt_nomFor.setText(Login.formateur.getFormation().getNom());
        date_debut_formation.setValue(Login.formateur.getFormation().getDateDebut());
        date_fin_formation.setValue(Login.formateur.getFormation().getDateFin());



        for (Quiz quiz: Login.formateur.getFormation().getListeDesQuiz()
             ) {
            ObservableList<Quiz2> data = table_quiz.getItems();
            data.add(new Quiz2(quiz.getNom(),
                    quiz.getStartDate().toString(),
                    quiz.getEndDate().toString()
            ));

        }


        for (Apprenant apprenant: Login.formateur.getFormation().getListeDesApprenants()){
            ObservableList<Apprennant2> data2 =  table_appren.getItems();
            data2.add(
                    new Apprennant2(apprenant.getNom(),
                            apprenant.getPrenom(), apprenant.getAdresse(), apprenant.getDateNaissance().toString())
            );


        }



    }

    @FXML
    void ajouteApprennantsClicked(MouseEvent event) throws IOException {


        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/AjouteApprenant.fxml"));
        primaryStage.setTitle("Ajouter Apprenant");
        primaryStage.setScene(new Scene(root, 549, 356));
        primaryStage.show();

        // get a handle to the stage
        Stage stage = (Stage) btn_ajouter_app.getScene().getWindow();
        // do what you have to do
        stage.close();




    }

    @FXML
    void ajouteQuizClicked(ActionEvent even) throws IOException {

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/AjouteQuiz.fxml"));
        primaryStage.setTitle("Ajouter Quiz");
        primaryStage.setScene(new Scene(root, 600, 331));
        primaryStage.show();


        // get a handle to the stage
        Stage stage = (Stage) btn_ajouter_quiz.getScene().getWindow();
        // do what you have to do
        stage.close();




    }


    @FXML
    void modifierQuiz(ActionEvent event) throws IOException {

        for (Quiz quiz: Login.formateur.getFormation().getListeDesQuiz()
        ) {
            if(
                    quiz.getNom().equals(table_quiz.getSelectionModel().getSelectedItem().getNom())
            ){
                ModifierQuiz.quiz = quiz;
            }
            System.out.println(ModifierQuiz.quiz.getNom());

            // get a handle to the stage
            Stage stage = (Stage) btn_modifier_quiz.getScene().getWindow();
            // do what you have to do
            stage.close();

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../view/modifierQuiz.fxml"));

            primaryStage.setTitle("Ajouter Quiz");
            primaryStage.setScene(new Scene(root, 600, 573));
            primaryStage.show();

        }

    }


    @FXML
    void modifierApprenant(ActionEvent event) throws IOException {
        for (Apprenant app: Login.formateur.getFormation().getListeDesApprenants()
             ) {
            if (
                    app.getDateNaissance().toString().equals(table_appren.getSelectionModel().getSelectedItem().getBirthday())
            ) {
                ModifierApp.apprenant = app;
            }

        }
            // get a handle to the stage
            Stage stage = (Stage) btn_modifier_app.getScene().getWindow();
            // do what you have to do
            stage.close();

            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../view/modifierApp.fxml"));

            primaryStage.setTitle("Modifier Apprennants");
            primaryStage.setScene(new Scene(root, 600, 551));
            primaryStage.show();
            
        }
        



    @FXML
    void supprimerApprennantsClicked(MouseEvent event) {
        Apprennant2 apprennant2 =table_appren.getSelectionModel().getSelectedItem();
        Login.formateur.getFormation().supprimerApprenant(apprennant2.getNom());

        table_appren.getItems().removeAll(apprennant2);

    }

    @FXML
    void supprimerQuizClicked(MouseEvent event) {

        Quiz2 quiz =table_quiz.getSelectionModel().getSelectedItem();

        
       Login.formateur.getFormation().supprimerQuiz(quiz.getNom());

        table_quiz.getItems().removeAll(quiz);



    }




    @FXML
    void apprenClicked(MouseEvent event) {
        pane_appren.setVisible(true);
        pane_Quiz.setVisible(false);
        pane_parametre.setVisible(false);
    }



    @FXML
    void quizClicked(MouseEvent event) {
        pane_appren.setVisible(false);
        pane_Quiz.setVisible(true);
        pane_parametre.setVisible(false);
    }


    @FXML
    void paneClicked(MouseEvent event) {

        pane_appren.setVisible(false);
        pane_Quiz.setVisible(false);
        pane_parametre.setVisible(true);

    }






    public void start(Stage primaryStage , String path) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(path));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    @FXML
    void modifierFormation(ActionEvent event) {

        Login.formateur.getFormation().setNom(txt_nomFor.getText());
        Login.formateur.getFormation().setDateFin(date_debut_formation.getValue());
        Login.formateur.getFormation().setDateFin(date_fin_formation.getValue());
        label_formation.setText(Login.formateur.getFormation().getNom());
        label_formation1.setText(Login.formateur.getFormation().getNom());



    }

}



