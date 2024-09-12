package kg.mega.mega_taxi.service;

import kg.mega.mega_taxi.model.Orders;
import kg.mega.mega_taxi.repository.OrdersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrdersService {
    
    private final OrdersRepository ordersRepository;

    public void createOrder(Orders order){
        ordersRepository.save(order);
    }

    public void deleteOrder(Long id){
        ordersRepository.deleteById(id);
    }

    public boolean updateOrder(Orders order, Long id){
        Orders orderToUpdate = ordersRepository.findById(id).orElse(null);
        if(orderToUpdate != null){
            orderToUpdate.setStatusOrder(order.getStatusOrder());
            orderToUpdate.setClient(order.getClient());
            orderToUpdate.setDriver(order.getDriver());
            orderToUpdate.setSourcePoint(order.getSourcePoint());
            orderToUpdate.setDestinationPoint(order.getDestinationPoint());
            orderToUpdate.setPrice(order.getPrice());
            ordersRepository.save(orderToUpdate);
            return true;
        }else{
            return false;
        }
    }

    public Orders getOrder(Long id){
        return ordersRepository.findById(id).orElse(null);
    }
    
    
}
