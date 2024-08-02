package EcommerceQuestion;
import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {
    
    static class Product {
        private int productId;
        private String item;
        private String category;

        public Product(int productId, String item, String category) {
            this.productId = productId;
            this.item = item;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getItem() {
            return item;
        }

        public String getCategory() {
            return category;
        }
    }

    static class ECommercePlatform {
        private Product[] products;

        public ECommercePlatform(Product[] products) {
            this.products = products;
        }

        public Product linearSearch(int key) {
            for (Product product : products) {
                if (product.getProductId() == key) {
                    return product;
                }
            }
            return null;
        }

        public Product binarySearch(int key) {
            int low = 0;
            int high = products.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                int midId = products[mid].getProductId();

                if (midId == key) {
                    return products[mid];
                } else if (midId < key) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Book", "Literature"),
            new Product(4, "Headphones", "Electronics"),
            new Product(5, "Shoes", "Fashion")
        };

        ECommercePlatform platform = new ECommercePlatform(products);

        System.out.println("Linear Search:");
        int searchKey = 3;
        Product result = platform.linearSearch(searchKey);
        if (result != null) {
            System.out.println("Product found: " + result.getItem() + " in category " + result.getCategory());
        } else {
            System.out.println("Product not found.");
        }

        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        System.out.println("\nBinary Search:");
        searchKey = 4;
        result = platform.binarySearch(searchKey);
        if (result != null) {
            System.out.println("Product found: " + result.getItem() + " in category " + result.getCategory());
        } else {
            System.out.println("Product not found.");
        }
    }
}
