package kg.mega.mega_taxi.repository;

import kg.mega.mega_taxi.model.OrdersHistory;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersHistoryRepository extends JpaRepository<OrdersHistory, Long> {
}
