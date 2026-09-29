# Online Shopping Management System

**Name:** Ayisha Niya  
**SRN:** R24SA008  
**Class:** BSc. Bioinformatics  
**Domain:** Online Shopping Management System

## Project Overview

A console-based Java application that manages products, customer details, cart operations, billing, discounts, GST, delivery charges, payment selection and order placement. The project demonstrates the required Unit-I and Unit-II Java/OOP concepts through one practical application.

### Project Structure

```text
src/
├── Main.java
└── shopping/
    ├── model/
    │   ├── Product.java
    │   ├── ElectronicsProduct.java
    │   ├── ClothingProduct.java
    │   ├── Customer.java
    │   └── PaymentMethod.java
    └── service/
        ├── ShoppingService.java
        ├── Payment.java
        └── PaymentProcessor.java
```

## Mandatory Feature Traceability

| # | Mandatory requirement | Exact implementation (file/class and line) |
|---|---|---|
| 1 | Encapsulation | `Product.java:7–10, 28–54`; `Customer.java:4–7, 24–56`; `ElectronicsProduct.java:4–5, 18–34`; `ClothingProduct.java:4–5, 18–32` — private fields with public getters/setters. |
| 2 | Data types, constants and scope | `ShoppingService.java:12–19` — `static final` constants, static field, instance fields; local variables throughout methods. `Customer.java:4–7` and `Product.java:7–10` use varied types. |
| 3 | Operators and precedence | `ShoppingService.java:165–168` — `price * quantity`; multiplication is evaluated before the surrounding assignment/addition operations. |
| 4 | Type conversion / casting | `Product.java:94–99` — explicit `(Product) obj` reference cast. `Main.java:35–44` also converts `String` input to `long` using `Long.parseLong()`. |
| 5 | Enum | `PaymentMethod.java:3–6` — `CASH_ON_DELIVERY`, `UPI`, `CARD`. |
| 6 | Control and jump statements | `ShoppingService.java:49–75` — `while`, `switch`, `break`; `97–103` — `for` and `continue`; `110–113`, `138–160`, `191–194`, `219–222` — `if/else` and `return`. |
| 7 | Array of objects | `ShoppingService.java:16, 28–44` — `Product[]` containing `ElectronicsProduct` and `ClothingProduct` objects. |
| 8 | Console I/O + formatted output | `Main.java:8, 14–24`; `ShoppingService.java:93–94, 167–168, 207–212` — `Scanner`, `System.out`, `printf`, and formatted output. |
| 9 | Constructor overloading | `Product.java:12–21`; `Customer.java:9–22`; `ElectronicsProduct.java:7–16`; `ClothingProduct.java:7–16` — default and parameterized constructors. |
| 10 | Method overloading | `Product.java:60–74` — two `reduceStock()` methods; `ShoppingService.java:296–310` — two `readInt()` methods. |
| 11 | Static fields/methods | `ShoppingService.java:14, 260–264, 313–315` — `totalOrders` and getter; `PaymentProcessor.java:6, 32–34` — `successfulPayments` and getter. |
| 12 | `this` reference / constructor chaining | `Product.java:13`; `Customer.java:10, 14`; field assignments such as `Product.java:17–20` and `Customer.java:18–21` explicitly use `this`. |
| 13 | String methods | `Main.java:23–24`; `Customer.java:58–64`; `ShoppingService.java:108–121` — `trim()`, `toLowerCase()`, `substring()`, `contains()`, and `equals()`. |
| 14 | Inheritance hierarchy | `ElectronicsProduct.java:3` and `ClothingProduct.java:3` — both extend `Product`. |
| 15 | `super` keyword | `ElectronicsProduct.java:13, 51`; `ClothingProduct.java:13, 48` — parent constructor and parent `toString()` calls. |
| 16 | Overriding + dynamic binding | `ElectronicsProduct.java:36–47` and `ClothingProduct.java:36–44` override methods; `ShoppingService.java:97–102` calls overridden methods through `Product` references. |
| 17 | Abstract class + abstract method | `Product.java:6` — abstract class; `Product.java:76` — abstract `getCategory()`. |
| 18 | Interface + interface reference | `Payment.java:5–6` — interface; `PaymentProcessor.java:5` implements it; `ShoppingService.java:19, 25` stores/creates it through the `Payment` interface reference. |
| 19 | Object methods | `Product.java:83–99` overrides `toString()` and `equals()`; `Customer.java:67–71` overrides `toString()`. |
| 20 | Final method/class + explanation | `Product.java:23–25` — final `getProductId()` with a comment explaining why it is final. `productId` is also final at line 7. |
| 21 | Two custom packages | `shopping.model` and `shopping.service` are used in the package declarations; `Main.java:3–4` imports classes from both. |

## Application Flow

```text
Start → Customer Details → Product Menu → View/Search Products
→ Add to Cart → View Cart/Bill → Checkout → Select Payment
→ Payment Processing → Order Placed → Exit
```

## Sample Output

`sample_output.txt` contains a captured end-to-end run showing customer input, product display, cart addition, bill calculation, checkout, UPI payment, successful order placement and exit.

## How to Compile and Run

From the project root:

```text
javac -d out src/Main.java src/shopping/model/*.java src/shopping/service/*.java
java -cp out Main
```

The source code was verified with `javac` and the complete shopping flow was executed successfully.
