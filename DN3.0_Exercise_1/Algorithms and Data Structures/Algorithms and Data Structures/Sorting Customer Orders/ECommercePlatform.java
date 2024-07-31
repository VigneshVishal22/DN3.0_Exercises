import java.util.Scanner;

public class ECommercePlatform {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of orders
        System.out.print("\nEnter the number of orders: ");
        int numOrders = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        Order[] orders = new Order[numOrders];

        // Get order details from the user
        for (int i = 0; i < numOrders; i++) {
            System.out.print("\nEnter order ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();

            System.out.print("Enter total price: ");
            double totalPrice = scanner.nextDouble();
            scanner.nextLine();  // Consume the newline

            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        // Perform Bubble Sort
        Order[] bubbleSortedOrders = orders.clone();
        BubbleSort.bubbleSort(bubbleSortedOrders);
        System.out.println("\nOrders sorted by Bubble Sort:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }

        // Perform Quick Sort
        Order[] quickSortedOrders = orders.clone();
        QuickSort.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("\nOrders sorted by Quick Sort:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
    }
}
