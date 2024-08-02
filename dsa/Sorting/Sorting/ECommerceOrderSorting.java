package Sorting;
import java.util.Arrays;
import java.util.Arrays;

public class ECommerceOrderSorting {
    static class Order {
        int orderId;
        String customerName;
        double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId=" + orderId +
                    ", customerName='" + customerName + '\'' +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice < orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice > pivot.totalPrice) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = new Order[] {
            new Order(1, "John Doe", 100.0),
            new Order(2, "Jane Smith", 50.0),
            new Order(3, "Bob Johnson", 200.0),
            new Order(4, "Alice Brown", 150.0)
        };

        bubbleSort(orders);
        System.out.println("Bubble Sort:");
        System.out.println(Arrays.toString(orders));

        Order[] orders2 = new Order[] {
            new Order(1, "John Doe", 100.0),
            new Order(2, "Jane Smith", 50.0),
            new Order(3, "Bob Johnson", 200.0),
            new Order(4, "Alice Brown", 150.0)
        };

        quickSort(orders2, 0, orders2.length - 1);
        System.out.println("Quick Sort:");
        System.out.println(Arrays.toString(orders2));
    }
}