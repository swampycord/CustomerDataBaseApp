package app.views.start;

import app.service.entities.UserService;
import app.tools.CustomThread;
import app.views.menu.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import static app.currentdata.CurrentUser.credentialsValidated;
import static app.currentdata.CurrentUser.getCurrentUser;

public class Start {

    private final UserService userService = new UserService();
    private final Scanner input = new Scanner(System.in);
    private Scanner passwordInput;
    private boolean wentToCatch = false;

    public Start() {
        loginView();
    }

    private void loginView() {


        System.out.println("Option:");
        System.out.println("\tPress 1 -> Sign in");
        System.out.println("\tPress 2 -> Register");
        System.out.print("Enter\t: ");

        do {
            try {
                int option = input.nextInt();
                if (option == 1) signIn();
                else if (option == 2) register();
                else throw new InputMismatchException();
            } catch (InputMismatchException e) {
                tryAgain();
            }
        } while (wentToCatch);
    }

    private void tryAgain() {
        wentToCatch = true;
        System.err.print("Please enter a valid number(1 or 2): ");
        input.next();
    }

    private void signIn() {
        wentToCatch = false;
        System.out.println("Sign in");
        Scanner input = new Scanner(System.in);
        usernameConfig(input);
        passwordConfig(input);
        if (!credentialsValidated()) {
            validationConfig();
        }
        Menu menu = new Menu();

        if (credentialsValidated()) {
            menu.open();
        }
    }

    private void register() {
        wentToCatch = false;
        register("");
    }

    private void register(String message) {
        if (message.isEmpty()) {
            System.out.println("Register");
        } else {
            System.err.println(message);
            CustomThread.sleep(500);
        }
        Scanner input = new Scanner(System.in);

        System.out.print("Enter username\t: ");
        String username = input.nextLine();

        if (!username.isEmpty()) {
            proceedToPassword(username);
        } else {
            register("Please enter a username");
        }
    }

    private void proceedToPassword(String username) {
        proceedToPassword(username, "");
    }

    private void proceedToPassword(String username, String message) {

        if (!message.isEmpty()) {
            System.err.println(message);
        }

        Scanner input = new Scanner(System.in);
        userService.getUserWithUsername(username);
        if (getCurrentUser() == null) {
            System.out.print("Enter password\t: ");
            String password = input.nextLine();
            if (password.isEmpty()) {
                proceedToPassword(username, "Please enter a password");
                CustomThread.sleep(500);
            } else {
                userService.addUser(username, password);
                loginView();
            }
        } else {
            register("Please enter a password");
        }
    }

    private void usernameConfig(Scanner input) {
        CustomThread.sleep(700);
        System.out.print("Enter username\t: ");
        String username = input.nextLine();
        userService.getUserWithUsername(username);

        if (getCurrentUser() == null) {
            System.err.println("Username does not exists");
            this.usernameConfig(input);
        }
    }

    private void passwordConfig(Scanner input) {
        CustomThread.sleep(700);
        passwordInput = input;
        System.out.print("Enter password\t: ");
        String password = input.nextLine();
        userService.verifyUserWithPassword(password);

        if (!credentialsValidated()) {
            System.err.println("Invalid password");
            passwordConfig(passwordInput);
        }
    }

    private void validationConfig() {
//        if (credentialsValidated()) {
//            AppConsole.clear();
//        } else {
        System.err.println("Invalid password");
        passwordConfig(passwordInput);
//        }
    }
}
