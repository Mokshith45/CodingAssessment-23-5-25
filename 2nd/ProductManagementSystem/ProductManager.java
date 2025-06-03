package ProductManagementSystem;

import java.util.*;

public class ProductManager {
    private Set<Product> productSet = new HashSet<>();

    public boolean addProduct(Product product) {
        if (productSet.add(product)) {
            System.out.println(" Product added: " + product);
            return true;
        } else {
            System.out.println(" Duplicate product not added (ID already exists).");
            return false;
        }
    }

    public void showAllProducts() {
        if (productSet.isEmpty()) {
            System.out.println(" No products available.");
            return;
        }
        System.out.println("Product List:");
        for (Product p : productSet) {
            System.out.println(p);
        }
    }

    public boolean updateProduct(int id, String name, String category, double price) {
        for (Product p : productSet) {
            if (p.getId() == id) {
                p.setName(name);
                p.setCategory(category);
                p.setPrice(price);
                System.out.println("Product updated.");
                return true;
            }
        }
        System.out.println("Product not found.");
        return false;
    }

    // Delete a product
    public boolean deleteProduct(int id) {
        Product toRemove = null;
        for (Product p : productSet) {
            if (p.getId() == id) {
                toRemove = p;
                break;
            }
        }
        if (toRemove != null) {
            productSet.remove(toRemove);
            System.out.println(" Product removed.");
            return true;
        } else {
            System.out.println("Product not found.");
            return false;
        }
    }

    public void sortById() {
        List<Product> list = new ArrayList<>(productSet);
        list.sort(Comparator.comparingInt(Product::getId));
        System.out.println("Products Sorted by ID:");
        list.forEach(System.out::println);
    }

    public void sortByName() {
        List<Product> list = new ArrayList<>(productSet);
        list.sort(Comparator.comparing(Product::getName));
        System.out.println("Products Sorted by Name:");
        list.forEach(System.out::println);
    }
}
