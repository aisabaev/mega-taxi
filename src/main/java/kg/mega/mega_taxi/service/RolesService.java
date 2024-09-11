package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Cars;
import kg.mega.mega_taxi.model.Roles;
import kg.mega.mega_taxi.repository.RolesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RolesService {

    private final RolesRepository rolesRepository;
    
    public void createRole(Roles role) {
        rolesRepository.save(role);
    }

    public void deleteCar(Long id) {
        rolesRepository.deleteById(id);
    }

    public boolean updateCar(Roles role, Long id) {
        Roles roleToUpdate = rolesRepository.findById(id).orElse(null);
        if (roleToUpdate != null) {
            roleToUpdate.setRole(role.getRole());
            roleToUpdate.setPermissions(role.getPermissions());
            rolesRepository.save(roleToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public Roles getRole(Long id) {
        return rolesRepository.findById(id).orElse(null);
    }
}
