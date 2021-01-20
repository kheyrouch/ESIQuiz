package tableView;

import javafx.beans.property.SimpleStringProperty;

public class Notion3 {

    private final SimpleStringProperty nom = new SimpleStringProperty("");
    private final SimpleStringProperty description = new SimpleStringProperty("");
    private final SimpleStringProperty nbQuestion = new SimpleStringProperty("");

    public Notion3() {
        this("", "", "");
    }

    public Notion3(String nom, String startDate, String finDate) {
        setNom(nom);
        setDescription(startDate);
        setNbQuestion(finDate);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String fnom) {
        nom.set(fnom);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String fnom) {
        description.set(fnom);
    }

    public String getNbQuestion() {
        return nbQuestion.get();
    }

    public void setNbQuestion(String fnom) {
        nbQuestion.set(fnom);
    }
}
