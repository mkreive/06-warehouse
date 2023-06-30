package lt.javau5.warehouse.repo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "article")
    private String article;
    @Column(name = "description")
    private String description;
    @Column(name = "unit")
    private Unit unit;
    @Column(name = "quantity")
    private int quantity;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "products_locations",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private List<Location> locations = new ArrayList<>();

    public Product() {
    }

    public Product(String name, String article, String description, Unit unit, int quantity, List<Location> locations) {
        this.name = name;
        this.article = article;
        this.description = description;
        this.unit = unit;
        this.quantity = quantity;
        this.locations = locations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public void addLocation(Location location) {
        this.locations.add(location);
        location.getProducts().add(this);
    }

    public void removeLocation(Long locationId) {
        Location location = this.locations.stream().filter(t -> t.getId() == locationId).findFirst().orElse(null);
        if (location != null) {
            this.locations.remove(location);
            location.getProducts().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", article='" + article + '\'' +
                ", description='" + description + '\'' +
                ", unit=" + unit +
                ", quantity=" + quantity +
                ", locations=" + locations +
                '}';
    }
}
