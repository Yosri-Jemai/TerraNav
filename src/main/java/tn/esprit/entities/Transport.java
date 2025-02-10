package tn.esprit.entities;


    public class Transport {
    private int id;
    private int idUser;
    private int idTrajet;
    private String nom;
    private String type;
    private int capacite;
    private String description;
    private String contact;
    private double prix;


    public Transport() {}


    public Transport(int id, int idUser, int idTrajet, String nom, String type, int capacite, String description, String contact, double prix) {
        this.id = id;
        this.idUser = idUser;
        this.idTrajet = idTrajet;
        this.nom = nom;
        this.type = type;
        this.capacite = capacite;
        this.description = description;
        this.contact = contact;
        this.prix = prix;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public int getIdTrajet() { return idTrajet; }
    public void setIdTrajet(int idTrajet) { this.idTrajet = idTrajet; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getCapacite() { return capacite; }
    public void setCapacite(int capacite) { this.capacite = capacite; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
}



