package tn.esprit.entities;

public class Agence extends User {
    private String nomAgence;
    public Agence() {
        super();
    }

    public Agence(int id, String username, String password, String email, String numTel, String address, String role, String nomAgence) {
        super(id, username, password, email, numTel, address, role);
        this.nomAgence = nomAgence;

    }

    public Agence(String username, String password, String email, String numTel, String address, String role, String nomAgence) {
        super(username, password, email, numTel, address, role);
        this.nomAgence = nomAgence;

    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }





    @Override
    public String toString() {
        return "Agence{" +
                "nomAgence='" + nomAgence + '\'' +
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
