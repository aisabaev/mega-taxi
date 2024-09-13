package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Orders;
import kg.mega.mega_taxi.model.OrdersHistory;
import kg.mega.mega_taxi.repository.OrdersHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class OrdersHistoryService {

    private final OrdersHistoryRepository ordersHistoryRepository;

    public void createOrder(OrdersHistory order){
        ordersHistoryRepository.save(order);
    }

    public void deleteOrder(Long id){
        ordersHistoryRepository.deleteById(id);
    }

    public boolean updateOrder(OrdersHistory order, Long id){
        OrdersHistory orderToUpdate = ordersHistoryRepository.findById(id).orElse(null);
        if(orderToUpdate != null){
            orderToUpdate.setOrderStatus(order.getOrderStatus());
            orderToUpdate.setClient(order.getClient());
            orderToUpdate.setDriver(order.getDriver());
            orderToUpdate.setSourcePoint(order.getSourcePoint());
            orderToUpdate.setEndPoint(order.getEndPoint());
            orderToUpdate.setPrice(order.getPrice());
            ordersHistoryRepository.save(orderToUpdate);
            return true;
        }else{
            return false;
        }
    }

    public OrdersHistory getOrder(Long id){
        return ordersHistoryRepository.findById(id).orElse(null);
    }
}
