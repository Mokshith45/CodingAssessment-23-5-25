package ProductCatalogueSystem;

public class ProductCatalogueSystem {
    public static void main(String[] args) {
        CatalogueManager catalogue = new CatalogueManager();

        Product p1 = new Product(100, "Monitor", "Electronics", 250.00);
        Product p2 = new Product(101, "Mouse", "Accessories", 20.00);
        Product p3 = new Product(100, "Monitor Duplicate", "Electronics", 260.00);

        catalogue.addProduct(p1, 5);
        catalogue.addProduct(p2, 50);
        catalogue.addProduct(p3, 2);  // will not be added

        System.out.println();

        catalogue.showCatalogue();

        System.out.println();

        catalogue.updateQuantity(101, 70);
        catalogue.updateProductDetails(100, "LED Monitor", "Display", 270.00);

        System.out.println();

        catalogue.sortByName();
        System.out.println();
        catalogue.sortById();

        System.out.println();

        catalogue.deleteProduct(101);

        System.out.println();

        catalogue.showCatalogue();
    }
}
