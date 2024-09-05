package service;

import model.Reservation;
import repository.ReservationRepository;

import java.sql.SQLException;
import java.util.List;

public class ReservationService {

    private ReservationRepository reservationRepository = new ReservationRepository();

    public void saveReservation(Reservation reservation) throws SQLException {
        reservationRepository.saveReservation(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.getAllReservations();
    }

    public void deleteReservation(int reservationId) {
        reservationRepository.deleteReservation(reservationId);
    }
}
