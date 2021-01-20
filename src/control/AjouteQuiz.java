package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Quiz;

import java.io.IOException;

public class AjouteQuiz{

    @FXML
    private JFXButton btn_ajouter;

    @FXML
    private JFXTextField txt_nom;

    @FXML
    private JFXDatePicker date_ouverture;

    @FXML
    private JFXDatePicker date_expiration;

    @FXML
    private Label label_formation;

    @FXML
    public void initialize() {
        label_formation.setText(Login.formateur.getFormation().getNom());
    }

    @FXML
    void ajouterClicked(MouseEvent event) throws IOException {
        Quiz quiz = new Quiz(txt_nom.getText(),date_ouverture.getValue(),date_expiration.getValue());
        Login.formateur.getFormation().ajouterQuiz(quiz);



        // get a handle to the stage
        Stage stage = (Stage) btn_ajouter.getScene().getWindow();
        // do what you have to do
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("../view/DashBoard.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 667, 507));
        primaryStage.show();




    }

}
