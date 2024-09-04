
package service;

import model.Admin;
import repository.AdminRepository;

import java.sql.SQLException;
import java.util.List;

public class AdminService {
    private AdminRepository adminRepository = new AdminRepository();

    public List<Admin> getAllAdmins() throws SQLException {
        return adminRepository.getAllAdmins();
    }

    public void registerAdmin(Admin admin) throws SQLException {
        adminRepository.saveAdmin(admin);
    }
}
