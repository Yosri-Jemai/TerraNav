package tn.esprit.services;

import tn.esprit.Services.IService;
import tn.esprit.entities.Transport;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTransport implements IService<Transport> {
    private Connection connection;

    public ServiceTransport() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Transport transport) throws SQLException {
        String sql = "INSERT INTO `transport`(`id_user`, `id_trajet`, `nom`, `type`, `capacite`, `description`, `contact`, `prix`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, transport.getIdUser());
        ps.setInt(2, transport.getIdTrajet());
        ps.setString(3, transport.getNom());
        ps.setString(4, transport.getType());
        ps.setInt(5, transport.getCapacite());
        ps.setString(6, transport.getDescription());
        ps.setString(7, transport.getContact());
        ps.setDouble(8, transport.getPrix());
        ps.executeUpdate();
    }

    @Override
    public void modifier(Transport transport) throws SQLException {
        String sql = "UPDATE `transport` SET `id_user`=?, `id_trajet`=?, `nom`=?, `type`=?, `capacite`=?, `description`=?, `contact`=?, `prix`=? WHERE `id` = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, transport.getIdUser());
        ps.setInt(2, transport.getIdTrajet());
        ps.setString(3, transport.getNom());
        ps.setString(4, transport.getType());
        ps.setInt(5, transport.getCapacite());
        ps.setString(6, transport.getDescription());
        ps.setString(7, transport.getContact());
        ps.setDouble(8, transport.getPrix());
        ps.setInt(9, transport.getId());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `transport` WHERE `id` = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Transport> afficher() throws SQLException {
        List<Transport> transports = new ArrayList<>();
        String sql = "SELECT * FROM `transport`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            transports.add(new Transport(
                    rs.getInt("id"),
                    rs.getInt("id_user"),
                    rs.getInt("id_trajet"),
                    rs.getString("nom"),
                    rs.getString("type"),
                    rs.getInt("capacite"),
                    rs.getString("description"),
                    rs.getString("contact"),
                    rs.getDouble("prix")
            ));
        }
        return transports;
    }
}
