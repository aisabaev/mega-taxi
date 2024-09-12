package kg.mega.mega_taxi.service;


import kg.mega.mega_taxi.model.Cars;
import kg.mega.mega_taxi.repository.CarsRepository;
import kg.mega.mega_taxi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarsService {

    private final CarsRepository carsRepository;
    private final UserRepository userRepository;


    public void createCar(Cars car) {
        carsRepository.save(car);
    }

    public void deleteCar(Long id) {
        carsRepository.deleteById(id);
    }

    public boolean updateCar(Cars car, Long id) {
        Cars carToUpdate = carsRepository.findById(id).orElse(null);
        if (carToUpdate != null) {
            carToUpdate.setUser(userRepository.findById(id).orElse(null));
            carToUpdate.setModel(car.getModel());
            carToUpdate.setColor(car.getColor());
            carToUpdate.setBrand(car.getBrand());
            carToUpdate.setNumber_sheet(car.getNumber_sheet());
            carsRepository.save(carToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public Cars getCar(Long id) {
        return carsRepository.findById(id).orElse(null);
    }
}