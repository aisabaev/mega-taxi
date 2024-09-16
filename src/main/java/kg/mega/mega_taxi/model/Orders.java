package kg.mega.mega_taxi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_point")
    private String sourcePoint;

    @Column(name = "destination_point")
    private String destinationPoint;

    @OneToOne
    @JoinColumn(name = "client")
    private Users client;

    @OneToOne
    @JoinColumn(name = "driver")
    private Users driver;

    private double price;

    @OneToOne
    @JoinColumn(name = "order_status")
    private OrderStatus statusOrder;

    public OrderStatus getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(OrderStatus statusOrder) {
        this.statusOrder = statusOrder;
    }

    public String getSourcePoint() {
        return sourcePoint;
    }

    public void setSourcePoint(String sourcePoint) {
        this.sourcePoint = sourcePoint;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getDriver() {
        return driver;
    }

    public void setDriver(Users driver) {
        this.driver = driver;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public Users getClient() {
        return client;
    }

    public void setClient(Users client) {
        this.client = client;
    }
}
