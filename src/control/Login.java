package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Formateur;

import java.io.IOException;


public class Login {

    public static Formateur formateur ;

    @FXML
    private JFXButton btn_logIn;

    @FXML
    private JFXTextField txt_userName;

    @FXML
    private JFXPasswordField txt_passwoed;

    @FXML
    void logInClicked(MouseEvent event) throws IOException {
       if(txt_userName.getText().equals(formateur.getUserName()) && txt_passwoed.getText().equals(formateur.getPassWord())){

            // get a handle to the stage
            Stage stage = (Stage) btn_logIn.getScene().getWindow();
            // do what you have to do
            stage.close();

            if (formateur.getFormation().getNom() != null){
                Parent root = FXMLLoader.load(getClass().getResource("../view/Dashboard.fxml"));
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Hello World");
                primaryStage.setScene(new Scene(root, 667, 507));
                primaryStage.show();

            }else {
                Parent root = FXMLLoader.load(getClass().getResource("../view/AjouterFormation.fxml"));

                Stage primaryStage = new Stage();
                primaryStage.setTitle("Hello World");
                primaryStage.setScene(new Scene(root, 600, 331));
                primaryStage.show();
            }




        }else{
            System.out.println("everything wrong un ");
            System.out.println(txt_userName.getText()+"  "+txt_passwoed.getText());

        }
    }
}

