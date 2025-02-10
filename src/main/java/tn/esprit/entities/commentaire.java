package tn.esprit.entities;

import java.util.Date;

public class commentaire {
    private int id;
    private int id_post;
    private int id_user;
    private Date date;
    private String contenu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public commentaire(int id, int id_post, int id_user, Date date, String contenu) {
        this.id = id;
        this.id_post = id_post;
        this.id_user = id_user;
        this.date = date;
        this.contenu = contenu;
    }
    public commentaire(int id_post, int id_user, Date date, String contenu) {
        this.id_post = id_post;
        this.id_user = id_user;
        this.date = date;
        this.contenu = contenu;
    }
    public commentaire() {}

    @Override
    public String toString() {
        return "commentaire{" +
                "id=" + id +
                ", id_post=" + id_post +
                ", id_user=" + id_user +
                ", date=" + date +
                ", contenu='" + contenu + '\'' +
                '}';
    }
}
