package kg.mega.mega_taxi.service;


import kg.mega.mega_taxi.exception.*;
import kg.mega.mega_taxi.model.Permissions;
import kg.mega.mega_taxi.repository.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionsService {

    @Autowired
    private PermissionsRepository permissionsRepository;

    public Permissions createPermissions(Permissions permissions){
        try {
            return permissionsRepository.save(permissions);
        }catch (PermissionsNotCreatedException e){
            throw new RuntimeException(e.getMessage() + " " + e.getCause());
        }
    }

    public Optional<Permissions> getPermissionsById(Long Id) {
        try {
            return permissionsRepository.findById(Id);
        }catch (GetPermissionsByIdException e){
            throw new RuntimeException(e.getMessage() + " " + e.getCause());
        }
    }

    public void deletePermissionsById(Long Id) {
        try {
            permissionsRepository.deleteById(Id);
        }catch (DeletePermissionsByIdException e){
            throw new RuntimeException(e.getMessage() + " " + e.getCause());
        }
    }

    public Permissions updatePermissions(Permissions permissions) {
        try {
            return permissionsRepository.save(permissions);
        }catch (UpdatePermissionsException e){
            throw new RuntimeException(e.getMessage() + " " + e.getCause());
        }
    }

}
