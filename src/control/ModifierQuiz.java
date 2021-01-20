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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Apprenant;
import model.Notion;
import model.Quiz;
import tableView.Notion3;
import java.io.IOException;

public class ModifierQuiz {

    public static Quiz quiz;

    @FXML
    private TableView<Notion3> table_notion;

    @FXML
    private TableColumn<Notion3, String> table_notion_titre;

    @FXML
    private TableColumn<Notion3, String> table_notion_desc;

    @FXML
    private TableColumn<Notion3, String> table_notion_nQ;

    @FXML
    private JFXButton btn_modifier;

    @FXML
    private JFXTextField txt_nom;

    @FXML
    private JFXDatePicker date_debut;

    @FXML
    private JFXDatePicker date_fin;

    @FXML
    private JFXButton btn_ajouter_notion;

    @FXML
    private JFXButton btn_supprimer_notion;

    @FXML
    private JFXButton btn_Notion;

    @FXML
    public void initialize(){
        txt_nom.setText(quiz.getNom());
        date_debut.setValue(quiz.getStartDate());
        date_fin.setValue(quiz.getEndDate());


        for (Notion notion: quiz.getListeDesNotion()
        ) {
            ObservableList<Notion3> data = table_notion.getItems();
            data.add(new Notion3(notion.getTitre(),
                    notion.getDescription(),
                    String.valueOf(notion.getNbQuestion())
            ));

        }
    }


    @FXML
    void modifierNotion(ActionEvent event) throws IOException {

        for (Notion notion: quiz.getListeDesNotion()
        ) {
            if (
                    notion.getTitre().equals(table_notion.getSelectionModel().getSelectedItem().getNom())
            ) {
                ModifierNotion.notion = notion;
            }

        }

        Stage stage = (Stage) btn_Notion.getScene().getWindow();
        // do what you have to do
        stage.close();

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/modifierNotion.fxml"));

        primaryStage.setTitle("Modifier Notion");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();

    }

    @FXML
    void ajouterNotion(ActionEvent event) throws IOException {

        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../view/Notion.fxml"));
        primaryStage.setTitle("Ajouter Notion");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();

        // get a handle to the stage
        Stage stage = (Stage) btn_ajouter_notion.getScene().getWindow();
        // do what you have to do
        stage.close();


    }

    @FXML
    void modifierClicked(ActionEvent event) throws IOException {
        Quiz quiz3 =  new Quiz(txt_nom.getText(),date_debut.getValue(),date_fin.getValue());
        quiz3.setListeDesNotion(quiz.getListeDesNotion());

        Login.formateur.getFormation().supprimerQuiz(quiz.getNom());
        Login.formateur.getFormation().getListeDesQuiz().add(quiz3);


        // get a handle to the stage
        Stage stage = (Stage) btn_modifier.getScene().getWindow();
        // do what you have to do
        stage.close();

        Parent root = FXMLLoader.load(getClass().getResource("../view/DashBoard.fxml"));
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Tableau de bord");
        primaryStage.setScene(new Scene(root, 667, 507));
        primaryStage.show();


    }

    @FXML
    void supprimerNotion(ActionEvent event) {
        Notion3 notion =table_notion.getSelectionModel().getSelectedItem();
        quiz.supprimerNotion(notion.getNom());
        Login.formateur.getFormation().getListeDesQuiz().remove(quiz);
        quiz.supprimerNotion(notion.getNom());
        Login.formateur.getFormation().getListeDesQuiz().add(quiz);

        table_notion.getItems().removeAll(notion);

    }

}
