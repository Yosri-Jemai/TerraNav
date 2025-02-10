package tn.esprit.services;

import tn.esprit.entities.EtatReservation;
import tn.esprit.entities.Reservation;
import tn.esprit.utils.MyDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceReservation implements IService<Reservation> {

    private Connection connection;
    public ServiceReservation(){
        connection = MyDataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Reservation reservation) throws SQLException {
        String query = "INSERT INTO `reservation` (`id_panier`,`id_voyage`,`id_Chambre`,`id_Transport`,`type_service`, `prix`, `date_reservation`, `Etat`,`nb_places`) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, reservation.getIdPanier());
        ps.setObject(2, reservation.getIdVoyage(),Types.INTEGER);
        ps.setObject(3, reservation.getIdChambre(),Types.INTEGER);
        ps.setObject(4, reservation.getIdTransport(),Types.INTEGER);
        ps.setString(5, reservation.getTypeService());
        ps.setDouble(6, reservation.getPrix());
        ps.setTimestamp(7, reservation.getDateReservation());
        ps.setString(8, reservation.getEtat().name());
        ps.setObject(9, reservation.getNbPlaces(),Types.INTEGER);
        ps.executeUpdate();
    }

    @Override
    public void modifier(Reservation reservation) throws SQLException {
        String sql = "UPDATE `Reservation` SET `id_panier`=?,`id_voyage`=?,`id_Chambre`=?,`id_Transport`=?,`type_service`=?, `prix`=?, `date_reservation`=?, `Etat`=?,`nb_places`=? " +
                "WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, reservation.getIdPanier());
        ps.setObject(2, reservation.getIdVoyage(),Types.INTEGER);
        ps.setObject(3, reservation.getIdChambre(),Types.INTEGER);
        ps.setObject(4, reservation.getIdTransport(),Types.INTEGER);
        ps.setString(5, reservation.getTypeService());
        ps.setDouble(6, reservation.getPrix());
        ps.setTimestamp(7, reservation.getDateReservation());
        ps.setString(8, reservation.getEtat().name());
        ps.setObject(9, reservation.getNbPlaces(),Types.INTEGER);
        ps.setInt(10, reservation.getId());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String query = "DELETE FROM `reservation` WHERE id =?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public List<Reservation> afficher() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = " SELECT * FROM `reservation`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()){
            reservations.add(new Reservation(rs.getInt("id"),rs.getObject("id_voyage", Integer.class),rs.getObject("id_Chambre", Integer.class),
                    rs.getObject("id_Transport", Integer.class), rs.getInt("id_panier"), rs.getDouble("prix"), rs.getTimestamp("date_reservation"),
                    EtatReservation.valueOf(rs.getString("Etat")),rs.getString("type_service"), rs.getObject("nb_places", Integer.class)));
        }
        return reservations;
    }

    public Reservation getReservationById(int id) throws SQLException {
        String query = "SELECT * FROM `reservation` WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Reservation(
                    rs.getInt("id"),
                    rs.getObject("id_voyage", Integer.class),
                    rs.getObject("id_Chambre", Integer.class),
                    rs.getObject("id_Transport", Integer.class),
                    rs.getInt("id_panier"),
                    rs.getDouble("prix"),
                    rs.getTimestamp("date_reservation"),
                    EtatReservation.valueOf(rs.getString("Etat")),
                    rs.getString("type_service"),
                    rs.getObject("nb_places", Integer.class)
            );
        }
        return null;
    }
}
