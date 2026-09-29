import java.util.Scanner;

import shopping.model.Customer;
import shopping.service.ShoppingService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("       ONLINE SHOPPING MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        long mobile = readMobile(scanner);

        System.out.print("Are you a REVA MART member? (yes/no): ");
        String memberInput = scanner.nextLine().trim().toLowerCase();
        boolean member = memberInput.equals("yes") || memberInput.equals("y");

        // Explicit type conversion: String -> long.
        Customer customer = new Customer(name, email, mobile, member);

        ShoppingService service = new ShoppingService(customer);
        service.run(scanner);

        scanner.close();
    }

    private static long readMobile(Scanner scanner) {
        System.out.print("Enter mobile number: ");
        String input = scanner.nextLine().trim();

        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid mobile number. Using 0.");
            return 0L;
        }
    }
}
