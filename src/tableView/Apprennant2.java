package tableView;

import javafx.beans.property.SimpleStringProperty;

public class Apprennant2 {

    private final SimpleStringProperty nom = new SimpleStringProperty("");
    private final SimpleStringProperty prenom = new SimpleStringProperty("");
    private final SimpleStringProperty adresse = new SimpleStringProperty("");
    private final SimpleStringProperty birthday = new SimpleStringProperty("");

    public Apprennant2() {
        this("", "", "","");
    }

    public Apprennant2(String nom, String prenom, String adresse, String birthday) {
        setNom(nom);
        setPrenom(prenom);
        setAdresse(adresse);
        setBirthday(birthday);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String fnom) {
        nom.set(fnom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public void setPrenom(String fnom) {
        prenom.set(fnom);
    }

    public String getBirthday() {
        return birthday.get();
    }

    public void setBirthday(String fnom) {
        birthday.set(fnom);
    }

    public String getAdresse() {
        return adresse.get();
    }

    public void setAdresse(String fnom) {
        adresse.set(fnom);
    }
}
