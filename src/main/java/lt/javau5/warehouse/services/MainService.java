package lt.javau5.warehouse.services;

import lt.javau5.warehouse.repo.entities.Location;
import lt.javau5.warehouse.repo.entities.Product;
import lt.javau5.warehouse.repo.repositories.LocationRepository;
import lt.javau5.warehouse.repo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    LocationRepository locationRepository;

    public void seedData() {
        List<Location> locations = new ArrayList<>();
        List<Product> products = new ArrayList<>();

    }
}
