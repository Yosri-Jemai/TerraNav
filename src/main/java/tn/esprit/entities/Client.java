package tn.esprit.entities;

public class Client extends User {
    private String nom;
    private String prenom;
    private String cin;



    public Client(int id, String username, String password, String email, String numTel, String address, String role, String nom, String prenom, String cin) {
        super(id, username, password, email, numTel, address, role);
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
    }

    public Client(String username, String password, String email, String numTel, String address, String role, String nom, String prenom, String cin) {
        super(username, password, email, numTel, address, role);
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
    }

    public Client() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", cin='" + cin + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", numTel='" + numTel + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
