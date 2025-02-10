package tn.esprit.entities;


    public class Trajet {
        private int id;
        private String pointDepart;
        private String destination;
        private String dateDepart;
        private int duree;
        private String description;
        private boolean disponibilite;


        public Trajet() {
        }

        public Trajet(int id, String pointDepart, String destination, String dateDepart, int duree, String description, boolean disponibilite) {
            this.id = id;
            this.pointDepart = pointDepart;
            this.destination = destination;
            this.dateDepart = dateDepart;
            this.duree = duree;
            this.description = description;
            this.disponibilite = disponibilite;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPointDepart() {
            return pointDepart;
        }

        public void setPointDepart(String pointDepart) {
            this.pointDepart = pointDepart;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getDateDepart() {
            return dateDepart;
        }

        public void setDateDepart(String dateDepart) {
            this.dateDepart = dateDepart;
        }

        public int getDuree() {
            return duree;
        }

        public void setDuree(int duree) {
            this.duree = duree;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isDisponibilite() {
            return disponibilite;
        }

        public void setDisponibilite(boolean disponibilite) {
            this.disponibilite = disponibilite;
        }
    }

