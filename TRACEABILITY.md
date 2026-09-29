# Traceability – Online Shopping Management System

**Name:** Ayisha Niya  
**SRN:** R24SA008  

This file provides exact source locations for every mandatory requirement in the assignment.

1. **Encapsulation** → `Product.java:7–10, 28–54`; `Customer.java:4–7, 24–56`; `ElectronicsProduct.java:4–5, 18–34`; `ClothingProduct.java:4–5, 18–32`.

2. **Data types/constants/scope** → `ShoppingService.java:12–19`; `Product.java:7–10`; `Customer.java:4–7`.

3. **Operators/precedence** → `ShoppingService.java:165–168` (`*` is evaluated before surrounding operations).

4. **Type conversion/casting** → `Product.java:94–99` (`(Product) obj`); `Main.java:35–44` (`Long.parseLong`).

5. **Enum** → `PaymentMethod.java:3–6`.

6. **Control/jump statements** → `ShoppingService.java:49–75` (`while`, `switch`, `break`); `97–103` (`for`, `continue`); `110–113`, `138–160`, `191–194`, `219–222` (`if`, `return`).

7. **Array of objects** → `ShoppingService.java:16, 28–44` (`Product[]`).

8. **Console I/O/formatted output** → `Main.java:8, 14–24`; `ShoppingService.java:93–94, 
167–168, 207–212`.

9. **Constructor overloading** → `Product.java:12–21`; `Customer.java:9–22`; `ElectronicsProduct.java:7–16`; `ClothingProduct.java:7–16`.

10. **Method overloading** → `Product.java:60–74`; `ShoppingService.java:296–310`.

11. **Static fields/methods** → `ShoppingService.java:14, 313–315`; `PaymentProcessor.java:6, 32–34`.

12. **`this` reference / chaining** → `Product.java:13, 17–20`; `Customer.java:10, 14, 18–21`.

13. **String methods** → `Main.java:23–24`; `Customer.java:58–64`; `ShoppingService.java:108–121`.

14. **Inheritance** → `ElectronicsProduct.java:3`; `ClothingProduct.java:3`.

15. **`super`** → `ElectronicsProduct.java:13, 51`; `ClothingProduct.java:13, 48`.

16. **Overriding/dynamic binding** → `ElectronicsProduct.java:36–47`; `ClothingProduct.java:36–44`; `ShoppingService.java:97–102`.

17. **Abstract class/method** → `Product.java:6, 76`.

18. **Interface/interface reference** → `Payment.java:5–6`; `PaymentProcessor.java:5`; `ShoppingService.java:19, 25`.

19. **Object methods** → `Product.java:83–99`; `Customer.java:67–71`.

20. **Final method/class + reason** → `Product.java:23–25`; final field at `Product.java:7`203.

21. **Custom packages/imports** → package declarations in all model/service classes; `Main.java:3–4` imports both custom packages.

**Verification:** The project compiles with standard `javac` commands and the end-to-end console flow has been tested successfully. See `sample_output.txt`.
