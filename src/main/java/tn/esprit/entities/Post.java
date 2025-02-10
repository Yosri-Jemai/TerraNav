package tn.esprit.entities;
import java.util.Date;

public class Post {
    private int id;
    private int idUser;
    private String statut;
    private Date date;
    private String image;
    private int nbCommentaires;
    private int nbReactions;

    public Post( ) {}
    public Post(int id, int idUser, String statut, Date date, String image, int nbCommentaires, int nbReactions) {
        this.id = id;
        this.idUser = idUser;
        this.statut = statut;
        this.date = date;
        this.image = image;
        this.nbCommentaires = nbCommentaires;
        this.nbReactions = nbReactions;
    }
    public Post(int idUser, String statut, Date date, String image, int nbCommentaires, int nbReactions) {
        this.idUser = idUser;
        this.statut = statut;
        this.date = date;
        this.image = image;
        this.nbCommentaires = nbCommentaires;
        this.nbReactions = nbReactions;
    }

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getStatut() {
        return statut;
    }

    public Date getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }

    public int getNbCommentaires() {
        return nbCommentaires;
    }

    public int getNbReactions() {
        return nbReactions;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setNbCommentaires(int nbCommentaires) {
        this.nbCommentaires = nbCommentaires;
    }

    public void setNbReactions(int nbReactions) {
        this.nbReactions = nbReactions;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", statut='" + statut + '\'' +
                ", date=" + date +
                ", image='" + image + '\'' +
                ", nbCommentaires=" + nbCommentaires +
                ", nbReactions=" + nbReactions +
                '}';
    }
}
