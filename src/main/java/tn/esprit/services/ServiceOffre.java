package tn.esprit.services;

import tn.esprit.entities.Offre;
import tn.esprit.entities.Voyage;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceOffre implements IService<Offre> {
    private Connection connection;
    public ServiceOffre(){
        connection = MyDataBase.getInstance().getConnection();
    }
    @Override
    public void ajouter(Offre offre) throws SQLException {
        String sql = "INSERT INTO `offre` (`titre`, `description`, `reduction`, `dateDebut`, `dateFin`) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, offre.getTitre());
        ps.setString(2, offre.getDescription());
        ps.setFloat(3, offre.getReduction());
        ps.setTimestamp(4, offre.getDateDebut());
        ps.setTimestamp(5, offre.getDateFin());

        ps.executeUpdate();
    }

    @Override
    public void modifier(Offre offre) throws SQLException {
        String sql = "UPDATE `offre` SET `titre`=?, `reduction`=?, `description`=?, `dateDebut`=?, `dateFin`=? WHERE `id` = ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, offre.getTitre());
        ps.setFloat(2, offre.getReduction());
        ps.setString(3, offre.getDescription());
        ps.setTimestamp(4, offre.getDateDebut());
        ps.setTimestamp(5, offre.getDateFin());
        ps.setInt(6, offre.getId());

        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM `offre` WHERE id =?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Offre> afficher() throws SQLException {
        List<Offre> offres = new ArrayList<>();
        String sql = "SELECT * FROM `offre`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            offres.add(new Offre(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getFloat(4),
                    rs.getTimestamp(5),
                    rs.getTimestamp(6)
            ));
        }
        return offres;
    }





}
