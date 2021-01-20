package tableView;

import javafx.beans.property.SimpleStringProperty;

public class Quiz2 {

    private final SimpleStringProperty nom = new SimpleStringProperty("");
    private final SimpleStringProperty startDate = new SimpleStringProperty("");
    private final SimpleStringProperty finDate = new SimpleStringProperty("");

    public Quiz2() {
        this("", "", "");
    }

    public Quiz2(String nom, String startDate, String finDate) {
        setNom(nom);
        setStartDate(startDate);
        setFinDate(finDate);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String fnom) {
        nom.set(fnom);
    }

    public String getStartDate() {
        return startDate.get();
    }

    public void setStartDate(String fnom) {
        startDate.set(fnom);
    }

    public String getFinDate() {
        return finDate.get();
    }

    public void setFinDate(String fnom) {
        finDate.set(fnom);
    }
}