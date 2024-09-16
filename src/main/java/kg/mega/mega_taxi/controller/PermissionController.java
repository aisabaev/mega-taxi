package kg.mega.mega_taxi.controller;


import kg.mega.mega_taxi.model.OrderStatus;
import kg.mega.mega_taxi.model.Permissions;
import kg.mega.mega_taxi.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Permission")
public class PermissionController {

    @Autowired
    PermissionsService permissionsService;


    @GetMapping("/byId")
    public ResponseEntity<?> getPermissionById(@RequestParam long id){
        try {
            return ResponseEntity.ok(permissionsService.getPermissionsById(id));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPermissions(@RequestBody Permissions permissions){
        try {
            if (permissions.getPermissionName() != null){
                permissionsService.createPermissions(permissions);
                return ResponseEntity.ok().body("Good Request");
            }else {
                return ResponseEntity.badRequest().build();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePermissions(@RequestParam long id){
        try{
            if (permissionsService.getPermissionsById(id).isPresent()){
                permissionsService.deletePermissionsById(id);
                return ResponseEntity.ok().body("Permissions was deleted");
            }else {
                return ResponseEntity.badRequest().body("Order Status with that id was not found");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    @PutMapping("/edit")
    public ResponseEntity<?> editPermission(@RequestBody Permissions permission, @RequestParam Long id){
        try {
            if (permissionsService.getPermissionsById(id).isPresent()) {
                permissionsService.updatePermissions(permission, id);
                return ResponseEntity.ok().body("Your change was successful");
            }else {
                return ResponseEntity.badRequest().body("Edited was failed");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}