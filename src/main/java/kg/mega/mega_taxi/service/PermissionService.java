package kg.mega.mega_taxi.service;


import kg.mega.mega_taxi.model.Permissions;
import kg.mega.mega_taxi.repository.PermissionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PermissionService {

    private final PermissionsRepository PermissionsRepository;

    public void createPermission(Permissions Permission) {
        PermissionsRepository.save(Permission);
    }

    public void deletePermission(Long id) {
        PermissionsRepository.deleteById(id);
    }

    public boolean updatePermission(Permissions Permission, Long id) {
        Permissions PermissionToUpdate = PermissionsRepository.findById(id).orElse(null);
        if (PermissionToUpdate != null) {
            PermissionToUpdate.setPermissionName(Permission.getPermissionName());
            PermissionsRepository.save(PermissionToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public Permissions getPermission(Long id) {
        return PermissionsRepository.findById(id).orElse(null);


    }
}