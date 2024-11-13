package UI;
import useradmin.system;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner (System.in);
    system system = new system();

    public void menu() {

        System.out.println("MENU:");

        System.out.println("1. View user list \n2. Create a new user \n3. Delete a user \n9. Quit");
        int userChoice = scanner.nextInt();


        if (userChoice == 1) {
            System.out.println("View user list");
            system.readFile();
        }

        if (userChoice == 2) {
            System.out.println("Create a new user");
            system.createNewUser();
            system.saveFile();
        }

        if (userChoice == 3) {
            System.out.println("Delete a user");
            system.deleteAUser();
        }

        if (userChoice == 9) {
            System.exit(0);
        }

    }



}
