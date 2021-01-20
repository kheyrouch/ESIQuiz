package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Formation;

import java.io.IOException;


public class AjouterFormation {


    @FXML
    private JFXButton btn_ajouter;

    @FXML
    private JFXDatePicker date_fin;

    @FXML
    private JFXDatePicker date_debut;

    @FXML
    private JFXTextArea txt_description;

    @FXML
    private JFXTextField txt_nom;



    @FXML
    void btnAjouterClicked(MouseEvent event) throws IOException {

        Formation formation = new Formation(txt_nom.getText(),txt_description.getText(),date_debut.getValue(), date_fin.getValue());
        System.out.println(Login.formateur.getUserName());
        Login.formateur.setFormation(formation);


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



