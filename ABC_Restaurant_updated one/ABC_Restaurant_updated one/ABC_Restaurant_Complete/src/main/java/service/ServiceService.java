
package service;

import model.Service;
import repository.ServiceRepository;

import java.sql.SQLException;
import java.util.List;

public class ServiceService {
    private ServiceRepository serviceRepository = new ServiceRepository();

    public List<Service> getAllServices() throws SQLException {
        return serviceRepository.getAllServices();
    }

    public void saveService(Service service) throws SQLException {
        serviceRepository.saveService(service);
    }
}
