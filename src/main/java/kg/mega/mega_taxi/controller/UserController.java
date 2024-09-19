package kg.mega.mega_taxi.controller;


import kg.mega.mega_taxi.model.Users;
import kg.mega.mega_taxi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public void createUser(@RequestBody Users user) {
        userService.createUser(user);
    }

    @GetMapping("/id")
    public Users getUserById(@RequestParam("id") Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody Users user, @RequestParam Long id) {
        userService.updateUser(user, id);
    }


    @DeleteMapping("/delete")
    public void deleteUserById(@RequestParam("id") Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/get_all")
    public List<Users> getAllUsers(@RequestParam(name = "filter") String filter) {
        return userService.getAllUsers(filter);
    }




}
