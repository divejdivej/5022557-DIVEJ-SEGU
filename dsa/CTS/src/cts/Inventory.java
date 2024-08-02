package cts;
import java.util.HashMap;
import java.util.Map;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

	public Product(int i, String string, String string2) {
		// TODO Auto-generated constructor stub
	}
}

public class Inventory {
    private Map<Integer, Product> inventory;

    public Inventory() {
        this.inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.productId, product);
    }

    public void updateProduct(int productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        }
    }

    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    public static void main(String[] args) {
        Inventory inventorySystem = new Inventory();

        Product product1 = new Product(1, "Product A", 10, 9.99);
        Product product2 = new Product(2, "Product B", 20, 19.99);

        inventorySystem.addProduct(product1);
        inventorySystem.addProduct(product2);

        System.out.println(inventorySystem.getProduct(1).productName);

        Product updatedProduct1 = new Product(1, "Product A Updated", 15, 10.99);
        inventorySystem.updateProduct(1, updatedProduct1);

        System.out.println(inventorySystem.getProduct(1).productName);

        inventorySystem.deleteProduct(2);

        System.out.println(inventorySystem.getProduct(2));
    }
}