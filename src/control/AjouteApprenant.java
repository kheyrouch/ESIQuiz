package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Apprenant;


import java.io.IOException;
import java.time.LocalDate;

public class AjouteApprenant {



    @FXML
    private JFXTextField txt_nom;

    @FXML
    private JFXTextField txt_prenom;

    @FXML
    private JFXDatePicker date_naissance;

    @FXML
    private JFXTextField txt_adresse;

    @FXML
    private JFXButton btn_ajouter;

    @FXML
    void ajouterClicked(MouseEvent event) throws IOException {



         Apprenant apprenant = new Apprenant(txt_nom.getText(),txt_prenom.getText(),date_naissance.getValue(),
                genererLogin(txt_nom.getText(),txt_prenom.getText()),genererMotDePass(txt_nom.getText(),date_naissance.getValue()),
                txt_adresse.getText());
         Login.formateur.getFormation().ajouterApprenant(apprenant);

        // get a handle to the stage
        Stage stage = (Stage) btn_ajouter.getScene().getWindow();
        // do what you have to do
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("../view/DashBoard.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Tableau de Bord");
        primaryStage.setScene(new Scene(root, 667, 507));
        primaryStage.show();

    }




    private String genererMotDePass(String nom, LocalDate dateNaissance) {
        return nom + dateNaissance.toString();
    }

    private String genererLogin(String nom, String prenom) {
        return prenom.charAt(0) + nom;
    }
}