package logicLayer;

import java.time.LocalDate;
import java.util.*;

public class Reservation {
    private Vector<Food> reservedFoods;
    private Customer customer;
    private LocalDate checkInDate, checkOutDate;

    public Reservation(Vector<Food> foods, Customer c, LocalDate inDate, LocalDate outDate) {
        reservedFoods = foods;
        customer = c;
        checkInDate = inDate;
        checkOutDate = outDate;
    }
}
