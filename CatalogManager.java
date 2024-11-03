import java.util.ArrayList;

public class CatalogManager {
    private ArrayList<Product> catalog = new ArrayList<>();

    public void addProduct(Product product) {
        catalog.add(product);
    }

    public void removeProduct(String name) {
        catalog.removeIf(product -> product.name.equals(name));
    }

    public void showProducts() {
        catalog.forEach(System.out::println);
    }

    public ArrayList<Product> getCatalog() {
        return catalog;
    }
}