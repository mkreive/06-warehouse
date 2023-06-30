package lt.javau5.warehouse.controllers;

import lt.javau5.warehouse.repo.entities.Product;
import lt.javau5.warehouse.repo.entities.Unit;

import java.util.List;

public class ProductModel {

    private long id;
    private String name;
    private String article;
    private String description;
    private Unit unit;
    private int quantity;

    private List<Long> locations_id;


    public ProductModel(Product product) {
        this.name = product.getName();
        this.article = product.getArticle();
        this.description = product.getDescription();
        this.unit = product.getUnit();
        this.quantity = product.getQuantity();
        this.locations_id= product.getLocations().stream().map(e -> e.getId()).toList();
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

    public List<Long> getLocations_id() {
        return locations_id;
    }

    public void setLocations_id(List<Long> locations_id) {
        this.locations_id = locations_id;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", article='" + article + '\'' +
                ", description='" + description + '\'' +
                ", unit=" + unit +
                ", quantity=" + quantity +
                ", locations_id=" + locations_id +
                '}';
    }
}
