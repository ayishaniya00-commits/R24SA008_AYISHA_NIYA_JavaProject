package shopping.model;

public class ElectronicsProduct extends Product {
    private String brand;
    private int warrantyMonths;

    public ElectronicsProduct() {
        this(0, "Unknown Electronics", 0.0, 0, "Unknown", 0);
    }

    public ElectronicsProduct(int productId, String name, double price, int stock,
                              String brand, int warrantyMonths) {
        super(productId, name, price, stock);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand() {
        return brand;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        if (warrantyMonths >= 0) {
            this.warrantyMonths = warrantyMonths;
        }
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    // Method overriding demonstrates dynamic binding.
    @Override
    public void displayBasicInfo() {
        System.out.printf("%-5d %-22s %-15s ₹%.2f | %s | %d months warranty%n",
                getProductId(), getName(), getCategory(), getPrice(),
                brand, warrantyMonths);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                " [Brand=%s, Warranty=%d months]", brand, warrantyMonths);
    }
}
