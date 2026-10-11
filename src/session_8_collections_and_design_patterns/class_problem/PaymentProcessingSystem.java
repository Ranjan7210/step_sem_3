package session_8.class_problem;

import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
}

enum OrderStatus {
    PENDING("Pending"),
    PAID("Paid"),
    FAILED("Failed");

    private final String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

interface PaymentMethod {
    String getMethodName();

    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    private boolean simulateSuccess;

    public CreditCardPayment(boolean simulateSuccess) {
        this.simulateSuccess = simulateSuccess;
    }

    @Override
    public String getMethodName() {
        return "Credit Card";
    }

    @Override
    public boolean processPayment(double amount) {
        return simulateSuccess;
    }
}

class PayPalPayment implements PaymentMethod {
    private boolean simulateSuccess;

    public PayPalPayment(boolean simulateSuccess) {
        this.simulateSuccess = simulateSuccess;
    }

    @Override
    public String getMethodName() {
        return "PayPal";
    }

    @Override
    public boolean processPayment(double amount) {
        return simulateSuccess;
    }
}

class BankTransferPayment implements PaymentMethod {
    private boolean simulateSuccess;

    public BankTransferPayment(boolean simulateSuccess) {
        this.simulateSuccess = simulateSuccess;
    }

    @Override
    public String getMethodName() {
        return "Bank Transfer";
    }

    @Override
    public boolean processPayment(double amount) {
        return simulateSuccess;
    }
}

class ShoppingCustomer {
    private String name;

    public ShoppingCustomer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Order {
    private String orderId;
    private ShoppingCustomer customer;
    private List<OrderItem> items;
    private OrderStatus status;

    public Order(String orderId, ShoppingCustomer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
        System.out.println("Order created for " + customer.getName() + ".");
    }

    public String getOrderId() {
        return orderId;
    }

    public ShoppingCustomer getCustomer() {
        return customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addProduct(Product product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }

    public double calculateTotal() {
        double total = 0.0;
        for (OrderItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public boolean processPayment(PaymentMethod paymentMethod) {
        if (items.isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return false;
        }

        System.out.println("Payment initiated via " + paymentMethod.getMethodName() + " for " + orderId + ".");
        boolean success = paymentMethod.processPayment(calculateTotal());

        if (success) {
            status = OrderStatus.PAID;
            System.out.println("Payment for " + orderId + " successful. Order status: " + status.getDisplayName() + ".");
            return true;
        } else {
            System.out.println("Payment for " + orderId + " failed. Order status: " + status.getDisplayName() + ".");
            return false;
        }
    }
}

public class PaymentProcessingSystem {
    public static void main(String[] args) {
        ShoppingCustomer customerX = new ShoppingCustomer("Customer X");
        ShoppingCustomer customerY = new ShoppingCustomer("Customer Y");
        ShoppingCustomer customerZ = new ShoppingCustomer("Customer Z");

        Product productA = new Product("Product A", 50.0);
        Product productB = new Product("Product B", 30.0);
        Product productC = new Product("Product C", 75.0);

        Order orderX = new Order("Order X", customerX);
        orderX.addProduct(productA, 2);
        orderX.addProduct(productB, 1);
        orderX.processPayment(new CreditCardPayment(true));

        Order orderY = new Order("Order Y", customerY);
        orderY.processPayment(new CreditCardPayment(true));

        Order orderZ = new Order("Order Z", customerZ);
        orderZ.addProduct(productC, 1);
        orderZ.processPayment(new PayPalPayment(false));
    }
}
