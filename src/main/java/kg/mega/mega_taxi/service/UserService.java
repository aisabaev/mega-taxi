package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Users;
import kg.mega.mega_taxi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void createUser(Users user){
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public boolean updateUser(Users user, Long id){
        Users userToUpdate = userRepository.findById(id).orElse(null);
        if(userToUpdate != null){
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPhoneNumber(user.getPhoneNumber());
            userRepository.save(userToUpdate);
            return true;
        }else{
            return false;
        }
    }

    public Users getUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public List<Users> getAllUsers(String filter){
        if (filter == null || filter.isEmpty()){
            return userRepository.findAll();
        }
        return userRepository.findAll().stream()
                .filter(users1 -> users1.getRoles().equals(filter) || users1.getFirstName().equals(filter) ||
                        users1.getLastName().equals(filter) || users1.getEmail().equals(filter) ||
                        users1.getPhoneNumber().equals(filter)
                ).toList();
    }
}
