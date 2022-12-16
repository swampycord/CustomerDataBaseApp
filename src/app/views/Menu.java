package app.views;

import app.service.CustomerService;
import app.service.entities.CustomerEntity;
import app.tools.AppConsole;
import app.tools.CustomThread;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {

    private final CustomerService customerService = new CustomerService();

    public void open() {
        System.out.println("Menu Screen");
        System.out.println("Options:");
        System.out.println("\tPress 1 -> view customers");
        System.out.println("\t      2 -> add customers");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter: ");
        int option = input.nextInt();

        if (option == 1) {
            viewCustomers();
        } else {
            addCustomers();
        }
    }


    private void viewCustomers() {
        System.out.println("View customer Screen");

        if (!customerService.getCustomers().isEmpty()) {
            for (CustomerEntity customer : customerService.getCustomers()) {
                System.out.println("Firstname\t\t: " + customer.getFirstName());
                System.out.println("Lastname\t\t: " +customer.getLastName());
                System.out.println("Email\t\t\t: " +customer.getEmail());
                System.out.println("Address\t\t\t: " +customer.getAddress());
                System.out.println("Date of birth\t: " + customer.getDob().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
                System.out.println("\b");
            }
        } else {
            System.err.println("There are no customers");
            backOption();
        }
        backOption();
    }

    private void backOption() {
        CustomThread.sleep(500);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter \"b\" to go back: ");
        String backOption = input.nextLine();

        if (backOption.equals("b")) {
            this.open();
            input.close();
        }
    }

    private void addCustomers() {

        Scanner input = new Scanner(System.in);

        System.out.print("Firstname\t\t: "  );
        String firstName = input.nextLine();

        System.out.print("Lastname\t\t: "  );
        String lastName = input.nextLine();

        System.out.print("Email\t\t\t: "  );
        String email = input.nextLine();

        System.out.print("Address\t\t\t: "  );
        String address = input.nextLine();

        System.out.print("Date of Birth\t: "  );
        String dob = input.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        customerService.addCustomer(firstName, lastName, email, address, LocalDate.parse(dob, dtf));
        System.out.println("Customer successfully added!");
        open();

    }
}
