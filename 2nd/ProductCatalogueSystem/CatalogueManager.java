package ProductCatalogueSystem;

import java.util.*;

public class CatalogueManager {
    private Map<Product, Integer> productMap = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (!productMap.containsKey(product)) {
            productMap.put(product, quantity);
            System.out.println("Product added to catalogue: " + product + ", Quantity: " + quantity);
        } else {
            System.out.println("Duplicate product not added.");
        }
    }

    public boolean updateQuantity(int id, int newQuantity) {
        for (Product p : productMap.keySet()) {
            if (p.getId() == id) {
                productMap.put(p, newQuantity);
                System.out.println("Quantity updated.");
                return true;
            }
        }
        System.out.println("Product not found.");
        return false;
    }

    public boolean updateProductDetails(int id, String name, String category, double price) {
        for (Product p : productMap.keySet()) {
            if (p.getId() == id) {
                p.setName(name);
                p.setCategory(category);
                p.setPrice(price);
                System.out.println("Product details updated.");
                return true;
            }
        }
        System.out.println("Product not found.");
        return false;
    }

    public boolean deleteProduct(int id) {
        Product toRemove = null;
        for (Product p : productMap.keySet()) {
            if (p.getId() == id) {
                toRemove = p;
                break;
            }
        }
        if (toRemove != null) {
            productMap.remove(toRemove);
            System.out.println("Product removed from catalogue.");
            return true;
        } else {
            System.out.println("Product not found.");
            return false;
        }
    }

    public void showCatalogue() {
        if (productMap.isEmpty()) {
            System.out.println("Catalogue is empty.");
            return;
        }
        System.out.println("Product Catalogue:");
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            System.out.println(entry.getKey() + " | Quantity: " + entry.getValue());
        }
    }

    public void sortById() {
        List<Product> sortedList = new ArrayList<>(productMap.keySet());
        sortedList.sort(Comparator.comparingInt(Product::getId));
        System.out.println("Catalogue Sorted by ID:");
        for (Product p : sortedList) {
            System.out.println(p + " | Quantity: " + productMap.get(p));
        }
    }

    public void sortByName() {
        List<Product> sortedList = new ArrayList<>(productMap.keySet());
        sortedList.sort(Comparator.comparing(Product::getName));
        System.out.println("Catalogue Sorted by Name:");
        for (Product p : sortedList) {
            System.out.println(p + " | Quantity: " + productMap.get(p));
        }
    }
}

