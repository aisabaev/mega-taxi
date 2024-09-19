package kg.mega.mega_taxi.repository;

import kg.mega.mega_taxi.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    // TODO. Add search by all user's parameters such as name, phone etc.

}
