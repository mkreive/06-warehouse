package lt.javau5.warehouse.repo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "queue")
    private String queue;
    @Column(name = "stand")
    private String stand;
    @Column(name = "shelf")
    private String shelf;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "locations")
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    public Location() {
    }

    public Location(String queue, String stand, String shelf, List<Product> products) {
        this.queue = queue;
        this.stand = stand;
        this.shelf = shelf;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getStand() {
        return stand;
    }

    public void setStand(String stand) {
        this.stand = stand;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
//
//    public void addProduct(Product product) {
//        product.addLocation(this);
//        getProducts().add(product);
//    }

    public void addProduct(Product product) {
        this.products.add(product);
        product.getLocations().add(this);
    }

//    public void removeProduct(Long locationId) {
//        Location location = this.locations.stream().filter(t -> t.getId() == locationId).findFirst().orElse(null);
//        if (location != null) {
//            this.locations.remove(location);
//            location.getProducts().remove(this);
//        }
//    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", row='" + queue + '\'' +
                ", stand='" + stand + '\'' +
                ", shelf='" + shelf + '\'' +
                ", products=" + products +
                '}';
    }
}
