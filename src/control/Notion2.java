package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;

public class Notion2 {

    @FXML
    private Label labelFormation;

    @FXML
    private Label labelQuiz;

    @FXML
    private JFXTextField textTitre;

    @FXML
    private JFXTextArea textDescription;

    @FXML
    private JFXTextField textNbQuestion;

    @FXML
    private JFXButton ajouterNotion;

    @FXML
    public void initialize(){
        labelQuiz.setText(ModifierQuiz.quiz.getNom());
    }

    @FXML
    void ajouterNotion(MouseEvent event) throws IOException {
        Notion notion = new Notion(textTitre.getText(),textDescription.getText(),Integer.valueOf(textNbQuestion.getText()) );

        for (Quiz quiz: Login.formateur.getFormation().getListeDesQuiz()
             ) {

            if (quiz.equals(ModifierQuiz.quiz)){
                ModifierQuiz.quiz.ajouterNotion(notion);
                Login.formateur.getFormation().getListeDesQuiz().remove(quiz);
                Login.formateur.getFormation().getListeDesQuiz().add(ModifierQuiz.quiz);
            }

        }

        Stage stage = (Stage) ajouterNotion.getScene().getWindow();
        // do what you have to do
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("../view/modifierQuiz.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Modifier Quiz");
        primaryStage.setScene(new Scene(root, 600, 573));
        primaryStage.show();



    }

}
