package logicLayer;

import dataLayer.writerAndReader;
import java.time.LocalDate;
import java.util.Vector;
import java.io.*;

public class HRS {
    private Vector<Customer> customers;
    private Vector<Restaurant> restaurants;
    private Vector<Vendor> vendors;
    private writerAndReader readAndWrite;
    private Vector<Receptionist> receptionists;
    private Vector<Admin> admins;

    //constructor
    public HRS() {
        //initializing data members
        customers = new Vector<>();
        restaurants = new Vector<>();
        vendors = new Vector<>();
        readAndWrite = new writerAndReader();
        receptionists = new Vector<>();
        admins = new Vector<>();

        //initializing customers from file
        try {
            File myObj = new File("./src/dataLayer/customers.csv");
            if (!myObj.createNewFile()) {   //if file has already created
                readAndWrite.readCustomersFromFile(customers);
            } else {
                readAndWrite.writeHeadersInFile(0); //0 indicates file of customers to be opened
            }
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        //initializing vendors from file
        try {
            File myObj = new File("./src/dataLayer/vendors.csv");
            if (!myObj.createNewFile()) {   //if file has already created
                readAndWrite.readVendorsFromFile(vendors);
            } else {
                readAndWrite.writeHeadersInFile(1); //1 indicates file of vendors to be opened
            }
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        //initializing receptionists from file
        try {
            File myObj = new File("./src/dataLayer/receptionists.csv");
            if (!myObj.createNewFile()) {   //if file has already created
                readAndWrite.readReceptionistFromFile(receptionists);
            } else {
                readAndWrite.writeHeadersInFile(2); //2 indicates file of receptionists to be opened
            }
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        //initializing hotels from file
        try {
            File myObj = new File("./src/dataLayer/hotels.csv");
            if (!myObj.createNewFile()) {   //if file has already created
                readAndWrite.readHotelsFromFile(restaurants);
            } else {
                readAndWrite.writeHeadersInFile(3); //3 indicates file of hotels to be opened
            }
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        //initializing admins from file
        try {
            File myObj = new File("./src/dataLayer/admins.csv");
            if (!myObj.createNewFile()) {   //if file has already created
                readAndWrite.readAdminsFromFile(admins);
            } else {
                readAndWrite.writeHeadersInFile(4); //2 indicates file of receptionists to be opened
            }
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        //initializing rooms from file
        try {
            File myObj = new File("./src/dataLayer/rooms.csv");
            if (!myObj.createNewFile()) {   //if file has already created
                for (int i = 0; i < restaurants.size(); ++i) {
                    readAndWrite.readRoomsFromFile(restaurants.get(i));
                }
            } else {
                readAndWrite.writeHeadersInFile(5); //5 indicates file of hotels to be opened
            }
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    //getters
    public Vector<Customer> getCustomers() {
        return customers;
    }
    public Vector<Restaurant> getHotels() {
        return restaurants;
    }
    public Vector<Receptionist> getReceptionists() {
        return receptionists;
    }
    public Vector<Vendor> getVendors() {
        return vendors;
    }
    public writerAndReader getReadAndWrite() {
        return readAndWrite;
    }

    //setters
    public void setCustomers(Vector<Customer> customers) {
        this.customers = customers;
    }
    public void setHotels(Vector<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
    public void setReadAndWrite(writerAndReader readAndWrite) {
        this.readAndWrite = readAndWrite;
    }
    public void setReceptionists(Vector<Receptionist> receptionists) {
        this.receptionists = receptionists;
    }
    public void setVendors(Vector<Vendor> vendors) {
        this.vendors = vendors;
    }

    //function to check if customer with same email already exists or not
    public boolean validateCustomerEmail(String email) {
        for (int i = 0; i < customers.size(); ++i) {
            if (email.equals(customers.get(i).getEmail())) {
                return false;
            }
        }
        return true;
    }

    //function to check if customer has logged in correctly or not
    public boolean validateCustomerAccount(String email, String pass) {
        for (int i = 0; i < customers.size(); ++i) {
            if (email.equals(customers.get(i).getEmail()) && customers.get(i).getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    //function to check if admin with same email already exists or not
    public boolean validateAdminEmail(String email) {
        for (int i = 0; i < admins.size(); ++i) {
            if (email.equals(admins.get(i).getEmail())) {
                return false;
            }
        }
        return true;
    }

    //function to check if admin has logged in correctly or not
    public boolean validateAdminAccount(String email, String pass) {
        for (int i = 0; i < admins.size(); ++i) {
            if (email.equals(admins.get(i).getEmail()) && admins.get(i).getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    //function to check if vendor with same email already exists or not
    public boolean validateVendorEmail(String email) {
        for (int i = 0; i < vendors.size(); ++i) {
            if (email.equals(vendors.get(i).getEmail())) {
                return false;
            }
        }
        return true;
    }

    //function to check if vendor has logged in correctly or not
    public boolean validateVendorAccount(String email, String pass) {
        for (int i = 0; i < vendors.size(); ++i) {
            if (email.equals(vendors.get(i).getEmail()) && vendors.get(i).getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    //function to check if receptionist with same email already exists or not
    public boolean validateReceptionistEmail(String email) {
        for (int i = 0; i < receptionists.size(); ++i) {
            if (email.equals(receptionists.get(i).getEmail())) {
                return false;
            }
        }
        return true;
    }

    //function to check if receptionist has logged in correctly or not
    public boolean validateReceptionistAccount(String email, String pass) {
        for (int i = 0; i < receptionists.size(); ++i) {
            if (email.equals(receptionists.get(i).getEmail()) && receptionists.get(i).getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    //function to check if hotel with same name and location already exists or not
    public boolean validateHotel(String name, String loc) {
        for (int i = 0; i < restaurants.size(); ++i) {
            if (name.equals(restaurants.get(i).getName()) && loc.equals(restaurants.get(i).getLocation())) {
                return false;
            }
        }
        return true;
    }

    //function for customer registration
    public void registerCustomer(String name, String email, String pass,
                                 String add, String phone, String cnic, String accNo) {
        int ID = 0;

        //getting maximum ID
        for (int i = 0; i < customers.size(); ++i) {
            if (customers.get(i).getID() > ID) {
                ID = customers.get(i).getID();
            }
        }
        ID++;

        //registering customer
        Customer c = new Customer(ID, email, pass, name, add, phone, cnic, accNo);
        customers.add(c);
        readAndWrite.writeCustomerIntoFile(c);
    }

    //function for Admin registration
    public void registerAdmin(String name, String email, String pass,
                              String add, String phone, String cnic, String accNo) {
        int ID = 0;

        //getting maximum ID
        for (int i = 0; i < admins.size(); ++i) {
            if (admins.get(i).getID() > ID) {
                ID = admins.get(i).getID();
            }
        }
        ID++;

        //registering Admin
        Admin v = new Admin(ID, email, pass, name, add, phone, cnic, accNo);
        admins.add(v);
        readAndWrite.writeAdminIntoFile(v);
    }

    //function for vendor registration
    public void registerVendor(String name, String email, String pass,
                               String add, String phone, String cnic, String accNo) {
        int ID = 0;

        //getting maximum ID
        for (int i = 0; i < vendors.size(); ++i) {
            if (vendors.get(i).getID() > ID) {
                ID = vendors.get(i).getID();
            }
        }
        ID++;

        //registering vendor
        Vendor v = new Vendor(ID, email, pass, name, add, phone, cnic, accNo);
        vendors.add(v);
        readAndWrite.writeVendorIntoFile(v);
    }

    //function for receptionist registration
    public void registerReceptionist(String name, String email, String pass,
                                     String add, String phone, String cnic, String accNo) {
        int ID = 0;

        //getting maximum ID
        for (int i = 0; i < receptionists.size(); ++i) {
            if (receptionists.get(i).getID() > ID) {
                ID = receptionists.get(i).getID();
            }
        }
        ID++;

        //registering vendor
        Receptionist r = new Receptionist(ID, email, pass, name, add, phone, cnic, accNo);
        receptionists.add(r);
        readAndWrite.writeReceptionistIntoFile(r);
    }

    //function for hotel registration
    public void registerHotel(String name, String add, String loc, String singleRooms, String doubleRooms,
                              String singleRoomPrice, String doubleRoomPrice) {
        int ID = 0;

        //getting maximum ID
        for (int i = 0; i < restaurants.size(); ++i) {
            if (restaurants.get(i).getID() > ID) {
                ID = restaurants.get(i).getID();
            }
        }
        ID++;

        //registering hotel
        Restaurant h = new Restaurant(ID, name, add, loc, singleRooms, doubleRooms, singleRoomPrice, doubleRoomPrice);
        restaurants.add(h);
        readAndWrite.writeHotelIntoFile(h);
        readAndWrite.writeRoomsIntoFile(h);
    }

    //function for hotel booking
    public Vector<Restaurant> getHotels(String location, String noOfPersons, LocalDate checkInDate, String roomType, boolean both) {
        Vector<Restaurant> searchedRestaurants = new Vector<>();
        for (int i = 0; i < restaurants.size(); ++i) {
            if (restaurants.get(i).getLocation().equals(location)) {
                Restaurant h1 = new Restaurant();
                h1.setAddress(restaurants.get(i).getAddress());
                h1.setName(restaurants.get(i).getName());
                h1.setID(restaurants.get(i).getID());
                h1.setRooms(restaurants.get(i).getRooms());
                h1.setTotalRooms(restaurants.get(i).getTotalRooms());
                h1.setLocation(restaurants.get(i).getLocation());
                h1.setDoubletableprice(restaurants.get(i).getDoubletableprice());
                h1.setDoubletable(restaurants.get(i).getDoubletable());
                h1.setSingletable(restaurants.get(i).getSingletable());
                h1.setSingletableprice(restaurants.get(i).getSingletableprice());
                h1.setReservations(restaurants.get(i).getReservations());
                Vector<Food> r;
                r = restaurants.get(i).getRooms(noOfPersons, checkInDate, roomType, both);
                if (r != null) {
                    h1.setRooms(r);
                    searchedRestaurants.add(h1);
                }
            }
        }
        return searchedRestaurants;
    }

    //function for reserving room
    public void makeReservation(String email, Restaurant h, LocalDate checkInDate, LocalDate checkOutDate) {
        //finding customer and calling for reservation
        for (int i = 0; i < customers.size(); ++i) {
            if (customers.get(i).getEmail().equals(email)) {
                h.reserveRoom(checkInDate, checkOutDate, customers.get(i), restaurants);
                readAndWrite.truncAFile("./src/dataLayer/rooms.csv");
                readAndWrite.writeHeadersInFile(5);
                for (int j = 0; j < restaurants.size(); ++j) {
                    readAndWrite.writeRoomsIntoFile(restaurants.get(j));
                }
                break;
            }
        }
    }

    //Function to Edit Customer
    public void editCustomerSelect(String Email,String ChangeType,String Change){
        admins.get(0).editCustomer(Email,ChangeType,Change,customers,readAndWrite);
    }

    //Function to Delete Customer
    public void DeleteCustomerSelect(String Email) {
        admins.get(0).DeleteCustomer(Email, customers, readAndWrite);
    }
    //Function to Edit Vendor
    public void editVendorSelect(String Email, String ChangeType,String Change){
        admins.get(0).editVendor(Email,ChangeType,Change,vendors,readAndWrite);
    }


    //Function to Delete Vendor
    public void DeleteVendorSelect(String Email){
        admins.get(0).DeleteVendor(Email, vendors, readAndWrite);
    }

    //Function to Edit Hotel
    public void editHotelSelect(String Name,String Loc,String ChangeType,String Change ){
        admins.get(0).editHotel(Name,Loc,ChangeType,Change, restaurants,readAndWrite);
    }

    //Function to Delete Hotel
    public void DeleteHotelSelect(String Name,String Loc){
        admins.get(0).DeleteHotel(Name,Loc, restaurants, readAndWrite);
    }

    //Function to Edit Receptionist
    public void editReceptionistSelect(String Email,String ChangeType,String Change  ){
        admins.get(0).editReceptionist(Email,ChangeType,Change,receptionists,readAndWrite);
    }

    //Function to Delete Receptionist
    public void DeleteReceptionistSelect(String Email){
        admins.get(0).DeleteReceptionist(Email, receptionists, readAndWrite);
    }

    // Search Customer On Email Basis
    public Customer searchCustomerByMail(String Email){
        for(int i=0;i<customers.size();++i){
            if(Email.equals(customers.get(i).getEmail())){
                return customers.get(i);
            }
        }
        return null;
    }
    // Search Receptionist On Email Basis
    public Receptionist searchReceptionistByMail(String Email){
        for(int i=0;i<receptionists.size();++i){
            if(Email.equals(receptionists.get(i).getEmail())){
                return receptionists.get(i);
            }
        }
        return null;
    }
    // Search Vendor On Email Basis
    public Vendor searchVendorByMail(String Email){
        for(int i=0;i<vendors.size();++i){
            if(Email.equals(vendors.get(i).getEmail())){
                return vendors.get(i);
            }
        }
        return null;
    }
    // Search Hotel On Name and Location Basis
    public Restaurant searchHotelByNameLoc(String Name, String Loc){
        for(int i = 0; i< restaurants.size(); ++i){
            if(Name.equals(restaurants.get(i).getName()) && Loc.equals(restaurants.get(i).getLocation())){
                return restaurants.get(i);
            }
        }
        return null;
    }
    // Search Admin On Email Basis
    public Admin searchAdminByMail(String Email){
        for(int i=0;i<admins.size();++i){
            if(Email.equals(admins.get(i).getEmail())){
                return admins.get(i);
            }
        }
        return null;
    }

    // Login Customer On Email and Password Basis
    public Boolean LoginCustomer(String Email,String Pass){
        for(int i=0;i<customers.size();++i){
            if(Email.equals(customers.get(i).getEmail()) &&  Pass.equals(customers.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }
    // Login Admin On Email and Password Basis
    public Boolean LoginAdmin(String Email,String Pass){
        for(int i=0;i<admins.size();++i){
            if(Email.equals(admins.get(i).getEmail()) &&  Pass.equals(admins.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }
    // Login Vendor On Email and Password Basis
    public Boolean LoginVendor(String Email,String Pass){
        for(int i=0;i<vendors.size();++i){
            if(Email.equals(vendors.get(i).getEmail()) &&  Pass.equals(vendors.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }
    // Login Receptionist On Email and Password Basis
    public Boolean LoginReceptionist(String Email,String Pass){
        for(int i=0;i<receptionists.size();++i){
            if(Email.equals(receptionists.get(i).getEmail()) &&  Pass.equals(receptionists.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }
}
