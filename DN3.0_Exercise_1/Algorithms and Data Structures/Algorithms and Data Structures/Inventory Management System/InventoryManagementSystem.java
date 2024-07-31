import java.util.HashMap;

public class InventoryManagementSystem {
    private HashMap<Integer, Product> inventory;

    public InventoryManagementSystem() {
        this.inventory = new HashMap<>();
    }

    // Method to add product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Method to update product
    public void updateProduct(int productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Method to delete product
    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found!");
        }
    }

    // Method to display all products
    public void displayProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        java.util.Scanner sc = new java.util.Scanner(System.in);
        boolean flag = true;
        while(flag)
        {
            System.out.println("\n1.Add Product\n2.Update Product\n3.Delete Product\n4.Display Products\n5.Exit\n");
            int c = sc.nextInt();
            switch(c)
            {
                case 1:
                {
                    System.out.println("Product Id: ");
                    int sno = sc.nextInt();
                    System.out.println("Product name: ");
                    String name = sc.next();
                    System.out.println("Quantity: ");
                    int q = sc.nextInt();
                    System.out.println("Cost per unit: ");
                    float cost = sc.nextFloat();
                    Product p1 = new Product(sno,name,q,cost);
                    ims.addProduct(p1);
                    System.out.println("Product Added Successfully!!!");
                }break;
                case 2:
                {
                    System.out.println("Product Id: ");
                    int pno = sc.nextInt();
                    System.out.println("Product name: ");
                    String name = sc.next();
                    System.out.println("Quantity: ");
                    int q = sc.nextInt();
                    System.out.println("Cost per unit: ");
                    float cost = sc.nextFloat();
                    Product p2 = new Product(pno,name,q,cost);
                    ims.updateProduct(pno, p2);
                    System.out.println("Product Updated Successfully!!!");
                }break;
                case 3:
                {
                    System.out.println("Product Id: ");
                    int pno = sc.nextInt();
                    ims.deleteProduct(pno);
                    System.out.println("Product Deleted Successfully!!!");
                }break;
                case 4:
                {
                    ims.displayProducts();
                }break;
                case 5:
                {
                    flag = false;
                }break;
                default: System.err.println("Invalid Option!");

            }
        }
    }
}
