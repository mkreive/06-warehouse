package lt.javau5.warehouse.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String article;
    private String description;
    private Unit unit;
    private int quantity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_location",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "location_id")
    private List<Location> locations;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
