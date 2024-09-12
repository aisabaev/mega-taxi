package kg.mega.mega_taxi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Permission;

@Repository
public interface Permissions extends JpaRepository<Permission, Long> {
}
