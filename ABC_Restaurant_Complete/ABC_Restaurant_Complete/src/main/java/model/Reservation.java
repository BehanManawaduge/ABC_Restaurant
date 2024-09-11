package model;

public class Reservation {
    private int reservationId;
    private String serviceType;
    private String reservationDate;
    private String details;
    private String status;

    public Reservation(int reservationId, String serviceType, String reservationDate, String details, String status) {
        this.reservationId = reservationId;
        this.serviceType = serviceType;
        this.reservationDate = reservationDate;
        this.details = details;
        this.status = status;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
