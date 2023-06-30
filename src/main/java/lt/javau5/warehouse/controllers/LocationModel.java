package lt.javau5.warehouse.repo.entities;

import java.util.List;

public class LocationModel {

    private long id;
    private String row;
    private String stand;
    private String shelf;
    private List<Long> product_id;

    public LocationModel(Location location) {
        this.id = location.getId();
        this.row = location.getRow();
        this.stand = location.getStand();
        this.shelf = location.getShelf();
        this.product_id = location.getProducts().stream().map(e -> e.getId()).toList();
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

    public List<Long> getProduct_id() {
        return product_id;
    }

    public void setProduct_id(List<Long> product_id) {
        this.product_id = product_id;
    }
}
