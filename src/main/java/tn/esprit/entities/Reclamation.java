package tn.esprit.entities;

import java.util.Date;

public class Reclamation {
    private int id;
    private int id_User;
    private Date dateReclamation;

    public Reclamation(int id, int id_User, Date dateReclamation) {
        this.id = id;
        this.id_User = id_User;
        this.dateReclamation = dateReclamation;
    }
    public Reclamation(){}
    public Reclamation(int id_User, Date dateReclamation) {

        this.id_User = id_User;
        this.dateReclamation = dateReclamation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public Date getDateReclamation() {
        return dateReclamation;
    }

    public void setDateReclamation(Date dateReclamation) {
        this.dateReclamation = dateReclamation;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "id=" + id +
                ", id_User='" + id_User + '\'' +
                ", dateReclamation='" + dateReclamation + '\'' +
                '}';
    }


}
