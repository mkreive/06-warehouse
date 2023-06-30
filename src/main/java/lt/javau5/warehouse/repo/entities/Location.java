package lt.javau5.warehouse.repo.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String row;
    private String stand;
    private String shelf;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "locations")
    private List<Product> products;

    public Location() {
    }

    public Location(String row, String stand, String shelf, List<Product> products) {
        this.row = row;
        this.stand = stand;
        this.shelf = shelf;
        this.products = products;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
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

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", row='" + row + '\'' +
                ", stand='" + stand + '\'' +
                ", shelf='" + shelf + '\'' +
                ", products=" + products +
                '}';
    }
}
