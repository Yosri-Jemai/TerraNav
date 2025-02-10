package tn.esprit.services;

import tn.esprit.entities.Panier;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicePanier implements IService<Panier> {

    private Connection connection;
    public ServicePanier(){
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Panier panier) throws SQLException {
        String query = "INSERT INTO `panier` (`id_user`, `prix_total`, `date_validation`) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, panier.getIdUser());
        ps.setDouble(2, panier.getPrixTotal());
        ps.setTimestamp(3, panier.getDateValidation());
        ps.executeUpdate();
    }

    @Override
    public void modifier(Panier panier) throws SQLException {
        String query = "UPDATE `panier` SET `id_user`=?, `prix_total`=?, `date_validation`=? WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, panier.getIdUser());
        ps.setDouble(2, panier.getPrixTotal());
        ps.setTimestamp(3, panier.getDateValidation());
        ps.setInt(4, panier.getId());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String query = "DELETE FROM `panier` WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Panier> afficher() throws SQLException {
        List<Panier> paniers = new ArrayList<>();
        String query = "SELECT * FROM `panier`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            paniers.add(new Panier(
                    rs.getInt("id"),
                    rs.getInt("id_user"),
                    rs.getDouble("prix_total"),
                    rs.getTimestamp("date_validation")
            ));
        }
        return paniers;
    }

    // Creation d'un panier pour un nouveau utilisateur sans panier

    public Panier getPanierByUser(int idUser) throws SQLException {
        String query = "SELECT * FROM `panier` WHERE id_user=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, idUser);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Panier(
                    rs.getInt("id"),
                    rs.getInt("id_user"),
                    rs.getDouble("prix_total"),
                    rs.getTimestamp("date_validation")
            );
        }
        return null;
    }

    public void createPanierForUser(int idUser) throws SQLException {
        Panier panier = getPanierByUser(idUser);
        if (panier == null) {
            panier = new Panier(idUser, 0.0, null);
            ajouter(panier);
        }
    }

}
