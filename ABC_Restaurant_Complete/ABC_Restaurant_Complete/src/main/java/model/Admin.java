package model;

import java.util.List;

public class Admin extends User {

    public Admin(int userId, String username, String password, String role, String contactInfo, String email) {
        super(userId, username, password, role, contactInfo, email);
    }

    public void addUser(User user, List<User> userList) {
        if (user != null) {
            userList.add(user);
            System.out.println("User added successfully: " + user.getUsername());
        } else {
            System.out.println("Invalid user. Cannot be added.");
        }
    }

    public void deleteUser(int userId, List<User> userList) {
        User userToRemove = null;
        for (User user : userList) {
            if (user.getUserId() == userId) {
                userToRemove = user;
                break;
            }
        }

        if (userToRemove != null) {
            userList.remove(userToRemove);
            System.out.println("User removed successfully: " + userToRemove.getUsername());
        } else {
            System.out.println("User not found with ID: " + userId);
        }
    }

    public void viewAllUsers(List<User> userList) {
        if (userList.isEmpty()) {
            System.out.println("No users available.");
        } else {
            System.out.println("List of all users:");
            for (User user : userList) {
                System.out.println("User ID: " + user.getUserId() + ", Username: " + user.getUsername() + ", Role: " + user.getRole());
            }
        }
    }

    public void viewReports(List<Report> reportList) {
        if (reportList.isEmpty()) {
            System.out.println("No reports available.");
        } else {
            System.out.println("List of all reports:");
            for (Report report : reportList) {
                System.out.println("Report ID: " + report.getReportId() + ", Type: " + report.getReportType() + ", Content: " + report.getReportContent());
            }
        }
    }

    public void manageReservations(List<Reservation> reservationList) {
        if (reservationList.isEmpty()) {
            System.out.println("No reservations available.");
        } else {
            System.out.println("List of all reservations:");
            for (Reservation reservation : reservationList) {
                System.out.println("Reservation ID: " + reservation.getReservationId() + ", Service Type: " + reservation.getServiceType() + ", Reservation Date: " + reservation.getReservationDate());
            }
        }
    }
}
