package tn.esprit.entities;

import java.sql.Timestamp;

public class Reservation {
    private int id;
    private int idPanier;
    private Integer idVoyage;
    private Integer idChambre;
    private Integer idTransport;
    private String typeService;
    private double prix;
    private Timestamp dateReservation;
    private EtatReservation etat;
    private Integer nbPlaces;

    public Reservation(){}

    public Reservation(int id, Integer idVoyage, Integer idChambre, Integer idTransport, int idPanier, double prix, Timestamp  dateReservation, EtatReservation etat, String typeService, Integer nbPlaces) {
        this.id = id;
        this.idVoyage = idVoyage;
        this.idChambre = idChambre;
        this.idTransport = idTransport;
        this.idPanier = idPanier;
        this.prix = prix;
        this.dateReservation = dateReservation;
        this.etat = etat;
        this.typeService = typeService;
        this.nbPlaces = nbPlaces;
    }

    public Reservation(Integer idVoyage, Integer idChambre, Integer idTransport, int idPanier, double prix, Timestamp  dateReservation, String typeService, Integer nbPlaces) {
        this.idVoyage = idVoyage;
        this.idChambre = idChambre;
        this.idTransport = idTransport;
        this.idPanier = idPanier;
        this.prix = prix;
        this.dateReservation = dateReservation;
        this.typeService = typeService;
        this.etat = EtatReservation.PENDING;
        this.nbPlaces = nbPlaces;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Integer getIdVoyage() { return idVoyage; }

    public void setIdVoyage(Integer idVoyage) { this.idVoyage = idVoyage; }

    public Integer getIdChambre() { return idChambre; }

    public void setIdChambre(Integer idChambre) { this.idChambre = idChambre; }

    public Integer getIdTransport() { return idTransport; }

    public void setIdTransport(Integer idTransport) { this.idTransport = idTransport; }

    public int getIdPanier() { return idPanier; }

    public void setIdPanier(int idPanier) { this.idPanier = idPanier; }

    public double getPrix() { return prix; }

    public void setPrix(double prix) { this.prix = prix; }

    public Timestamp  getDateReservation() { return dateReservation; }

    public void setDateReservation(Timestamp  dateReservation) { this.dateReservation = dateReservation; }

    public EtatReservation getEtat() { return etat; }

    public void setEtat(EtatReservation etat) { this.etat = etat; }

    public String getTypeService() { return typeService; }

    public void setTypeService(String typeService) { this.typeService = typeService; }

    public Integer getNbPlaces() { return nbPlaces; }

    public void setNbPlaces(Integer nbPlaces) { this.nbPlaces = nbPlaces; }


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", idPanier=" + idPanier +
                ", idVoyage=" + idVoyage +
                ", idChambre=" + idChambre +
                ", idTransport=" + idTransport +
                ", typeService='" + typeService + '\'' +
                ", prix=" + prix +
                ", dateReservation=" + dateReservation +
                ", etat=" + etat +
                ", nbPlaces=" + nbPlaces +
                '}';
    }
}
