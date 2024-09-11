package model;

public class User {
    private int userId;
    private String username;
    private String password;
    private String role;
    private String contactInfo;
    private String email;

    public User(int userId, String username, String password, String role, String contactInfo, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.contactInfo = contactInfo;
        this.email = email;
    }

    public User(int userId, String username, String password, String role) {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
