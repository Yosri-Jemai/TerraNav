package tn.esprit.entities;
import java.sql.Timestamp;

public class Offre {
    private int id;
    private String titre;
    private String description;
    private float reduction;
    private Timestamp dateDebut;
    private Timestamp dateFin;

    public Offre(int id, String titre, String description, float reduction, Timestamp dateDebut, Timestamp dateFin) {
        this.id = id;
        this.titre = titre;
        this.reduction = reduction;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Offre(String titre, String description, float reduction, Timestamp dateDebut, Timestamp dateFin) {
        this.titre = titre;
        this.description = description;
        this.reduction = reduction;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Offre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", reduction=" + reduction +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}
