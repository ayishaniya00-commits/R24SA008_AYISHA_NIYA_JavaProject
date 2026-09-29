package shopping.service;

import java.util.Scanner;

import shopping.model.ClothingProduct;
import shopping.model.Customer;
import shopping.model.ElectronicsProduct;
import shopping.model.PaymentMethod;
import shopping.model.Product;

public class ShoppingService {
    public static final String STORE_NAME = "REVA MART";
    public static final double GST_RATE = 0.18;
    private static int totalOrders = 0;

    private final Product[] products;
    private final int[] cartQuantities;
    private final Customer customer;
    private final Payment paymentProcessor;

    public ShoppingService(Customer customer) {
        this.customer = customer;
        this.products = createProducts();
        this.cartQuantities = new int[products.length];
        this.paymentProcessor = new PaymentProcessor();
    }

    private Product[] createProducts() {
        // Array of objects.
        return new Product[] {
            new ElectronicsProduct(101, "Wireless Headphones", 1499.00, 8,
                    "Boat", 12),
            new ElectronicsProduct(102, "Smart Watch", 2499.00, 5,
                    "Noise", 12),
            new ElectronicsProduct(103, "Bluetooth Speaker", 1799.00, 6,
                    "JBL", 24),
            new ClothingProduct(201, "Cotton T-Shirt", 599.00, 10,
                    "M", "Cotton"),
            new ClothingProduct(202, "Denim Jacket", 1899.00, 4,
                    "L", "Denim"),
            new ClothingProduct(203, "Sports Shoes", 2299.00, 7,
                    "9", "Mesh")
        };
    }

    public void run(Scanner scanner) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    searchProducts(scanner);
                    break;
                case 3:
                    addToCart(scanner);
                    break;
                case 4:
                    viewCart();
                    break;
                case 5:
                    checkout(scanner);
                    break;
                case 6:
                    System.out.println("Thank you for shopping with " + STORE_NAME + "!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n========== " + STORE_NAME + " ==========");
        System.out.println("Welcome, " + customer.getShortName() + "!");
        System.out.println("1. View Products");
        System.out.println("2. Search Product");
        System.out.println("3. Add Product to Cart");
        System.out.println("4. View Cart");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
        System.out.println("========================================");
    }

    private void displayProducts() {
        System.out.println("\n---------------- AVAILABLE PRODUCTS ----------------");
        System.out.printf("%-5s %-22s %-15s %-12s%n",
                "ID", "Product", "Category", "Price");
        System.out.println("-----------------------------------------------------");

        for (Product product : products) {
            if (!product.isAvailable()) {
                continue;
            }
            // Dynamic binding: Product reference calls the subclass version.
            product.displayBasicInfo();
        }
    }

    private void searchProducts(Scanner scanner) {
        System.out.print("Enter product name/category to search: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        if (keyword.isEmpty()) {
            System.out.println("Search keyword cannot be empty.");
            return;
        }

        boolean found = false;

        for (Product product : products) {
            String name = product.getName().toLowerCase();
            String category = product.getCategory().toLowerCase();

            if (name.contains(keyword) || category.contains(keyword)) {
                product.displayBasicInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching product found.");
        }
    }

    private void addToCart(Scanner scanner) {
        displayProducts();

        int id = readInt(scanner, "Enter product ID: ");
        int index = findProductIndex(id);

        if (index == -1) {
            System.out.println("Product not found.");
            return;
        }

        Product selected = products[index];

        if (!selected.isAvailable()) {
            System.out.println("Product is out of stock.");
            return;
        }

        int quantity = readInt(scanner, "Enter quantity: ");

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        if (quantity > selected.getStock()) {
            System.out.println("Only " + selected.getStock() + " item(s) are available.");
            return;
        }

        selected.reduceStock(quantity);
        cartQuantities[index] += quantity;

        // * has higher precedence than + in this expression.
        double itemTotal = selected.getPrice() * quantity;
        System.out.printf("%d x %s added to cart. Item total: ₹%.2f%n",
                quantity, selected.getName(), itemTotal);
    }

    private void viewCart() {
        System.out.println("\n---------------- CART ----------------");
        double subtotal = 0.0;
        int itemCount = 0;

        for (int i = 0; i < products.length; i++) {
            int quantity = cartQuantities[i];

            if (quantity == 0) {
                continue;
            }

            double itemTotal = products[i].getPrice() * quantity;
            subtotal += itemTotal;
            itemCount += quantity;

            System.out.printf("%-22s Qty: %-3d ₹%.2f%n",
                    products[i].getName(), quantity, itemTotal);
        }

        if (itemCount == 0) {
            System.out.println("Your cart is empty.");
            return;
        }

        printBill(subtotal, itemCount);
    }

    private void printBill(double subtotal, int itemCount) {
        double discount = customer.isMember() ? subtotal * 0.05 : 0.0;
        double taxableAmount = subtotal - discount;
        double gst = taxableAmount * GST_RATE;
        double deliveryCharge = taxableAmount >= 2000 ? 0.0 : 50.0;
        double total = taxableAmount + gst + deliveryCharge;

        System.out.println("--------------------------------------");
        System.out.printf("Items              : %d%n", itemCount);
        System.out.printf("Subtotal           : ₹%.2f%n", subtotal);
        System.out.printf("Member Discount    : ₹%.2f%n", discount);
        System.out.printf("GST (18%%)          : ₹%.2f%n", gst);
        System.out.printf("Delivery Charge    : ₹%.2f%n", deliveryCharge);
        System.out.printf("TOTAL              : ₹%.2f%n", total);
        System.out.println("--------------------------------------");
    }

    private void checkout(Scanner scanner) {
        double subtotal = calculateSubtotal();

        if (subtotal <= 0) {
            System.out.println("Your cart is empty. Add products before checkout.");
            return;
        }

        double discount = customer.isMember() ? subtotal * 0.05 : 0.0;
        double taxableAmount = subtotal - discount;
        double gst = taxableAmount * GST_RATE;
        double deliveryCharge = taxableAmount >= 2000 ? 0.0 : 50.0;
        double total = taxableAmount + gst + deliveryCharge;

        System.out.println("\n=============== CHECKOUT ===============");
        System.out.printf("Subtotal        : ₹%.2f%n", subtotal);
        System.out.printf("Discount        : ₹%.2f%n", discount);
        System.out.printf("GST             : ₹%.2f%n", gst);
        System.out.printf("Delivery        : ₹%.2f%n", deliveryCharge);
        System.out.printf("Final Amount    : ₹%.2f%n", total);

        System.out.println("\nPayment Method:");
        System.out.println("1. Cash on Delivery");
        System.out.println("2. UPI");
        System.out.println("3. Card");

        int paymentChoice = readInt(scanner, "Choose payment method: ");
        PaymentMethod method;

        switch (paymentChoice) {
            case 1:
                method = PaymentMethod.CASH_ON_DELIVERY;
                break;
            case 2:
                method = PaymentMethod.UPI;
                break;
            case 3:
                method = PaymentMethod.CARD;
                break;
            default:
                System.out.println("Invalid payment option.");
                return;
        }

        if (paymentProcessor.pay(total, method)) {
            totalOrders++;
            clearCart();
            System.out.println("Order placed successfully!");
            System.out.println("Order number: " + totalOrders);
        } else {
            System.out.println("Payment failed.");
        }
    }

    private void clearCart() {
        for (int i = 0; i < cartQuantities.length; i++) {
            cartQuantities[i] = 0;
        }
    }

    private double calculateSubtotal() {
        double subtotal = 0.0;

        for (int i = 0; i < products.length; i++) {
            int quantity = cartQuantities[i];
            subtotal += products[i].getPrice() * quantity;
        }

        return subtotal;
    }

    private int findProductIndex(int id) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == id) {
                return i;
            }
        }
        return -1;
    }

    // Method overloading: same method name with different parameters.
    private int readInt(Scanner scanner, String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private int readInt(Scanner scanner, String message, int defaultValue) {
        int value = readInt(scanner, message);
        return value == -1 ? defaultValue : value;
    }

    public static int getTotalOrders() {
        return totalOrders;
    }
}
