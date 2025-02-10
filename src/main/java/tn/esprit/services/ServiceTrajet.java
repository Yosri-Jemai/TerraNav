package tn.esprit.services;

import tn.esprit.entities.Trajet;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTrajet implements IService<Trajet> {
    private Connection connection;

    public ServiceTrajet() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Trajet trajet) throws SQLException {
        String sql = "INSERT INTO `trajet`(`point_depart`, `destination`, `date_depart`, `duree`, `description`, `disponibilite`) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, trajet.getPointDepart());
        ps.setString(2, trajet.getDestination());
        ps.setString(3, trajet.getDateDepart());
        ps.setInt(4, trajet.getDuree());
        ps.setString(5, trajet.getDescription());
        ps.setBoolean(6, trajet.isDisponibilite());
        ps.executeUpdate();
    }

    @Override
    public void modifier(Trajet trajet) throws SQLException {
        String sql = "UPDATE `trajet` SET `point_depart`=?, `destination`=?, `date_depart`=?, `duree`=?, `description`=?, `disponibilite`=? WHERE `id` = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, trajet.getPointDepart());
        ps.setString(2, trajet.getDestination());
        ps.setString(3, trajet.getDateDepart());
        ps.setInt(4, trajet.getDuree());
        ps.setString(5, trajet.getDescription());
        ps.setBoolean(6, trajet.isDisponibilite());
        ps.setInt(7, trajet.getId());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `trajet` WHERE `id` = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Trajet> afficher() throws SQLException {
        List<Trajet> trajets = new ArrayList<>();
        String sql = "SELECT * FROM `trajet`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            trajets.add(new Trajet(
                    rs.getInt("id"),
                    rs.getString("point_depart"),
                    rs.getString("destination"),
                    rs.getString("date_depart"),
                    rs.getInt("duree"),
                    rs.getString("description"),
                    rs.getBoolean("disponibilite")
            ));
        }
        return trajets;
    }
}
