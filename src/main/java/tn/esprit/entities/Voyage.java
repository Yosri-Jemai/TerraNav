package tn.esprit.entities;

import java.sql.Timestamp;

public class Voyage {
    private int id;
    private int id_offre;
    private int id_user;
    private String pointDepart;
    private Timestamp dateDepart;
    private Timestamp dateRetour;
    private String destination;
    private int nbPlacesD;
    private String type;
    private float prix;
    private String description;
    private String titre;
    private String pathImages;

    public Voyage(int id, int id_offre, int id_user, String pointDepart, Timestamp dateDepart, Timestamp dateRetour, String destination, int nbPlacesD, String type, float prix, String description, String titre, String pathImages) {
        this.id = id;
        this.id_offre = id_offre;
        this.id_user = id_user;
        this.pointDepart = pointDepart;
        this.dateDepart = dateDepart;
        this.dateRetour = dateRetour;
        this.destination = destination;
        this.nbPlacesD = nbPlacesD;
        this.type = type;
        this.prix = prix;
        this.description = description;
        this.titre = titre;
        this.pathImages = pathImages;
    }
    public Voyage() {}

    public Voyage(int id_offre, int id_user, String pointDepart, Timestamp dateDepart, Timestamp dateRetour, String destination, int nbPlacesD, String type, float prix, String description, String titre, String pathImages) {
        this.id_offre = id_offre;
        this.id_user = id_user;
        this.pointDepart = pointDepart;
        this.dateDepart = dateDepart;
        this.dateRetour = dateRetour;
        this.destination = destination;
        this.nbPlacesD = nbPlacesD;
        this.type = type;
        this.prix = prix;
        this.description = description;
        this.titre = titre;
        this.pathImages = pathImages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getPointDepart() {
        return pointDepart;
    }

    public void setPointDepart(String pointDepart) {
        this.pointDepart = pointDepart;
    }

    public Timestamp getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Timestamp dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Timestamp getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Timestamp dateRetour) {
        this.dateRetour = dateRetour;
    }

    public int getNbPlacesD() {
        return nbPlacesD;
    }

    public void setNbPlacesD(int nbPlacesD) {
        this.nbPlacesD = nbPlacesD;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathImages() {
        return pathImages;
    }

    public void setPathImages(String pathImages) {
        this.pathImages = pathImages;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public String toString() {
        return "Voyage{" +
                "id=" + id +
                ", id_offre=" + id_offre +
                ", id_user=" + id_user +
                ", pointDepart='" + pointDepart + '\'' +
                ", dateDepart=" + dateDepart +
                ", dateRetour=" + dateRetour +
                ", destination='" + destination + '\'' +
                ", nbPlacesD=" + nbPlacesD +
                ", type='" + type + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", titre='" + titre + '\'' +
                ", pathImages='" + pathImages + '\'' +
                '}';
    }
}
