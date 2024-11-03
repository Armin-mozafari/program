import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CatalogManager catalogManager = new CatalogManager();
        FileHandler fileHandler = new FileHandler();
        Scanner scanner = new Scanner(System.in);

        fileHandler.loadProducts(catalogManager);

        while (true) {
            System.out.println("1. Add Product\n2. Remove Product\n3. View Products\n4. Save and Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Product price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Product category: ");
                    String category = scanner.nextLine();
                    catalogManager.addProduct(new Product(name, price, category));
                }
                case 2 -> {
                    System.out.print("Enter name to remove: ");
                    String name = scanner.nextLine();
                    catalogManager.removeProduct(name);
                }
                case 3 -> {
                    System.out.println("Catalog Products:");
                    catalogManager.showProducts();
                }
                case 4 -> {
                    fileHandler.saveProducts(catalogManager.getCatalog());
                    System.out.println("Saved and exiting.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}