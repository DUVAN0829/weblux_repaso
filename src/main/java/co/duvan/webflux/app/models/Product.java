package co.duvan.webflux.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "products")
public class Product {

    //* Vars
    @Id
    private String id;

    private String name;
    private Double price;
    private LocalDateTime createAt;

    private Category category;

    //* Constructors
    public Product() {}

    public Product(String name, Double price, Category category) {
        this.name = name;
        this.price = price;
        this.createAt = LocalDateTime.now();
        this.category = category;
    }

    //* Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
