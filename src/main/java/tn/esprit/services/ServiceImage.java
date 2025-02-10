package tn.esprit.services;

import tn.esprit.entities.Image;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImage implements IService<Image> {
    private Connection connection;

    public ServiceImage() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Image image) throws SQLException {
        String sql = "INSERT INTO `image`(`id_chanbre`, `url_image`) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, image.getIdChambre());
        ps.setString(2, image.getUrlImage());
        ps.executeUpdate();
    }

    @Override
    public void modifier(Image image) throws SQLException {
        String sql = "UPDATE `image` SET `id_chanbre`=?, `url_image`=? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, image.getIdChambre());
        ps.setString(2, image.getUrlImage());
        ps.setInt(3, image.getId());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `image` WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Image> afficher() throws SQLException {
        List<Image> images = new ArrayList<>();
        String sql = "SELECT * FROM `image`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            images.add(new Image(
                    rs.getInt("id"),
                    rs.getInt("id_chanbre"),
                    rs.getString("url_image")
            ));
        }
        return images;
    }
}