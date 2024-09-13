package kg.mega.mega_taxi.repository;


import kg.mega.mega_taxi.model.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


<

/** @Импортироовали security.Permission вместо model.Permissions. Исправил */


@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, Long> {
}
