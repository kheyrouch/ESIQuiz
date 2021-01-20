package control;

import com.jfoenix.controls.*;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Qcm;
import model.Qcu;
import model.Qo;

import java.io.IOException;
import java.util.ArrayList;

public class Question3 {




    @FXML
    private JFXRadioButton radio_QCM;

    @FXML
    private JFXRadioButton radio_QCU;

    @FXML
    private JFXRadioButton radio_QO;

    @FXML
    private Pane pane_question;

    @FXML
    private Pane pane_QCM;

    @FXML
    private Pane pane_QO;

    @FXML
    private JFXTextArea enonce_QCM;

    @FXML
    private TextField p1;

    @FXML
    private TextField p3;

    @FXML
    private TextField p2;

    @FXML
    private JFXCheckBox s1;

    @FXML
    private JFXCheckBox s2;

    @FXML
    private JFXCheckBox s3;

    @FXML
    private JFXTextArea enonce_QO;

    @FXML
    private JFXTextField solutio_QO;

    @FXML
    private Label label_formation;

    @FXML
    private Label label_quiz;

    @FXML
    private Label label_notion;

    @FXML
    private JFXButton ajouterButton;

    public static model.Question question;
    @FXML
    void ajouter(MouseEvent event) throws IOException {
        question=ajouterQuestion();
         ModifierNotion.notion.ajouterQuestion(question);

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/modifierNotion.fxml"));
        primaryStage.setTitle("Modifier Notion");
        primaryStage.setScene(new Scene(root, 696, 672));
        primaryStage.show();

        // get a handle to the stage
        Stage stage = (Stage) ajouterButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    void radio_QCM_checked(MouseEvent event) {
        if (radio_QCM.isSelected()) {
            radio_QCU.setSelected(false);
            radio_QO.setSelected(false);
            pane_QO.setVisible(false);
            pane_QCM.setVisible(true);
        } else pane_QCM.setVisible(false);

    }

    @FXML
    void radio_QCU_checked(MouseEvent event) {
        if (radio_QCU.isSelected()) {
            radio_QCM.setSelected(false);
            radio_QO.setSelected(false);
            pane_QO.setVisible(false);
            pane_QCM.setVisible(true);
        } else pane_QCM.setVisible(false);
    }

    @FXML
    void radio_QO_checked(MouseEvent event) {
        if (radio_QO.isSelected()) {
            radio_QCM.setSelected(false);
            radio_QCU.setSelected(false);
            pane_QO.setVisible(true);
            pane_QCM.setVisible(false);
        } else pane_QO.setVisible(false);
    }

    @FXML
    void p1_checked(MouseEvent event) {
        if (radio_QCU.isSelected()) {
            s2.setSelected(false);
            s3.setSelected(false);
        }

    }

    @FXML
    void p2_checked(MouseEvent event) {
        if (radio_QCU.isSelected()) {
            s1.setSelected(false);
            s3.setSelected(false);
        }
    }

    @FXML
    void p3_checked(MouseEvent event) {
        if (radio_QCU.isSelected()) {
            s1.setSelected(false);
            s2.setSelected(false);
        }
    }

    public model.Question ajouterQuestion() {

        if (radio_QCM.isSelected()) {
            Qcm question = new Qcm(enonce_QCM.getText());
            question.ajouterProposition(p1.getText());
            question.ajouterProposition(p2.getText());
            question.ajouterProposition(p3.getText());
            if (s1.isSelected()) question.ajouterSolution(p1.getText());
            if (s2.isSelected()) question.ajouterSolution(p2.getText());
            if (s3.isSelected()) question.ajouterSolution(p3.getText());
            return question;


        } else if (radio_QCU.isSelected()) {
            Qcu question = new Qcu(enonce_QCM.getText());
            question.ajouterProposition(p1.getText());
            question.ajouterProposition(p2.getText());
            question.ajouterProposition(p3.getText());
            if (s1.isSelected()) question.ajouterSolution(p1.getText());
            if (s2.isSelected()) question.ajouterSolution(p2.getText());
            if (s3.isSelected()) question.ajouterSolution(p3.getText());
            return question;
        } else {
            Qo question = new Qo(enonce_QO.getText());
            question.ajouterSolution(solutio_QO.getText());
            return question;
        }

    }

    public model.Question modifierQuestion(model.Question question){
        ArrayList<String> solutions;
        if (question.getClass().getName()=="model.Qcm"){
            radio_QCM.setSelected(true);
            pane_QO.setVisible(false);
            pane_QCM.setVisible(true);
            radio_QO.setDisable(true);
            radio_QCU.setDisable(true);
            enonce_QCM.setText(question.getEnonce());
            p1.setText(question.getProposition(0));
            p2.setText(question.getProposition(1));
            p3.setText(question.getProposition(2));
            solutions=question.getSolutions();
            if (solutions.contains(question.getProposition(0))){s1.setSelected(true);}
            if (solutions.contains(question.getProposition(1))){s2.setSelected(true);}
            if (solutions.contains(question.getProposition(2))){s3.setSelected(true);}
        }else if(question.getClass().getName()=="model.Qcu"){
            radio_QCU.setSelected(true);
            pane_QO.setVisible(false);
            pane_QCM.setVisible(true);
            radio_QO.setDisable(true);
            radio_QCM.setDisable(true);
            enonce_QCM.setText(question.getEnonce());
            p1.setText(question.getProposition(0));
            p2.setText(question.getProposition(1));
            p3.setText(question.getProposition(2));
            solutions=question.getSolutions();
            if (solutions.contains(question.getProposition(0))){s1.setSelected(true);}
            if (solutions.contains(question.getProposition(1))){s2.setSelected(true);}
            if (solutions.contains(question.getProposition(2))){s3.setSelected(true);}
        }else {
            radio_QO.setSelected(true);
            pane_QCM.setVisible(false);
            pane_QO.setVisible(true);
            radio_QCM.setDisable(true);
            radio_QCU.setDisable(true);
            enonce_QO.setText(question.getEnonce());
            solutio_QO.setText(question.getSolution(0));
        }
        return question;
    }
}



