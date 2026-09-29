package shopping.model;

/**
 * Abstract base class for all products sold in the online store.
 */
public abstract class Product {
    private final int productId;
    private String name;
    private double price;
    private int stock;

    public Product() {
        this(0, "Unknown Product", 0.0, 0);
    }

    public Product(int productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Final prevents subclasses from changing the identity returned for a product.
    public final int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public void reduceStock(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            stock -= quantity;
        }
    }

    // Method overloading: same method name with an extra parameter.
    public void reduceStock(int quantity, boolean showMessage) {
        if (quantity > 0 && quantity <= stock) {
            stock -= quantity;
            if (showMessage) {
                System.out.printf("Stock updated. Remaining stock: %d%n", stock);
            }
        }
    }

    public abstract String getCategory();

    public void displayBasicInfo() {
        System.out.printf("%-5d %-22s %-15s ₹%.2f%n",
                productId, name, getCategory(), price);
    }

    @Override
    public String toString() {
        return String.format("%s [ID=%d, Price=₹%.2f, Stock=%d]",
                name, productId, price, stock);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        // Explicit reference casting from Object to Product.
        Product other = (Product) obj;
        return this.productId == other.productId;
    }
}
