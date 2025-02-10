package tn.esprit.services;

import tn.esprit.entities.Chambre;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceChambre implements IService<Chambre> {
    private Connection connection;

    public ServiceChambre() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Chambre chambre) throws SQLException {
        String sql = "INSERT INTO `chambre`(`id_hebergement`, `numero`, `disponibilité`, `prix`, `description`) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, chambre.getIdHebergement());
        ps.setString(2, chambre.getNumero());
        ps.setBoolean(3, chambre.isDisponibilite());
        ps.setDouble(4, chambre.getPrix());
        ps.setString(5, chambre.getDescription());
        ps.executeUpdate();
    }

    @Override
    public void modifier(Chambre chambre) throws SQLException {
        String sql = "UPDATE `chambre` SET `id_hebergement`=?, `numero`=?, `disponibilité`=?, `prix`=?, `description`=? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, chambre.getIdHebergement());
        ps.setString(2, chambre.getNumero());
        ps.setBoolean(3, chambre.isDisponibilite());
        ps.setDouble(4, chambre.getPrix());
        ps.setString(5, chambre.getDescription());
        ps.setInt(6, chambre.getId());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `chambre` WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Chambre> afficher() throws SQLException {
        List<Chambre> chambres = new ArrayList<>();
        String sql = "SELECT * FROM `chambre`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            chambres.add(new Chambre(
                    rs.getInt("id"),
                    rs.getInt("id_hebergement"),
                    rs.getString("numero"),
                    rs.getBoolean("disponibilité"),
                    rs.getDouble("prix"),
                    rs.getString("description")
            ));
        }
        return chambres;
    }
}