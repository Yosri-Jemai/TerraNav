package tn.esprit.services;

import tn.esprit.entities.Offre;
import tn.esprit.entities.Voyage;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ServiceVoyage implements IService<Voyage> {
    private Connection connection;
    public ServiceVoyage(){
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Voyage voyage) throws SQLException {
        String sql = "INSERT INTO `voyage` (`id_offre`, `id_user`, `pointDepart`, `dateDepart`, `dateRetour`, "
                + "`destination`, `nbPlacesD`, `type`, `prix`, `description`, `titre`, `pathImages`) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, voyage.getId_offre());
        ps.setInt(2, voyage.getId_user());
        ps.setString(3, voyage.getPointDepart());
        ps.setTimestamp(4, voyage.getDateDepart());
        ps.setTimestamp(5, voyage.getDateRetour());
        ps.setString(6, voyage.getDestination());
        ps.setInt(7, voyage.getNbPlacesD());
        ps.setString(8, voyage.getType());
        ps.setFloat(9, voyage.getPrix());
        ps.setString(10, voyage.getDescription());
        ps.setString(11, voyage.getTitre());
        ps.setString(12, voyage.getPathImages());

        ps.executeUpdate();
    }


    @Override
    public void modifier(Voyage voyage) throws SQLException {
        String sql = "UPDATE `voyage` SET `id_offre`=?, `id_user`=?, `pointDepart`=?, `dateDepart`=?, `dateRetour`=?, "
                + "`destination`=?, `nbPlacesD`=?, `type`=?, `prix`=?, `description`=?, `titre`=?, `pathImages`=? WHERE `id` = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, voyage.getId_offre());
        ps.setInt(2, voyage.getId_user());
        ps.setString(3, voyage.getPointDepart());
        ps.setTimestamp(4, voyage.getDateDepart());
        ps.setTimestamp(5, voyage.getDateRetour());
        ps.setString(6, voyage.getDestination());
        ps.setInt(7, voyage.getNbPlacesD());
        ps.setString(8, voyage.getType());
        ps.setFloat(9, voyage.getPrix());
        ps.setString(10, voyage.getDescription());
        ps.setString(11, voyage.getTitre());
        ps.setString(12, voyage.getPathImages());
        ps.setInt(13, voyage.getId()); // Condition WHERE

        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `voyage` WHERE id =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Voyage> afficher() throws SQLException {
        List<Voyage> voyages = new ArrayList<>();
        String sql = " SELECT * FROM `voyage`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            voyages.add(new Voyage(
                    rs.getInt(1),       // id
                    rs.getInt(2),       // id_offre
                    rs.getInt(3),       // id_user
                    rs.getString(4),    // pointDepart
                    rs.getTimestamp(5), // dateDepart
                    rs.getTimestamp(6), // dateRetour
                    rs.getString(7),    // destination
                    rs.getInt(8),       // nbPlacesD
                    rs.getString(9),    // type
                    rs.getFloat(10),    // prix
                    rs.getString(11),   // description
                    rs.getString(12),   // titre
                    rs.getString(13)    // pathImages
            ));

        }
        return voyages;
    }

}
