import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ECommercePlatform {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the number of products: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        Product[] products = new Product[numProducts];

        for (int i = 0; i < numProducts; i++) {
            System.out.print("\nEnter product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();

            System.out.print("Enter product category: ");
            String category = scanner.nextLine();

            products[i] = new Product(productId, productName, category);
        }

        System.out.print("\nEnter the product name to search: ");
        String targetProductName = scanner.nextLine();

        // Linear Search
        Product foundProductLinear = linearSearch(products, targetProductName);
        System.out.println("Linear Search Result: " + (foundProductLinear != null ? foundProductLinear : "Product not found"));

        // Binary Search
        Product foundProductBinary = binarySearch(products, targetProductName);
        System.out.println("Binary Search Result: " + (foundProductBinary != null ? foundProductBinary : "Product not found"));
    }

    // Linear Search Algorithm
    public static Product linearSearch(Product[] products, String targetProductName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetProductName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search Algorithm
    public static Product binarySearch(Product[] products, String targetProductName) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetProductName);

            if (comparison == 0) {
                return products[mid];
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return "\nProduct Id: " + productId + "\nProduct Name: " + productName + "\nCategory: " + category;
    }
}
