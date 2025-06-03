package ProductManagementSystem;

public class ProductManagementSystem {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(new Product(1, "Laptop", "Electronics", 1200.50));
        manager.addProduct(new Product(2, "Phone", "Electronics", 850.00));
        manager.addProduct(new Product(1, "Tablet", "Electronics", 600.00)); // duplicate

        System.out.println();

        manager.showAllProducts();

        System.out.println();

        manager.updateProduct(2, "Smartphone", "Gadgets", 890.00);

        System.out.println();

        manager.sortByName();
        System.out.println();
        manager.sortById();

        System.out.println();

        manager.deleteProduct(1);

        System.out.println();

        manager.showAllProducts();
    }
}
