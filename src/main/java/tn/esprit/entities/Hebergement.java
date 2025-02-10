package tn.esprit.entities;

public class Hebergement {
    private int id;
    private int idUser;
    private String nom;
    private String localisation;
    private Integer nbChambresD;
    private String typeHebergement;
    private String description;

    public Hebergement() {
    }

    public Hebergement(int id, int idUser, String nom, String localisation, Integer nbChambresD, String typeHebergement, String description) {
        this.id = id;
        this.idUser = idUser;
        this.nom = nom;
        this.localisation = localisation;
        this.nbChambresD = nbChambresD;
        this.typeHebergement = typeHebergement;
        this.description = description;
    }

    public Hebergement(int idUser, String nom, String localisation, Integer nbChambresD, String typeHebergement, String description) {
        this.idUser = idUser;
        this.nom = nom;
        this.localisation = localisation;
        this.nbChambresD = nbChambresD;
        this.typeHebergement = typeHebergement;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Integer getNbChambresD() {
        return nbChambresD;
    }

    public void setNbChambresD(Integer nbChambresD) {
        this.nbChambresD = nbChambresD;
    }

    public String getTypeHebergement() {
        return typeHebergement;
    }

    public void setTypeHebergement(String typeHebergement) {
        this.typeHebergement = typeHebergement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Hebergement{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", nom='" + nom + '\'' +
                ", localisation='" + localisation + '\'' +
                ", nbChambresD=" + nbChambresD +
                ", typeHebergement='" + typeHebergement + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}