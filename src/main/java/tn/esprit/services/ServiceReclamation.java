package tn.esprit.services;

import tn.esprit.entities.Reclamation;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceReclamation implements IService<Reclamation> {
    private Connection connection;

    public ServiceReclamation() {
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Reclamation reclamation) throws SQLException {
        String sql = "INSERT INTO reclamation (id_user, DateReclamation) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, reclamation.getId_User());
        preparedStatement.setDate(2, (Date) reclamation.getDateReclamation());

        preparedStatement.executeUpdate();
    }


    public Reclamation read(int id) throws SQLException {
        Reclamation reclamation = null;
        String sql = "SELECT * FROM reclamation WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            reclamation = new Reclamation(
                    resultSet.getInt("id"),
                    resultSet.getInt("id_user"),
                    resultSet.getDate("dateReclamation")
            );
        }
        return reclamation;
    }
    @Override
    public List<Reclamation> afficher() throws SQLException {
        List<Reclamation> reclamations = new ArrayList<>();
        String sql = "SELECT * FROM reclamation";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Reclamation reclamation = new Reclamation(
                    resultSet.getInt("id"),
                    resultSet.getInt("id_user"),
                    resultSet.getDate("dateReclamation")
            );
            reclamations.add(reclamation);
        }
        return reclamations;
    }

    @Override
    public void modifier(Reclamation reclamation) throws SQLException {
        String sql = "UPDATE reclamation SET id_user = ?, dateReclamation = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, reclamation.getId());
        preparedStatement.setInt(2, reclamation.getId_User());
        preparedStatement.setDate(3, (Date) reclamation.getDateReclamation());


        preparedStatement.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String sql = "DELETE FROM reclamation WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
