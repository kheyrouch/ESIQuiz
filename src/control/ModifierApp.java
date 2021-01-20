package control;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.time.LocalDate;

public class ModifierApp {

    public static Apprenant apprenant ;

    @FXML
    private JFXTextField txt_nom;

    @FXML
    private JFXTextField txt_prenom;

    @FXML
    private JFXTextField txt_adresse;

    @FXML
    private JFXDatePicker date_birthday;

    @FXML
    private JFXButton btn_modifier;

    @FXML
    public void initialize() {
        txt_nom.setText(apprenant.getNom());
        txt_prenom.setText(apprenant.getPrenom());
        txt_adresse.setText(apprenant.getAdresse());
        date_birthday.setValue(apprenant.getDateNaissance());

    }

    @FXML
    void modifierClicked(ActionEvent event) throws IOException {

        for (Apprenant app: Login.formateur.getFormation().getListeDesApprenants()
             ) {
            if (app.equals(apprenant)){

                Login.formateur.getFormation().getListeDesApprenants().remove(apprenant);

                Apprenant apprenantS = new Apprenant(txt_nom.getText(),
                        txt_prenom.getText(),date_birthday.getValue(),genererLogin(txt_nom.getText(),txt_prenom.getText()),genererMotDePass(txt_nom.getText(),date_birthday.getValue()),
                        txt_adresse.getText());

                Login.formateur.getFormation().getListeDesApprenants().add(apprenantS);


            }
        }

        Stage stage = (Stage) btn_modifier.getScene().getWindow();
        // do what you have to do
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("../view/DashBoard.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Tableau de bord");
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

