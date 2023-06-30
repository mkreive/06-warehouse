package lt.javau5.warehouse.services;

import lt.javau5.warehouse.repo.entities.Location;
import lt.javau5.warehouse.repo.entities.Product;
import lt.javau5.warehouse.repo.entities.Unit;
import lt.javau5.warehouse.repo.repositories.LocationRepository;
import lt.javau5.warehouse.repo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<Object> getAllLocations() {
        List<Location> dbLocations = locationRepository.findAll();
        if (dbLocations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dbLocations, HttpStatus.OK);
    }

    public boolean seedData() {
        if(locationRepository.count() == 0 || productRepository.count() == 0) {
            Location location1 = new Location("03", "AA", "001", new ArrayList<>());
            Product tv = new Product("Tv", "AZ-3452", "Samsung S23", Unit.UNIT, 20, new ArrayList<>());
            tv.addLocation(location1);
            location1.addProduct(tv);
            locationRepository.save(location1);
            productRepository.save(tv);

            Location location2 = new Location("01", "BB", "023", new ArrayList<>());
            Product rug = new Product("Rug", "RN-1444", "Arabic Fuzzy", Unit.METER, 300, new ArrayList<>());
            rug.addLocation(location2);
            location2.addProduct(rug);
            locationRepository.save(location2);
            productRepository.save(rug);
            return true;
        }

        return false;
    }
}
