package tableView;

import javafx.beans.property.SimpleStringProperty;

public class Question2 {

    private final SimpleStringProperty ennonce = new SimpleStringProperty("");
    private final SimpleStringProperty type = new SimpleStringProperty("");


    public Question2() {
        this("", "");
    }

    public Question2(String nom, String startDate) {
        setEnnonce(nom);
        setType(startDate);
    }

    public String getEnnonce() {
        return ennonce.get();
    }

    public void setEnnonce(String fnom) {
        ennonce.set(fnom);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String fnom) {
        type.set(fnom);
    }

}