package shopping.model;

public class ClothingProduct extends Product {
    private String size;
    private String material;

    public ClothingProduct() {
        this(0, "Unknown Clothing", 0.0, 0, "M", "Cotton");
    }

    public ClothingProduct(int productId, String name, double price, int stock,
                           String size, String material) {
        super(productId, name, price, stock);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }

    @Override
    public void displayBasicInfo() {
        System.out.printf("%-5d %-22s %-15s ₹%.2f | Size: %s | %s%n",
                getProductId(), getName(), getCategory(), getPrice(),
                size, material);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                " [Size=%s, Material=%s]", size, material);
    }
}
