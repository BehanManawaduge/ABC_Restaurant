package logicLayer;

import java.time.LocalDate;
import java.util.*;

public class Restaurant {
    private int ID, totalRooms;
    private String singletable, doubletable, singletableprice, doubletableprice, name, address, location;
    private Vector<Food> foods;
    private Vector<Reservation> reservations;

    //constructors
    public Restaurant() {
    }
    public Restaurant(int id, String Name, String add, String loc, String sRooms, String dRooms, String sRoomPrice, String dRoomPrice) {
        //assigning values to data members
        ID = id;
        name = Name;
        address = add;
        totalRooms = Integer.parseInt(sRooms) + Integer.parseInt(dRooms);
        singletable = sRooms;
        doubletable = dRooms;
        location = loc;
        singletableprice = sRoomPrice;
        doubletableprice = dRoomPrice;
        reservations = new Vector<>();

        //making table in restaurant
        foods = new Vector<>();
        for (int i = 0; i < totalRooms; ++i) {
            Food r1;
            if (i < Integer.parseInt(singletable)) {
                r1 = new Food(i + 1, "Single");
            } else {
                r1 = new Food(i + 1, "Double");
            }
            foods.add(r1);
        }
    }

    //getters
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public int getID() {
        return ID;
    }
    public int getTotalRooms() {
        return totalRooms;
    }
    public Vector<Food> getRooms() {
        return foods;
    }
    public String getLocation() {
        return location;
    }
    public String getDoubletable() {
        return doubletable;
    }
    public String getSingletable() {
        return singletable;
    }
    public String getSingletableprice() {
        return singletableprice;
    }
    public Vector<Reservation> getReservations() {
        return reservations;
    }
    public String getDoubletableprice() {
        return doubletableprice;
    }

    //setters
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setRooms(Vector<Food> foods) {
        this.foods = foods;
    }
    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setDoubletable(String doubletable) {
        this.doubletable = doubletable;
    }
    public void setReservations(Vector<Reservation> reservations) {
        this.reservations = reservations;
    }
    public void setSingletable(String singletable) {
        this.singletable = singletable;
    }
    public void setSingletableprice(String singletableprice) {
        this.singletableprice = singletableprice;
    }
    public void setDoubletableprice(String doubletableprice) {
        this.doubletableprice = doubletableprice;
    }

    //return table of restaurant which can accommodate user requirements
    public Vector<Food> getRooms(String noOfPersons, LocalDate checkInDate, String roomType, Boolean both) {
        int personsCount = 0;
        Vector<Food> searchedFoods = new Vector<>();
        for (int i = 0; i < totalRooms; ++i) {
            if (foods.get(i).isAvailable() || checkInDate.isEqual(foods.get(i).getAvailableDate()) ||
                    checkInDate.isAfter(foods.get(i).getAvailableDate())) {
                if (both == true) {
                    if (foods.get(i).getType().equals("Single")) {
                        personsCount += 1;
                    } else {
                        personsCount += 2;
                    }
                    searchedFoods.add(foods.get(i));
                }
                else {
                    if (foods.get(i).getType().equals("Single") && roomType.equals("Single")) {
                        personsCount += 1;
                        searchedFoods.add(foods.get(i));
                    } else if (foods.get(i).getType().equals("Double") && roomType.equals("Double")){
                        personsCount += 2;
                        searchedFoods.add(foods.get(i));
                    }
                }
            }

            if (personsCount >= Integer.parseInt(noOfPersons)) {
                return searchedFoods;
            }
        }
        return null;
    }

    //function for reserving table in a restaurant
    public void reserveRoom(LocalDate checkInDate, LocalDate checkOutDate, Customer c, Vector<Restaurant> restaurants) {
        int temp = 0;
        for (int i = 0; i < foods.size(); ++i) {
            foods.get(i).setAvailable(false);
            foods.get(i).setAvailableDate(checkOutDate.plusDays(1));
        }
        for (int i = 0; i < restaurants.size(); ++i) {
            if (restaurants.get(i).getID() == ID) {
                for (int j = 0; j < restaurants.get(i).getRooms().size(); ++j) {
                    if (restaurants.get(i).getRooms().get(j).getNumber() == foods.get(temp).getNumber()) {
                        restaurants.get(i).getRooms().get(j).setAvailable(foods.get(temp).isAvailable());
                        restaurants.get(i).getRooms().get(j).setAvailableDate(foods.get(temp).getAvailableDate());
                        if ((temp + 1) != foods.size()) {
                            temp++;
                        }
                    }
                }
            }
        }
        Reservation r1 = new Reservation(foods, c, checkInDate, checkOutDate);
        reservations.add(r1);
    }
}
