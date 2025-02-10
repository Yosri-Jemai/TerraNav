package tn.esprit.entities;

public class Image {
    private int id;
    private int idChambre;
    private String urlImage;

    public Image() {
    }

    public Image(int id, int idChambre, String urlImage) {
        this.id = id;
        this.idChambre = idChambre;
        this.urlImage = urlImage;
    }

    public Image(int idChambre, String urlImage) {
        this.idChambre = idChambre;
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", idChambre=" + idChambre +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}