package tn.esprit.services;

import tn.esprit.entities.Hebergement;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceHebergement implements IService<Hebergement> {
    private Connection connection;

    public ServiceHebergement() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Hebergement hebergement) throws SQLException {
        String sql = "INSERT INTO `hebergement`(`id_user`, `nom`, `localisation`, `nbChambresD`, `typeHebergement`, `description`) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, hebergement.getIdUser());
        ps.setString(2, hebergement.getNom());
        ps.setString(3, hebergement.getLocalisation());
        ps.setInt(4, hebergement.getNbChambresD());
        ps.setString(5, hebergement.getTypeHebergement());
        ps.setString(6, hebergement.getDescription());
        ps.executeUpdate();
    }

    @Override
    public void modifier(Hebergement hebergement) throws SQLException {
        String sql = "UPDATE `hebergement` SET `id_user`=?, `nom`=?, `localisation`=?, `nbChambresD`=?, `typeHebergement`=?, `description`=? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, hebergement.getIdUser());
        ps.setString(2, hebergement.getNom());
        ps.setString(3, hebergement.getLocalisation());
        ps.setInt(4, hebergement.getNbChambresD());
        ps.setString(5, hebergement.getTypeHebergement());
        ps.setString(6, hebergement.getDescription());
        ps.setInt(7, hebergement.getId());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `hebergement` WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Hebergement> afficher() throws SQLException {
        List<Hebergement> hebergements = new ArrayList<>();
        String sql = "SELECT * FROM `hebergement`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            hebergements.add(new Hebergement(
                    rs.getInt("id"),
                    rs.getInt("id_user"),
                    rs.getString("nom"),
                    rs.getString("localisation"),
                    rs.getInt("nbChambresD"),
                    rs.getString("typeHebergement"),
                    rs.getString("description")
            ));
        }
        return hebergements;
    }
}