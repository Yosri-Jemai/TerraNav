package tn.esprit.entities;

import java.sql.Timestamp;

public class Panier {
    private int id;
    private int idUser;
    private double prixTotal;
    private Timestamp dateValidation;

    public Panier() {}

    public Panier(int id, int idUser, double prixTotal, Timestamp  dateValidation) {
        this.id = id;
        this.idUser = idUser;
        this.prixTotal = prixTotal;
        this.dateValidation = dateValidation;
    }
    public Panier(int idUser, double prixTotal, Timestamp  dateValidation) {
        this.idUser = idUser;
        this.prixTotal = prixTotal;
        this.dateValidation = dateValidation;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getIdUser() { return idUser; }

    public void setIdUser(int idUser) { this.idUser = idUser; }

    public double getPrixTotal() { return prixTotal; }

    public void setPrixTotal(double prixTotal) { this.prixTotal = prixTotal; }

    public Timestamp getDateValidation() { return dateValidation; }

    public void setDateValidation(Timestamp dateValidation) { this.dateValidation = dateValidation; }

    @Override
    public String toString() {
        return "Panier{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", prixTotal=" + prixTotal +
                ", dateValidation=" + dateValidation +
                '}';
    }
}
