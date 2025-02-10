package tn.esprit.entities;

public class Chambre {
    private int id;
    private int idHebergement;
    private String numero;
    private boolean disponibilite;
    private double prix;
    private String description;

    public Chambre() {
    }

    public Chambre(int id, int idHebergement, String numero, boolean disponibilite, double prix, String description) {
        this.id = id;
        this.idHebergement = idHebergement;
        this.numero = numero;
        this.disponibilite = disponibilite;
        this.prix = prix;
        this.description = description;
    }

    public Chambre(int idHebergement, String numero, boolean disponibilite, double prix, String description) {
        this.idHebergement = idHebergement;
        this.numero = numero;
        this.disponibilite = disponibilite;
        this.prix = prix;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHebergement() {
        return idHebergement;
    }

    public void setIdHebergement(int idHebergement) {
        this.idHebergement = idHebergement;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Chambre{" +
                "id=" + id +
                ", idHebergement=" + idHebergement +
                ", numero='" + numero + '\'' +
                ", disponibilite=" + disponibilite +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                '}';
    }
}