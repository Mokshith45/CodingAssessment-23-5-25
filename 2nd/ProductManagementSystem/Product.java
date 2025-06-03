package ProductManagementSystem;

import java.util.*;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;

    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean equals(Object o){
        if(this == o)return true;
        if(!(o instanceof Product)) return false;
        Product product = (Product)o;
        return id == product.id;
    }

    public int hashCode(){
        return Objects.hash(id);
    }

    public String toString() {
        return "[" + id + "," + name + "," + category + ", $" + price + "]";
    }
}
