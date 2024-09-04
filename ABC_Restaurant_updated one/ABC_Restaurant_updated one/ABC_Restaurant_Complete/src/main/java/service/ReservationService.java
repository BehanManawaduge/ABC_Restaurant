package service;

import model.Reservation;
import repository.ReservationRepository;

import java.util.List;

public class ReservationService {

    private ReservationRepository reservationRepository = new ReservationRepository();

    public List<Reservation> getAllReservations() {
        return reservationRepository.getAllReservations();
    }

    public void addReservation(Reservation reservation) {
        reservationRepository.addReservation(reservation);
    }

    public void deleteReservation(int reservationId) {
        reservationRepository.deleteReservation(reservationId);
    }
}
