package control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Notion;
import model.Question;
import model.Quiz;
import tableView.Notion3;
import tableView.Question2;
import tableView.Quiz2;

import java.io.IOException;

public class ModifierNotion {

    public static Notion notion;

    @FXML
    private JFXTextField txt_titre;

    @FXML
    private JFXTextArea txt_description;

    @FXML
    private JFXTextField txt_nbQuestion;

    @FXML
    private TableView<Question2> table_quuestion;

    @FXML
    private TableColumn<Question2, String> table_qt_enonnce;

    @FXML
    private TableColumn<Question2, String> table_qt_type;

    @FXML
    private JFXButton btn_ajouter;

    @FXML
    private JFXButton btn_supprimer;

    @FXML
    private JFXButton btn_modifier;

    @FXML
    private JFXButton btn_done;

    @FXML

    public void initialize(){
        txt_titre.setText(notion.getTitre());
        txt_description.setText(notion.getDescription());
        txt_nbQuestion.setText(String.valueOf(notion.getNbQuestion()));


        for (Question question: notion.getListeDesQuestion()
        ) {
            ObservableList<Question2> data = table_quuestion.getItems();
            data.add(new Question2(question.getEnonce(),
                    question.getClass().getName()
            ));

        }
    }

    @FXML
    void ajouterQuestion(ActionEvent event) throws IOException {

        Stage stage = (Stage) btn_ajouter.getScene().getWindow();
        // do what you have to do
        stage.close();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/Question3.fxml"));

        primaryStage.setTitle("Ajouter Question");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();


    }

    @FXML
    void doneClicked(ActionEvent event) throws IOException {

        Notion notionModifier = new Notion(txt_titre.getText(),txt_description.getText(),Integer.valueOf(txt_nbQuestion.getText()));
        notionModifier.setListeDesQuestion(notion.getListeDesQuestion());


        ModifierQuiz.quiz.supprimerNotion(notion.getTitre());
        ModifierQuiz.quiz.getListeDesNotion().add(notionModifier);

        Stage stage = (Stage) btn_ajouter.getScene().getWindow();
        // do what you have to do
        stage.close();


        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/modifierQuiz.fxml"));

        primaryStage.setTitle("Modifier Quiz");
        primaryStage.setScene(new Scene(root, 600, 573));
        primaryStage.show();



    }

    @FXML
    void modifierQuestion(ActionEvent event) {



    }

    @FXML
    void supprimerQuestion(ActionEvent event) {
        Question2 question2 =table_quuestion.getSelectionModel().getSelectedItem();
        ModifierQuiz.quiz.supprimerNotion(notion.getTitre());
        notion.supprimerQuestion(question2.getEnnonce());
        ModifierQuiz.quiz.getListeDesNotion().add(notion);
        table_quuestion.getItems().removeAll(question2);
    }

}
